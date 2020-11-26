package graph;

// JAVA program to print all paths from a source to destination.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// A directed graph using adjacency list representation
//https://www.youtube.com/watch?v=PApEamXn94I

public class DFSAllPathsBetweenAtoB {

    // Driver program
    public static void main(String[] args) {
        int [][] jaggedArray = {{1,2,3},{2,4},{4},{4},{}}; // input
        DFSAllPathsBetweenAtoB obj = new DFSAllPathsBetweenAtoB();
        obj.allPathsFromSourceToTarget(jaggedArray);
    }

    private List<List<Integer>> allPathsFromSourceToTarget(int [][] jaggedArray) {
        List<List<Integer>> resultPaths = new LinkedList<>();

        List<Integer> startNode = new ArrayList<>();
        startNode.add(0);
        Integer targetNode = jaggedArray.length-1;
        System.out.println("Target Node:" + targetNode);

        dfs(0, startNode, jaggedArray, targetNode, resultPaths);
        return resultPaths;
    }

    private void dfs(int src, List<Integer> current, int[][] jaggedArray, Integer targetNode,
                     List<List<Integer>> resultPaths) {
        if(src == targetNode) {
            resultPaths.add(current);
            System.out.println(current);
            return;
        }

        for(int i : jaggedArray[src]) {
            current.add(i);
            dfs(i, current, jaggedArray, targetNode, resultPaths);
            current.remove(current.size()-1);
        }
    }

}
