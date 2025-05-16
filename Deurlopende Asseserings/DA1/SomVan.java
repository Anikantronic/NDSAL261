package DA1;
public class SomVan {

    public static void main(String[] args) {
        
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int n = 20;

        long beginIterative = System.nanoTime();
        int iterative = sumIterative(numbers);
        long endIterative = System.nanoTime();
        long iterativeTime = endIterative-beginIterative;

        long beginRecursive = System.nanoTime();
        int recursive = sumRecursive(numbers, n);
        long endRecursive = System.nanoTime();
        long recursiveTime = endRecursive-beginRecursive;

        System.out.println("Iteratiewe som:"+iterative+" | Tyd: "+iterativeTime+"ns");
        System.out.println("Rekursiewe som:"+recursive+" | Tyd: "+recursiveTime+"ns");
        System.out.println("Tydkompleksiteit:");
        System.out.println("- Iteratief: O(n)");
        System.out.println("- Rekursief: O(log(n))");


    }

    public static int sumIterative(int[] numbers){

        int somVan = 0;

        for(int i=0; i<numbers.length; i++){
            somVan += numbers[i];
        }

        return somVan;
    }

    public static int sumRecursive(int[] numbers, int n){

        if(n == 0){
            return 0;
        }
        else {
            return numbers[n-1] + sumRecursive(numbers, n-1);
        }
    }
    
}
