public class Student {
    private String name = null;

    public Student(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public class dohomework implements dojob{

        @Override
        public void fillBlank(int a, int b, int result) {
            System.out.println("student:a + b --->" + result);
        }
    }

    public void callhelp(int a, int b){
        new SuperCalculator().add(a, b, new dohomework());
    }
}
