package interpreter.semanticanalysis.semanticAnalazyerExample.ast;

public class Token {
    public enum Type {
        NUMBER, IDENTIFIER, PLUS, MINUS, MULTIPLY, DIVIDE, ASSIGN, VAR, CONST, LBRACE, RBRACE, LPAREN, RPAREN, SEMICOLON
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
