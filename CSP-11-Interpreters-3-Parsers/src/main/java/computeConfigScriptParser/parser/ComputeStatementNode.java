package computeConfigScriptParser.parser;

import computeConfigScriptParser.lexer.Lexer;

public class ComputeStatementNode extends ConfigScriptASTNode {
    public final Lexer.ConfigScriptToken name;
    public final Lexer.ConfigScriptToken left;
    public final Lexer.ConfigScriptToken operator;
    public final Lexer.ConfigScriptToken right;

    public ComputeStatementNode(Lexer.ConfigScriptToken name, Lexer.ConfigScriptToken left, Lexer.ConfigScriptToken operator, Lexer.ConfigScriptToken right) {
        this.name = name;
        this.left = left;
        this.operator = operator;
        this.right = right;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + "Compute {" + name.value + " = " + left.value + " " + operator.value + " " + right.value + "}");
    }
}
