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
        return ((Boolean) dijkstra(fromVertex, toVertex)[0]).booleanValue();
    }

/*  Returns the cost of a minimum cost path from the fromVertex to the toVertex.
    Returns Double.NaN if there is no path
*/
	public double getMinimumWeight(int fromVertex, int toVertex) {
        return ((Double) dijkstra(fromVertex, toVertex)[1]).doubleValue();
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

/*  Returns the edge with the specified vertex indexes
*/
    private EdgeWithWeight getEdge(int fromVertexIndex, int toVertexIndex) {
        for(EdgeWithWeight e : edges) {
            int from = vertices.get(fromVertexIndex);
            int to = vertices.get(toVertexIndex);
            // System.out.println("searching for edge ("+from+","+to+")");
            if(e.getFromVertex() == from && e.getToVertex() == to) return e;
        }
        if(debugOutput) {
            // System.out.println("problem in getEdge()");
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

        PriorityQueue<VertexWithWeight> q = new PriorityQueue<>(vertices.size(), new VertexWithWeightWeightComparator());
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

            for(EdgeWithWeight e : getAdjEdges(v.getVertex())) {
                int u = e.getToVertex();
                int indexOfU = indexOfVertex(u);
                if(q.contains( costs[indexOfU] )) { // if u is still in q
                    if( v.getWeight() + e.getWeight() < costs[indexOfU].getWeight() ) { // if weight from v to u < u's current weight
                        costs[indexOfU].setWeight(v.getWeight() + e.getWeight()); // update u's weight to lesser weight
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
        else return result;

        // the weight of minimum cost past from source to dest. is the VertexWithWeight element in
        // costs at the index associated with the dest. vertex
        result[1] = costs[indexOfDest].getWeight();

        // list of vertices in order of head -> tail : dest. -> source
        // the forward path is just path in order of tail -> head
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(indexOfDest);

        // backtrack path using parents[]
        while(path.getLast().intValue() != fromVertexIndex) {
            path.addLast(parents[path.getLast()]);
        }
        // System.out.println("LinkedList = " + toStringLL(path));

        EdgeWithWeight[] edgePath = new EdgeWithWeight[path.size() - 1];
        for(int i = 0; i < edgePath.length; i++) {
            Integer current = path.pollLast();
            edgePath[i] = getEdge(current.intValue(), path.peekLast().intValue());
        }
        result[2] = edgePath;

        return result;
    }

    public String toStringLL(LinkedList<Integer> list) {
        String result = "head-{";
        for(Integer n : list) {
            result += n + ",";
        }
        if(result.charAt(result.length() - 1) == ',') result = result.substring(0,result.length() - 1);
        return result + "}-tail";
    }

/*  Returns a minimum cost path from the fromVertex to the toVertex if there is one
    – that is, it returns an ordered list of edges from the fromVertex to the toVertex.
    Returns an EdgeWithWeight[] of length 0 if there is no path.
*/
    public EdgeWithWeight[] getPath(int fromVertex, int toVertex) {
        if(debugOutput) {
            System.out.println("TESTING getEdge():");
            EdgeWithWeight e1 = edges.get(0);
            EdgeWithWeight e2 = getEdge(e1.getFromVertex(), e1.getToVertex());
            System.out.println(e2 + " should be not null");
        }
        return ((EdgeWithWeight[]) dijkstra(fromVertex, toVertex)[2]);
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
