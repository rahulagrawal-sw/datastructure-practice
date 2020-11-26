package graph;

import java.util.ArrayList;

public class DFSSearch {

    private int V;
    private ArrayList<Integer> adj[];

    public DFSSearch(int numberOfVertexes) {
        this.V = numberOfVertexes;
        adj = new ArrayList[numberOfVertexes];
        for(int i=0; i<numberOfVertexes;i++)
            adj[i]  = new ArrayList<Integer>();
    }

    private void addEdge(int source, int destination) {
        adj[source].add(destination);
    }

    private void DFS(int startingSource) {
        // Mark all the vertices as not visited(set as false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(startingSource, visited);
    }

    private void DFSUtil(int vertex, boolean[] visited) {
        System.out.println("vertex visiting : " + vertex);

        visited[vertex] = true;
        ArrayList<Integer> adjcentList = adj[vertex];

        for(Integer currentVetex: adjcentList) {
            if(!visited[currentVetex]) {
                DFSUtil(currentVetex, visited);
            }
        }
    }

    public static void main(String args[]) {
        DFSSearch g = new DFSSearch(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal (starting from vertex 2)");

        g.DFS(2);
    }
//OUTPUT:
    //vertex visiting : 2
    //vertex visiting : 0
    //vertex visiting : 1
    //vertex visiting : 3
//TIME COMPLEXITY : O(NumberOfVertexes * NumberOfEdges)
}
