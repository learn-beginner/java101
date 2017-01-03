package net.sarvesh.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.util.Scanner;

public class Main {

    static int[][] adj;
    static boolean[] visited;

    static void dfs(int currentNode) {
        visited[currentNode] = true;
        for (int i = 0; i < adj.length; i++) {
            if (visited[adj[currentNode][i]] == false) {
                dfs(adj[currentNode][i]);
            }
        }
    }

    static void initialize() {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        try {
            int nodes, edges, x, y, connectedComponents = 0;
            BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
            nodes = Integer.parseInt(stdin.readLine());
            edges = Integer.parseInt(stdin.readLine());
            adj = new int[nodes][nodes];
            visited = new boolean[nodes];
            for (int i = 0; i < edges; ++i) {
                String line = stdin.readLine();
                String[] e = line.split(" ");
//                adj[Integer.parseInt(e[0])][Integer.parseInt(e[1])] = Integer.parseInt(e[0]);
//                adj[Integer.parseInt(e[1])][Integer.parseInt(e[0])] = Integer.parseInt(e[1]);
                adj[Integer.parseInt(e[0]) - 1][Integer.parseInt(e[1]) - 1] = 1;
                adj[Integer.parseInt(e[1]) - 1][Integer.parseInt(e[0]) - 1] = 1;
            }

            initialize();

            for (int i = 0; i < nodes; i++) {
                if (visited[i] == false) {
                    dfs(i);
                    connectedComponents++;
                }
            }

            System.out.println("Number of connected components: " + connectedComponents);

            for (int i = 0; i < adj.length; i++) {
                for (int j = 0; j < adj[i].length; j++) {
                    System.out.print(adj[i][j]);
                }
                System.out.println();
            }


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
