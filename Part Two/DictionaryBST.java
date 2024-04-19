/**
 * DictionaryBST.java
 * 
 * This class is creates an implementation of a BST dictionary. The class
 * contains method to insert, remove and search recursivley, as well as a print
 * and a print all method
 * 
 * @author Kyle Barker
 * @version
 */

public class DictionaryBST {
    // root node of the BST
    DictionaryNode root;

    public DictionaryBST() {
        root = null;
    }

    /**
     * method to insert a value into the BST
     * 
     * @param s   value to insert
     * @param def definition to insert
     */

    public void insert(String s, String def) {
        root = insertR(s, root, def);
    }

    /**
     * Recursive method to insert a value into the BST
     * 
     * @param s     the value to insert
     * @param cRoot the root node to start at
     * @param def   the definition to insert
     * @return the node that is inserted
     */

    public DictionaryNode insertR(String s, DictionaryNode cRoot, String def) {
        // if root node is null, make the new node the root node
        if (cRoot == null) {
            cRoot = new DictionaryNode(s, def);
        } // if the value s is less than the current node, insert to the left
        else if (s.compareTo(cRoot.value) < 0) {
            cRoot.left = insertR(s, cRoot.left, def);
        } // if the value s is greater than the current node, insert to the right
        else if (s.compareTo(cRoot.value) > 0) {
            cRoot.right = insertR(s, cRoot.right, def);
        }
        return cRoot;
    }

    /**
     * Method to print specifc value from dictionary, and its definition
     * 
     * @param s the value to search for and print defintion
     */
    public void printDictonaryItem(String s) {

        DictionaryNode cRoot = root;
        boolean found = false;

        // checks tree is not empty and if the value has been found
        while (cRoot != null && found == false) {
            // if the value is less than the current root alphabetically, go left
            if (s.compareTo(cRoot.value) < 0) {
                cRoot = cRoot.left;
            }
            // if the value is greater than the current root alphabetically, go right
            else if (s.compareTo(cRoot.value) > 0) {
                cRoot = cRoot.right;
            } // if the value is equal to the current root, print
            else if (s.compareTo(cRoot.value) == 0) {
                System.out.println("Word: " + cRoot.value);
                System.out.println("Definition: " + cRoot.definition);
                // exits loop
                found = true;
            }
        }
    }
/**
 * Method to print the entire dictionary
 */
    public void printDictonary() {
        printR(root);
    }

/**
 * Method to print the entire dictionary using in order transveral
 * @param cRoot the current head root of the BST
 */
    public void printR(DictionaryNode cRoot) {
        if (cRoot == null) {
            return;
        }
        //Transverse LHS
        printR(cRoot.left);

        //Process - print
        System.out.println("Word: " + cRoot.value);
        System.out.println("Definition: " + cRoot.definition);
        System.out.println();

        //Transverse RHS
        printR(cRoot.right);
    }


    /**
     * Method to search tree to check if it contains a value
     * @param s value to search for
     * @return if the value has been found
     */
    public boolean search(String s) {
        boolean found = false;
        //call recursive function to search for value
        found = searchR(s, root);
        return found;
    }

/**
 * 
 * @param s value to search for
 * @param cRoot the head root of the BST
 * @return if the value is found in the BST
 */
    public boolean searchR(String s, DictionaryNode cRoot) {
        //if node is null, either BST is empty, or reached a empty leaf node, therefore does not contain value s, return flase
        if (cRoot == null) {
            return false;
        } //if s is less than cRoot, go left
        else if (s.compareTo(cRoot.value) < 0) {
            return searchR(s, cRoot.left);
        } //if s is greather than cRoot, go right
        else if (s.compareTo(cRoot.value) > 0) {
            return searchR(s, cRoot.right);
        } //if not greater or less than, must be equal, and therefore list contains value, return true
        else {
            return true;
        }

    }
/**
 * Method to remove a value and its definition from the tree
 * @param s value to remove
 */
    public void remove(String s) {
        removeR(s, root);
    }
/**
 * Method to remove value and its definition from the tree
 * @param s value to remove
 * @param cRoot root node of BST
 * @return returns root node
 */

    public DictionaryNode removeR(String s, DictionaryNode cRoot) {
        if (cRoot == null) {
            return root;
        }

        if (s.compareTo(cRoot.value) < 0) {
            cRoot.left = removeR(s, cRoot.left);
        } else if (s.compareTo(cRoot.value) > 0) {
            cRoot.right = removeR(s, cRoot.right);
        } else {
            // If the node to be deleted has one or no children, return child
            if (cRoot.left == null) {
                return cRoot.right;
            } else if (cRoot.right == null) {
                return cRoot.left;
            }
            //calls to find the left most node of the right sub tree
            cRoot.value = minString(cRoot.right);
            cRoot.right = removeR(cRoot.value, cRoot.right);
            
    }

        return cRoot;
    }
/**
 *  Private method used when removing from BST, to find the left most node of the right sub tree
 * @param cRoot right node to start from
 * @return left most node of right sub tree
 */
    private String minString(DictionaryNode cRoot) {
        String minString = cRoot.value;
        //continues iterating left till next node is null, getting the value
        while (cRoot.left != null) {
            minString = cRoot.left.value;
            //move left
            cRoot = cRoot.left;
        }
        return minString;
    }
}