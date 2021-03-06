package Task3.Stack;

import java.util.Map;

public class BracketsDemoStack {

    private static final String TEXT_EXAMPLE = "'";
//               public E peek() {
//                   return data[size - 1];
//               };
//               """;

    private static final Map<Character, Character> BRACKETS_MAP = Map.of(
            '{', '}',
            '[', ']',
            '(', ')'
    );

    public static void main(String[] args) {
        new BracketsDemoStack().check(TEXT_EXAMPLE);
    }

    public void check(String text) {
        IStack<Character> stack = new MyStack<>(text.length());
        MyStack<Integer> stack1 = new MyStack<>(text.length());

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (BRACKETS_MAP.containsKey(currentChar)) {
                stack.push(currentChar);
            } else if (BRACKETS_MAP.containsValue(currentChar)) {
                if (stack.isEmpty()) {
                    System.err.println("Error: " + currentChar + " at " + i);
                    continue;
                }

                Character lastOpenedBracket =  stack.pop();
                if (!BRACKETS_MAP.get(lastOpenedBracket).equals(currentChar)) {
                    System.err.println("Error: " + currentChar + " at " + i);
                }
            }
        }

        if (!stack.isEmpty()) {
            System.err.println("Error: missing right delimiter");
        }
    }

}
