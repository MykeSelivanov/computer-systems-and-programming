package interpreter.parsers.parserExample;

import java.util.Arrays;
import java.util.List;

public class Lexer {
    public static List<Token> getHardcodedTokens() {

        // 3 * 5 + 10 * 4
//        return Arrays.asList(
//                new Token(Token.Type.NUMBER, "3"),
//                new Token(Token.Type.MULTIPLY, "*"),
//                new Token(Token.Type.NUMBER, "5"),
//                new Token(Token.Type.PLUS, "+"),
//                new Token(Token.Type.NUMBER, "10"),
//                new Token(Token.Type.MULTIPLY, "*"),
//                new Token(Token.Type.NUMBER, "4")
//        );

        // 3 + 5 * (10 - 4)
        return Arrays.asList(
                new Token(Token.Type.NUMBER, "3"),
                new Token(Token.Type.PLUS, "+"),
                new Token(Token.Type.NUMBER, "5"),
                new Token(Token.Type.MULTIPLY, "*"),
                new Token(Token.Type.LPAREN, "("),
                new Token(Token.Type.NUMBER, "10"),
                new Token(Token.Type.MINUS, "-"),
                new Token(Token.Type.NUMBER, "4"),
                new Token(Token.Type.RPAREN, ")")
        );
    }
}
