import java.util.*;

class liu_Graph implements ConnectedGraphFunctions {
    private final ArrayList<Integer> vertices = new ArrayList<>(); // contains the vertices
    private final ArrayList<Edge> edges = new ArrayList<>(); // contains the list of edges
    private final boolean isDirected; // tells us if the graph is or is not directe

// DONE
    liu_Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

// DONE
    liu_Graph() {
        this(false);
    }

// DONE
    public int getNumberOfVertices() {
        return vertices.size();
    }

// DONE
	public int getNumberOfEdges() {
        return edges.size();
    }

// DONE
	public boolean isDirected() {
        return isDirected;
    }

// DONE
	public void addVertex(int v) throws GraphException {
        if(vertices.contains(v)) {
            throw new GraphException("attempting to add duplicate vertex \"" + v + "\"");
        }
        vertices.add(v);
    }

// TEST
	public void addEdge(int from, int to) throws GraphException {
        if(!vertices.contains(from) || !vertices.contains(to)) {
            throw new GraphException("attempting to add edge with undefined vertex \"(" + from + "," + to + ")\"");
        }
        if(edges.contains(new Edge(from, to))) {
            throw new GraphException("attempting to add duplicate edge \"(" + from + "," + to + ")\"");
        }
        /*
        if(!isDirected) {
            if(edges.contains(new Edge(to, from))) {
                throw new GraphException("attempting to add duplicate edge \"(" + from + "," + to + ")\"");
            }
        }
        */
        if(!isDirected && edges.contains(new Edge(to, from))) {
            throw new GraphException("attempting to add duplicate edge \"(" + from + "," + to + ")\"");
        }
        edges.add(new Edge(from, to));
    }

// DONE
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

    private boolean isConnected(ArrayList<Edge> j) {
            HashSet<Integer> connectedSubset = new HashSet<>();
            connectedSubset.add(vertices.get(0));
            ArrayDeque<Integer> newlyAddedVertices = new ArrayDeque<>();
            newlyAddedVertices.add(vertices.get(0));

            while(newlyAddedVertices.size() > 0) {
                Integer currentVertex = newlyAddedVertices.pop();
                for(Edge e : j) {
                    // undirected
                    if(!isDirected) {
                        if(e.fromVertex().equals( currentVertex )) {
                            if(!connectedSubset.contains( e.toVertex() )) {
                                connectedSubset.add( e.toVertex() );
                                newlyAddedVertices.push( e.toVertex() );
                            }
                        }
                        else if(e.toVertex().equals(currentVertex)) {
                            if(!connectedSubset.contains( e.fromVertex() )) {
                                connectedSubset.add( e.fromVertex() );
                                newlyAddedVertices.push( e.fromVertex() );
                            }
                        }
                    }
                    // directed
                    else {
                        if(e.fromVertex().equals( currentVertex )) {
                            if(!connectedSubset.contains( e.toVertex() )) {
                                connectedSubset.add( e.toVertex() );
                                newlyAddedVertices.push( e.toVertex() );
                            }
                        }
                    }
                }
            }

        return vertices.size() == connectedSubset.size();
    }

    public boolean isConnected() {
        if(isDirected) {
            ArrayList<Edge> reversedEdges = new ArrayList<>(edges.size());
            for(Edge ej : edges) {
                reversedEdges.add( new Edge(ej.toVertex(), ej.fromVertex()) );
            }
            
            return isConnected(edges) && isConnected(reversedEdges);
        }
        else {
            return isConnected(edges);
        }
    }

}
