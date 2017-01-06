package net.sarvesh.graph;

import java.util.List;

/**
 * Created by Sarvesh on 1/6/2017.
 */
public interface Graph {
    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }

    void addEdge(int sourceVertex, int destinationVertex);
    List<Integer> getAdjacentVertices(int currentVertex);
}
