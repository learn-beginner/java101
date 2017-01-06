package net.sarvesh.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sarvesh on 1/6/2017.
 */
public class AdjacencyMatrixGraph implements Graph {

    private int[][] adjacencyMatrix;//VxV matrix to hold vertices and edges
    private GraphType graphType = GraphType.DIRECTED;
    private int numVertices = 0;

    public  AdjacencyMatrixGraph(int numVertices, GraphType graphType){
        this.numVertices = numVertices;
        this.graphType = graphType;

        adjacencyMatrix = new int[numVertices][numVertices];
    }

    @Override
    public void addEdge(int sourceVertex, int destinationVertex) {

        if(sourceVertex > numVertices || sourceVertex < 0 || destinationVertex > numVertices || destinationVertex <0){
            throw new IllegalArgumentException("Vertex number is not valid");
        }

        adjacencyMatrix[sourceVertex][destinationVertex] = 1;

        if(graphType == GraphType.UNDIRECTED){
            adjacencyMatrix[destinationVertex][sourceVertex] = 1;
        }
    }

    @Override
    public List<Integer> getAdjacentVertices(int currentVertex) {
        if(currentVertex > numVertices || currentVertex < 0){
            throw new  IllegalArgumentException("Vertex number is not valid.");
        }

        List<Integer> adjacentVertices = new ArrayList<>();
        for (int i =0; i < numVertices; i++){
            if(adjacencyMatrix[currentVertex][i] == 1){
                adjacentVertices.add(i);
            }
        }

        Collections.sort(adjacentVertices);

        return  adjacentVertices;
    }
}
