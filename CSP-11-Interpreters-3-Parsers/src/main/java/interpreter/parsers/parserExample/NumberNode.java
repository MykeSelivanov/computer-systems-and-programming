package interpreter.parsers.parserExample;

public class NumberNode extends ASTNode {
    final int value;
    Token numberToken;

    public NumberNode(Token numberToken) {
        this.numberToken = numberToken;
        this.value = Integer.parseInt(numberToken.value);
    }

//    @Override
//    public String toString() {
//        return "NumberNode{" +
//                value +
//                '}';
//    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "N{" + value + "}");
    }
}
