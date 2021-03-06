class EdgeWithWeight implements EdgeWithWeightFunctions {
    private Integer fromVertex;
    private Integer toVertex;
    private Double weight;

    EdgeWithWeight(int fromVertex, int toVertex, double weight) {
        this.fromVertex = Integer.valueOf(fromVertex);
        this.toVertex = Integer.valueOf(toVertex);
        this.weight = Double.valueOf(weight);
    }

    public int getFromVertex() {
        return fromVertex.intValue();
    }

	public int getToVertex() {
        return toVertex.intValue();
    }

	public double getWeight() {
        return weight.doubleValue();
    }

/*  Return a string representation of the edge in the form “(x,y,w)” where x is the
    from vertex, y is the to vertex, and w is the weight
*/
	public String toString() {
        String result = "(";
        result += fromVertex + "," + toVertex + "," + weight;
        result += ")";
        return result;
    }
}
