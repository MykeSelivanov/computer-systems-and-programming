package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.ASTNode;
import interpreter.semanticanalysis.semanticAnalazyerExample.ast.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = """
        3 + 5 * (10 - 1);
        var x = 4 - 5;
        x = 1;
        const y = 7;
        """;
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();
        for (Token token: tokens) {
            System.out.println(token);
        }
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();

        root.print("  ");
    }
}