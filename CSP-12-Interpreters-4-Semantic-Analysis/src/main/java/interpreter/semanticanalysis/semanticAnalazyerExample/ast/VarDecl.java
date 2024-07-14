package interpreter.semanticanalysis.semanticAnalazyerExample.ast;

public class VarDecl extends ASTNode {
    Var varNode;
    ASTNode expr;
    boolean isConst;

    public VarDecl(Var varNode, ASTNode expr, boolean isConst) {
        this.varNode = varNode;
        this.expr = expr;
        this.isConst = isConst;
    }

    @Override
    public void print(String indent) {
        String type = isConst ? "ConstDecl" : "VarDecl";
        System.out.println(indent + type + "{" + varNode.name + "}");
        expr.print(indent + indent);
    }
}
