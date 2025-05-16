package DA2;
import java.util.Scanner;
import java.util.Stack;

public class DA2_Vraag3 {

    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Insert an equation to test:");
        String equation = input.nextLine();
        if(areParenthesesBalanced(equation)){
            System.out.println("The parentheses are balanced.");
        } else {
            System.out.println("The parentheses are not balanced.");
        }
        
    }

    public static boolean areParenthesesBalanced(String stringInput){

        //Rand geval!
        if(stringInput.isEmpty()){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<stringInput.length();i++){
            char value = stringInput.charAt(i);
            if(value == '('){
                stack.push(value);
            } else if(value == ')'){
                if(!stack.isEmpty()){
                    char previous = stack.peek();
                    if(previous == '('){
                        stack.pop();
                    } 
                } else {
                    return false;
                }       
            }
        }

        if(!stack.isEmpty()){
            return false;
        } else {
            return true;
        }

    }
}
