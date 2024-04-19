/**
 * Dictionary Class used to create a node of a dictionary BST that stores the value, the definition, and a pointer to the left and right node
 */

public class DictionaryNode {
    //value of the node
    String value;
    //definition of the node
    String definition;
    //left child node
    DictionaryNode left;
    //right child node
    DictionaryNode right;
/**
 * 
 * @param x the value of the node
 * @param y the definition of the node
 */
    public DictionaryNode(String x, String y){
        value = x;
        definition = y;
        left = null;
        right = null;
    }
}
