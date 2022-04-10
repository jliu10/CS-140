import java.util.*;

class liu_WeightedGraph implements WeightedGraphFunctions {
    private ArrayList<Integer> vertices;
    private ArrayList<EdgeWithWeight> edges;
    private boolean debugOutput = false;

    liu_WeightedGraph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void setDebug(boolean b) {
        debugOutput = b;
    }

/*  Returns true or false depending on whether there is a path from fromVertex to
    toVertex
*/
    public boolean hasPath(int fromVertex, int toVertex) {
        return false;
    }

/*  Returns the cost of a minimum cost path from the fromVertex to the toVertex.
    Returns Double.NaN if there is no path
*/
	public double getMinimumWeight(int fromVertex, int toVertex) {
        return 0;
    }

/*  Returns a minimum cost path from the fromVertex to the toVertex if there is one
    – that is, it returns an ordered list of edges from the fromVertex to the toVertex.
    Returns an EdgeWithWeight[] of length 0 if there is no path.
*/
	public EdgeWithWeight[] getPath(int fromVertex, int toVertex) {
        return null;
    }


/*  Add a vertex to the weighted graph
    If the vertex already exists, do not add it
*/
	public boolean addVertex(int v) {
        return false;
    }


/*  Add a weighted edge to the weighted graph
    If the weighted edge already exists, do not add it
    That is, there already exists a weighted edge with the from and to vertices
*/
	public boolean addWeightedEdge(int from, int to, double weight) {
        return false;
    }

/*  Return a string representation of the graph
    Below is my output for “sample_weighted_graph_1.txt”
    1. G = (V, E)
    2. V = {1,2,3,4,5,6,7,8,9,10,11,12,13}
    3. E = {(1,2,1.0),(1,3,3.0),(1,4,5.0),(2,3,1.0),(3,4,1.0),(1,5,1.0),(4,6,2.0),
    (5,6,1.0),(4,7,6.0),(6,7,5.0),(5,8,4.0),(6,9,2.0),(7,10,2.0),(8,11,8.0),
    (9,12,5.0),(9,13,2.0),(9,8,3.0),(10,13,5.0),(12,11,1.0),(13,12,3.0),
    (10,9,1.0)}
*/
	public String toString() {
        return null;
    }
}