package assignment04;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author chloe Josien, Ryan Outtrim
 */
public class AnagramUtil {

    /**
     * Gets a word and sorts it by letter using an insertion sort.
     *
     * @param word - gets a word to turn into an anagram
     * @return - returns the sorted word
     */
    public static String sort(String word) {
        //converts the string to and array
        String[] stringArray = new String[word.length()];
        String newWord = word.toLowerCase();
        for (int size = 0; size < newWord.length(); size++) {
            stringArray[size] = newWord.substring(size, size + 1);
        }
        //sorts the array by insertion
        insertionSort(stringArray, new stringCompare());

        // converts the array back into a string
        String sorted = "";
        for (int num = 0; num < stringArray.length; num++) {
            sorted += stringArray[num];
        }
        return sorted;
    }

    // This generic method sorts the input array using an insertion sort and
    // the input Comparator object.

    /**
     * Sorts the array of a generic type using insertion sort
     *
     * @param arrayType  - an array of a generic type
     * @param comparator - a comparator of generic type
     * @param <T>        - of type generic
     */
    public static <T> void insertionSort(T[] arrayType, Comparator<? super T> comparator) {
        for (int count = 1; count < arrayType.length; count++) {
            T temp = arrayType[count];
            for (int position = count - 1; position >= 0; position--) {
                if (comparator.compare(arrayType[position], temp) > 0) {
                    arrayType[position + 1] = arrayType[position];
                    if (position == 0) {
                        arrayType[position] = temp;
                    }
                } else {
                    arrayType[position + 1] = temp;
                    break;
                }
            }
        }

    }

    /**
     * This method takes two strings and checks to see if they are
     * anagrams of each other.
     *
     * @param anagram - the first string to compare if an anagram
     * @param compare - the second string to compare if an anagram
     * @return - returns true if an anagram else returns false
     */
    public static boolean areAnagrams(String anagram, String compare) {
        String sortedAnagram = AnagramUtil.sort(anagram);
        String sortedCompare = AnagramUtil.sort(compare);
        return sortedAnagram.equals(sortedCompare);
    }

    //This method returns the largest group of anagrams in the input
    // array of words, in no particular order. It returns an empty array if
    // there are no anagrams in the input array.

    /**
     * Gets an array of strings and find the biggest list of anaragrams
     * and returns them in an array
     *
     * @param wordList - a string array of word
     * @return - the list of anagram that are the largest
     */
    public static String[] getLargestAnagramGroup(String[] wordList) {
        String[] anagramGroup;
        ArrayList<Integer> currentAnagramGroup = new ArrayList<Integer>();
        ArrayList<Integer> savedAnagramGroup = new ArrayList<Integer>();
        ArrayList<String> anagramer = new ArrayList<String>();

        //loops through the word list to find anagrams
        //if anagrams are found it makes the list of them
        //if that list is bigger then the previous it saves it
        for(int index = 0; index < wordList.length; index++) {
            if(savedAnagramGroup.size() < currentAnagramGroup.size()) {
                savedAnagramGroup = new ArrayList<Integer>(currentAnagramGroup);
            }
            currentAnagramGroup.clear();
            for(int words = index; words < wordList.length; words++) {
                if(areAnagrams(wordList[index], wordList[words])) {
                    currentAnagramGroup.add(words);
                }
            }
        }

        //uses the saved list to add the words to an array list
        for(int index = 0; index < savedAnagramGroup.size(); index++) {
            anagramer.add(wordList[savedAnagramGroup.get(index)]);
        }

        //converts the arraylist to an array to be returned
        anagramGroup = new String[anagramer.size()];
        for(int index = 0; index < savedAnagramGroup.size(); index++) {
            anagramGroup[index] = anagramer.get(index);
        }

        return anagramGroup;
    }

    // Behaves the same as the previous method, but reads the list of
    // words from the input filename. It is assumed that the file contains
    // one word per line. If the file does not exist or is empty, the method
    // returns an empty array because there are no anagrams.
    public static String[] getLargestAnagramGroup(String fileName) {
        //creates a bufferedReader and reads the given fileName
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            return new String[]{};
        }
        //adds each word to an ArrayList
        Scanner scan = new Scanner(reader);
        ArrayList<String> words = new ArrayList<>();
        while (scan.hasNext()) {
            words.add(scan.next());
        }
        //converts arrayList into a string array
        String[] wordArray = new String[words.size()];
        for (int count = 0; count < wordArray.length; count++) {
            wordArray[count] = words.get(count);
        }
        scan.close();
        //returns the largest anagram group
        return getLargestAnagramGroup(wordArray);
    }

    /**
     * This class implements Comparator and uses it to compare strings
     */
    public static class stringCompare implements Comparator<String> {
        // compares the strings and returns either -1,0,1
        @Override
        public int compare(String left, String right) {
            return left.compareTo(right);
        }
    }

    /**
     *  This class implements Comparator and uses it to compare integers
     */
    public static class integerCompare implements Comparator<Integer> {

        @Override
        public int compare(Integer value, Integer num) {
            return value.compareTo(num);
        }
    }

    /**
     *  This class implements Comparator and uses it to compare characters
     */
    public static class charCompare implements Comparator<Character> {
        @Override
        public int compare(Character first, Character second) {
            return first.compareTo(second);
        }
    }

    //for arrayLists timing

    /**
     * Does the same as the one above only sorting with arraylists
     * @param wordList
     * @return
     */
    public static String[] getLargestAnagramGroupArrayList(String[] wordList) {
        String[] anagramGroup;
        ArrayList<Integer> currentAnagramGroup = new ArrayList<Integer>();
        ArrayList<Integer> savedAnagramGroup = new ArrayList<Integer>();
        ArrayList<String> anagramer = new ArrayList<String>();

        //loops through the word list to find anagrams
        //if anagrams are found it makes the list of them
        //if that list is bigger then the previous it saves it
        for(int index = 0; index < wordList.length; index++) {
            if(savedAnagramGroup.size() < currentAnagramGroup.size()) {
                savedAnagramGroup = new ArrayList<Integer>(currentAnagramGroup);
            }
            currentAnagramGroup.clear();
            for(int words = index; words < wordList.length; words++) {
                if(areAnagramsArrayList(wordList[index], wordList[words])) {
                    currentAnagramGroup.add(words);
                }
            }
        }

        //uses the saved list to add the words to an array list
        for(int index = 0; index < savedAnagramGroup.size(); index++) {
            anagramer.add(wordList[savedAnagramGroup.get(index)]);
        }

        //converts the arraylist to an array to be returned
        anagramGroup = new String[anagramer.size()];
        for(int index = 0; index < savedAnagramGroup.size(); index++) {
            anagramGroup[index] = anagramer.get(index);
        }

        return anagramGroup;
    }

    /**
     * sorts using arrayLists
     *
     * @param anagram
     * @param compare
     * @return
     */
    public static boolean areAnagramsArrayList(String anagram, String compare) {
        //converts the string to and array
        ArrayList<String> listAnagram= new ArrayList<>();
        ArrayList<String> listCompare= new ArrayList<>();
        for (int size = 0; size < anagram.length(); size++) {
            listAnagram.add(anagram.substring(size,size+1));
        }
        for(int count=0; count<compare.length(); count++){
            listCompare.add(compare.substring(count,count+1));
        }
        listAnagram.sort(new stringCompare());
        listCompare.sort(new stringCompare());
        return listAnagram.equals(listCompare);
    }
}
