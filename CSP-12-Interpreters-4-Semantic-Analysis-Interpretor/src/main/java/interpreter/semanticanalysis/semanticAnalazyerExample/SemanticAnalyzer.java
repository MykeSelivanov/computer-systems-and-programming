package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.*;

import java.util.*;

public class SemanticAnalyzer {

    private Stack<Map<String, Boolean>> scopes = new Stack<>();

    void visit(ASTNode node) {
        if (node instanceof BinaryOpNode) {
            visit(((BinaryOpNode)node).left);
            visit(((BinaryOpNode)node).right);
        } else if (node instanceof NumberNode) {
            // Nothing
        } else if (node instanceof VarDecl varDecl) {
            String varName = varDecl.varNode.name;
            if (isVariableDefinedInCurrentScope(varName)) {
                throw new InterpreterException("Identifier already defined: " + varName);
            }
            // put varName to current scope with its const status
            scopes.peek().put(varName, varDecl.isConst);
        } else if (node instanceof Var) {
            String varName = ((Var)node).name;
            if (!isVariableDefined(varName)) {
                throw new InterpreterException("Unexpected identifier: " + varName);
            }
        } else if (node instanceof Assign assignNode) {
            String varName = assignNode.left.name;
            if (!isVariableDefined(varName)) {
                throw new InterpreterException("Unexpected identifier: " + varName);
            }
            if (isConstVariable(varName)) {
                throw new InterpreterException("Cannot reassign a const variable: " + varName);
            }
            visit(assignNode.right);
        } else if (node instanceof Block block) {
            // enter a new scope
            scopes.push(new HashMap<>());
            for (ASTNode statement: block.statements) {
                visit(statement);
            }
            // exit scope
            scopes.pop();
        } else {
            throw new InterpreterException("Unexpected AST Node: " + node.getClass().getCanonicalName());
        }
    }

    private boolean isVariableDefined(String varName) {
        for (Map<String, Boolean> scope: scopes) {
            if (scope.containsKey(varName)) {
                return true;
            }
        }
        return false;
    }

    private boolean isVariableDefinedInCurrentScope(String varName) {
        return scopes.peek().containsKey(varName);
    }

    private boolean isConstVariable(String varName) {
        for (Map<String, Boolean> scope: scopes) {
            if (scope.containsKey(varName)) {
                return scope.get(varName);
            }
        }
        return false;
    }
}
