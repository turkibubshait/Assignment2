package pkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class SpellChecker {

    /**
     * This method takes in a filename and spells check it
     *
     * @param filename an input file stream (i.e. bonk.txt)
     * @return ArrayList<String> list of words not found in dictionary
     */
    public ArrayList<String> spell(String filename) {
        ArrayList<String> list = new ArrayList<>();
        ArrayList<String> dict = new ArrayList<>();
        ArrayList<String> words = new ArrayList<>();
        try {
            String line, line2;

            BufferedReader br2 = new BufferedReader(new FileReader("dictionary.txt"));
            while ((line2 = br2.readLine()) != null) {
                dict.add(line2);
            }
            br2.close();
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(" ");
                words.addAll(Arrays.asList(arr));
            }
            br.close();
            
            
           for(String str:words)
           {
               if(dict.contains(str))
               {
                   list.add(str);
               }
           }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * This method takes the list of words not found in the dictionary and
     * prints a list of non-duplicate words
     *
     * @param <error>
     * @param arr
     * @param ArrayList<String> List of words not found in dictionary
     */
    public void printNonDuplicates(ArrayList<String> arr) {

        arr = new ArrayList<>(new LinkedHashSet<>(arr));
        for (String str : arr) {
            System.out.println(str);
        }
    }

    /**
     * This method returns true if a word in input file stream (i.e. bonk.txt)
     * is in the dictionary, false otherwise.
     *
     * @param word a string that contains a word to be checked
     * @return the boolean status of the word (i.e. true or false)
     */
    public boolean inDictionary(String word, String[] dictionary) {
        boolean isfound = false;
        try {
            BufferedReader br = new BufferedReader(new FileReader("dictionary.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(word)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return isfound;
    }

    public static void main(String[] args) {
        // Prompt the user to enter a file to be spell checked
        SpellChecker sc = new SpellChecker();
        ArrayList<String> list = sc.spell("bonk.txt");
        System.out.println("List of Correctlt Matched words");
        for(String str:list)
         {
         System.out.println("> "+str);
         }
    }
}
