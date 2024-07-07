package computeConfigScriptParser.parser;

import computeConfigScriptParser.lexer.Lexer;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    private final List<Lexer.ConfigScriptToken> tokens;
    private int currentPos;
    private Lexer.ConfigScriptToken currentToken;

    public Parser(List<Lexer.ConfigScriptToken> tokens) {
        this.tokens = tokens;
        this.currentPos = 0;
        this.currentToken = tokens.get(currentPos);
    }

    public List<ConfigScriptASTNode> parse() throws ParserException {
        List<ConfigScriptASTNode> statements = new ArrayList<>();
        while (currentToken != null) {
            statements.add(statement());
        }
        return statements;
    }

    private ConfigScriptASTNode statement() throws ParserException {
        switch (currentToken.type) {
            case CONFIG:
                return configStatement();
            case UPDATE:
                return updateStatement();
            case COMPUTE:
                return computeStatement();
            case SHOW:
                return showStatement();
            default:
                throw new ParserException("Unexpected token: " + currentToken);
        }
    }

    private ConfigScriptASTNode configStatement() throws ParserException {
        consume(Lexer.TokenType.CONFIG);
        Lexer.ConfigScriptToken name = consume(Lexer.TokenType.STRING);
        consume(Lexer.TokenType.ASSIGNMENT);
        Lexer.ConfigScriptToken value = consume(Lexer.TokenType.NUMBER);
        return new ConfigStatementNode(name, value);
    }

    private ConfigScriptASTNode updateStatement() throws ParserException {
        consume(Lexer.TokenType.UPDATE);
        Lexer.ConfigScriptToken name = consume(Lexer.TokenType.STRING);
        consume(Lexer.TokenType.ASSIGNMENT);
        Lexer.ConfigScriptToken value = consume(Lexer.TokenType.NUMBER);
        return new UpdateStatementNode(name, value);
    }

    private ConfigScriptASTNode computeStatement() throws ParserException {
        consume(Lexer.TokenType.COMPUTE);
        Lexer.ConfigScriptToken name = consume(Lexer.TokenType.STRING);
        consume(Lexer.TokenType.ASSIGNMENT);
        Lexer.ConfigScriptToken left = consume(Lexer.TokenType.REFERENCES);
        Lexer.ConfigScriptToken operator = consume(Lexer.TokenType.OPERATOR);
        Lexer.ConfigScriptToken right = consume(Lexer.TokenType.REFERENCES);
        return new ComputeStatementNode(name, left, operator, right);
    }

    private ConfigScriptASTNode showStatement() throws ParserException {
        consume(Lexer.TokenType.SHOW);
        consume(Lexer.TokenType.CONFIGS);
        return new ShowConfigsNode();
    }

    private Lexer.ConfigScriptToken consume(Lexer.TokenType type) throws ParserException {
        if (currentToken.type == type) {
            Lexer.ConfigScriptToken token = currentToken;
            currentPos++;
            if (currentPos < tokens.size()) {
                currentToken = tokens.get(currentPos);
            } else {
                currentToken = null;
            }
            return token;
        } else {
            throw new ParserException("Expected token type: " + type + " but found: " + currentToken.type);
        }
    }
}
