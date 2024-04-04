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

    private Node head;
    private int size;
    public LinkedList() {
        // 初始链表时head为空，size为0
        head = null;
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
     * 在链表头添加新的元素e
     * @param e
     */
    public void addFirst(E e) {
        Node node = new Node(e);
        node.next = head;
        head = node;

//        head = new Node(e, head); 上面的三行可以用这一行代替
        size++;
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
        // 如果在链表头添加
        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            Node node = new Node(e);
            node.next = prev.next;
            prev.next = node;
//            prev.next = new Node(e, prev.next); 上面三行可以用这一行写法代替
            size++;
        }
    }

    /**
     * 在链表末尾添加新的元素e
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }
}
