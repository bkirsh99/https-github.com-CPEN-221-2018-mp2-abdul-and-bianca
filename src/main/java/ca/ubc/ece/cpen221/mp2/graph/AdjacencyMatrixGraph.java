package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

/******************************************************************************
 *  Dependencies: Graph.java Vertex.java
 *
 *  A data type that represents a Graph using Adjacency Matrices.
 *
 ******************************************************************************/

public class AdjacencyMatrixGraph implements Graph {
    private int i = 0;
    private int[][] matrix;
    private int[][] temporarymatrix ;
    private Map<Integer, Vertex> referenceforInteger = new HashMap<>();
    private Map<Vertex, Integer> referenceforVertex = new HashMap<>();

    // Rep invariant:
    //    edges contains no repeated vertices
    //    matrix contains no null values
    // Abstraction Function:
    //   represents the adjacency matrix of graph

    //This is the constructor for AdjacencyMatrixGraph
    public void AdjacencyMatrixGraph() {
    }

    /**
     * Adds a vertex to the graph.
     * If vertex v is already added, we ignore the addition of the new vertex
     *
     * Precondition: none
     *
     */
    public void addVertex(Vertex v){
        if(!getVertices().contains(v)){
            referenceforInteger.put(i,v);
            referenceforVertex.put(v,i);
            i++;
            matrix = new int[i][i];
            if(temporarymatrix != null){
                for (int a =0; a < temporarymatrix.length; a++){
                    for(int b =0; b < temporarymatrix.length; b++){
                        matrix[a][b] = temporarymatrix[a][b];
                    }
                }
            }
        }
        temporarymatrix = matrix;
    }

    /**
     * Adds an edge between v1 and v2.
     * If v1 and/or v2 are not yet vertices in the graph, they are first added and then connected.
     *
     */
    public void addEdge(Vertex v1, Vertex v2){
        if(referenceforVertex.containsKey(v1) && referenceforVertex.containsKey(v2)){
            matrix[referenceforVertex.get(v1)][referenceforVertex.get(v2)] = 1;
            matrix[referenceforVertex.get(v2)][referenceforVertex.get(v1)] = 1;
        } else{
            if(!referenceforVertex.containsKey(v1)){
                addVertex(v1);
            }
            if(!referenceforVertex.containsKey(v2)) {
                addVertex(v2);
            }
            addEdge(v1,v2);
        }
    }

    /**
     * Check if there is an edge between v1 and v2.
     *
     * Precondition: v1 and v2 are vertices in the graph
     *
     * Postcondition: return true if an edge from v1 connects to v2
     *
     */
    public boolean edgeExists(Vertex v1, Vertex v2){
        Boolean exists = false;

        if(matrix[referenceforVertex.get(v1)][referenceforVertex.get(v2)] == 1 && matrix[referenceforVertex.get(v2)][referenceforVertex.get(v1)] == 1){
            exists = true;
        }

        return exists;
    }

    /**
     * Get an array containing all vertices adjacent to v.
     *
     * Precondition: v is a vertex in the graph
     *
     * Postcondition: returns a list containing each vertex w such that there is
     * an edge from v to w. The size of the list must be as small as possible
     * This method should return a list of size 0 if v has no downstream neighbors.
     *
     */
    public List<Vertex> getNeighbors(Vertex v){
        List<Vertex> neighbours = new ArrayList<Vertex>();

        for(int i = 0; i < matrix.length; i++){
            if(matrix[referenceforVertex.get(v)][i] == 1){
                neighbours.add(referenceforInteger.get(i));
            }
        }
        return neighbours;
    }

    /**
     * Get all vertices in the graph.
     *
     * Postcondition: returns a list containing all vertices in the graph,
     * sorted by label in non-descending order.
     * This method should return a list of size 0 if the graph has no vertices.
     *
     */
    public List<Vertex> getVertices(){
        List<Vertex> allvertices = new ArrayList<Vertex>();

        if(matrix != null){
            for(int i = 0; i<matrix.length; i++){
                allvertices.add(referenceforInteger.get(i));
            }
        }
        return allvertices;
    }
}
