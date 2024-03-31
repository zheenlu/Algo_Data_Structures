public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.insert(2, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);
        // [-1, 0, 1, 100, 2, 3, 4, 5, 6, 7, 8, 9]

        arr.removeAt(3);
        System.out.println(arr);

        arr.removeElement(5);
        System.out.println(arr);

        arr.removeLast();
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

    }
}