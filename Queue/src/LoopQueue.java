public class LoopQueue<E> implements Queue<E> {
    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity) {
        // +1因为数组内有个位置会被浪费
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        // 因为数组内有个位置被浪费了，所以真正
        // 能承载的capacity要-1
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void enqueue(E e) {
        // 队列已满
        if ((tail + 1) % data.length == front) {
            // 用getCapacity而不是data.length
            // 是因为我们前面说过我们有意浪费一个位置
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null; // loitering object
        front = (front + 1) % data.length;
        size--;
        if ((size == getCapacity() / 4) && (getCapacity() / 2 != 0)) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) { // 可以对比下和toString里遍历的方式
            // newData[0] 对应 data[front]
            // newData[1] 对应 data[front + 1]
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append("front [");
        // loop到tail位置终止
        // 但因为数组是循环的，tail的位置可能比front还小，所以i != tail
        // 前一节课说过，如果tail == front说明数组为空
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            // 判断当前索引还不是最后一个元素
            if ((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
