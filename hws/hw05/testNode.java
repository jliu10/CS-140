class testNode {
    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(1);

        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setParent(n1);
        n3.setParent(n1);
        n2.setRight(n4);
        n4.setParent(n2);

        System.out.println("***** equals() TEST *****");
        System.out.println(n1.equals(n1) + " should be true");
        System.out.println(n1.equals(n5) + " should be true");
        System.out.println(n1.equals(n2) + " should be false");
        System.out.println(n1.equals(new String("n1")) + " should be false");
        System.out.println(n1.equals(null) + " should be false");

        System.out.println("***** toString() TEST *****");
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);
    }
}
