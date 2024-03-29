public class Array {
    private int[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public Array() {
        this(10);
    }

    /**
     * 获取数组中的元素个数
     * @return
     */
    public int getSize() {
        return this.size;
    }

    /**
     * 获取数组的容量
     * @return
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 检查数组是否为空
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 插入到指定index
     */
    public void insert(int index, int e) {
        if (size == data.length) {
            throw new IllegalArgumentException("Insert failed. Array full");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Insert failed. require index >= 0 || index <= size");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(int e) {
        insert(0, e);
    }

    public void addLast(int e) {
        insert(size, e);
    }

}
