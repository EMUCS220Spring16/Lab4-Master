package hash.table;

import java.lang.reflect.Constructor;

/**
 * Created by sjoshua270 on 10/23/2014.
 */
public class Tester {
    public static void main(String[] arguments) {
        double numCorrect = 0;
        double numTests = 0;
        boolean failed = false;

        String[] names = {
                "Josh M.", "Alex", "Chris", "Josiah", "Timothy",
                "Randell", "Kyle", "Isaac", "Caleb", "Dee",
                "Aron", "Jonathan", "Suha", "David", "Josh S.",
                "Alvin", "Maise", "Matthew", "Antonina", "Dani",
                "Angel", "Jamey", "Clinton", "Jenee", "Aurora"
        };
        HashTable hashTable = null;
        numTests++;
        try {
            hashTable = new HashTable(101);
            numCorrect++;
        }
        catch (Exception e){
            System.out.println("Constructing the table with a specific size failed");
        }
        int tableSize = hashTable.getTableSize();
        int[] keys = {
                tableSize,
                tableSize * 2,
                8, 265, 35,
                56, 54, 65, 787, 346,
                68, 65, 8, 34, 7,
                2, 3, 4, 5, 1111,
                85, 86, 47, 6889, 4
        };

        // Initial tests
        numTests++;
        System.out.println("Initial tests of insert() and findEntry(). If these don't work, the rest of the tests won't continue");
        System.out.print("insert(): ");
        try {
            hashTable.insert(270, "John Smith");
            System.out.println("Success");
        } catch (Exception e) {
            System.out.print("Failed");
            failed = true;
        }
        System.out.print("findEntry(): ");
        try {
            if (hashTable.remove(270).equals("John Smith")) {
                numCorrect++;
            }
            System.out.println("Success");
        } catch (Exception e) {
            System.out.println("Failed");
            failed = true;
        }

        if (failed) {
            System.out.print("Make sure insert() and findEntry() work before continuing");
        } else {

            for (int i = 0; i < names.length; i++) {
                numTests++;
                hashTable.insert(keys[i], names[i]);
                if (hashTable.findEntry(keys[i]).equals(names[i])) {
                    numCorrect++;
                }
            }

            numTests++;
            try {
                if (hashTable.remove(keys[0]).equals(names[0]))
                    numCorrect++;
                else
                    System.out.println("Remove Failed");
            } catch (Exception e) {
                System.out.println("Failed to remove entry " + names[0] + ": " + e.toString());
            }

            numTests++;
            try {
                if (hashTable.findEntry(keys[1]).equals(names[1]))
                    numCorrect++;
                else
                    System.out.println("Finding Entry Failed");
            } catch (Exception e) {
                System.out.println("Failed to find entry " + names[1] + ": " + e.toString());
            }

            numTests++;
            try {
                if(hashTable.findEntry(keys[7]).equals(names[7]))
                   System.out.println("This should have been overwritten: "+names[7]);
                else
                    numCorrect++;
            }
            catch (Exception e){
                System.out.println(e.toString());
            }

            numTests++;
            try {
                if(hashTable.findEntry(keys[11]).equals(names[11]))
                    numCorrect++;
                else
                    System.out.println("Didn't find "+names[11]);
            }
            catch (Exception e){
                System.out.println(e.toString());
            }

            String expected = "Dani, Alex; Alvin; Maise; Aurora, Matthew; Antonina; Josh S.; Suha, Chris; Jenee; David; Timothy; Dee; Clinton; Kyle; Randell; Josiah; Jonathan, Isaac; Aron; Caleb; Angel; Jamey; ";
            System.out.println("Expected: " + expected);
            System.out.println("Actual:   " + hashTable.toString());
            numTests++;
            if (hashTable.toString().equals(expected))
                numCorrect++;
            else
                System.out.println("Output does not match");
            double score = 100 * numCorrect / numTests;
            score = Math.round(score * 100);
            score = score / 100;
            System.out.println("Tests: "+(int) numCorrect + "/" + (int) numTests);
            System.out.println("Score: "+score + "%");
        }
    }
}