package org.example;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FindPossibleWords {
    private Set<String> possibleWords = new HashSet<>();

    private Set<String> findValidWords(String letterPool, String currWord) throws IOException {
        //Add to possibleWords when valid word
        if (letterPool.equals("")) {
            // No action to be done.
        } else if (currWord.equals("")) {
            //Will run only the initial time the method is called.
            for (int i = 0; i < letterPool.length(); i++) {
                //Get the individual letters that will become the first letter of a word
                String curr = letterPool.substring(i, i + 1);
                //Delete the single letter from letterPool
                String newLetterPool = (letterPool.substring(0, i) + letterPool.substring(i + 1));
                if (Dictionary.isEnglishWord(curr)) {
                    possibleWords.add(curr);
                }
                boolean prefixInDic = Dictionary.binarySearch(curr);
                if (prefixInDic) {
                    //If the prefix isn't found, don't continue this recursive path.
                    findValidWords(newLetterPool, curr);
                }
            }
        } else {
            //Every time we add a letter to currWord, delete from letterPool
            for (int i = 0; i < letterPool.length(); i++) {
                String curr = currWord + letterPool.substring(i, i + 1);
                String newLetterPool = (letterPool.substring(0, i) + letterPool.substring(i + 1));
                if (Dictionary.isEnglishWord(curr)) {
                    possibleWords.add(curr);
                }
                boolean prefixInDic = Dictionary.binarySearch(curr);
                if (prefixInDic) {
                    findValidWords(newLetterPool, curr);
                }
            }
        }
        return possibleWords;
    }

    public Set<String> findValidWords(String letterPool) throws IOException {
        return findValidWords(letterPool, "");
    }

    public static void main(String[] args) throws IOException {
        FindPossibleWords fb = new FindPossibleWords();
        System.out.println(fb.findValidWords("working"));
    }
}
