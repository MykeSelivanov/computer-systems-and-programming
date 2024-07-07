package computeConfigScriptParser.parser;

import computeConfigScriptParser.lexer.Lexer;

public class UpdateStatementNode  extends  ConfigScriptASTNode{
    public final Lexer.ConfigScriptToken name;
    public final Lexer.ConfigScriptToken value;

    public UpdateStatementNode(Lexer.ConfigScriptToken name, Lexer.ConfigScriptToken value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Update {" + name.value + " = " + value.value + "}");
    }
}
