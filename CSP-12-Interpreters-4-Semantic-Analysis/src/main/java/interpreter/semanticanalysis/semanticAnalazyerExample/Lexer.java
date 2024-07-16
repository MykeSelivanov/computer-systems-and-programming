package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private int currentPos;
    private char currentChar;

    public Lexer(String input) {
        this.input = input;
        this.currentPos = 0;
        this.currentChar = input.length() > 0 ? input.charAt(currentPos) : '\0';
    }

    private void advance() {
        currentPos++;
        if (currentPos >= input.length()) {
            currentChar = '\0'; // End of input
        } else {
            currentChar = input.charAt(currentPos);
        }
    }

    private void skipWhitespace() {
        while (currentChar != '\0' && Character.isWhitespace(currentChar)) {
            advance();
        }
    }

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
    String value = result.toString();
    if (value.equals("var")) {
        return new Token(Token.Type.VAR, "var");
    } else if (value.equals("const")) {
        return new Token(Token.Type.CONST, "const");
    } else {
        return new Token(Token.Type.IDENTIFIER, value);
    }
}

    public List<Token> tokenize() {
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
                    throw new RuntimeException("Unexpected character: " + currentChar);
            }
            advance();
        }
        return tokens;
    }
}

