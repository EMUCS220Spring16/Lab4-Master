package hash.table;

/**
 * Created by sjoshua270 on 10/23/2014.
 */
public interface List {
    public boolean add(int key, String newString);
    public String get(int key);
    public String remove(int key);
    public int size();
    public boolean isEmpty();
}
