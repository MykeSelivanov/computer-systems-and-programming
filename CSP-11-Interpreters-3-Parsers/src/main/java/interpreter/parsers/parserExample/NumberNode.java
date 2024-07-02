package interpreter.parsers.parserExample;

public class NumberNode extends ASTNode {
    final int value;
    Token numberToken;

    public NumberNode(Token numberToken) {
        this.numberToken = numberToken;
        this.value = Integer.parseInt(numberToken.value);
    }
}
