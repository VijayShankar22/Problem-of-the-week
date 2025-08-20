/*
Problem of the Week – Step Words Finder

Scenario:
-----------
In a word game, a step word is created by adding exactly one letter 
to a given word and then anagramming the result to form a valid dictionary word.

For example, from "APPLE":
• Add "A" → "APPLEA"
• Anagram to form "APPEAL" (a valid dictionary word) → This is a step word.

You are given:
• A dictionary of valid English words (as a list of strings),
• An input word.

Your task:
-----------
Write a function that returns all valid step words that can be created from 
the input word using the above logic.

Input Format:
-------------
• First line: A string W (the input word)
• Second line: An integer N (the number of words in the dictionary)
• Next N lines: Each line contains one valid word from the dictionary

Output Format:
--------------
• Print each valid step word (one per line) in lexicographical order

Constraints:
------------
• 1 <= len(W) <= 15
• 1 <= N <= 10^5
• All dictionary words are lowercase, alphabetic, and contain no spaces

Example:
--------
Input:
apple
5
appeal
apply
pepla
papple
apples

Output:
appeal
papple

Explanation:
------------
• "appeal" is formed by adding "a" to "apple" → "applea" → anagram → "appeal"
• "papple" is formed by adding "p" → "applep" → anagram → "papple"
• "apply", "pepla", and "apples" are not valid because:
    - "apply" is missing "e", not just one letter added
    - "pepla" is not formed by adding just one letter
    - "apples" has 6 letters, but the added letter doesn’t result 
      in a correct multiset match with "apple"

*/

import java.util.*;

public class step_words_finder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String W = sc.nextLine().trim();
        int N = Integer.parseInt(sc.nextLine().trim());

        List<String> dict = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            dict.add(sc.nextLine().trim());
        }
        int[] freqW = new int[26];
        for (char c : W.toCharArray()) {
            freqW[c - 'a']++;
        }

        List<String> result = new ArrayList<>();

        for (String word : dict) {
            if (word.length() != W.length() + 1) continue;

            int[] freqWord = new int[26];
            for (char c : word.toCharArray()) {
                freqWord[c - 'a']++;
            }
            int diffCount = 0;
            boolean valid = true;

            for (int i = 0; i < 26; i++) {
                if (freqWord[i] < freqW[i]) {
                    valid = false;
                    break;
                }
                diffCount += (freqWord[i] - freqW[i]);
            }

            if (valid && diffCount == 1) {
                result.add(word);
            }
        }
        Collections.sort(result);
        for (String stepWord : result) {
            System.out.println(stepWord);
        }
    }
}
