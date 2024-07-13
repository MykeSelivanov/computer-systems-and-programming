package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.ASTNode;
import interpreter.semanticanalysis.semanticAnalazyerExample.ast.Token;

import java.util.List;

public class Parser {
    private final List<Token> tokens;
    private int currentPos;
    private Token currentToken;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
        currentPos = 0;
        currentToken = tokens.get(currentPos);
    }

    public ASTNode parse() {
        return expression();
    }
}
