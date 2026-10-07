import java.util.*;

class Student {
    private int id;
    private String fname;
    private double cgpa;

    public Student(int id, String fname, double cgpa) {
        this.id = id;
        this.fname = fname;
        this.cgpa = cgpa;
    }

    public int getId() { return id; }
    public String getFname() { return fname; }
    public double getCgpa() { return cgpa; }
}

public class JavaSort {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine().trim());

        List<Student> studentList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int id = in.nextInt();
            String fname = in.next();
            double cgpa = Double.parseDouble(in.next());
            studentList.add(new Student(id, fname, cgpa));
        }
        in.close();

        studentList.sort(
                Comparator.comparingDouble(Student::getCgpa).reversed()
                        .thenComparing(Student::getFname)
                        .thenComparingInt(Student::getId)
        );

        for (Student st : studentList) {
            System.out.println(st.getFname());
        }
    }
}