class VertexWithWeight {
    private final Integer vertex;
    private Double weight = Double.POSITIVE_INFINITY;

    VertexWithWeight(int v, double w) {
        vertex = Integer.valueOf(v);
        weight = Double.valueOf(w);
    }

    public String toString() {
        return "(" + vertex + "," + weight + ")";
    }

    public Integer getVertex() {
        return vertex;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(double w) {
        weight = w;
    }

    public boolean equals(Object o) {
        if(this == o) return true;
        if(getClass() == o.getClass()) {
            if(vertex.intValue() == ((VertexWithWeight) o).getVertex().intValue()) return true;
        }
        return false;
    }

    public int hashCode() {
        return vertex.intValue();
    }

}
