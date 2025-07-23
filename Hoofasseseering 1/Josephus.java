import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Josephus {

    public static Scanner invoer = new Scanner(System.in);
    public static Queue<Integer> mense = new LinkedList<Integer>();
    public static void main(String[] args) {

        System.out.print("Hoeveel mense is in die sirkel: ");
        int aantalMense = invoer.nextInt();
        invoer.nextLine();
        System.out.print("Elke hoeveelste persoon word verwyder: ");
        int k = invoer.nextInt();
        invoer.nextLine();
        System.out.println(josephusQueue(aantalMense, k)+" is die laaste mens oor.");
        
    }

    public static int josephusQueue(int aantalMense, int k){

        for(int i=1; i<=aantalMense; i++){
            mense.add(i);
        }
        System.out.println(mense.toString());
        while(mense.size() != 1){
            for(int j=1; j<k; j++){
                int huidige = mense.poll();
                mense.add(huidige);
            }
            int verwyder = mense.poll();
            System.out.println("Die persoon nommer: "+verwyder+" is nou verwyder.");
        }
        return mense.peek();
    }

}