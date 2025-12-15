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

    public List<T> getNeighbours(T v){
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

            for(T neighbour : adjList.getOrDefault(curr, Collections.emptyList())){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
    }

    public void dfs(T start){
        Set<T> visited = new HashSet<>();
        dfsHelper(start,visited);
    }
    public void dfsHelper(T start, Set<T> visited){
        visited.add(start);
        System.out.print(start + " ");
        List<T> neighbours = adjList.getOrDefault(start, Collections.emptyList());
        for(T n : neighbours){
            if(!visited.contains(n))
                dfsHelper(n,visited);
        }
    }
}
