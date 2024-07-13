package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.Token;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Lexer lexer = new Lexer("3 + 5 * (10 - 1); var x = 4 - 5; x = 1");
        List<Token> tokens = lexer.tokenize();


    }
}