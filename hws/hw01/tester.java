class tester {
    public static String toString(int[] arr) {
        if(arr.length == 0) return "[]";
        String str = "[";
        for(int i = 0; i < arr.length - 1; i++) {
            str += arr[i] + ", ";
        }
        str += arr[arr.length - 1] + "]";
        return str;
    }

    public static void main(String[] args) {
        liu_p1 Liu = new liu_p1();

        int[] arr0 = new int[]{0, 5, 4, 4, 3, 6};
        System.out.println(Liu.forLoopTest(0, 5, 7, arr0));

        /*
        int[] arr0 = new int[]{5,4,3,2,1};
        System.out.println(toString(arr0));

        int[] arr1 = Liu.selectionSort(arr0, 0, 1);
        System.out.println(toString(arr1));
        */
    }
}
