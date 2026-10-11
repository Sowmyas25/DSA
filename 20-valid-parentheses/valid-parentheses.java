class Solution {
    public boolean isValid(String s) {

        // Stack<Character> stack = new Stack<>();
        // Map<Character,Character> map = new HashMap<>();
        // map.put(')','(');
        // map.put('}','{');
        // map.put(']','[');

        // for (char ch : s.toCharArray()) {
        //     if (map.containsKey(ch)) {
        //         if (stack.isEmpty() || stack.pop() != map.get(ch)) {
        //             return false;
        //         }
        //     } else {
        //         stack.push(ch);
        //     }
        // }
        // return stack.isEmpty();

        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                if ( ch == ')' && stack.pop() != '(') return false;
                if ( ch == '}' && stack.pop() != '{') return false;
                if ( ch == ']' && stack.pop() != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}