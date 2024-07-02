package interpreter.parsers.parserExample;

public class BinaryOpNode extends ASTNode {
    ASTNode left;
    ASTNode right;
    Token operationToken;

    public BinaryOpNode(ASTNode left, ASTNode right, Token operationToken) {
        this.left = left;
        this.right = right;
        this.operationToken = operationToken;
    }
}
