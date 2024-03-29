public class StrBST{
    Node root;
    public StrBST(){

        root = null;
    }

    public void insert (String s){
        root = insertR(s, root);
    }

    public Node insertR(String s, Node cRoot){

        if(cRoot == null){
            cRoot = new Node(s);
        } else if (s.compareTo(cRoot.value)<0) {
            cRoot.left = insertR(s, cRoot.left);
        }else if (s.compareTo(cRoot.value)>0) {
            cRoot.right = insertR(s, cRoot.right);
        }
        return cRoot;
    }


    public void print(){
        printR(root);
    }

    public void printR(Node cRoot){
        if (cRoot == null) {
            return;
        }

        System.out.println("Root: " + cRoot.value);

        if (cRoot.left == null) {
            System.out.print(" | Left: null");
        }else{
            System.out.print(" | Left: " + cRoot.left.value);

        }

        if (cRoot.right == null) {
            System.out.print(" | Right: null");

        }else{
            System.out.print(" | Right: " + cRoot.right.value);
        }
        System.out.println();


        printR(cRoot.left);
        printR(cRoot.right);

    }

    public boolean search(string s){
    boolean found = false;
    found = searchR(s, root);
    return found;
    }
    public boolean searchR(string s, Node cRoot){
        boolean found = false;

        if (cRoot == null){
            return false;
        } else if (s.compareTo(cRoot.value)<0) {
        cRoot.left = insertR(s, cRoot.left);
    }else if (s.compareTo(cRoot.value)>0) {
        cRoot.right = insertR(s, cRoot.right);
    }else if (s.compareTo(cRoot.value)==0){
        return true;
    }
        return found;

}