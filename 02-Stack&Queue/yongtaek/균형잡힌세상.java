package Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 균형잡힌세상 {
    
    public static boolean chkEven(char[] arr) {
        Stack<Character> stack = new Stack<>();
        for(char c : arr) {
            if(c == '(' || c == '[') {
                stack.push(c);
            } else if(c == ')') {
                if(stack.empty() || stack.peek() != '('){
                    return false;
                } else {
                    stack.pop();
                }
            } else if(c == ']') {
                if(stack.empty() || stack.peek() != '['){
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if(stack.empty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String line = br.readLine();
            if(line.equals(".")) break;

            line = line.replaceAll("\\w", "");
            line = line.replaceAll("\\s", "");
            line = line.replaceAll("[.]", "");
           
            char [] arr = line.toCharArray();
            if(chkEven(arr)) {
                sb.append("yes" + "\n");
            } else {
                sb.append("no" + "\n");
            }
        }
        System.out.println(sb);
    }
}