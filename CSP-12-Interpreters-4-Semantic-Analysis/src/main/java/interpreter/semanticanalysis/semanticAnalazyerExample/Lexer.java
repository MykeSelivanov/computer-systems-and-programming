package interpreter.semanticanalysis.semanticAnalazyerExample;

import interpreter.semanticanalysis.semanticAnalazyerExample.ast.Token;

import java.util.ArrayList;
import java.util.List;

public class Lexer {
    private final String input;
    private final List<Token> tokens;
    private int currentChar;

    List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        while (currentChar != '\0') {
            if (Character.isWhitespace(currentChar)) {
                skipWhitespace();
                continue;
            }

        }
    }

}
