/*

Problem of the Week – First Recurring Character in a String

Scenario:
While building an autocomplete feature, you're analyzing the patterns of user-typed strings.
You're interested in identifying the first recurring character — the one that appears more 
than once and whose second occurrence happens earliest.
This will help prioritize autocomplete suggestions based on early recurring patterns.

Problem Statement:
Given a string s, return the first character that appears more than once, with the earliest 
second appearance.
If there is no such character, return null.

Input Format:
• A single string s consisting of lowercase and/or uppercase English letters.

Output Format:
• Return the first recurring character as a single character string.
• Return null if no character repeats.

Examples:

Example 1:
Input: "acbbac"
Output: "b"
Explanation:
• 'a' appears at index 0 and again at index 4
• 'b' appears at index 2 and again at index 3 — earlier second occurrence
→ Output is "b"

Example 2:
Input: "abcdef"
Output: null
Explanation:
• All characters are unique

Example 3:
Input: "abca"
Output: "a"

Constraints:
• 1 <= s.length <= 10^5
• All characters are ASCII printable characters

*/

import java.util.*;

public class first_recurring_character {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Set<Character> seen = new HashSet<>();
        Character ans = null;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen.contains(c)) {
                ans = c;
                break;
            } else {
                seen.add(c);
            }
        }
        if (ans == null) {
            System.out.println("null");
        } else {
            System.out.println(ans);
        }
    }
}

