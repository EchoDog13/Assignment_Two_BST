/**
 * This class is performs operations including insertion, removal, searching and printing the Binary Search Tree
 * @author Kyle Barker 
 */

public class StrBST {
    Node root;

    public StrBST() {
        root = null;
    }

 /**
  * Method used to insert into the BST
  * @param s the value to insert
  */
    public void insert(String s) {
        root = insertR(s, root);
    }
/**
 * Recursive method to insert a value to the BST
 * @param s the value to add
 * @param cRoot the head of the BST
 * @return the root of the BST
 */
    public Node insertR(String s, Node cRoot) {
        //if head is null, tree is emtpy so insert at root
        //checks if less than alphabetically, calls left
        //else if greater than alphabetically, calls right
        if (cRoot == null) {
            cRoot = new Node(s);
        } else if (s.compareTo(cRoot.value) < 0) {
            cRoot.left = insertR(s, cRoot.left);
        } else if (s.compareTo(cRoot.value) > 0) {
            cRoot.right = insertR(s, cRoot.right);
        }
        return cRoot;
    }
/**
 * Method to use to call recursive method to print tree
 */
    public void print() {
        printR(root);
    }
/**
 * Recursive method to print tree using in order transveral
 * @param cRoot
 */
    public void printR(Node cRoot) {
        //if head is null, tree is empty
        if (cRoot == null) {
            return;
        }
        //transverse LHS
        printR(cRoot.left);
        System.out.print("Root: " + cRoot.value);
        //process and print node
        if (cRoot.left == null) {
            System.out.print(" | Left: null");
        } else {
            System.out.print(" | Left: " + cRoot.left.value);
        }
        if (cRoot.right == null) {
            System.out.print(" | Right: null");

        } else {
            System.out.print(" | Right: " + cRoot.right.value);
        }
        System.out.println();
        //transverse RHS
        printR(cRoot.right);

    }
/**
 * Method to call search function to find if a word exists in the tree
 * @param s value to search for
 * @return boolean if the value is contained in the tree
 */
    public boolean search(String s) {
        boolean found = false;
        //call recursive function parsing the value to search for and the root node
        found = searchR(s, root);
        return found;
    }

    /**
     * 
     * @param s value to search for
     * @param cRoot root of the BST
     * @return boolean if BST contains value
     */
    public boolean searchR(String s, Node cRoot) {
        boolean found = false;

        //if the tree is empty, return false
        //else if less than alaphabetically, search LHS
        //else if greather than alpahbetically, search RHS
        //else if equal, found

        if (cRoot == null) {
            return false;
        } else if (s.compareTo(cRoot.value) < 0) {
            found = searchR(s, cRoot.left);
        } else if (s.compareTo(cRoot.value) > 0) {
            found = searchR(s, cRoot.right);
        } else if (s.compareTo(cRoot.value) == 0) {
            return true;
        }
        return false;

    }

    public void remove(String s) {
        removeR(s, root);
    }

    public Node removeR(String s, Node cRoot) {
        String placeholder;
        if (cRoot == null) {
            return root;
        }

        if (s.compareTo(cRoot.value) < 0) {
            cRoot.left = removeR(s, cRoot.left);
        } else if (s.compareTo(cRoot.value) > 0) {
            cRoot.right = removeR(s, cRoot.right);
        } else {
            // If the node to be deleted has one or no children
            if (cRoot.left == null) {
                return cRoot.right;
            } else if (cRoot.right == null) {
                return cRoot.left;
            }

        }
        cRoot.value = minString(cRoot.right);
        cRoot.right = removeR(cRoot.value, cRoot.right);
        return cRoot;
    }

    private String minString(Node cRoot) {
        String minString = cRoot.value;
        while (cRoot.left != null) {
            minString = cRoot.left.value;
            cRoot = cRoot.left;
        }
        return minString;
    }
}