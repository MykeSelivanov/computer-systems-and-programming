package interpreteres.lexers.computeConfigScript;

import interpreteres.lexers.computeConfigScript.lexer.Lexer;
import interpreteres.lexers.computeConfigScript.lexer.LexerException;

public class Main {
    public static void main(String[] args) throws LexerException {

        String input = """
                config "num_users" = 100
                config "num_requests" = 25
                update "num_users" = 145
                compute "result" = %num_users * %num_requests
                loop "i" from 1 to 5
                    compute "iteration_result_%i" = %num_users * %i
                end
                if %num_users > 1000
                update "status" = "high load"
                        else
                update "status" = "normal load"
                end
                """;

        Lexer lexer = new Lexer(input);
        for (Lexer.Token token: lexer) {
            System.out.println(token);
        }
    }
}
