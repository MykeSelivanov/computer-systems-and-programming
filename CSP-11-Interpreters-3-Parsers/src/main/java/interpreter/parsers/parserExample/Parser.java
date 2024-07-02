package interpreter.parsers.parserExample;

import javax.xml.parsers.ParserConfigurationException;
import java.text.ParseException;
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
        ASTNode factor = factor();

        while (currentToken != null || currentToken.type == Token.Type.MULTIPLY || currentToken.type == Token.Type.DIVIDE) {
            consume(currentToken.type);
        }
    }

    private void consume(Token.Type type) {
        if (currentToken.type == type) {

        } else {
            throw new ParserException("Unexpected token: " + type);
        }
    }

    private ASTNode factor() {
    }
}
