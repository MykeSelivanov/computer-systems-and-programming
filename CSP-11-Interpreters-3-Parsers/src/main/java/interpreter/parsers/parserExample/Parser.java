package interpreter.parsers.parserExample;

public class Parser {
    abstract class ASTNode {

    }

    class Number extends ASTNode {
        Token numberToken;

        public Number(Token numberToken) {
            this.numberToken = numberToken;
        }
    }

    class BinaryOp extends ASTNode {
        ASTNode left;
        ASTNode right;
        Token operationToken;

        public BinaryOp(ASTNode left, ASTNode right, Token operationToken) {
            this.left = left;
            this.right = right;
            this.operationToken = operationToken;
        }
    }
}
