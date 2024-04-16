public class Main{
    public static void main(String args[]){
      StrBST alphabet = new StrBST();
        System.out.println(alphabet.search("Dog"));
        alphabet.insert("Carrot");
        alphabet.insert("Apple");
        alphabet.insert("Banana");
        alphabet.insert("Dog");
        alphabet.insert("Elephant");
      //  alphabet.search("Dog");
        alphabet.print();

        alphabet.remove("Carrot");
        System.out.println("Post Removal");
        alphabet.print();

    }
}