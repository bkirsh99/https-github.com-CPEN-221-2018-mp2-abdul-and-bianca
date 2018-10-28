#For this MP, we have done as follows:
1. For *AdjacencyListGraph*:
- In the constructor:
  - We take in no arguments and initialize a new HashMap called allLists
- In addVertex:
  - We first of all check if allLists map already contains the vertex added, if not, we create a new LinkedList and add an entry in allLists (with the added vertex as key and the new list as value)
- In addEdge:
  - We add v2 to v1's list, and vice versa. If either v1 or v2 (or both) don't exist, we add them to allLists and then add them to each other
- In edgeExists:
  - We check if v1's list contains v2 and if v2's list contains v1. If yes, we return true, if not then false
- In getNeighbors:
  - We get vertex v's list from allLists, and that would be all adjacent verteces of vertex v
- In getVertices:
  - We iterate down allLists' keyset and add each vertex to a list of verteces (allVertex) and return it


2. For *AdjacencyMatrixGraph*:
- In the constructor:
  - We take in no arguments.
- In addVertex:
  - We first of all check if the vertex was added before, if not, we create a new 2D array called matrix, use temporarymatrix(which is the previous matrix) to regenerate previously stored values and we get a new 2D array without any data lost
- In addEdge:
  - We change the entry in matrix at [v1][v2] and [v2][v1] to 1. If either v1 or v2 (or both) don't exist, we add them to matrix and then change the values as stated before
- In edgeExists:
  - We check if [v1][v2] and [v2][v1] both contain the value 1. If yes, we return true, if not then false
- In getNeighbors:
  - We iterate through the whole row for vertex v and add verteces to a list if we come across a value 1 (meaning an edfge exists), and that would be all adjacent verteces of vertex v
- In getVertices:
  - We iterate down the matrix and add each vertex to a list of verteces (allVertex) and return it


3. For *Algorithms*:
- In shortestdistance:
  - We record information about the imported graph, call a recursive function to get all the distances between vertex a and b, and then get the minimum of all these distances
- In depthFirstSearch
  - We record information about the imported graph, call a recursive function that returns the DFS sequence. If graphs are disconnnected, we return the DFS sequence of all of them seperately
- In breadthFirstSearch
  - We record information about the imported graph, we used a queue and a Boolean array to keep track of the vertices that we already performed the BFS on. We loop the main computation part so that we can get the BFS starting from every vertex in the graph. Add the end of every loop, we add the BFS analysis starting from that vertex to a Set.
- In centre:
  - We record information about the imported graph, then we get every possible distance between a changing start and end vertex and then get the minimum of those. This would give us the minimum of the maximum distances, hence the centre of the graph
- In diameter:
  - We record information about the imported graph, call a recursive function that would get all possible distances between vertex start and end (which both change to cover all verteces) and then get the maximum of that, which would give us the diameter.

4. For *BogglePlayer*:
- In getAllValidWords
  - We build an adjacencyListGraph representation of the board.
  - We added vertices to the graph using their char representation (or string representation “Qu” in the case of ‘Q’) as labels and coordinate pair as content.
  - We added edges to all vertices, including wrap arounds. In this way, a 4 x 4 board would be represented by a graph with two extra rows and two extra columns. The bottom-most row on the board would reappear as the top-most layer in the graph, while the top-most row on the board would appear as the bottom-most layer in the graph, and so forth.
  - We used recursion to get all possible paths for every possible combination of starting and ending vertex. The paths formed words, and if their length was >= 3 and was contained in the dictionary, we added them to a Set of validWords.
  - We return the set of valid words once recursion is done.
- In getMaximumScore and scoreOf
  - We called a helper method getScore that computed the score of any word, whether it was a valid word or not.
  - To assure that the word was valid, we called getAllValidWords on the board and checked if the word was contained in the Set. If not, we returned 0. If yes, we returned the score obtained from getScore.
  - For getMaximumScore, we looped this procedure and kept adding the score of each word until we checked all the valid words.