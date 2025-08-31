package algorithm.tree.basic;

import lombok.Data;

import java.util.ArrayList;

@Data
public class TreeNode {
    private String data;
    ArrayList<TreeNode> children;
    
    public TreeNode(String data) {
        this.data = data;
        children = new ArrayList<TreeNode>();
    }
    
    public void addChild(TreeNode node) {
        this.children.add(node);
    }
    
    public String print(int level){
        String ret;
        ret = " ".repeat(level) + data + "\n";  // level 숫자 만큼 공백 생성

        for (TreeNode node : children) {
            ret += node.print(level + 1);
        }
        return ret; //
    }
}
