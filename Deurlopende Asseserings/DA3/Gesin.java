public class Gesin {
    
    String naam;
    int grootte;

    public Gesin(String naam, int grootte){
        this.naam = naam;
        this.grootte = grootte;
    }

    public int getGrootte() {
        return grootte;
    }
    public String getNaam() {
        return naam;
    }
    public void setGrootte(int grootte) {
        this.grootte = grootte;
    }
    public void setNaam(String naam) {
        this.naam = naam;
    }

    public static void main(String[] args) {

        //Skep gesinne
        Gesin[] gesinne = {
            new Gesin("Van der Merwe", 6),
            new Gesin("Khumalo", 3),
            new Gesin("Ngcobo", 4),
            new Gesin("Smith", 6),
            new Gesin("Naidoo", 1)
        };

        System.out.println("Nie sorteerde lys:");
        for(int i=0; i<gesinne.length; i++){
            System.out.println(gesinne[i].getNaam()+" het grootte "+gesinne[i].getGrootte());
        }
        //Sorteer nou die gesinne
        mergeSort(gesinne);
        System.out.println();

        System.out.println("Gesorteerde lys:");
        for(int i=0; i<gesinne.length; i++){
            System.out.println(gesinne[i].getNaam()+" het grootte "+gesinne[i].getGrootte());
        }
        
    }

    public static void mergeSort(Gesin[] gesinne){

        //gesinne array word opgebreek totdat hulle groote van 1 bereik.
        if(gesinne.length > 1){

            int mid = gesinne.length/2;
            Gesin[] linksArr = new Gesin[mid];
            Gesin[] regsArr = new Gesin[mid];
            for(int i =0; i<mid; i++){
                linksArr[i] = gesinne[i];
            }
            for(int j =0; j<mid; j++){
                regsArr[j] = gesinne[mid+j];
            }

            mergeSort(linksArr);
            mergeSort(regsArr);

            //Nou word die arrays almal weer bymekaar gevoeg
            int links = 0;
            int regs = 0;
            int huidige = 0;

            while(links < linksArr.length && regs < regsArr.length){

                if(linksArr[links].grootte >= regsArr[regs].grootte){
                    gesinne[huidige] = linksArr[links];
                    links++;
                } else {
                    gesinne[huidige] = regsArr[regs];
                    regs++;
                }
                huidige++;
            }
            
            //Enige oorblywende gesinne van die linker en regter arrays word nou aan die einde bygevoeg
            while (links < linksArr.length) {
                gesinne[huidige] = linksArr[links];
                links++;
                huidige++;
            }
            while (regs < regsArr.length) {
                gesinne[huidige] = regsArr[regs];
                regs++;
                huidige++;
            }
        }
    }   
}