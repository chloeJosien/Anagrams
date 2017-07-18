package assignment04;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

/**
 * Tests all the methods in the AnagramUtil class
 *
 * @author chloe Josien, Ryan Outtrim
 */
public class AnagramUtilTest {

    @Test
    public void sortTest() {

        String word = "karine";
        assertEquals("aeiknr", AnagramUtil.sort(word));

        String word1 = "apple";
        assertEquals("aelpp", AnagramUtil.sort(word1));

        String word2 = "a";
        assertEquals("a", AnagramUtil.sort(word2));

        String word3 = "Bats";
        assertEquals("abst", AnagramUtil.sort(word3));
    }

    //tests the generic insertion sort
    @Test
    public void insertionSortTest() {
        //tests strings
        String[] nameString = {"k", "a", "r", "i", "n", "e"};
        AnagramUtil.insertionSort(nameString, new AnagramUtil.stringCompare());
        String[] solution = {"a", "e", "i", "k", "n", "r"};
        for (int count = 0; count < nameString.length; count++) {
            assertEquals(solution[count], nameString[count]);
        }

        //test Integers
        Integer[] numArray = {5, 2, 1, 6, 4, 3};
        AnagramUtil.insertionSort(numArray, new AnagramUtil.integerCompare());
        Integer[] solutionNum = {1, 2, 3, 4, 5, 6};
        for (int count = 0; count < nameString.length; count++) {
            assertEquals(solutionNum[count], numArray[count]);
        }

        // tests characters
        Character[] charArray = {'c', 'a', 'd', 'b', 'e', 'f'};
        AnagramUtil.insertionSort(charArray, new AnagramUtil.charCompare());
        Character[] solutionChar = {'a', 'b', 'c', 'd', 'e', 'f'};
        for (int count = 0; count < nameString.length; count++) {
            assertEquals(solutionChar[count], charArray[count]);
        }

    }

    @Test
    public void areAnagramsTest() {

        //tests a known anagram
        String word = "bats";
        String compare = "stab";
        assertEquals(true, AnagramUtil.areAnagrams(word, compare));

        //tests a false anagram
        String word1 = "cars";
        String compare1 = "cats";
        assertEquals(false, AnagramUtil.areAnagrams(word1, compare1));

    }

    @Test
    public void getLargestAnagramsGroupsArrayTest() {

        String[] words = {"bats", "stab", "abst", "apple", "alepp"};
        String[] answer = {"bats", "stab", "abst"};
        String[] testAnswer = AnagramUtil.getLargestAnagramGroup(words);
        for (int count = 0; count < testAnswer.length; count++) {
            assertEquals(answer[count], testAnswer[count]);
        }

        String[] words1 = {"bats", "cans", "world", "hello", "hi"};
        String[] answer1 = {"bats"};
        String[] testAnswer1 = AnagramUtil.getLargestAnagramGroup(words1);
        for (int count = 0; count < testAnswer1.length; count++) {
            assertEquals(answer1[count], testAnswer1[count]);
        }

        String[] words2 = {"bats", "staB", "world", "hello", "hi"};
        String[] answer2 = {"bats", "staB"};
        String[] testAnswer2 = AnagramUtil.getLargestAnagramGroup(words2);
        for (int count = 0; count < testAnswer2.length; count++) {
            assertEquals(answer2[count], testAnswer2[count]);
        }
    }

    @Test
    public void getLargestAnagramGroupTest() {

        String[] answer = {"bats", "stab", "abst"};
        String[] testAnswer = AnagramUtil.getLargestAnagramGroup("Resources/test");
        for (int count = 0; count < testAnswer.length; count++) {
            assertEquals(answer[count], testAnswer[count]);
        }

        //given a mispelled file
        String[] answer1 = {};
        String[] testAnswer1 = AnagramUtil.getLargestAnagramGroup("Resources/tes");
        boolean test = Arrays.toString(answer1).equals(Arrays.toString(testAnswer1));
        assertEquals(true, test);

        //given an empty array
        String[] answer2 = {};
        String[] testAnswer2 = AnagramUtil.getLargestAnagramGroup("Resources/empty");
        boolean test1 = Arrays.toString(answer2).equals(Arrays.toString(testAnswer2));
        assertEquals(true, test1);
    }

}
