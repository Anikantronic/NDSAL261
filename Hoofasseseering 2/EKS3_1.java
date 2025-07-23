import java.util.*;

public class EKS3_1 {

    public static void main(String[] args) {
        
        Node taakEen = new Node("Wiskunde Opdrag", "WISN211", "20240503");
        Node taakTwee = new Node("Rekenaarwetenskap Toets", "NDSAL261", "20240501");
        Node taakDrie = new Node("Vakansie", "SVAK200", "20250101");

        Taak taakLys = new Taak();
        taakLys.voegByInVolgorde(taakEen);
        taakLys.voegByInVolgorde(taakTwee);
        taakLys.voegByInVolgorde(taakDrie);

        taakLys.drukLys();

    }
    
}

class Node {

    String naam;
    String vak;
    String sperdatum;
    Node next;

    Node(String naam, String vak, String sperdatum){
        this.naam = naam;
        this.sperdatum = sperdatum;
        this.vak = vak;
        this.next = null;
    }

    public String getSperdatum() {
        return sperdatum;
    }    

    @Override
    public String toString(){
        return naam+" - "+vak+" - Sperdatum: "+sperdatum.substring(0, 4)+"/"+sperdatum.substring(4, 6)+"/"+sperdatum.substring(6, sperdatum.length());
    }
}

class Taak {

    public LinkedList<Node> lys;
    public Node head;

    Taak(){
        lys = new LinkedList<>();
    }

    public void voegByInVolgorde(Node item){

        if(head == null){
            head = item;
            return;
        }

        Node current = head;
        String curSperdatum = current.getSperdatum();
        int cJaar = Integer.parseInt(curSperdatum.substring(0, 4));
        int cMaand = Integer.parseInt(curSperdatum.substring(4, 6));
        int cDag = Integer.parseInt(curSperdatum.substring(6, curSperdatum.length()));
        String itemSper = item.getSperdatum();
        int iJaar = Integer.parseInt(itemSper.substring(0, 4));
        int iMaand = Integer.parseInt(itemSper.substring(4, 6));
        int iDag = Integer.parseInt(itemSper.substring(6, itemSper.length()));

        if(iJaar < cJaar){
            item.next = current;
            head = item;
            return;
        } else if(iMaand < cMaand){
            item.next = current;
            head = item;
            return;
        } else if(iDag < cDag){
            item.next = current;
            head = item;
            return;
        }

        while(current.next != null){
            String nextSper = current.next.getSperdatum();
            int nJaar = Integer.parseInt(nextSper.substring(0, 4));
            int nMaand = Integer.parseInt(nextSper.substring(4, 6));
            int nDag = Integer.parseInt(nextSper.substring(6, nextSper.length()));

            if(nJaar < iJaar){
                item.next = current.next;
                current.next = item;
                return;
            } else if(nMaand < iMaand){
                item.next = current.next;
                current.next = item;
                return;
            } else if(nDag < iDag){
                item.next = current.next;
                current.next = item;
                return;
            }
            current = current.next;
        }
        current.next = item;
    }

    public void drukLys(){
        if(head == null){
            System.out.println("Die lys is leeg.");
        }
        Node current = head;
        int taakNr = 1;

        while(current != null){
            System.out.println("Taak "+taakNr+": "+current.toString());
            taakNr++;
            current = current.next;
        }
    }
}