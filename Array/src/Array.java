public class Array<E> {
    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     * @param capacity
     */
    public Array(int capacity) {
        data = (E[])new Object[capacity];
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
    public void insert(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Insert failed. require index >= 0 || index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    public void addFirst(E e) {
        insert(0, e);
    }

    public void addLast(E e) {
        insert(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal");
        }
        return data[index];
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        data[index] = e;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public E removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal");
        }
        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--; // 减小size变量的值以反映数组中有效元素数量的减少。这里的size减少1是因为移除了一个元素。
        // 最后，将数组中的size索引处的元素设置为null。
        // 这是因为数组的大小实际上并没有变小，只是通过减少size变量来标识有效元素数量的减少。
        // 因此，data[size]现在位于有效元素范围之外，但它之前存放的对象依然占用内存。
        // 将其设置为null有助于避免游离对象问题，使得Java的垃圾回收机制可以回收这个不再使用的对象。
        data[size] = null; // loitering object != memory leak, 让java垃圾回收机制回收

        // 缩容
        if (size == data.length / 2) {
            resize(data.length / 2);
        }
        return ret;
    }

    public E removeFirst() {
        return removeAt(0);
    }

    public E removeLast() {
        return removeAt(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            removeAt(index);
        }
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");
        return res.toString();
    }
}
