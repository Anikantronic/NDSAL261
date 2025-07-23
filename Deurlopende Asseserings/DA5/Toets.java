import java.util.*;

public class Toets {

    public static void main(String[] args) {
        
        Graph bestemmings = new Graph();

        bestemmings.addNode("A");
        bestemmings.addNode("B");
        bestemmings.addNode("C");
        bestemmings.addNode("D");
        bestemmings.addNode("E");

        bestemmings.addEdge("A", "B", 4);
        bestemmings.addEdge("A", "C", 2);
        bestemmings.addEdge("B", "C", 5);
        bestemmings.addEdge("B", "D", 10);
        bestemmings.addEdge("C", "D",3);
        bestemmings.addEdge("D", "E", 4);
        bestemmings.addEdge("C", "E", 12);

        Map<String,Integer> paaie = Dijkstra.shortestPath(bestemmings, "A");

        for(String pad : paaie.keySet()){
            System.out.println("Kortste pad vanaf A na "+pad+" vat : "+paaie.get(pad)+" minute.");
        }
    }

}

class Node implements Comparable<Node>{
    final String name;
    final int distance;

    public Node(String name, int distance){
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node other){
        return Integer.compare(this.distance, other.distance);
    }
}

class Graph {

    public final Map<String, List<Edge>> adjList = new HashMap<>();

    public Map<String, List<Edge>> getAdjList() {
        return adjList;
    }

    class Edge {
        private final String to;
        private final int weight;

        public Edge(String to, int weight){
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

    public void addNode(String name){
        adjList.putIfAbsent(name, new ArrayList<>());
    }

    public void addEdge(String from, String to, int weight){
        List<Edge> edges = adjList.get(from);
        if(edges == null){
            throw new IllegalArgumentException("Unkown Node: "+from);
        }
        edges.add(new Edge(to, weight));
    }
}

class Dijkstra {

    public static Map<String, Integer> shortestPath(Graph graph, String start){

        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        Set<String> visited = new HashSet<>();

        //Initialize
        for(String v: graph.adjList.keySet()){
            distances.put(v, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node current = pq.poll();
            if(!visited.add(current.name)){
                continue;
            }

            for(Graph.Edge e : graph.adjList.get(current.name)){
                int nd = distances.get(current.name) + e.getWeight();
                if(nd < distances.get(e.getTo())){
                    distances.put(e.getTo(), nd);
                    pq.add(new Node(e.getTo(),nd));
                }
            }
        }
        return distances;
    }
}