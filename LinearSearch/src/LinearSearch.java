public class LinearSearch {
    private LinearSearch(){}
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        String[] data = {"python", "java", "c", "go"};
//        int res = LinearSearch.search(data, "java");
//        System.out.println(res); // return 1
//        int res2 = LinearSearch.search(data, "javascript");
//        System.out.println(res2);

//        Student[] students = {new Student("Alice"),
//                                new Student("Jake"),
//                                new Student("Erin")};
//        Student Erin = new Student("Erin");
//        int res3 = LinearSearch.search(students, Erin);
//        System.out.println(res3); // return -1

        int[] dataSize = {1000000, 10000000};
        for (int size : dataSize) {
            Integer[] data = ArrayGenerator.generateOrderedArray(size);
            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++) {
                LinearSearch.search(data, size);
            }
            long endTIme = System.nanoTime();
            double time = (endTIme - startTime) / 1000000000.0;
            System.out.println("size = " + size + ", 100 runs : " + time + " s");
        }

    }
}
