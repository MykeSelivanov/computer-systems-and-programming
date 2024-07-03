package interpreter.parsers.parserExample;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int currentPos;
    private Token currentToken;

    Parser(List<Token> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }

    public ASTNode parse() {
        return term();
    }

    private ASTNode term() {
        ASTNode node = factor();

        while (currentToken != null && (currentToken.type == Token.Type.MULTIPLY || currentToken.type == Token.Type.DIVIDE)) {
            Token token = currentToken;
            consume(currentToken.type);
            node = new BinaryOpNode(node, factor(), token);
        }
        return node;
    }

    private void consume(Token.Type type) {
        if (currentToken.type == type) {
            currentPos++;
            if (currentPos < tokens.size()) {
                currentToken = tokens.get(currentPos);
            } else {
                currentToken = null;
            }
        } else {
            throw new ParserException("Unexpected token: " + type);
        }
    }

    private ASTNode factor() {
        return null;
    }
}
