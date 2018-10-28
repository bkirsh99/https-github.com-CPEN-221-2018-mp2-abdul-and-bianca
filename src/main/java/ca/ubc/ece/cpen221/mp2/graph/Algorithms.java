package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.Queue;
import java.util.LinkedList;

public class Algorithms {
	private static List<Integer> record = new ArrayList<>();

	/**
	 * *********************** Algorithms ****************************
	 *
	 * Please see the README for this machine problem for a more detailed
	 * specification of the behavior of each method that one should
	 * implement.
	 */


	/**
	 * The distance between two vertices v and w is the minimum number
	 * of edges that would have to be traversed to get to v from w.
	 *
	 * @param graph
	 * @param a
	 * @param b
	 * @return the shortest distance between a and b
	 *     The distance between a vertex and itself is 0.
	 *     If no path exists from a to b ,returns -1.
	 */
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		int i = 0;
		int distance;
		List<Vertex> graphvertices = graph.getVertices();
		List<List<Vertex>> table = new ArrayList<>();
		HashMap<Vertex, Integer> reference = new HashMap<>();
		boolean visited[] = new boolean[graphvertices.size()];

		if(a.equals(b)){
			return 0;
		}

		for(Vertex v: graphvertices){
			table.add(i,graph.getNeighbors(v));
			reference.put(v,i);
			visited[i] = false;
			i++;
		}

		getdistances(a,b,record,table,reference,a,1,visited);

		if(record.size() == 0){
			return -1;
		}

		Collections.sort(record);

		distance = record.get(0);
		return distance;
	}

	/*
	 * This is the recursive function used to get all possible paths between a and b.
	 */
	private static void getdistances(Vertex a,Vertex b,List<Integer> record, List<List<Vertex>> table,HashMap<Vertex, Integer> reference,Vertex search, int count, boolean visited[]){
		if(table.get(reference.get(search)).contains(b)){
			record.add(count);
			return;
		} else{
			visited[reference.get(search)] = true;
			for(Vertex temporary: table.get(reference.get(search))){
				if(visited[reference.get(temporary)] == false) {
					getdistances(a, b, record, table, reference, temporary, count + 1, visited);
				}
			}
		}
	}


	/**
	 * Perform a complete depth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a DFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param graph
	 * @return a set where each element of the set is a list
	 * of vertices seen by starting a DFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 */
	public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
		Set<List<Vertex>> DFS = new HashSet<>();
		List<Vertex> graphvertices = graph.getVertices();
		List<List<Vertex>> table = new ArrayList<>();
		boolean visited[] = new boolean[graphvertices.size()];
		HashMap<Vertex,Integer> reference = new HashMap<>();
		List<Vertex> storage;

		Collections.sort(graphvertices,Comparator.comparing(Vertex::getLabel));

		int i = 0;
		for(Vertex v : graphvertices){
			table.add(i,graph.getNeighbors(v));
			reference.put(v,i);
			i++;
		}

		//gets the largest number of verteces conneceted(in case of disconnected graphs)
		Set<List<Vertex>> BFSresult = Algorithms.breadthFirstSearch(graph);
		int maxlength = 0;

		for(Vertex start: graphvertices){
			i = 0;
			for(Vertex v : graphvertices){
				visited[i] = false;
				i++;
			}

			for(List<Vertex> search: BFSresult){
				if(search.contains(start)){
					maxlength = search.size();
				}
			}
			storage = new ArrayList<>();
			int stepback = 1;
			DFSgenerator(start,table,visited,reference,storage,stepback,maxlength);
			DFS.add(storage);
		}
		return DFS;
	}

	/*
	 * This is the recursive function used for DFS.
	 */
	private static void DFSgenerator (Vertex start,List<List<Vertex>> table,boolean visited[],HashMap<Vertex,Integer> reference,List<Vertex> storage, int stepback, int maxlength){
		if(visited[reference.get(start)] == false) {
			storage.add(start);
			visited[reference.get(start)] = true;
		}

		if(storage.size() == maxlength){
			return;
		}

		List<Vertex> temporary = new ArrayList<>();
		temporary = table.get(reference.get(start));
		Collections.sort(temporary,Comparator.comparing(Vertex::getLabel));

		int count = 0;
		for(Vertex v: temporary){
			if(visited[reference.get(v)] == true){
				count++;
			}
		}

		if(count == temporary.size() || temporary.size() == 0){
			stepback++;
			DFSgenerator(storage.get(storage.size()-stepback),table,visited,reference,storage,stepback,maxlength);
		} else{
			for(Vertex v: temporary){
				if (visited[reference.get(v)] == false) {
					stepback = 1;
					DFSgenerator(v,table,visited,reference,storage,stepback,maxlength);
					return;
				}
			}
		}
	}

	/**
	 * Perform a complete breadth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a BFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param graph
	 * @return a set where each element of the set is a list
	 * of vertices seen by starting a BFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 */
	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
		Set<List<Vertex>> BFS = new HashSet<>();
		List<Vertex> graphvertices = graph.getVertices();
		boolean visited[] = new boolean[graphvertices.size()];
		HashMap<Vertex,Integer> reference = new HashMap<>();

		Collections.sort(graphvertices,Comparator.comparing(Vertex::getLabel));

		int i = 0;
		for(Vertex v : graphvertices){
			reference.put(v,i);
			i++;
		}

		for(int k = 0; k < graphvertices.size(); k++) {
			for(int a = 0; a < graphvertices.size(); a++){
				visited[a] = false;
			}
			List<Vertex> temporary = new LinkedList<>();
			Vertex source = graphvertices.get(k);
			Queue<Vertex> queue = new LinkedList<>();
			queue.add(source);
			visited[reference.get(source)] = true;

			for (int j = 0; j < graphvertices.size(); j++) {
				while (queue.size() != 0) {
					Vertex v = queue.remove();
					temporary.add(v);
					Collections.sort(graph.getNeighbors(v),Comparator.comparing(Vertex::getLabel));

					for (Vertex vertex : graph.getNeighbors(v)) {
						if (!visited[reference.get(vertex)]) {
							queue.add(vertex);
							visited[reference.get(vertex)] = true;
						}
					}
				}
			}
			BFS.add(temporary);
		}
		return BFS;
	}

	/**
	 * For a vertex v, the eccentricity of v is defined as the maximum distance
	 * between v and any other vertex w in the graph.
	 *
	 * @param graph
	 * @return vertex with the minimum eccentricity
	 *
	 * If a graph is not connected, the graph's center is the center of the
	 * largest connected component.
	 *
	 * If multiple vertices qualify, return the vertex that has the smallest
	 * lexicographic id.
	 *
	 */
	public static Vertex center(Graph graph) {
		int i = 0;
		int shortest;
		List<Vertex> graphvertices = graph.getVertices();
		List<List<Vertex>> table = new ArrayList<>();
		HashMap<Vertex, Integer> reference = new HashMap<>();
		List<Integer> distances = new ArrayList<>();
		List<Integer> differentlengths = new ArrayList<Integer>();
		boolean visited[] = new boolean[graphvertices.size()];
		HashMap<Integer,List<Vertex>> value = new HashMap<>();

		for(Vertex v: graphvertices){
			table.add(i,graph.getNeighbors(v));
			reference.put(v,i);
			visited[i] = false;
			i++;
		}

		for(Vertex start: graphvertices){
			for(Vertex end : graphvertices) {
				if (!start.equals(end)) {
					getalldistances(start,end,differentlengths,1,table,reference,visited,start);
					if(differentlengths.size() != 0) {
						distances.add(Collections.max(differentlengths));
						if (value.containsKey(Collections.max(differentlengths))) {
							value.get(Collections.max(differentlengths)).add(start);
						} else {
							value.put(Collections.max(differentlengths), new ArrayList<>());
							value.get(Collections.max(differentlengths)).add(start);
						}
						differentlengths = new ArrayList<Integer>();
					}
					i=0;
					for(Vertex v: graphvertices){
						visited[i] = false;
						i++;
					}
				}
			}
		}
		shortest = Collections.min(distances);

		Collections.sort(value.get(shortest),Comparator.comparing(Vertex::getLabel));

		return value.get(shortest).get(0);
	}


	/**
	 * The diameter of a graph is the maximum distance among the distances between
	 * all pairs of vertices in the graph.
	 *
	 * @param graph
	 * @return the diameter of graph
	 *
	 */
	public static int diameter(Graph graph) {
		int i = 0;
		int diameter;
		List<Integer> differentlengths = new ArrayList<>();
		List<Vertex> graphvertices = graph.getVertices();
		List<List<Vertex>> table = new ArrayList<>();
		HashMap<Vertex, Integer> reference = new HashMap<>();
		boolean visited[] = new boolean[graphvertices.size()];
		List<Integer> distances = new ArrayList<>();

		for(Vertex v: graphvertices){
			table.add(i,graph.getNeighbors(v));
			reference.put(v,i);
			visited[i] = false;
			i++;
		}
		for(Vertex start: graphvertices){
			for(Vertex end: graphvertices) {
				if (!start.equals(end)) {
					getalldistances(start, end, differentlengths, 1, table, reference, visited, start);

					if(!(differentlengths.size() == 0)){
						distances.add(Collections.min(differentlengths));
					}
					differentlengths = new ArrayList<>();

					i = 0;
					for (Vertex v : graphvertices) {
						visited[i] = false;
						i++;
					}
				}
			}
		}

		diameter = Collections.max(distances);

		return diameter;
	}

	/*
	 * This is the recursive function to get all possible paths between start vector and  end vector.
	 */
	private static void getalldistances(Vertex start,Vertex end,List<Integer> differentlengths, int count, List<List<Vertex>> table,HashMap<Vertex, Integer> reference,boolean visited[], Vertex search) {
		if(table.get(reference.get(search)).contains(end)){
			differentlengths.add(count);
			return;
		} else{
			visited[reference.get(search)] = true;
			for(Vertex temporary: table.get(reference.get(search))){
				if(visited[reference.get(temporary)] == false) {
					getdistances(start, end, differentlengths,table,reference,temporary,count +1,visited);
				}
			}
		}
	}
}