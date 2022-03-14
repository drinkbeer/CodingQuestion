package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DirectedGraph
{
  private static void addEdge(Map<Integer, List<Integer>> graph, int u, int v)
  {
    graph.putIfAbsent(u, new ArrayList<>());
    graph.putIfAbsent(v, new ArrayList<>());
    graph.get(u).add(v);
    graph.get(v).add(u);
  }

  private static void printGraph(Map<Integer, List<Integer>> graph)
  {
    System.out.println();
    for (int k : graph.keySet()) {
      System.out.println("\nAdjacency list of vertex " + k);
      for (int v : graph.get(k)) {
        System.out.print(" -> " + v);
      }
    }
  }

  public static Map<Integer, List<Integer>> buildGraphWithAdjList()
  {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    return graph;
  }

  private static void addEdge(int[][] graph, int u, int v)
  {
    assert u >= 0 && u <= graph.length && u <= graph[0].length;
    assert v >= 0 && v <= graph.length && v <= graph[0].length;

    graph[u][v] = 1;
    graph[v][u] = 1;
  }

  private static void printGraph(int[][] graph)
  {
    System.out.println();
    for (int u = 0; u < graph.length; u++) {
      System.out.println("\nAdjacency list of vertex " + u);
      for (int v = 0; v < graph[u].length; v++) {
        if (graph[u][v] == 1) {
          System.out.print(" -> " + v);
        }
      }
    }
  }

  public static int[][] buildGraphWithAdjMatrix()
  {
    int V = 5;
    int[][] graph = new int[V][V];
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    return graph;
  }

  public static void main(String[] args)
  {
    Map<Integer, List<Integer>> graphAdjList = buildGraphWithAdjList();
    printGraph(graphAdjList);

    int[][] graphAdjMatrix = buildGraphWithAdjMatrix();
    printGraph(graphAdjMatrix);
  }
}
