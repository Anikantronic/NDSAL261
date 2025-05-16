public class Test {
    //Om te toets
    public static void main(String[] args) {
        UnorderedList list = new UnorderedList();

        // 1. Voeg ’n paar elemente by die voorkant
        list.insertFront(10);
        list.insertFront(20);
        list.insertFront(30);

        // 2. display moet wys: 30 -> 20 -> 10
        list.display();

        // 3. Soek na ’n bestaande en ’n nie-bestaande waarde
        System.out.println("Soek 20: " + list.search(20)); // Verwag: true
        System.out.println("Soek 40: " + list.search(40)); // Verwag: false

        // 4. Verwyder ’n element (bv. 20)
        list.remove(20);
        // 5. display moet nou wys: 30 -> 10
        list.display();

        // 6. Opsioneel: Check grootte
        // System.out.println("Grootte van lys: " + list.size());
    }   
}