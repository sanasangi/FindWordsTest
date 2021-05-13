package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Dictionary {
    private static ArrayList<String> listOfLines;

    private static void addDataInArrayList() throws IOException {
        BufferedReader bufReader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/src/main/resources/dictionary.txt"));
        listOfLines = new ArrayList<>();
        String line = bufReader.readLine();
        while (line != null) {
            listOfLines.add(line);
            line = bufReader.readLine();
        }
        bufReader.close();
    }

    static {
        try {
            Dictionary.addDataInArrayList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isEnglishWord(String word) throws IOException {
        return listOfLines.contains(word.toLowerCase());
    }

    public static void main(String[] args) throws IOException {
        System.out.println(Dictionary.isEnglishWord("How"));
    }

    public static boolean binarySearch(String word) {
        int max = listOfLines.size() - 1;
        int min = 0;
        int currIndex;
        boolean result = false;
        while (min <= max) {
            currIndex = (min + max) / 2;
            if (listOfLines.get(currIndex).startsWith(word)) {
                result = true;
                break;
            } else if (listOfLines.get(currIndex).compareTo(word) < 0) {
                min = currIndex + 1;
            } else if (listOfLines.get(currIndex).compareTo(word) > 0) {
                max = currIndex - 1;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }
}

