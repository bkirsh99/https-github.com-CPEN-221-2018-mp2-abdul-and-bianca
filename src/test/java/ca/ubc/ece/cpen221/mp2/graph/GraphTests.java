package ca.ubc.ece.cpen221.mp2.graph;

import ca.ubc.ece.cpen221.mp2.boggle.BoggleBoard;
import ca.ubc.ece.cpen221.mp2.boggle.BogglePlayer;
import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import ca.ubc.ece.cpen221.utils.In;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.*;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class GraphTests {

    @Test
    public void test_adjacencyList() {
        Graph g = new AdjacencyListGraph();
        List<Vertex> list = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Tom Fury");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(v1, v2);
        g.addEdge(v1, v3);
        g.addEdge(v1, v4);
        list.add(v2);
        list.add(v3);
        list.add(v4);
        assertEquals(list ,g.getNeighbors(v1));
    }

    @Test
    public void test_adjacencyMatrix() {
        Graph g = new AdjacencyMatrixGraph();
        List<Vertex> list = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        g.addEdge(v1, v2);
        g.addEdge(v1, v3);
        list.add(v2);
        list.add(v3);
        assertEquals(list,g.getNeighbors(v1));
    }

    @Test
    public void test_centre1() { //v1 and v2 qualify - centre is v1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(v1, v2);
        Vertex c = Algorithms.center(g);
        assertEquals( "1", Algorithms.center(g).getLabel());
    }

    @Test
    public void test_centre2() {//v1 and v4 qualify - centre is v1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Geroge Jones");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(v1, v2);
        g.addEdge(v2,v4);
        Vertex c = Algorithms.center(g);
        assertEquals("1" ,c.getLabel());
    }

    @Test
    public void test_centre3() { //centre is v1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Andre Guz");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addEdge(v1, v2);
        g.addEdge(v3,v4);
        g.addEdge(v1,v6);
        Vertex c = Algorithms.center(g);
        assertEquals("1" ,c.getLabel());
    }

    @Test
    public void test_centre4() { //v1 and v2 qualify - centre is v1
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(v1, v2);
        Vertex c = Algorithms.center(g);
        assertEquals("1" ,c.getLabel());
    }

    @Test
    public void test_centre5() { //centre is v1
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Geroge Jones");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(v1, v2);
        g.addEdge(v2,v4);
        Vertex c = Algorithms.center(g);
        assertEquals("1" ,c.getLabel());
    }

    @Test
    public void test_centre6() { //centre is v1
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Andre Guz");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addEdge(v1, v2);
        g.addEdge(v3,v4);
        g.addEdge(v1,v6);
        Vertex c = Algorithms.center(g);
        assertEquals("1" , c.getLabel());
    }

    @Test
    public void test_centre7() { //centre is v1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Andre Guz");
        Vertex v7 = new Vertex("7","Aahana Kanyal");
        Vertex v8 = new Vertex ("8","Hannah Montana");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addVertex(v8);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v1,v5);
        g.addEdge(v2,v3);
        g.addEdge(v2,v4);
        g.addEdge(v3,v6);
        g.addEdge(v3,v4);
        g.addEdge(v6,v8);
        g.addEdge(v6,v4);
        g.addEdge(v8,v7);
        g.addEdge(v8,v4);
        g.addEdge(v7,v5);
        g.addEdge(v7,v4);
        g.addEdge(v4,v5);
        Vertex c = Algorithms.center(g);
        assertEquals("1" ,c.getLabel());
    }

    @Test
    public void test_centre8() { //centre is v1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Andre Guz");
        g.addVertex(v5);
        g.addEdge(v1, v2);
        g.addEdge(v3, v4);
        g.addEdge(v1, v6);
        Vertex c = Algorithms.center(g);
        assertEquals("1" , c.getLabel());
    }

    @Test
    public void test_centre9(){ //centre is 1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "John Doe");
        Vertex v7 = new Vertex("7", "Lalala");
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v2,v4);
        g.addEdge(v4,v5);
        g.addEdge(v1,v6);
        g.addEdge(v6,v7);
        Vertex a = Algorithms.center(g);
        assertEquals("1" ,a.getLabel());
    }

    @Test
    public void test_centre_disconnected(){ //1 or 2, return 1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "John Doe");
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v4,v5);
        g.addEdge(v5,v6);
        Vertex a = Algorithms.center(g);
        assertEquals("1" ,a.getLabel());
    }

    @Test
    public void test_dist1() {//shortest distance is 2
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        int c = Algorithms.shortestDistance(g,v1,v3);
        assertEquals(2 ,c);
    }

    @Test
    public void test_dist2() { //every vertex is connected to each other - shortest distance is 1
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex ("4","Bianca Kirsh");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v2,v4);
        g.addEdge(v2,v3);
        g.addEdge(v3,v4);
        int c = Algorithms.shortestDistance(g,v1,v3);
        assertEquals(1 , c);
    }

    @Test
    public void test_dist3() {//shortest distance is 2
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        int c = Algorithms.shortestDistance(g,v1,v3);
        assertEquals(2 , c);
    }

    @Test
    public void test_dist4() { //every vertex is connected to each other - shortest distance is 1
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex ("4","Bianca Kirsh");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v2,v4);
        g.addEdge(v2,v3);
        g.addEdge(v3,v4);
        int c = Algorithms.shortestDistance(g,v1,v3);
        assertEquals(1 , c);
    }

    @Test
    public void test_dist5() {//shortest distance is 2
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex ("4","Bianca Kirsh");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v1,v4);
        g.addEdge(v3,v4);
        int c = Algorithms.shortestDistance(g,v1,v3);
        assertEquals(2 , c);
    }

    @Test
    public void test_dist6() {//shortest distance is 3
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex ("4","Bianca Kirsh");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v3,v4);
        int c = Algorithms.shortestDistance(g,v1,v4);
        assertEquals(3 , c);
    }

    @Test
    public void test_dist7() {//shortest distance is 3
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex ("4","Bianca Kirsh");
        Vertex v5 = new Vertex ("5","Cindy Lou");
        Vertex v6 = new Vertex ("6","Laura Ben");
        Vertex v7 = new Vertex ("7","Hin Yu");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v4,v7);
        g.addEdge(v1,v5);
        g.addEdge(v5,v6);
        g.addEdge(v6,v7);
        g.addEdge(v3,v4);
        int c = Algorithms.shortestDistance(g,v1,v7);
        assertEquals(3 ,c);
    }

    @Test
    public void test_dist8() {//shortest distance is 4
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Andre Guz");
        Vertex v7 = new Vertex("7","Aahana Kanyal");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v2,v4);
        g.addEdge(v2,v5);
        g.addEdge(v4,v7);
        g.addEdge(v5,v7);
        g.addEdge(v3,v6);
        int c = Algorithms.shortestDistance(g,v5,v6);
        assertEquals(4 , c);
    }

    @Test
    public void test_dist9() {//vertices v1 and v5 aren't connected - return -1
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Lala Gou");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v4,v5);
        int c = Algorithms.shortestDistance(g,v5,v1);
        assertEquals(-1 ,c);
    }

    @Test
    public void test_diameter1() {//diameter is 5
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Andre Guz");
        Vertex v7 = new Vertex("7","Aahana Kanyal");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v2,v4);
        g.addEdge(v2,v5);
        g.addEdge(v4,v7);
        g.addEdge(v5,v7);
        g.addEdge(v3,v6);
        int c = Algorithms.diameter(g);
        assertEquals(5 , c);
    }

    @Test
    public void test_diameter2() {//diameter is 5
        Graph g = new AdjacencyMatrixGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Andre Guz");
        Vertex v7 = new Vertex("7","Aahana Kanyal");
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v2,v4);
        g.addEdge(v4,v5);
        g.addEdge(v1,v6);
        g.addEdge(v6,v7);
        int c = Algorithms.diameter(g);
        assertEquals(5 , c);
    }

    @Test
    public void test_diameter_disconnected(){
        Graph g = new AdjacencyListGraph();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "John Doe");
        Vertex v7 = new Vertex("7", "Lalala");
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v4,v5);
        g.addEdge(v1,v6);
        g.addEdge(v6,v7);
        int a = Algorithms.diameter(g);
        assertEquals( 4, a);
    }

    @Test
    public void test_BFS1(){
        Graph g = new AdjacencyListGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v3,v5);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v4);
        list1.add(v5);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v4);
        list2.add(v5);
        list3.add(v3);
        list3.add(v1);
        list3.add(v5);
        list3.add(v2);
        list3.add(v4);
        list4.add(v4);
        list4.add(v1);
        list4.add(v2);
        list4.add(v3);
        list4.add(v5);
        list5.add(v5);
        list5.add(v3);
        list5.add(v1);
        list5.add(v2);
        list5.add(v4);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        Set<List<Vertex>> c = Algorithms.breadthFirstSearch(g);
        assertEquals(check , c);
    }

    @Test
    public void test_BFS2(){
        Graph g = new AdjacencyListGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v2,v5);
        g.addEdge(v3,v5);
        g.addEdge(v5,v4);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v4);
        list1.add(v5);
        list2.add(v2);
        list2.add(v1);
        list2.add(v5);
        list2.add(v3);
        list2.add(v4);
        list3.add(v3);
        list3.add(v1);
        list3.add(v5);
        list3.add(v2);
        list3.add(v4);
        list4.add(v4);
        list4.add(v1);
        list4.add(v5);
        list4.add(v2);
        list4.add(v3);
        list5.add(v5);
        list5.add(v2);
        list5.add(v3);
        list5.add(v4);
        list5.add(v1);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        Set<List<Vertex>> a = Algorithms.breadthFirstSearch(g);
        assertEquals(check,a);
    }

    @Test
    public void test_BFS_disconnected(){
        Graph g = new AdjacencyListGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        List<Vertex> list7 = new ArrayList<>();
        List<Vertex> list8 = new ArrayList<>();
        List<Vertex> list9 = new ArrayList<>();
        List<Vertex> list10 = new ArrayList<>();
        List<Vertex> list11 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "John Doe");
        Vertex v7 = new Vertex("7", "Jvhfjvnfv");
        Vertex v8 = new Vertex("8", "dfdsfs");
        Vertex v9 = new Vertex("9", "dfds");
        Vertex v10 = new Vertex("10", "dsfs");
        Vertex v11 = new Vertex("11", "dhjkl");
        g.addVertex(v11);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v2,v4);
        g.addEdge(v4,v5);
        g.addEdge(v1,v6);
        g.addEdge(v6,v7);
        g.addEdge(v8,v9);
        g.addEdge(v9,v10);
        list1.add(v1);
        list1.add(v2);
        list1.add(v6);
        list1.add(v3);
        list1.add(v4);
        list1.add(v7);
        list1.add(v5);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v4);
        list2.add(v6);
        list2.add(v5);
        list2.add(v7);
        list3.add(v3);
        list3.add(v2);
        list3.add(v1);
        list3.add(v4);
        list3.add(v6);
        list3.add(v5);
        list3.add(v7);
        list4.add(v4);
        list4.add(v2);
        list4.add(v5);
        list4.add(v1);
        list4.add(v3);
        list4.add(v6);
        list4.add(v7);
        list5.add(v5);
        list5.add(v4);
        list5.add(v2);
        list5.add(v1);
        list5.add(v3);
        list5.add(v6);
        list5.add(v7);
        list6.add(v6);
        list6.add(v1);
        list6.add(v7);
        list6.add(v2);
        list6.add(v3);
        list6.add(v4);
        list6.add(v5);
        list7.add(v7);
        list7.add(v6);
        list7.add(v1);
        list7.add(v2);
        list7.add(v3);
        list7.add(v4);
        list7.add(v5);
        list8.add(v8);
        list8.add(v9);
        list8.add(v10);
        list9.add(v9);
        list9.add(v10);
        list9.add(v8);
        list10.add(v10);
        list10.add(v9);
        list10.add(v8);
        list11.add(v11);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        check.add(list7);
        check.add(list8);
        check.add(list9);
        check.add(list10);
        check.add(list11);
        Set<List<Vertex>> c = Algorithms.breadthFirstSearch(g);
        assertEquals(check,c);
    }

    @Test
    public void test_DFS1(){
        Graph g = new AdjacencyListGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v1,v4);
        g.addEdge(v3,v5);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v5);
        list1.add(v4);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v5);
        list2.add(v4);
        list3.add(v3);
        list3.add(v1);
        list3.add(v2);
        list3.add(v4);
        list3.add(v5);
        list4.add(v4);
        list4.add(v1);
        list4.add(v2);
        list4.add(v3);
        list4.add(v5);
        list5.add(v5);
        list5.add(v3);
        list5.add(v1);
        list5.add(v2);
        list5.add(v4);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check ,c);
    }

    @Test
    public void test_DFS2(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        List<Vertex> list7 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Nick Jones");
        Vertex v7 = new Vertex("7", "Terry Fanta");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addVertex(v7);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v3,v4);
        g.addEdge(v3,v5);
        g.addEdge(v5,v6);
        g.addEdge(v2,v7);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v4);
        list1.add(v5);
        list1.add(v6);
        list1.add(v7);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v4);
        list2.add(v5);
        list2.add(v6);
        list2.add(v7);
        list3.add(v3);
        list3.add(v2);
        list3.add(v1);
        list3.add(v7);
        list3.add(v4);
        list3.add(v5);
        list3.add(v6);
        list4.add(v4);
        list4.add(v3);
        list4.add(v2);
        list4.add(v1);
        list4.add(v7);
        list4.add(v5);
        list4.add(v6);
        list5.add(v5);
        list5.add(v3);
        list5.add(v2);
        list5.add(v1);
        list5.add(v7);
        list5.add(v4);
        list5.add(v6);
        list6.add(v6);
        list6.add(v5);
        list6.add(v3);
        list6.add(v2);
        list6.add(v1);
        list6.add(v7);
        list6.add(v4);
        list7.add(v7);
        list7.add(v2);
        list7.add(v1);
        list7.add(v3);
        list7.add(v4);
        list7.add(v5);
        list7.add(v6);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        check.add(list7);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }

    @Test
    public void test_DFS3(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Nick Jones");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v2,v4);
        g.addEdge(v3,v5);
        g.addEdge(v4,v5);
        g.addEdge(v3,v6);
        list1.add(v1);
        list1.add(v2);
        list1.add(v4);
        list1.add(v5);
        list1.add(v3);
        list1.add(v6);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v5);
        list2.add(v4);
        list2.add(v6);
        list3.add(v3);
        list3.add(v1);
        list3.add(v2);
        list3.add(v4);
        list3.add(v5);
        list3.add(v6);
        list4.add(v4);
        list4.add(v2);
        list4.add(v1);
        list4.add(v3);
        list4.add(v5);
        list4.add(v6);
        list5.add(v5);
        list5.add(v3);
        list5.add(v1);
        list5.add(v2);
        list5.add(v4);
        list5.add(v6);
        list6.add(v6);
        list6.add(v3);
        list6.add(v1);
        list6.add(v2);
        list6.add(v4);
        list6.add(v5);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }


    @Test
    public void test_DFS4(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Nick Jones");
        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v3,v4);
        g.addEdge(v1,v5);
        g.addEdge(v2,v6);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v4);
        list1.add(v6);
        list1.add(v5);
        list2.add(v2);
        list2.add(v1);
        list2.add(v5);
        list2.add(v3);
        list2.add(v4);
        list2.add(v6);
        list3.add(v3);
        list3.add(v2);
        list3.add(v1);
        list3.add(v5);
        list3.add(v6);
        list3.add(v4);
        list4.add(v4);
        list4.add(v3);
        list4.add(v2);
        list4.add(v1);
        list4.add(v5);
        list4.add(v6);
        list5.add(v5);
        list5.add(v1);
        list5.add(v2);
        list5.add(v3);
        list5.add(v4);
        list5.add(v6);
        list6.add(v6);
        list6.add(v2);
        list6.add(v1);
        list6.add(v5);
        list6.add(v3);
        list6.add(v4);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }


    @Test
    public void test_DFS5(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Nick Jones");
        g.addEdge(v1,v2);
        g.addEdge(v1,v3);
        g.addEdge(v2,v4);
        g.addEdge(v2,v5);
        g.addEdge(v3,v5);
        g.addEdge(v4,v5);
        g.addEdge(v4,v6);
        g.addEdge(v5,v6);
        list1.add(v1);
        list1.add(v2);
        list1.add(v4);
        list1.add(v5);
        list1.add(v3);
        list1.add(v6);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v5);
        list2.add(v4);
        list2.add(v6);
        list3.add(v3);
        list3.add(v1);
        list3.add(v2);
        list3.add(v4);
        list3.add(v5);
        list3.add(v6);
        list4.add(v4);
        list4.add(v2);
        list4.add(v1);
        list4.add(v3);
        list4.add(v5);
        list4.add(v6);
        list5.add(v5);
        list5.add(v2);
        list5.add(v1);
        list5.add(v3);
        list5.add(v4);
        list5.add(v6);
        list6.add(v6);
        list6.add(v4);
        list6.add(v2);
        list6.add(v1);
        list6.add(v3);
        list6.add(v5);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }


    @Test
    public void test_DFS6(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        g.addEdge(v1, v2);
        g.addEdge(v1, v3);
        g.addEdge(v1, v4);
        g.addEdge(v2, v5);
        g.addEdge(v3, v5);
        g.addEdge(v4, v5);
        list1.add(v1);
        list1.add(v2);
        list1.add(v5);
        list1.add(v3);
        list1.add(v4);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v5);
        list2.add(v4);
        list3.add(v3);
        list3.add(v1);
        list3.add(v2);
        list3.add(v5);
        list3.add(v4);
        list4.add(v4);
        list4.add(v1);
        list4.add(v2);
        list4.add(v5);
        list4.add(v3);
        list5.add(v5);
        list5.add(v2);
        list5.add(v1);
        list5.add(v3);
        list5.add(v4);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }


    @Test
    public void test_DFS7(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        g.addEdge(v1, v2);
        g.addEdge(v1, v3);
        g.addEdge(v2, v3);
        g.addEdge(v3, v4);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v4);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list2.add(v4);
        list3.add(v3);
        list3.add(v1);
        list3.add(v2);
        list3.add(v4);
        list4.add(v4);
        list4.add(v3);
        list4.add(v1);
        list4.add(v2);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }

    @Test
    public void test_DFS_disconnected1(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "Nick Jones");
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v4,v5);
        g.addEdge(v5,v6);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list2.add(v2);
        list2.add(v1);
        list2.add(v3);
        list3.add(v3);
        list3.add(v2);
        list3.add(v1);
        list4.add(v4);
        list4.add(v5);
        list4.add(v6);
        list5.add(v5);
        list5.add(v4);
        list5.add(v6);
        list6.add(v6);
        list6.add(v5);
        list6.add(v4);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }


    @Test
    public void test_DFS_disconnected2(){
        Graph g = new AdjacencyListGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        List<Vertex> list7 = new ArrayList<>();
        List<Vertex> list8 = new ArrayList<>();
        List<Vertex> list9 = new ArrayList<>();
        List<Vertex> list10 = new ArrayList<>();
        List<Vertex> list11 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "John Doe");
        Vertex v7 = new Vertex("7", "Jvhfjvnfv");
        Vertex v8 = new Vertex("8", "dfdsfs");
        Vertex v9 = new Vertex("9", "dfds");
        Vertex v10 = new Vertex("10", "dsfs");
        Vertex v11 = new Vertex("11", "dhjkl");
        g.addVertex(v11);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v2,v4);
        g.addEdge(v4,v5);
        g.addEdge(v1,v6);
        g.addEdge(v6,v7);
        g.addEdge(v8,v9);
        g.addEdge(v9,v10);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v4);
        list1.add(v5);
        list1.add(v6);
        list1.add(v7);
        list2.add(v2);
        list2.add(v1);
        list2.add(v6);
        list2.add(v7);
        list2.add(v3);
        list2.add(v4);
        list2.add(v5);
        list3.add(v3);
        list3.add(v2);
        list3.add(v1);
        list3.add(v6);
        list3.add(v7);
        list3.add(v4);
        list3.add(v5);
        list4.add(v4);
        list4.add(v2);
        list4.add(v1);
        list4.add(v6);
        list4.add(v7);
        list4.add(v3);
        list4.add(v5);
        list5.add(v5);
        list5.add(v4);
        list5.add(v2);
        list5.add(v1);
        list5.add(v6);
        list5.add(v7);
        list5.add(v3);
        list6.add(v6);
        list6.add(v1);
        list6.add(v2);
        list6.add(v3);
        list6.add(v4);
        list6.add(v5);
        list6.add(v7);
        list7.add(v7);
        list7.add(v6);
        list7.add(v1);
        list7.add(v2);
        list7.add(v3);
        list7.add(v4);
        list7.add(v5);
        list8.add(v8);
        list8.add(v9);
        list8.add(v10);
        list9.add(v9);
        list9.add(v10);
        list9.add(v8);
        list10.add(v10);
        list10.add(v9);
        list10.add(v8);
        list11.add(v11);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        check.add(list7);
        check.add(list8);
        check.add(list9);
        check.add(list10);
        check.add(list11);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }


    @Test
    public void test_DFS_disconnected3(){
        Graph g = new AdjacencyMatrixGraph();
        Set<List<Vertex>> check = new HashSet<>();
        List<Vertex> list1 = new ArrayList<>();
        List<Vertex> list2 = new ArrayList<>();
        List<Vertex> list3 = new ArrayList<>();
        List<Vertex> list4 = new ArrayList<>();
        List<Vertex> list5 = new ArrayList<>();
        List<Vertex> list6 = new ArrayList<>();
        List<Vertex> list7 = new ArrayList<>();
        List<Vertex> list8 = new ArrayList<>();
        List<Vertex> list9 = new ArrayList<>();
        List<Vertex> list10 = new ArrayList<>();
        List<Vertex> list11 = new ArrayList<>();
        Vertex v1 = new Vertex("1", "Paul Erdos");
        Vertex v2 = new Vertex("2", "Alfred Renyi");
        Vertex v3 = new Vertex("3", "Endre Szemerédi");
        Vertex v4 = new Vertex("4", "Jack Gou");
        Vertex v5 = new Vertex("5", "Bianca Kirsh");
        Vertex v6 = new Vertex("6", "John Doe");
        Vertex v7 = new Vertex("7", "Jvhfjvnfv");
        Vertex v8 = new Vertex("8", "dfdsfs");
        Vertex v9 = new Vertex("9", "dfds");
        Vertex v10 = new Vertex("10", "dsfs");
        Vertex v11 = new Vertex("11", "dhjkl");
        g.addVertex(v11);
        g.addEdge(v1,v2);
        g.addEdge(v2,v3);
        g.addEdge(v2,v4);
        g.addEdge(v4,v5);
        g.addEdge(v1,v6);
        g.addEdge(v6,v7);
        g.addEdge(v8,v9);
        g.addEdge(v9,v10);
        list1.add(v1);
        list1.add(v2);
        list1.add(v3);
        list1.add(v4);
        list1.add(v5);
        list1.add(v6);
        list1.add(v7);
        list2.add(v2);
        list2.add(v1);
        list2.add(v6);
        list2.add(v7);
        list2.add(v3);
        list2.add(v4);
        list2.add(v5);
        list3.add(v3);
        list3.add(v2);
        list3.add(v1);
        list3.add(v6);
        list3.add(v7);
        list3.add(v4);
        list3.add(v5);
        list4.add(v4);
        list4.add(v2);
        list4.add(v1);
        list4.add(v6);
        list4.add(v7);
        list4.add(v3);
        list4.add(v5);
        list5.add(v5);
        list5.add(v4);
        list5.add(v2);
        list5.add(v1);
        list5.add(v6);
        list5.add(v7);
        list5.add(v3);
        list6.add(v6);
        list6.add(v1);
        list6.add(v2);
        list6.add(v3);
        list6.add(v4);
        list6.add(v5);
        list6.add(v7);
        list7.add(v7);
        list7.add(v6);
        list7.add(v1);
        list7.add(v2);
        list7.add(v3);
        list7.add(v4);
        list7.add(v5);
        list8.add(v8);
        list8.add(v9);
        list8.add(v10);
        list9.add(v9);
        list9.add(v10);
        list9.add(v8);
        list10.add(v10);
        list10.add(v9);
        list10.add(v8);
        list11.add(v11);
        check.add(list1);
        check.add(list2);
        check.add(list3);
        check.add(list4);
        check.add(list5);
        check.add(list6);
        check.add(list7);
        check.add(list8);
        check.add(list9);
        check.add(list10);
        check.add(list11);
        Set<List<Vertex>> c = Algorithms.depthFirstSearch(g);
        assertEquals(check,c);
    }
}