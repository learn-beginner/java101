package net.sarvesh.graph;

import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
       AdjacencyMatrixGraph();

    }

    private static void AdjacencyMatrixGraph()
    {
        AdjacencyMatrixGraph grp = new AdjacencyMatrixGraph(3, Graph.GraphType.DIRECTED);
        grp.addEdge(0,1);
        grp.addEdge(1,2);

        List<Integer> adjVerts = grp.getAdjacentVertices(1);

        for (int i = 0; i < adjVerts.size(); i++) {
            System.out.println(adjVerts.get(i));
        }
    }
}
