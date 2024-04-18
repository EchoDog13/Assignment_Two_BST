public class DictionaryBST {
    DictionaryNode root;

    public DictionaryBST() {
        root = null;
    }

    public void insert(String s, String def) {
        root = insertR(s, root, def);
    }

    public DictionaryNode insertR(String s, DictionaryNode cRoot, String def) {

        if (cRoot == null) {
            cRoot = new DictionaryNode(s, def);
        } else if (s.compareTo(cRoot.value) < 0) {
            cRoot.left = insertR(s, cRoot.left, def);
        } else if (s.compareTo(cRoot.value) > 0) {
            cRoot.right = insertR(s, cRoot.right, def);
        }
        return cRoot;
    }

    public void printDictonaryItem(String s) {
        DictionaryNode cRoot = root;
        boolean found = false;
        while (cRoot != null && found == false) {

            if (s.compareTo(cRoot.value) < 0) {
                cRoot = cRoot.left;
            } else if (s.compareTo(cRoot.value) > 0) {
                cRoot = cRoot.right;
            } else if (s.compareTo(cRoot.value) == 0) {
                System.out.println("Word: " + cRoot.value);
                System.out.println("Definition: " + cRoot.definition);
                found = true;
            }
        }
    }

    public void printDictonary() {
        printR(root);
    }

    public void printR(DictionaryNode cRoot) {
        if (cRoot == null) {
            return;
        }

        printR(cRoot.left);

        System.out.println("Word: " + cRoot.value);
        System.out.println("Definition: " + cRoot.definition);
        System.out.println();

        printR(cRoot.right);
    }

    public boolean search(String s) {
        boolean found = false;
        found = searchR(s, root);
        return found;
    }

    public boolean searchR(String s, DictionaryNode cRoot) {

        if (cRoot == null) {
            return false;
        } else if (s.compareTo(cRoot.value) < 0) {
            return searchR(s, cRoot.left);
        } else if (s.compareTo(cRoot.value) > 0) {
            return searchR(s, cRoot.right);
        } else {
            return true;
        }

    }

    public void remove(String s) {
        removeR(s, root);
    }

    public DictionaryNode removeR(String s, DictionaryNode cRoot) {
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
            cRoot.value = minString(cRoot.right);
            cRoot.right = removeR(cRoot.value, cRoot.right);
        }

        return cRoot;
    }

    private String minString(DictionaryNode cRoot) {
        String minString = cRoot.value;
        while (cRoot.left != null) {
            minString = cRoot.left.value;
            cRoot = cRoot.left;
        }
        return minString;
    }
}