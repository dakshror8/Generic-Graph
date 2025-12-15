package Graphs;

import java.util.*;

public class DirectedGraph<T> extends Graph<T>{
    @Override
    public void addEdge(T from, T to){
        adjList.putIfAbsent(from, new ArrayList<>());

        adjList.get(from).add(to);
    }
}