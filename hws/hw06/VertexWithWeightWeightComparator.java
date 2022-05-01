import java.util.*;

class VertexWithWeightWeightComparator implements Comparator<VertexWithWeight> {

    public int compare(VertexWithWeight o1, VertexWithWeight o2) {
        if(o1.getWeight().doubleValue() < o2.getWeight().doubleValue()) return -1;
        if(o1.getWeight().doubleValue() > o2.getWeight().doubleValue()) return 1;

        if(o1.getVertex().doubleValue() < o2.getVertex().intValue()) return -1;
        if(o1.getVertex().doubleValue() > o2.getVertex().intValue()) return 1;
        // if(o1.getVertex() == o2.getVertex()) return 0;

        // if(o1.getVertex() == o2.getVertex()) {
        //     if(o1.getWeight() < o2.getWeight()) return -1;
        //     if(o1.getWeight() > o2.getWeight()) return 1;
        //     if(o1.getWeight() == o2.getWeight()) return 0;
        // }

        return 0;
    }

}
