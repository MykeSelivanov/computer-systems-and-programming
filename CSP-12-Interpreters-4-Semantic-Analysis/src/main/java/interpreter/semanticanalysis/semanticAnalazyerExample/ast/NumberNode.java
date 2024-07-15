package interpreter.semanticanalysis.semanticAnalazyerExample.ast;

public class NumberNode extends ASTNode {
    public final int value;
    public Token numberToken;

    public NumberNode(Token numberToken) {
        this.numberToken = numberToken;
        this.value = Integer.parseInt(numberToken.value);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "N{" + value + "}");
    }
}
