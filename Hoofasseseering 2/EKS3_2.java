import java.util.*;

public class EKS3_2 {

    public static void main(String[] args) {

        //Toetsgevalle
        String een = "{[()]}";
        System.out.println(een);
        if(isGebalanseerd(een)){
            System.out.println("Die hakkies is geldig.");
        } else {
            System.out.println("Die hakkies is ongeldig.");
        }

        String twee = "{[(]})";
        System.out.println(twee);
        if(isGebalanseerd(twee)){
            System.out.println("Die hakkies is geldig.");
        } else {
            System.out.println("Die hakkies is ongeldig.");
        }

        String drie = "((()))";
        System.out.println(drie);
        if(isGebalanseerd(drie)){
            System.out.println("Die hakkies is geldig.");
        } else {
            System.out.println("Die hakkies is ongeldig.");
        }

        String vier = "({[})]";
        System.out.println(vier);
        if(isGebalanseerd(vier)){
            System.out.println("Die hakkies is geldig.");
        } else {
            System.out.println("Die hakkies is ongeldig.");
        }
        
        
    }

    public static boolean isGebalanseerd(String invoer){

        Stack<Character> stapel = new Stack<>(); //Skep stapel
        int posisie = 0; //Om deur die invoer string te werk
        boolean gebalanseerd = false;

        while(posisie < invoer.length()){ //Werk deur string

            char huidige = invoer.charAt(posisie);

            //Toets
            if((huidige == '}' && stapel.peek() == '{') || (huidige == ')' && stapel.peek() == '(') || (huidige == ']' && stapel.peek() == '[')){
                stapel.pop();
            } else {
                stapel.add(huidige);
            }
            posisie++;

        }
        if(stapel.isEmpty()){
            gebalanseerd = true;
        }

        return gebalanseerd;

    }
    
}
