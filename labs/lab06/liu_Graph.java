import java.util.*;

class liu_Graph implements ConnectedGraphFunctions {
    private final ArrayList<Integer> vertices = new ArrayList<>(); // contains the vertices
    private final ArrayList<Edge> edges = new ArrayList<>(); // contains the list of edges
    private final boolean isDirected; // tells us if the graph is or is not directe

    liu_Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    liu_Graph() {
        this(false);
    }

    public int getNumberOfVertices() {
        return vertices.size();
    }

	public int getNumberOfEdges() {
        return edges.size();
    }

	public boolean isDirected() {
        return isDirected;
    }

	public void addVertex(int v) throws GraphException {

    }

	public void addEdge(int from, int to) throws GraphException {

    }

	public String toString() {
        // Line 1 is to be “G = (V,E)”
        StringBuilder result = new StringBuilder("G = (V, E)\n");

        // Line 2 is to be “V = {v1,v2,v3,...,vn}”, where vi , i = 1, ..., n are the vertices of G
        result.append("V = {");
        for(int i = 0; i < vertices.size() - 1; i++) {
            result.append(vertices.get(i) + ",");
        }
        if(vertices.size() > 0) result.append(vertices.get(vertices.size() - 1));
        result.append("}\n");

        // Line 3 is to be “E = {(u1,v1),(u2,v2),...,(uk,vk)}”, where (ui,vi), i = 1, ..., k are the edges of G
        result.append("E = {");

        for(int i = 0; i < edges.size() - 1; i++) {
            result.append("(" + edges.get(i).fromVertex() + "," + edges.get(i).toVertex() + "),");
        }
        Edge lastEdge = edges.get(edges.size() - 1);

        if(edges.size() > 0) result.append("(" + lastEdge.fromVertex() + "," + lastEdge.toVertex() + ")");
        result.append("}\n");

        return result.toString();
    }

    public boolean isConnected() {
        HashSet<Integer> connectedSubset = new HashSet<>();
        connectedSubset.add(vertices.get(0));
        ArrayDeque<Integer> newlyAddedVertices = new ArrayDeque<>();
        newlyAddedVertices.add(vertices.get(0));

        return false;
    }

}
