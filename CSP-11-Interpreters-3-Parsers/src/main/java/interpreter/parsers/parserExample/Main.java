package interpreter.parsers.parserExample;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 3 * 5 * 10 * 4
        List<Token> tokens = Lexer.getHardcodedTokens();
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();

        root.print("  ");
    }
}