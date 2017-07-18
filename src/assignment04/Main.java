package assignment04;

import java.util.Arrays;
import java.util.Random;

/**
 * Runs the AnagramUtil for words, moderate_word_list, and words_english
 *
 * @author chloe Josien, Ryan Outtrim
 */
public class Main {
    public static void main(String[] args) {

        long startTime;
        long endTime;

        // runs the words list in resources
//        startTime = System.nanoTime();
//        String[] wordsArray = AnagramUtil.getLargestAnagramGroup("Resources/words");
//        endTime = System.nanoTime();
//        System.out.println("The largest anagram is: " + Arrays.toString(wordsArray));
//        System.out.println("Time take: " + (endTime - startTime) / ((double) 1000000000) + "seconds");
//
//
        //runs the moderate word list in resources
//        startTime = System.nanoTime();
//        String[] moderateWordListArray = AnagramUtil.getLargestAnagramGroup(
//                "Resources/moderate_word_list");
//        endTime = System.nanoTime();
//        System.out.println("The largest anagram is: " + Arrays.toString(moderateWordListArray));
//        System.out.println("Time take: " + (endTime - startTime) / ((double) 1000000000) + "seconds");

        //runs the words English in resources
        //startTime=System.nanoTime();
        //String[] wordsEnglishArray = AnagramUtil.getLargestAnagramGroup("Resources/words_english");
        //endTime =System.nanoTime();
        //System.out.println("The largest anagram is: " + Arrays.toString(wordsEnglishArray));
        //System.out.println("Time take: "+ (endTime-startTime)/((double)1000000000) + "seconds");

        //timing code for areAnagrams
        double total=0.0;
        for(int count=0; count<100;count++){
            String one = "";
            String two = "";
            Random randomChar = new Random();
            for(int length=0;length<100;length++){
                one = ""+Math.random()*10;
                two = ""+Math.random()*10;
            }
            startTime = System.nanoTime();
            AnagramUtil.areAnagrams(one,two);
            endTime = System.nanoTime();
            double math =(endTime-startTime)/((double)1000000000);
            total += math;
        }
        System.out.println(total);

        //timing code for getLargestAnagram group
        String[] randomStringsMaker = new String[500];
        for(int count=0;count<randomStringsMaker.length;count++) {
            Random randomString = new Random();
            for (int i = 0; i < randomStringsMaker.length; i++) {
                char[] word = new char[randomString.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
                for (int j = 0; j < word.length; j++) {
                    word[j] = (char) ('a' + randomString.nextInt(26));
                }
                randomStringsMaker[i] = new String(word);
            }
        }
        startTime = System.nanoTime();
        AnagramUtil.getLargestAnagramGroup(randomStringsMaker);
        endTime = System.nanoTime();
        double timer =(endTime-startTime)/((double)1000000000);
        System.out.println(timer);

        // timing for insertionSort for characters
        Character[] randomStrings = new Character[10000];
        Random random = new Random();
        for(int i = 0; i <randomStrings.length; i++) {
            randomStrings[i] = (char)('a' + random.nextInt(26));
        }
        startTime = System.nanoTime();
        AnagramUtil.insertionSort(randomStrings, new AnagramUtil.charCompare());
        endTime = System.nanoTime();
        double time =(endTime-startTime)/((double)1000000000);
        System.out.println(time);

        // timing for insertionSort for integers
        Integer[] randomStrings1 = new Integer[10000];
        for(int i = 0; i <randomStrings1.length; i++) {
            randomStrings1[i] = (int)(Math.random()*100);
        }
        startTime = System.nanoTime();
        AnagramUtil.insertionSort(randomStrings1, new AnagramUtil.integerCompare());
        endTime = System.nanoTime();
        double time2 =(endTime-startTime)/((double)1000000000);
        System.out.println(time2+ " integers");

        //timing code for getLargestAnagramGroupArrayList
        String[] randomStringsCreate = new String[10000];
        for(int count=0;count<randomStringsCreate.length;count++) {
            Random randomString = new Random();
            for (int i = 0; i < randomStringsCreate.length; i++) {
                char[] word = new char[randomString.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
                for (int j = 0; j < word.length; j++) {
                    word[j] = (char) ('a' + randomString.nextInt(26));
                }
                randomStringsCreate[i] = new String(word);
            }
        }
        startTime = System.nanoTime();
        AnagramUtil.getLargestAnagramGroupArrayList(randomStringsCreate);
        endTime = System.nanoTime();
        double timeCount =(endTime-startTime)/((double)1000000000);
        System.out.println(timeCount + " ArrayList");
    }
}
