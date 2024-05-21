import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

class Solution {
    
    private int index = 0;
    
    public int[][] solution(int[][] nodeinfo) {
        
        int[][] answer = new int[2][nodeinfo.length];
        List<Node> nodeList  = new ArrayList<>();
        int value = 1;
        
        for(int[] n : nodeinfo) {
            nodeList.add(new Node(value++, n[0], n[1]));
        }
        
        Collections.sort(nodeList, Comparator.comparing(Node::getY).reversed());
        
        Node node = createTree(nodeList);
        
        
        preOrder(node, answer[0]);
        index = 0;
        postOrder(node, answer[1]);
        
        return answer;
    }
    
    private class Node {
        int value;
        int x;
        int y;
        Node left;
        Node right;
        
        
        Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
        
        int getX() { return this.x; }
        int getY() { return this.y; }
        int getValue() { return this.value; }
    }
    
    private Node createTree(List<Node> nodeList) {
        if(nodeList.isEmpty()) return null;
        
        Node root = nodeList.get(0);
        
        for(int i = 1; i < nodeList.size(); i++) {
            insert(root, nodeList.get(i));
        }
        
        return root;
    }
    
    private void insert(Node parent, Node child) {
        //왼쪽
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
    }
    
    private void preOrder(Node node, int[] result) {
        if(node == null) return;
        
        result[index++] = node.value;
        preOrder(node.left, result);
        preOrder(node.right, result);
    }
    
    private void postOrder(Node node, int[] result) {
        if(node == null) return;
        
        postOrder(node.left, result);
        postOrder(node.right, result);
        result[index++] = node. value;
    }
}