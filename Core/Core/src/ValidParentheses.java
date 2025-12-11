// Validate parentheses
//Check if string of parentheses is valid.

/*
    "()[]{}"      → true
    "(]"          → false
    "([{}])"      → true
    "([)]"        → false

 */

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            else {
                // If closing without matching opening → invalid
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                // Check matching pairs
                if ( (c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[') ) {
                    return false;
                }
            }
        }

        // All brackets should be closed
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()[]{}"));   // true
        System.out.println(isValid("(]"));       // false
        System.out.println(isValid("([{}])"));   // true
    }
}

