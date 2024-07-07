package computeConfigScriptParser;

import computeConfigScriptParser.lexer.Lexer;
import computeConfigScriptParser.lexer.LexerException;
import computeConfigScriptParser.parser.ConfigScriptASTNode;
import computeConfigScriptParser.parser.Parser;

import java.util.List;

public class Main {
    public static void main(String[] args) throws LexerException {
        String input = """
                config "num_users" = 100
                config "request_rate" = 5
                config "timeout" = 30
                update "num_users" = 200
                update "request_rate" = 7
                compute "total_requests" = %num_users * %request_rate
                compute "total_timeout" = %num_users * %timeout
                show configs
                """;

        Lexer lexer = new Lexer(input);
        Parser parser = new Parser(lexer.getAllTokens());

        List<ConfigScriptASTNode> program = parser.parse();

        for (ConfigScriptASTNode node : program) {
            node.print(" ");
        }
    }
}
