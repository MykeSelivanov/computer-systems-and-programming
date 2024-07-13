package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private final List<Token> tokens;
    private int currentChar;

    private Token number() {
        StringBuilder result = new StringBuilder();
        while (currentChar != '\0' && Character.isDigit(currentChar)) {
            result.append(currentChar);
            advance();
        }
        return new Token(Token.Type.NUMBER, result.toString());
    }

    private Token identifier() {
        StringBuilder result = new StringBuilder();
        while (currentChar != '\0' && Character.isLetterOrDigit(currentChar)) {
            result.append(currentChar);
            advance();
        }
        return new Token(Token.Type.IDENTIFIER, result.toString());
    }

    List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (currentChar != '\0') {
            if (Character.isWhitespace(currentChar)) {
                skipWhitespace();
                continue;
            }
            if (Character.isDigit(currentChar)) {
                tokens.add(number());
                continue;
            }
            if (Character.isLetter(currentChar)) {
                Token id = identifier();
                if (id.value.equals("var")) {
                    tokens.add(new Token(Token.Type.VAR, "var"));
                } else {
                    tokens.add(id);
                }
                continue;
            }
            switch (currentChar) {
                case '+':
                    tokens.add(new Token(Token.Type.PLUS, "+"));
                    break;
                case '-':
                    tokens.add(new Token(Token.Type.MINUS, "-"));
                    break;
                case '*':
                    tokens.add(new Token(Token.Type.MULTIPLY, "*"));
                    break;
                case '/':
                    tokens.add(new Token(Token.Type.DIVIDE, "/"));
                    break;
                case '(':
                    tokens.add(new Token(Token.Type.LPAREN, "("));
                    break;
                case ')':
                    tokens.add(new Token(Token.Type.RPAREN, ")"));
                    break;
                case '=':
                    tokens.add(new Token(Token.Type.ASSIGN, "="));
                    break;
                case '{':
                    tokens.add(new Token(Token.Type.LBRACE, "{"));
                    break;
                case '}':
                    tokens.add(new Token(Token.Type.RBRACE, "}"));
                    break;
                case ';':
                    tokens.add(new Token(Token.Type.SEMICOLON, ";"));
                    break;
                default:
                    throw new RuntimeException("Unexpected character:" + currentChar);
            }
            advance();
        }
        return tokens;
    }

}
