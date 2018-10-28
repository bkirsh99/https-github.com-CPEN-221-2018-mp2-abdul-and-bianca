package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Lists.
 *
 ******************************************************************************/


public class AdjacencyListGraph implements Graph {
    private HashMap<Vertex, LinkedList<Vertex>> allLists;

    // Rep invariant:
    //    allLists contains no repeated vertices
    //    allLists cannot have any null values
    // Abstraction Function:
    //   represents the adjacency list of graph

    //This is the constructor gor AdjacencyListGraph
    public AdjacencyListGraph() {
        allLists = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     * If vertex is already added, we ignore the addition of the new Vertex
     *
     * Precondition: none
     */
    public void addVertex(Vertex v){
        if(!allLists.containsKey(v)) {
            LinkedList<Vertex> list = new LinkedList<>();
            allLists.put(v,list);
        }
    }

    /**
     * Adds an edge between v1 and v2
     * If v1 and/or v2 are not yet vertices in the graph, they are first added and then connected.
     *
     */
    public void addEdge(Vertex v1, Vertex v2) {
        if(!allLists.containsKey(v1)){
            addVertex(v1);
        }
        if(!allLists.containsKey(v2)){
            addVertex(v2);
        }
        if (!v1.equals(v2)) {
            for (Vertex vertex1 : allLists.keySet()) {
                if (vertex1.equals(v1) && !allLists.get(v1).contains(v2)) {
                    allLists.get(v1).add(v2);
                }
            }
            for (Vertex vertex2 : allLists.keySet()) {
                if (vertex2.equals(v2) && !allLists.get(v2).contains(v1)) {
                    allLists.get(v2).add(v1);
                }
            }
        }
    }

    /**
     * Check if there is an edge between v1 and v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     *
     * Postcondition: return true if an edge exists between v1 and v2
     *
     */
    public boolean edgeExists(Vertex v1,Vertex v2){
        if (!v1.equals(v2)) {
            for(Vertex vertex1 : allLists.keySet()){
                if (vertex1.equals(v1) && allLists.get(v1).contains(v2)) {
                    for (Vertex vertex2 : allLists.keySet()) {
                        if (vertex2.equals(v2) && allLists.get(v2).contains(v1)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     * Get an array containing all vertices adjacent to v.
     *
     * Precondition: v is a vertex in the graph
     *
     * Postcondition: returns a list containing each vertex w such that there is
     * an edge between v and w. The size of the list must be as small as possible
     * This method should return a list of size 0 if v has no downstream neighbors.
     *
     */
    public List<Vertex> getNeighbors(Vertex v){
        for(Vertex vertex : allLists.keySet()) {
            if (vertex.equals(v)) {
                return allLists.get(v);
            }
        }
        return null;
    }

    /**
     * Get all vertices in the graph.
     *
     * Postcondition: returns a list containing all vertices in the graph,
     * sorted by label in non-descending order.
     *
     * This method should return a list of size 0 if the graph has no vertices.
     *
     */
    public List<Vertex> getVertices(){
        List<Vertex> allVertex = new LinkedList<>();
        for(Vertex vertex : allLists.keySet()){
            allVertex.add(vertex);
        }
        return allVertex;
    }
}
