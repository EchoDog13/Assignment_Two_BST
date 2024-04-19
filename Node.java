/**
 * Class to create nodes which are used in the implementation of a binary seach tree
 * Each Node contains a value (string), and a pointer to the left and right nodes
 */

public class Node {
    //value of the node
    String value;
    //pointer to the left node
    Node left;
    //pointer to the right node
    Node right;
    
/**
 * @param x the value to store in the node
 */
    public Node(String x){
        value = x;
        left = null;
        right = null;
    }
}
