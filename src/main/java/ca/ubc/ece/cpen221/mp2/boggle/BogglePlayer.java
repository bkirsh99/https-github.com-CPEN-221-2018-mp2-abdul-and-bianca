package ca.ubc.ece.cpen221.mp2.boggle;

import ca.ubc.ece.cpen221.mp2.core.Graph;
import ca.ubc.ece.cpen221.mp2.core.Vertex;
import ca.ubc.ece.cpen221.mp2.graph.AdjacencyListGraph;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;

public class BogglePlayer {
    private BoggleBoard board;
    private Set<String> dictionary;
    private Stack<Vertex> stack;
    private Set<String> validWords;
    Map<String, Integer> words;

    // Rep invariant:
    //    board is of dimensions n x n, with n > 2
    //    dictionary is not empty
    // Abstraction Function:
    //   represents all the valid words and their individual/total
    //   score for a boggle game

    // This is the constructor - note: the constructor is overloaded
    // Initializes the data type using the given set of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BogglePlayer(String[] dictionary) {
        Set<String> mySet = new HashSet<>(Arrays.asList(dictionary));
        this.dictionary = mySet;
        this.stack = new Stack<>();
        this.validWords = new TreeSet<>();
        this.words = new HashMap<>();
        int count = 0;
        for (String s : dictionary) {
            if (s.length() > 2) {
                words.put(s, count);
                count++;
            }
        }
    }

    public BogglePlayer(Set<String> dictionary) {
        this.dictionary = dictionary;

    }

    /**
     *
     * @param board
     * @return all valid words in the given Boggle board, as a set of strings.
     *
     */
    public Set<String> getAllValidWords(BoggleBoard board) {
        this.board = board;
        Graph graph = new AdjacencyListGraph();
        HashMap<List<Integer>, String> dice = new HashMap<>();
        int rows = board.rows();
        int columns = board.cols();
        Vertex v;
        int a;
        int b;
        int row = 0;
        int column = 0;
        int temprow;
        int tempcol;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Character rep = board.getLetter(i, j);
                List<Integer> pair = new ArrayList<>();
                pair.add(i);
                pair.add(j);
                String content = pair.toString();
                if (rep.toString().equals("Q") || rep.toString().equals("Qu")) {
                    String name = "QU";
                    v = new Vertex(name, content);
                    dice.put(pair, name);
                } else {
                    v = new Vertex(rep.toString(), content);
                    dice.put(pair, rep.toString());
                }
                graph.addVertex(v);
            }
        }

        int maxlength = dice.size();

        for (Vertex check : graph.getVertices()) {
            String tag = check.getContent();
            for (List<Integer> temp : dice.keySet()) {
                String see = temp.toString();
                if (tag.equals(see)) {
                    row = temp.get(0);
                    column = temp.get(1);
                    break;
                }
            }
            List<List<Integer>> neighbors = new ArrayList<>();
            for (a = row - 1; a < row + 2; a++) {
                for (b = column - 1; b < column + 2; b++) {
                    temprow = 0;
                    tempcol = 0;
                    if (a < 0) {
                        temprow = a + (int) ((Math.pow(maxlength, 0.5)));
                    }
                    if (a > (((Math.pow(maxlength, 0.5))) - 1)) {
                        temprow = a - (int) ((Math.pow(maxlength, 0.5)));
                    }
                    if (b < 0) {
                        tempcol = b + (int) ((Math.pow(maxlength, 0.5)));
                    }
                    if (b > (((Math.pow(maxlength, 0.5))) - 1)) {
                        tempcol = b - (int) ((Math.pow(maxlength, 0.5)));
                    }
                    List<Integer> reference = new ArrayList<>();
                    if (temprow == 0 && a > (int) (Math.pow(maxlength, 0.5) - 1)) {
                        reference.add(temprow);
                    } else if (temprow != 0) {
                        reference.add(temprow);
                    } else {
                        reference.add(a);
                    }
                    if (tempcol == 0 && b > (int) (Math.pow(maxlength, 0.5) - 1)) {
                        reference.add(tempcol);
                    } else if (tempcol != 0) {
                        reference.add(tempcol);
                    } else {
                        reference.add(b);
                    }
                    neighbors.add(reference);
                }
            }

            for (List<Integer> iterator : neighbors) {
                String verify = iterator.toString();
                for (Vertex find : graph.getVertices()) {
                    if (verify.equals(find.getContent())) {
                        if (!graph.edgeExists(check, find)) {
                            graph.addEdge(check, find);
                            break;
                        }
                    }
                }
            }
        }

        List<Vertex> hold = new ArrayList<>();

        for (Vertex start : graph.getVertices()) {
            for (Vertex end : graph.getVertices()) {
                if (!start.equals(end)) {
                    allPaths(graph, start, end, hold);
                }
            }
        }
        Set<String> allWords = validWords;
        return allWords;
    }

    // Recursive method for getting all possible words
    private void allPaths(Graph g, Vertex start, Vertex end, List<Vertex> hold) {
        stack.add(start);
        hold.add(start);
        String path = new String();
        boolean prefix = false;
        for (Vertex vert : hold) {
            path = path + vert.getLabel();

        }
        for (String check : dictionary) {
            if (check.startsWith(path)) {
                prefix = true;
                break;
            }
        }

        if (prefix) {
            if (start.equals(end)) {
                if (words.containsKey(path)) {
                    if (!validWords.contains(path)) {
                        validWords.add(path);
                    }
                }
            } else {
                for (Vertex adjacent : g.getNeighbors(start)) {
                    if (!hold.contains(adjacent)) {
                        allPaths(g, adjacent, end, hold);
                    }
                }
            }
        }
        stack.pop();
        hold.remove(start);

    }

    /**
     *
     * @param board
     * @return the maximum possible score that can be achieved from a given board
     */
    public int getMaximumScore(BoggleBoard board){
        Set<String> allWords = getAllValidWords(board);
        int score = 0;

        for(String word : allWords){
            score += getScore(word);
        }

        return score;
    }

    /**
     *
     * @param word
     * @return the score of the given word if it is in the dictionary, zero otherwise.
     *
     */
    public int scoreOf(String word){
        Set<String> allWords = getAllValidWords(board);

        if(allWords.contains(word)){
            return getScore(word);
        }

        return 0;
    }

    private int getScore(String word){
        int length = word.length();
        int score = 0;

        if(length == 3 || length == 4){
            score = 1;
        } else if(length == 5){
            score = 2;
        } else if(length == 6){
            score = 3;
        } else if(length == 7){
            score = 5;
        } else if(length >= 8){
            score = 11;
        }
        return score;
    }

}