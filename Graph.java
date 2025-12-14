package Graphs;
import java.util.*;
public class Graph<T> {
    Map<T,List<T>> adjList;
    public Graph(){
        adjList = new HashMap<>();
    }

    public void addVertex(T vertex){
        adjList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(T u, T v){
        adjList.putIfAbsent(u, new ArrayList<>());
        adjList.putIfAbsent(v, new ArrayList<>());

        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public List<> getNeighbours(T v){
        return adjList.getOrDefault(v, new ArrayList<>());
    }

    public void bfs(T start){
        Queue<T> queue = new LinkedList<>();
        queue.offer(start);

        Set<T> visited = new HashSet<>();
        visited.add(start);

        while(!queue.isEmpty()) {
            T curr = queue.poll();
            System.out.print(curr + " ");
            
            for(T neighbour : adjList.get(curr)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }
}
