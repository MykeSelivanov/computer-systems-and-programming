package computeConfigScriptParser.parser;

public class ShowConfigsNode extends ConfigScriptASTNode{
    @Override
    public void print(String indent) {
        System.out.println(indent + "Show configs");
    }
}
