
import java.util.*;

public class MyFirstJavaProgram {
  public static void main(String[] args) {
    ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
    Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
    f.setProgram("Software Engineering");
    UGrad s = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");

    CSD csd = new CSD(chair);
    try {
      csd.HireFaculty(f);
      csd.AdmitStudent(s);
    } catch (Exception e) {
      // fail();
    }

    // csd.setCh
    System.out.println(csd); // prints Hello World
  }
}

public class CSD {
  private ChairPerson chairPerson;
  ProgramDirector compScAdmin;
  ProgramDirector softEndAdmin;
  ProgramDirector digitTechAdmin;
  private List<Faculty> facultyList;
  private List<Student> studentList;
  private List<Student> gradStudentList;
  int lastStudentId = 100;
  int lastEmployeeId = 100;

  public int generateEmpId() {
    return lastEmployeeId++;
  }

  public CSD(ChairPerson chair) {
    chair.employeeId = generateEmpId();
    setChairPerson(chair);
  }

  private void setChairPerson(ChairPerson chair) {
    this.chairPerson = new ChairPerson(chair.firstName, chair.lastName, chair.age, chair.gender,
        chair.address);
  }

  public void AdmitStudent(Student newStudent) throws Exception {
    if (studentList.contains(newStudent))
      return;

    if (studentList.size() >= 500)
      throw new Exception("NoSpaceException");
    if (this.facultyList.size() == 0) {
      throw new Exception("NoFacultyException");
    }
    newStudent.setId(this.lastStudentId);
    this.lastStudentId++;
    this.studentList.add(newStudent);
  }

  public ChairPerson setChairPerson() {
    return new ChairPerson(chairPerson.firstName, chairPerson.lastName, chairPerson.age, chairPerson.gender,
        chairPerson.address);
  }

  public ChairPerson getChairPerson() {
    return new ChairPerson(chairPerson.firstName, chairPerson.lastName, chairPerson.age, chairPerson.gender,
        chairPerson.address);

  }

  public void HireFaculty(Faculty f) {
    f.employeeId = generateEmpId();
    this.facultyList.add(f);
  }

  public Map<Object, Object> getFaculty() {
    return null;
  }

  public int getNumOfFaculty() {
    return 0;
  }
}

class Person {
  String firstName;
  String lastName;
  int age;
  String gender;
  String address;

  public void setInfo(String firstName, String lastName, int age, String gender, String address) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
    this.gender = gender;
    this.address = address;

  }

}

class Academics extends Person {
  int employeeId;

}

class Administrator extends Academics {
  double salary;
}

class ProgramDirector extends Administrator {
  private List<Faculty> assignedFactLst;

}

class ChairPerson extends Administrator {

  public ChairPerson(String name, String lastName, int age, String gender, String address) {
    super();
    this.setInfo(lastName, lastName, age, gender, address);
  }

  public int getEmployeeID() {
    return this.employeeId;
  }

  public void setSalary(double salary) {
    this.salary = salary;

  }
}

class Faculty extends Academics implements Comparable<Academics> {
  private List<Student> assignedStudents;
  private List<Grad> assignedGrads;
  private String program;
  private double salary;

  public Faculty(String firstName, String lastName, int age, String gender, String address) {
    super();
    this.setInfo(firstName, lastName, age, gender, address);
  }

  @Override
  public int compareTo(Academics o) {
    return 0;
  }

  public int getEmployeeID() {
    return this.employeeId;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public Object getProgram(Object program) {
    return this.program;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

}

class Student extends Person implements Comparable<Student> {
  private int studentId;
  private Faculty assignedFact;

  public Student(String firstName, String lastName, int age, String gender, String address) {
    super();
    this.setInfo(firstName, lastName, age, gender, address);
  }

  public void setId(int id) {
    studentId = id;
  }

  @Override
  public int compareTo(Student o) {
    return 0;
  }
}

class UGrad extends Student {

  public UGrad(String firstName, String lastName, int age, String gender, String address) {
    super(address, address, age, address, address);
  }

  public int getAdvisor() {
    return 0;
  }
}

class Grad extends Student {
  public Grad(String firstName, String lastName, int age, String gender, String address) {
    super(address, address, age, address, address);
  }

}
