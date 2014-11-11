package hash.table;
/**
 * Created by sjoshua270 on 10/23/2014.
 */
public class Node {
    private int key;
    private String content;
    private Node next;

    public Node(){
        key = 0;
        content = "";
        next = null;
    }
    public Node(int key, String content){
        this.key = key;
        this.content = content;
        next = null;
    }
    public Node(int key, String content, Node newNext){
        this.key = key;
        this.content = content;
        next = newNext;
    }

    // Getter and setter for content Object
    /**
     * Gets Node content
     * @return Object Content of the Node
     */
    public String getContent(){
        return content;
    }

    /**
     * Sets Node content
     * @param newContent Content to store in the Node
     */
    public void setContent(String newContent){
        content = newContent;
    }

    // Getter and setter for next Node
    /**
     * Gets the Node that current Node is pointing to
     * @return Node Next Node in the sequence
     */
    public Node getNext(){
        return next;
    }

    /**
     * Sets the Node that the current Node points to
     * @param newNext Node to point to
     */
    public void setNext(Node newNext){
        next = newNext;
    }

    // Getter and setter for key
    /**
     * Gets the key of current Node
     * @return String Key of the Node
     */
    public int getKey(){
        return key;
    }

    /**
     * Sets the key of the current Node
     * @param newKey Key to hold
     */
    public void setKey(int newKey){
        key = newKey;
    }
}
