package interpreter.semanticanalysis.semanticAnalazyerExample.ast;

public class BinaryOpNode extends ASTNode {
    public ASTNode left;
    public ASTNode right;
    public Token operationToken;

    public BinaryOpNode(ASTNode left, ASTNode right, Token operationToken) {
        this.left = left;
        this.right = right;
        this.operationToken = operationToken;
    }

    public void print(String indent) {
        System.out.println(indent + "Op{" + operationToken.value + "}");
        left.print(indent + indent);
        right.print(indent + indent);
    }
}
