import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Integer five = 5;
        Integer[] others = {0,5,10,-50,50};

        for(Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTO= %d%n",five,
                    (val == 0 ? "==" :(val<0)?"<":">"),i,val);
        }

        String banana = "banana";
        String[] fruit = {"apple","banana","pear","BANANA"};

        for(String s: fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTO= %d%n",banana,
                    (val == 0 ? "==" :(val<0)?"<":">"),s,val);
        }
        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));

        System.out.println("A:" +(int)'A' + " " + "a:"+ (int)'a');
        System.out.println("B:" +(int)'B' + " " + "b:"+ (int)'b');
        System.out.println("V:" +(int)'V' + " " + "v:"+ (int)'v');

        Student MC = new Student("MC");
        Student[] rap = {new Student("Eminem"),new Student("Naz"),new Student("MC")};

        Arrays.sort(rap);
        System.out.println(Arrays.toString(rap));

        System.out.println("Result = " + MC.compareTo(new Student("mc")));

        Comparator<Student> gpaSorter = new StudentGPAComparartor();
        Arrays.sort(rap,gpaSorter.reversed());
        System.out.println(Arrays.toString(rap));
    }
}
class StudentGPAComparartor implements Comparator<Student>{
   @Override
    public int compare(Student o1, Student o2){
        return (o1.gpa + o1.name).compareTo(o2.gpa + o2.name);
    }
}
class Student implements Comparable <Student>{
     String name;
    private static int LAST_ID= 1000;
    private static Random random = new Random();
    private int id;
    protected double gpa;

    public Student(String name) {
        this.name = name;
        id = LAST_ID++;
        gpa = random.nextDouble(1.0,4.0);
    }

    @Override
    public String toString() {
        return "%d - %s (%.2f)".formatted(id,name,gpa);
    }

//    @Override
//    public int compareTo(Object o) {
//        Student other = (Student) o;
//        return name.compareTo(other.name);
//    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}