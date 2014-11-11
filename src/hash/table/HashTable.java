package hash.table;

/**
 * Created by sjoshua270 on 10/23/2014.
 */
public class HashTable {

    LinkedList[] lists;
    private int tableSize = 101;

    public HashTable() {
        lists = new LinkedList[tableSize];
    }

    public HashTable(int tableSize) {
        this.tableSize = tableSize;
        lists = new LinkedList[this.tableSize];
    }

    public int getTableSize() {
        return lists.length;
    }

    public boolean insert(int key, String item) {
        int hash = hashCode(key);
        if (lists[hash] == null) {
            lists[hash] = new LinkedList();
        }
        lists[hash].add(key, item);
        return true;
    }

    private int hashCode(int k){
        return k % tableSize;
    }

    public String remove(int key) {
        int hash = hashCode(key);
        if (lists[hash] == null) return null;
        return lists[hash].remove(key);
    }

    public String findEntry(int key) {
        if (lists[hashCode(key)] == null) return null;
        return lists[hashCode(key)].get(key);
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < lists.length; i++) {
            if (i <= lists.length && lists[i] != null) {
                if (lists[i].toString() != null) {
                    output += lists[i].toString();
                    output += "; ";
                }
            }
        }
        return output;
    }
}
