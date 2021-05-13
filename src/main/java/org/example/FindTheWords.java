package org.example;

import java.io.IOException;
import java.util.*;

public class FindTheWords {
    private Set<String> setOfWords = new HashSet<>();
 /*   private StringBuilder output = new StringBuilder();
    private final String inputstring;


    public FindTheWords(final String str) {
        inputstring = str;
        System.out.println("The input string  is  : " + inputstring);
    }*/

    public static void main(String[] args) throws IOException {
        FindTheWords fw = new FindTheWords();
        System.out.println(fw.printPermutn("asdm"));
        //System.out.println("Final Result" + fw.combine());
    }

    Set<String> printPermutn(String str) throws IOException {
        return printPermutn(str, "");
    }

    private Set<String> printPermutn(String str, String ans) throws IOException {
        // If string is empty
        if (str.length() == 0) {
            System.out.print(ans + " ");
            if(Dictionary.isEnglishWord(ans))
                setOfWords.add(ans);
        }
        for (int i = 0; i < str.length(); i++) {
            // ith character of str
            char ch = str.charAt(i);
            // Rest of the string after excluding
            // the ith character
            String ros = str.substring(0, i) +
                    str.substring(i + 1);
            // Recurvise call
            printPermutn(ros, ans + ch);
        }
        return setOfWords;
    }


/*    public Set<String> combine() throws IOException {
        return combine(0);
    }

    private Set<String> combine(int start) throws IOException {
        for (int i = start; i < inputstring.length(); ++i) {
            output.append(inputstring.charAt(i));
            System.out.println(output);
            if (Dictionary.isEnglishWord(output.toString()))
                setOfWords.add(output.toString());
            if (i < inputstring.length())
                combine(i + 1);
            output.setLength(output.length() - 1);
        }
        return setOfWords;
    }*/

   /* private static Set getMatchingWords(String str, String out) throws IOException {
        Set<String> setOfWords = new HashSet<>();
        // if the end of the string is reached,
        // print the output string
        if (str.length() == 0) {
            System.out.println(out);
            setOfWords.add(out);
        }

        for (int i = 1; i <= str.length(); i++) {
            // consider all prefixes of the current string
            String prefix = str.substring(0, i);

            // if the prefix is present in the dictionary, add it to the
            // output string and recur for the remaining string

            if (Dictionary.isEnglishWord(prefix)) {
                setOfWords.add(prefix);
                getMatchingWords(str.substring(i), out + " " + prefix);
            }
        }
        return setOfWords;
    }*/



    /*public static Set<String> getMatchingWords(final String input) {
        final char[] contents = input.toCharArray();
        Arrays.sort(contents);
        final int inputLength = contents.length;

        final Set<String> matchedWords = new HashSet<>();

        char[] candidate;
        int len;
        int matched;

        for (final Map.Entry<String, char[]> entry : dictionary.entrySet()) {
            candidate = entry.getValue();
            // If the first character of the candidate is greater
            // than the first character of the contents, no need
            // to continue (recall: the dictionary is sorted)
            if (candidate[0] > contents[0])
                break;
            // If the word has a greater length than the input,
            // go for the next word
            len = candidate.length;
            if (len > inputLength)
                continue;
            // Compare character by character
            for (matched = 0; matched < len; matched++)
                if (candidate[matched] != contents[matched])
                    break;
            // We only add a match if the number of matched characters
            // is exactly that of the candidate
            if (matched == len)
                matchedWords.add(entry.getKey());
        }

        return matchedWords;
    }
     */
}