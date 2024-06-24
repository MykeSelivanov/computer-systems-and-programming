package interpreteres.lexers.computeConfigScript;

import interpreteres.lexers.computeConfigScript.lexer.Lexer;
import interpreteres.lexers.computeConfigScript.lexer.LexerException;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws LexerException {

        String input = """
                config "num_users" = 100
                config "num_requests" = 100
                update "num_users" = 200
                compute "result" = %num_users * %num_requests
                """;

        Lexer lexer = new Lexer(input);
        for (Lexer.Token token: lexer) {
            System.out.println(token);
        }
    }
}
