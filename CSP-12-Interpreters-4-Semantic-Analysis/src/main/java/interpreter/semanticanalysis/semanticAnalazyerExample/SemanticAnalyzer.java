package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.*;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class SemanticAnalyzer {

    private Stack<Set<String>> scopes = new Stack<>();

    void visit(ASTNode node) {
        if (node instanceof BinaryOpNode) {
            visit(((BinaryOpNode)node).left);
            visit(((BinaryOpNode)node).right);
        } else if (node instanceof NumberNode) {
            // Nothing
        } else if (node instanceof VarDecl varDecl) {
            String varName = varDecl.varNode.name;
            if (isVariableDefined(varName)) {
                throw new InterpreterException("Identifier already defined: " + varName);
            }
            // put varName to scope
            scopes.peek().add(varName); // declare variable in scope
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
            visit(assignNode.right);
        } else if (node instanceof Block block) {
            // enter a new scope
            scopes.push(new HashSet<>());
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
        for (Set<String> scope: scopes) {
            if (scope.contains(varName)) return true;
        }
        return false;
    }
}
