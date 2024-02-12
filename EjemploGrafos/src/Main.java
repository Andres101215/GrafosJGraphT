import org.jgrapht.Graph;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Graph<String, DefaultWeightedEdge> graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // Añadir nodos
        String warehouse = "Almacen";
        String destination1 = "Destino1";
        String destination2 = "Destino2";
        String destination3 ="Destino3";

        graph.addVertex(warehouse);
        graph.addVertex(destination1);
        graph.addVertex(destination2);
        graph.addVertex(destination3);

        // Añadir aristas con pesos (distancias)
        DefaultWeightedEdge edge1 = graph.addEdge(warehouse, destination1);
        graph.setEdgeWeight(edge1, 10);  // Distancia del almacén a Destino1

        DefaultWeightedEdge edge2 = graph.addEdge(destination1, destination2);
        graph.setEdgeWeight(edge2, 15);  // Distancia del almacén a Destino2

        DefaultWeightedEdge edge3 = graph.addEdge(warehouse, destination2);
        graph.setEdgeWeight(edge3, 30);

        DefaultWeightedEdge edge4 = graph.addEdge(destination2, destination3);
        graph.setEdgeWeight(edge4, 15);

        DefaultWeightedEdge edge5 = graph.addEdge(warehouse, destination3);
        graph.setEdgeWeight(edge5, 35);


        // Calcular la ruta más corta desde el almacén a cada destino utilizando Dijkstra
        calculateShortestPath(graph, warehouse, destination1);
        calculateShortestPath(graph, warehouse, destination2);
        calculateShortestPath(graph,warehouse,destination3);
    }
    private static void calculateShortestPath(Graph<String, DefaultWeightedEdge> graph, String source, String target) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graph);
        List<String> shortestPath = dijkstra.getPath(source, target).getVertexList();

        // Imprimir la ruta más corta y su longitud
        System.out.println("Ruta desde " + source + " a " + target + ": " + shortestPath);
        System.out.println("Longitud de la ruta: " + dijkstra.getPathWeight(source, target));
        System.out.println();
    }
}