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

        // Lexer
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.tokenize();
        for (Token token: tokens) {
            System.out.println(token);
        }

        // Parser
        Parser parser = new Parser(tokens);
        ASTNode root = parser.parse();

        // Print the AST tree
        root.print("  ");

        // Semantic analyzer
        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
        try {
            semanticAnalyzer.visit(root);
            System.out.println("Semantic analysis passed");
        } catch (InterpreterException e) {
            System.err.println("Semantic error: " + e.getMessage());
        }

        // Interpreter
        Interpreter interpreter = new Interpreter();
        try {
            int result = interpreter.visit(root);
            System.out.println("Interpretation result: " + result);
        } catch (InterpreterException e) {
            System.err.println("Interpretation error: " + e.getMessage());
        }
    }
}