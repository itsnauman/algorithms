package com.company;


public class SubstringSearch {
    public static void main(String[] args) {
        System.out.println(bruteForceSubstringSearch("ABCDEDFFDSSS", "ABC"));
    }

    /**
     * Search a text for a certain pattern
     * @param text Text to be searched
     * @param pattern Pattern to search for
     * @return Index of first occurrence of pattern
     */
    private static int bruteForceSubstringSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i < n - m; i++) {
            int j;
            for (j = 0; j < m; j++)
                if (text.charAt(i + j) != pattern.charAt(j))
                    break;

            if (j == m)
                return i;
        }

        return -1;
    }
}
