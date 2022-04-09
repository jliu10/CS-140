import java.util.*;

class liu_lab7 {
    public static void main(String[] args) {
        PriorityQueue<VertexWithWeight> p = new PriorityQueue<>(new VertexWithWeightComparator());

        VertexWithWeight[] vww = new VertexWithWeight[10];
        vww[0] = new VertexWithWeight(0, 0.0);
        vww[1] = new VertexWithWeight(1, 1.0);
        vww[2] = new VertexWithWeight(2, 2.0);
        vww[3] = new VertexWithWeight(3, 3.0);
        vww[4] = new VertexWithWeight(4, 4.0);
        vww[5] = new VertexWithWeight(5, 0.0);
        vww[6] = new VertexWithWeight(6, 1.0);
        vww[7] = new VertexWithWeight(7, 2.0);
        vww[8] = new VertexWithWeight(8, 3.0);
        vww[9] = new VertexWithWeight(9, 4.0);

        // for(int i = 0; i < vww.length; i++) p.add(vww[i]);
        for(VertexWithWeight v : vww) p.add(v);

        Iterator it = p.iterator();
        System.out.println("iterator initial");
        while(it.hasNext()) {
            System.out.println("\t" + it.next());
        }
        // System.out.println("**********");

        VertexWithWeight[] vww1 = p.toArray(new VertexWithWeight[0]);
        System.out.println("toArray initial");
        for(VertexWithWeight v : vww1) System.out.println("\t" + v);
        // System.out.println("**********");

        System.out.println("polling initial");
        while(p.size() > 0) System.out.println("\t" + p.poll());
        // System.out.println("**********");

        for(VertexWithWeight v : vww) p.add(v);
        vww[0].setWeight(10);

        it = p.iterator();
        System.out.println("iterator modified");
        while(it.hasNext()) {
            System.out.println("\t" + it.next());
        }
        // System.out.println("**********");

        vww1 = p.toArray(new VertexWithWeight[0]);
        System.out.println("toArray modified");
        for(VertexWithWeight v : vww1) System.out.println("\t" + v);
        // System.out.println("**********");

        System.out.println("polling modified");
        while(p.size() > 0) System.out.println("\t" + p.poll());
        // System.out.println("**********");

        System.out.println("polling after deletion, modification, addition");
        vww[0].setWeight(0);
        for(VertexWithWeight v : vww) p.add(v);
        p.remove(vww[0]);
        vww[0].setWeight(10);
        p.add(vww[0]);
        while(p.size() > 0) System.out.println("\t" + p.poll());

        // ystem.out.println(p.comparator());
    }
}
