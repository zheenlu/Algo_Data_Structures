public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student obj) {
        // 从小到大排列
        return this.score - obj.score;
        // return this.score - obj.score; 从大到小排列
    }

    @Override
    public boolean equals(Object obj) {
        // 如果当前的类的对象就是传进来的obj对象，直接true
        // 比较是否是同一个对象，比较地址是否一样
        if (this == obj) {
            return true;
        }
        // 如果传进来的是个空对象，直接false
        if (obj == null) {
            return false;
        }
        // 如果双方不属于同一个类，直接false
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        // 强制类型转换
        Student student = (Student) obj;
        return this.name.equals(student.name);
    }

    /**
     * 如果重写 equals，通常也需要重写 hashCode
     * */
    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    @Override
    public String toString() {
        // 规定如果打印的话，以这种格式
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
