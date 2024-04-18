public class DictionaryNode {
    String value;
    String definition;
    DictionaryNode left;
    DictionaryNode right;

    public DictionaryNode(String x, String y){
        value = x;
        definition = y;
        left = null;
        right = null;
    }
}
