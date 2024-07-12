package interpreter.semanticanalysis.semanticAnalazyerExample.ast;

public class Var extends ASTNode {
    Token token;
    String name;

    public Var(Token token, String name) {
        this.token = token;
        this.name = name;
    }


    @Override
    public void print(String indent) {
        System.out.println(indent + "Var{" + name + "}");
    }
}
