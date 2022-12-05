

import java.util.*;

public class MyFirstJavaProgram {
  CSD mCSD;
  MyFirstJavaProgram() {
    System.out.println("Hello World~~~~~~~~~`");
    ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
    CSD csd = new CSD(chair);

  }

  public static void main(String[] args) {
    ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
    CSD csd = new CSD(chair);
    csd.setCh
    System.out.println("Hello World"); // prints Hello World
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

  public CSD(Object chair) {
    System.out.println(chair); 
  }

  public void AdmitStudent(Student newStudent) throws Exception {
    if (studentList.contains(newStudent))
      return;

    if (facultyList.size() >= 500)
      throw new Exception("NoSpaceException");

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

  public ChairPerson(String rebert, String jack, int i, String male, String birchmount_road) {
    super();
  }

  public int getEmployeeID() {
    this.employeeId = 100;
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
  }

  @Override
  public int compareTo(Academics o) {
    return 0;
  }

  public int getEmployeeID() {
    this.employeeId = 100;
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
  private String studentId;
  private Faculty assignedFact;

  @Override
  public int compareTo(Student o) {
    return 0;
  }
}

class UGrad extends Student {

  public UGrad(String firstName, String lastName, int age, String gender, String address) {
    super();
  }

  public int getAdvisor() {
    return 0;
  }
}

class Grad extends Student {
  public Grad(String firstName, String lastName, int age, String gender, String address) {
    super();
  }

}
