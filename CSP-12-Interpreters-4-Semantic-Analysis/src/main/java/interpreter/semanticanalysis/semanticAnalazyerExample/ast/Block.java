package interpreter.semanticanalysis.semanticAnalazyerExample.ast;

import java.util.List;

public class Block extends ASTNode {
    List<ASTNode> statements;

    public Block(List<ASTNode> statements) {
        this.statements = statements;
    }


    @Override
    public void print(String indent) {
        for (ASTNode node: statements) {
            node.print("  ");
        }
    }
}
