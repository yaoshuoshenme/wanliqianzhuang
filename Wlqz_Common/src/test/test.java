public interface test {

    public static void main(String[] args) {
        Student student = new Student("小明");
        Teacher teacher = new Teacher("老张");

        student.callhelp(2, 4);
        teacher.callhelp(234,456);
    }
}
