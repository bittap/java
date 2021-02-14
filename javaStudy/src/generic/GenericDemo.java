package generic;


class StudentInfo{
    public int grade;
    StudentInfo(int grade){ this.grade = grade; }
}
class EmployeeInfo{
    public int rank;
    EmployeeInfo(int rank){ this.rank = rank; }
}
class Person<T>{
    public T info;
    Person(T info){ this.info = info; }
}
public class GenericDemo {
    public static void main(String[] args) {
        Person<EmployeeInfo> p1 = new Person<EmployeeInfo>(new EmployeeInfo(1)); // int형
        EmployeeInfo ei1 = p1.info; // int
        System.out.println(ei1.rank); // 성공
          
        Person<String> p2 = new Person<String>("부장"); // String
        String ei2 = p2.info; // sTRING
        System.out.println(ei2); // 컴파일 실패
    }
}
