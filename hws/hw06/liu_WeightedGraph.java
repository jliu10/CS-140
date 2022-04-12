import java.util.*;

class liu_WeightedGraph implements WeightedGraphFunctions {
    private ArrayList<Integer> vertices;
    private ArrayList<EdgeWithWeight> edges;
    private boolean debugOutput = true;

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
        return ((Boolean) dijkstra(fromVertex, toVertex)[0]).booleanValue();
        // return false;
    }

/*  Returns the cost of a minimum cost path from the fromVertex to the toVertex.
    Returns Double.NaN if there is no path
*/
	public double getMinimumWeight(int fromVertex, int toVertex) {
        return ((Double) dijkstra(fromVertex, toVertex)[1]).doubleValue();
        // return Double.NaN;
    }

/*  Returns an array of edges whose fromVertex is equal to vertex
*/
    private EdgeWithWeight[] getAdjEdges(int vertex) {
        ArrayList<EdgeWithWeight> result = new ArrayList<>();

        for(EdgeWithWeight e : edges) {
            if(e.getFromVertex() == vertex) result.add(e);
        }

        return result.toArray(new EdgeWithWeight[result.size()]);
    }

/*  Returns the index of the VertexWithWeight whose vertex equals v
*/
    private int indexOfVertex(int v) {
        for(int i = 0; i < vertices.size(); i++) {
            if(vertices.get(i).intValue() == v) return i;
        }
        return -1;
    }

/*  Returns the edge with the specified vertices
*/
    private EdgeWithWeight getEdge(int fromVertex, int toVertex) {
        for(EdgeWithWeight e : edges) {
            if(e.getFromVertex() == fromVertex && e.getToVertex() == toVertex) return e;
        }
        return null;
    }

    public Object[] dijkstra(int fromVertex, int toVertex) {
        Object[] result = new Object[3];
        result[0] = false;
        result[1] = Double.NaN;
        result[2] = new EdgeWithWeight[0];
        int fromVertexIndex = indexOfVertex(fromVertex); // index of source vertex
        int indexOfDest = indexOfVertex(toVertex); // index of destination vertex
        if(fromVertexIndex == -1 || indexOfDest == -1) return result; // invalid input

        PriorityQueue<VertexWithWeight> q = new PriorityQueue<>(vertices.size(), new VertexWithWeightComparator());
        VertexWithWeight[] costs = new VertexWithWeight[vertices.size()];
        int[] parents = new int[vertices.size()]; // used to trace path back when destination is reached

        for(int i = 0; i < vertices.size(); i++) {
            costs[i] = new VertexWithWeight(vertices.get(i), Double.POSITIVE_INFINITY);
            parents[i] = -1;
        }

        if(debugOutput) {
            System.out.println("fromVertexIndex = " + fromVertexIndex);
        }

        costs[fromVertexIndex] = new VertexWithWeight(vertices.get(fromVertexIndex), 0); // set cost of start to 0
        parents[fromVertexIndex] = fromVertex; // set parent of start to itself
        for(VertexWithWeight t : costs) q.add(t);

        while(q.size() > 0) {
            VertexWithWeight v = q.poll();
            int indexOfV = indexOfVertex(v.getVertex());

            if(parents[indexOfV] == -1) break; // all remaining vertices in q are not reachable from source, so we can exit loop;
            if(v.getVertex() == toVertex) break; // if v is destination, we can exit loop

            for(EdgeWithWeight e : getAdjEdges(v.getVertex())) {
                int u = e.getToVertex();
                // VertexWithWeight u ?
                int indexOfU = indexOfVertex(u);
                if(q.contains( costs[indexOfU] )) { // if u is still in q
                    if( v.getWeight() + e.getWeight() < costs[indexOfU].getWeight() ) { // if weight from v to u < u's current weight
                        costs[indexOfU].setWeight(v.getWeight() + e.getWeight()); // update u's weight to lesser weight
                        // <UPDATE U'S WEIGHT IN Q>;
                        for(VertexWithWeight p : q) if(p.getVertex() == u) { // find u in q
                            q.remove(p); // update u's weight in q
                            q.add(new VertexWithWeight(u, v.getWeight() + e.getWeight()));
                            parents[indexOfU] = indexOfV; // update parent of u to be v
                            break;
                        }
                    }
                }
            }
        }

        // if parent array value for destination has not -1, then there exists a path from the source
        if(parents[indexOfDest] != -1) result[0] = true;
        else {
            return result;
        }

        // the weight of minimum cost past from source to dest. is the VertexWithWeight element in
        // costs at the index associated with the dest. vertex
        result[1] = costs[indexOfDest];

        // list of vertices in order of head -> tail : dest. -> source
        // the forward path is just path in order of tail -> head
        LinkedList<Integer> path = new LinkedList<>();
        path.add(indexOfDest);
        // backtrack path using parents[]
        while(path.getLast().intValue() != fromVertex) {
            // if(reversePath.getLast() == -1) break;
            path.add(parents[path.getLast()]);
        }

        EdgeWithWeight[] edgePath = new EdgeWithWeight[path.size() - 1];
        for(int i = 0; i < edgePath.length; i++) {
            Integer current = path.pollLast();
            edgePath[i] = getEdge(current.intValue(), path.peekLast().intValue());
        }
        result[2] = edgePath;

        return result;
    }

/*  Returns a minimum cost path from the fromVertex to the toVertex if there is one
    – that is, it returns an ordered list of edges from the fromVertex to the toVertex.
    Returns an EdgeWithWeight[] of length 0 if there is no path.
*/
    public EdgeWithWeight[] getPath(int fromVertex, int toVertex) {
        return ((EdgeWithWeight[]) dijkstra(fromVertex, toVertex)[2]);
        // return new EdgeWithWeight[0];
    }

    public EdgeWithWeight[] getPath1(int fromVertex, int toVertex) {
        PriorityQueue<VertexWithWeight> q = new PriorityQueue<>(vertices.size(), new VertexWithWeightComparator());
        VertexWithWeight[] costs = new VertexWithWeight[vertices.size()];
        int[] parents = new int[vertices.size()]; // used to trace path back when destination is reached

        for(int i = 0; i < vertices.size(); i++) {
            costs[i] = new VertexWithWeight(vertices.get(i), Double.POSITIVE_INFINITY);
            parents[i] = -1;
        }
        int fromVertexIndex = indexOfVertex(fromVertex);

        costs[fromVertexIndex] = new VertexWithWeight(vertices.get(fromVertexIndex), 0); // set cost of start to 0
        parents[fromVertexIndex] = fromVertex; // set parent of start to itself
        for(VertexWithWeight t : costs) q.add(t);

        while(q.size() > 0) {
            VertexWithWeight v = q.poll();
            int indexOfV = indexOfVertex(v.getVertex());

            if(parents[indexOfV] == -1) break; // all remaining vertices in q are not reachable from source, so we can exit loop;
            if(v.getVertex() == toVertex) break; // if v is destination, we can exit loop

            for(EdgeWithWeight e : getAdjEdges(v.getVertex())) {
                int u = e.getToVertex();
                // VertexWithWeight u ?
                int indexOfU = indexOfVertex(u);
                if(q.contains( costs[indexOfU] )) { // if u is still in q
                    if( v.getWeight() + e.getWeight() < costs[indexOfU].getWeight() ) { // if weight from v to u < u's current weight
                        costs[indexOfU].setWeight(v.getWeight() + e.getWeight()); // update u's weight to lesser weight
                        // <UPDATE U'S WEIGHT IN Q>;
                        for(VertexWithWeight p : q) if(p.getVertex() == u) { // find u in q
                            q.remove(p); // update u's weight in q
                            q.add(new VertexWithWeight(u, v.getWeight() + e.getWeight()));
                            parents[indexOfU] = indexOfV; // update parent of u to be v
                            break;
                        }
                    }
                }
            }
        }
        return new EdgeWithWeight[0];
    }

/*  Add a vertex to the weighted graph
    If the vertex already exists, do not add it
*/
	public boolean addVertex(int v) {
        if(vertices.contains(v)) return false;
        vertices.add(v);
        return true;
    }


/*  Add a weighted edge to the weighted graph
    If the weighted edge already exists, do not add it
    That is, there already exists a weighted edge with the from and to vertices
*/
	public boolean addWeightedEdge(int from, int to, double weight) {
        // if either vertex doesn't exist
        if( !vertices.contains(Integer.valueOf(from)) || !vertices.contains(Integer.valueOf(to)) ) return false;

        // if edge already exists
        for(EdgeWithWeight e : edges) {
            if(e.getFromVertex() == from && e.getToVertex() == to) return false;
        }

        EdgeWithWeight edge = new EdgeWithWeight(from, to, weight);
        edges.add(edge);

        return true;
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
        StringBuilder result = new StringBuilder("G = (V, E)\n");

        result.append("V = {");
        vertices.forEach( (v) -> {result.append(v + ",");} );
        // remove extra comma
        if(result.charAt(result.length() - 1) == ',') result.deleteCharAt(result.length() - 1);
        result.append("}\n");

        result.append("E = {");
        edges.forEach( (e) -> {
            result.append("(" + e.getFromVertex() + "," + e.getToVertex() + "," + e.getWeight() + "),");
        } );
        if(result.charAt(result.length() - 1) == ',') result.deleteCharAt(result.length() - 1);
        result.append("}\n");

        return result.toString();
    }
}
