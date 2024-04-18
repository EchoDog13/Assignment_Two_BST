public class StrBST {
    Node root;

    public StrBST() {

        root = null;
    }

    public void insert(String s) {
        root = insertR(s, root);
    }

    public Node insertR(String s, Node cRoot) {

        if (cRoot == null) {
            cRoot = new Node(s);
        } else if (s.compareTo(cRoot.value) < 0) {
            cRoot.left = insertR(s, cRoot.left);
        } else if (s.compareTo(cRoot.value) > 0) {
            cRoot.right = insertR(s, cRoot.right);
        }
        return cRoot;
    }

    public void print() {
        printR(root);
    }

    public void printR(Node cRoot) {
        if (cRoot == null) {
            return;
        }
        printR(cRoot.left);
        System.out.print("Root: " + cRoot.value);

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

        
        printR(cRoot.right);

    }

    public boolean search(String s) {
        boolean found = false;
        found = searchR(s, root);
        return found;
    }

    public boolean searchR(String s, Node cRoot) {
        boolean found = false;

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
private String minString(Node cRoot){
    String minString = cRoot.value;
    while (cRoot.left !=null) {
        minString = cRoot.left.value;
        cRoot = cRoot.left;
    }
    return minString;
}
}