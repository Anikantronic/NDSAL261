import java.util.Scanner;

public class Boek {
    String titel;
    String isbn;

    public Boek(String titel, String isbn){
        this.titel = titel;
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
    public String getTitel() {
        return titel;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }

    public static void main(String[] args) {

        Boek[] boeke = {
            new Boek("Rekenaarwetenskap vir Beginners", "ISBN001"),
            new Boek("Avonture van 'n Nerd", "ISBN005"),
            new Boek("Zebra se Geheim", "ISBN003"),
            new Boek("Binêre Bome en Balle", "ISBN002"),
            new Boek("Algoritmes vir Almal", "ISBN004")
        };

        System.out.println("Nie sorteerde lys:");
        for(int i=0; i<boeke.length; i++){
            System.out.println(boeke[i].getTitel()+" het ISBN: "+boeke[i].getIsbn());
        }
        selectionSort(boeke);
        System.out.println("Gesorteerde lys:");
        for(int i=0; i<boeke.length; i++){
            System.out.println(boeke[i].getTitel()+" het ISBN: "+boeke[i].getIsbn());
        }
        System.out.println();
        Scanner invoer = new Scanner(System.in);
        System.out.print("Watter boek soek jy vir: ");
        String titel = invoer.nextLine();
        
        int indeks = BinarySearch(boeke, titel);
        if(indeks >= 0){
            System.out.println("ISBN: "+boeke[indeks].getIsbn());
        } else {
            System.out.println("Verlangde boek is nie gevind nie.");
        }

        invoer.close();

    }

    public static void selectionSort(Boek[] boeke){

        for(int i=0; i<boeke.length; i++){
            int huidige = 0;
            int grootste = 0;
            while (huidige < boeke.length-i) {
                if(boeke[huidige].titel.compareTo(boeke[grootste].titel) > 0){
                    grootste = huidige;
                }
                huidige++;
            }
            Boek temp = boeke[grootste];
            boeke[grootste] = boeke[boeke.length-i-1];
            boeke[boeke.length-i-1] = temp;
        }
    }

    public static int BinarySearch(Boek[] boeke, String item){
        int left = 0;
        int right = boeke.length;
        int mid = boeke.length/2;

        while (left<right) {

            mid = (left+right)/2;
            if(boeke[mid].titel.compareTo(item) == 0){
                return mid;
            } else if(boeke[mid].titel.compareTo(item) < 0){
                left = mid;
            } else {
                right = mid;
            }
        }
        return -1;
    }
}
