public class LinkedList<E> {
    /**
     * 设置private是为了封装，不希望用户从外部可以改变，用户只要使用就好
     * 只供我们内部使用
     */
    private class Node<E> {
        // public是为了我们可以直接修改元素，不需要写getter, setter
        public E e;
        public Node next;

        public Node(E e, Node next) {
            // 把我们当前的的值赋值用户传进来的
            this.e = e;
            this.next = next;
        }
        public Node(E e) {
            this(e, null);
        }
        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public LinkedList() {
        // 初始链表时head为空，size为0
//        head = null;

        dummyHead = new Node(null, null); //实例化的时候传入两个 null，是因为初始链表是空链表。

        size = 0;
    }

    /**
     * 获取链表中元素个数
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 判断链表是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新的元素e
     * 在链表中不是一个常用操作，练习用
     * @param e
     */
    public void add(int index, E e) {
        // 注意index是可以取到size的，可以在链表末尾添加元素
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node node = new Node(e);
        node.next = prev.next;
        prev.next = node;
//            prev.next = new Node(e, prev.next); 上面三行可以用这一行写法代替
        size++;
        /**
         * 我的问题是，因为prev = dummyHead，当prev.next指向加入的node，
         * dummyHead.next也同时指向加入的node了？？
         *
         * 是的，您的理解是正确的。当 `prev = dummyHead` 时，
         * 对 `prev.next` 的任何修改也会反映在 `dummyHead.next` 上。
         * 这是因为 `prev` 和 `dummyHead` 实际上是引用同一个对象。
         *
         * 在 Java 中，对象变量（如 `prev` 和 `dummyHead`）实际上是对对象的引用，
         * 而不是对象本身。因此，当您将 `prev` 设置为 `dummyHead`，
         * `prev` 和 `dummyHead` 都指向同一个 `Node` 对象。
         * 所以，当您修改 `prev.next` 时，由于 `prev` 和 `dummyHead` 指向同一个对象，
         * `dummyHead.next` 也被相应地修改。
         *
         * 这个机制是如何使得在链表头部添加元素变得简单的关键所在。
         * 通过使用虚拟头节点（`dummyHead`）并始终让 `prev` 初始指向这个虚拟头节点，
         * 您可以使用统一的方式来处理在链表中的任何位置插入新节点，包括头部位置。
         * 对于头部插入（即 `addFirst` 方法），这个方法通过简单地更新 `dummyHead.next`
         * 来实现将新节点添加到链表的开头。
         */
    }

    /**
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 在链表末尾添加新的元素e
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }
}
