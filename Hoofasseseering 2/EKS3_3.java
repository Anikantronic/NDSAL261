import java.util.*;

public class EKS3_3 {

    public static void main(String[] args) {

        //Skep grafiek
        Graph padkaart = new Graph();
        //Skep stede
        padkaart.addNode("S");
        padkaart.addNode("C");
        padkaart.addNode("W");
        padkaart.addNode("P");
        padkaart.addNode("E");
        padkaart.addNode("D");
        //Skep paaie tussen stede wat ongerig is
        padkaart.addEdge("S", "C", 50);
        //padkaart.addEdge("C", "S", 50);
        padkaart.addEdge("S", "W", 100);
        //padkaart.addEdge("W", "S", 100);
        padkaart.addEdge("C", "W", 90);
        //padkaart.addEdge("W", "C", 90);
        padkaart.addEdge("C", "P", 800);
        //padkaart.addEdge("P", "C", 800);
        padkaart.addEdge("W", "P", 700);
        //padkaart.addEdge("P", "W", 700);
        padkaart.addEdge("P", "E", 300);
        //padkaart.addEdge("E", "P", 300);
        padkaart.addEdge("E", "D", 600);
        //padkaart.addEdge("D", "E", 600);
        padkaart.addEdge("W", "E", 500);
        //padkaart.addEdge("E", "W", 500);

        //Bereken korste paaie
        Map<String,Integer> korstePaaie = Djikstra.shortestPath(padkaart,"S");
        
        System.out.println("Die totaale afstand van die korste pad tussen Stellenbosch en Durban is: "+korstePaaie.get("D")+"km.");

    }
    
}

class Graph {

    //Lys van stede aangrensend aan elke stad
    private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

    public Map<String, List<Edge>> getAdjacencyList() {
        return adjacencyList;
    }

    //Skep stad
    public void addNode(String name){
        adjacencyList.putIfAbsent(name, new ArrayList<>());
    }

    //Skep pad tussen twee stede in een rigting
    public void addEdge(String from, String to, int weight){
        List<Edge> edges = adjacencyList.get(from);
        if(edges == null){
            throw new IllegalArgumentException("Unkown Node: "+from);
        } else {
            edges.add(new Edge(to, weight));
        }
    }

    class Edge {

        private final String to;
        private final int weight;

        Edge(String to, int weight){
            this.to = to;
            this.weight = weight;
        }

        public String getTo() {
            return to;
        }

        public int getWeight() {
            return weight;
        }
    }
}

class Node implements Comparable<Node>{
    final String name;
    final int weight;

    Node(String name, int weight){
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.weight, other.weight);
    }
}

class Djikstra {

    public static Map<String,Integer> shortestPath(Graph graph, String start){

        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();
        Map<String, String> naasteStad = new HashMap<>();

        //Initialiseer die kortste pad lengtes
        for(String places : graph.getAdjacencyList().keySet()){
            distances.put(places, Integer.MAX_VALUE);
        }

        //Maak begin punt die gegewe stad
        distances.put(start, 0);
        pq.add(new Node(start, 0));
        naasteStad.put(start, "Begin");

        while(pq.isEmpty() == false){

            Node current = pq.poll();
            if(visited.add(current.name) == false){
                continue;
            }

            for(Graph.Edge edge : graph.getAdjacencyList().get(current.name)){
                //System.out.println(distances.get(current.name) + " - "+ edge.getWeight());
                int newDistance = distances.get(current.name) + edge.getWeight();
                //System.out.println(newDistance);
                if(newDistance < distances.get(edge.getTo())){
                    distances.put(current.name, newDistance);
                    pq.add(new Node(edge.getTo(), newDistance));
                    naasteStad.put(edge.getTo(), current.name);
                }
            }
        }
        String einde = "D";
        ArrayList<String> kortstePad = new ArrayList<>();
        while(naasteStad.get(einde).compareTo("Begin") != 0){
            kortstePad.add(einde);
            einde = naasteStad.get(einde);
        }

        System.out.println("Die korste pad vanaf Stellenbosch na Durban is: ");
        for(int i=kortstePad.size()-1; i>0; i--){
            System.out.print(kortstePad.get(i)+ " -> ");
        }
        System.out.print(kortstePad.get(0));

        return distances;
    }
}
