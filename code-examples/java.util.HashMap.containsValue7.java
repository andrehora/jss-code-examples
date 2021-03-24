public static boolean isBalanced(String s){
  Stack<Character> stack = new Stack<Character>();
  HashMap<Character, Character> symbols = new HashMap<Character, Character>();

  symbols.put(')' , '(');
  symbols.put('}' , '{');
  symbols.put(']' , '[');

  for (int i = 0; i < s.length(); i++) {
    char c = s.charAt(i);
    if (symbols.containsValue(c)) {
      stack.push(c);
    }
    if (symbols.containsKey(c)) {
      if (stack.empty()) {
        return false;
      } else {
        Character temp = stack.pop();
        if (temp != symbols.get(c)) {
          return false;
        }
      }
    }
  }
  if (stack.empty()) {
    return true;
  }
  return false;
}