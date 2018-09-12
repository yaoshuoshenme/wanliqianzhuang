public class Teacher {
    private String name = null;

    public Teacher(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public class dohomework implements dojob{
        @Override
        public void fillBlank(int a, int b, int result) {
            System.out.println("teacher: a + b---->" +  result);
        }
    }

    public void callhelp(int a, int b){
        new SuperCalculator().add(a, b, new dohomework());
    }

}
