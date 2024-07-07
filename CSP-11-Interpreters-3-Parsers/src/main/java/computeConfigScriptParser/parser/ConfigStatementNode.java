package computeConfigScriptParser.parser;

import computeConfigScriptParser.lexer.Lexer;
import computeConfigScriptParser.parser.ConfigScriptASTNode;

public class ConfigStatementNode extends ConfigScriptASTNode {
    public final Lexer.ConfigScriptToken name;
    public final Lexer.ConfigScriptToken value;

    public ConfigStatementNode(Lexer.ConfigScriptToken name, Lexer.ConfigScriptToken value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Config {" + name.value + " = " + value.value + "}");
    }
}