package interpreter.parsers.parserExample;

public class Token {
    public enum Type {
        NUMBER, MULTIPLY, DIVIDE, // PLUS, MINUS, LPAREN, RPAREN
    }

    public final Type type;
    public final String value;

    public Token(Type type, String value) {
        this.type = type;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Token{" +
                "type=" + type +
                ", value='" + value + '\'' +
                '}';
    }
}
