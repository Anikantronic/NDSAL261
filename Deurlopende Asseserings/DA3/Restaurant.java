public class Restaurant {
    
    String naam;
    int gradering;

    public Restaurant(String naam, int gradering){
        this.naam = naam;
        this.gradering = gradering;
    }

    public int getGradering() {
        return gradering;
    }

    public String getNaam() {
        return naam;
    }

    public void setGradering(int gradering) {
        this.gradering = gradering;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public static Restaurant[] restaurants = {
        new Restaurant("Pizza Palace", 3),
        new Restaurant("Sushi Stop", 5),
        new Restaurant("Burger Barn", 2),
        new Restaurant("Taco Town", 4),
        new Restaurant("Noodle Nest", 1)
    };
    public static void main(String[] args) {

        System.out.println("Nie sorteerde lys:");
        for(int i=0; i<restaurants.length; i++){
            System.out.println(restaurants[i].getNaam()+" gradering is "+restaurants[i].getGradering());
        }
        BubbleSort(restaurants);
        System.out.println();
        System.out.println("Gesorteerde lys:");
        for(int i=0; i<restaurants.length; i++){
            System.out.println(restaurants[i].getNaam()+" gradering is "+restaurants[i].getGradering());
        }
    }

    public static void BubbleSort(Restaurant[] restaurants){

        for(int i=0; i<restaurants.length; i++){
            for(int j=0; j<restaurants.length-1; j++){
                if(restaurants[j].getGradering() > restaurants[j+1].getGradering()){
                    Restaurant temp = restaurants[j];
                    restaurants[j] = restaurants[j+1];
                    restaurants[j+1] = temp;
                }
            }
        }
    }
}