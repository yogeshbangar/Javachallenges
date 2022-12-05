import java.util.*;
public class App {
    public static void main(String[] args) throws Exception {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");

    ProgramDirector compScAdmin = new ProgramDirector("Comp", "Admin", 59, "Male", "Birchmount Road",
        "Computer Science");
    ProgramDirector softEndAdmin = new ProgramDirector("softEnd", "Admin", 59, "Male", "Birchmount Road",
        "Software Engineering");
    ProgramDirector digitTechAdmin = new ProgramDirector("digitTechAdmin", "Admin", 59, "Male", "Birchmount Road",
        "Digital Technology");

    Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
    f.setProgram("Software Engineering");
    UGrad s = new UGrad("ZRyan", "Mark", 35, "Male", "Canlish Road");
    UGrad s2 = new UGrad("Yog", "Shon", 23, "Male", "nariman Road");

    CSD csd = new CSD(chair);
    try {
      csd.compScAdmin = compScAdmin;
      csd.softEndAdmin = softEndAdmin;
      csd.digitTechAdmin = digitTechAdmin;
      csd.HireFaculty(f);
      csd.AdmitStudent(s);
      csd.AdmitStudent(s2);
      // csd.upgradeToAlumnusUGrad(1000);
    } catch (Exception e) {
      // fail();
    }

    csd.showDetail();
    System.out.println(csd); // prints Hello World

    }
}

class CSD {
    private ChairPerson chairPerson;
    ProgramDirector compScAdmin;
    ProgramDirector softEndAdmin;
    ProgramDirector digitTechAdmin;
    private List<Faculty> facultyList = new ArrayList<Faculty>();
    private List<Student> studentList = new ArrayList<Student>();
    private List<Student> gradStudentList = new ArrayList<Student>();
    int lastStudentId = 1000;
    int lastEmployeeId = 100;
  
    public void showDetail() {
  
      String arr[] = { "practice.geeksforgeeks.org",
          "quiz.geeksforgeeks.org",
          "code.geeksforgeeks.org" };
  
      // Sorts arr[] in ascending order
      Arrays.sort(arr);
      System.out.println(arr[0]);
  
      System.out.println(chairPerson.getInfo());
      System.out.println(compScAdmin.getInfo());
      System.out.println(softEndAdmin.getInfo());
      System.out.println(digitTechAdmin.getInfo());
      System.out.println("Faculty~~~~~~~~~~~~");
      for (Faculty faculty : facultyList) {
        System.out.println(faculty.getInfo());
        for (Integer student : faculty.getStudentList()) {
          System.out.println("studentId = " + student);
        }
      }
  
      System.out.println("studentList~~~~~~~~~~~~");
      for (Student student : studentList) {
        System.out.println(student.getId() + " " + student.getInfo());
      }
      System.out.println("gradStudentList~~~~~~~~~~~~");
      for (Student gStudentList : gradStudentList) {
        System.out.println(gStudentList.isTAs + " " + gStudentList.getInfo());
      }
      extractAllUGradDetails();
    }
  
    public int generateEmpId() {
      return lastEmployeeId++;
    }
  
    public int generateStudentId() {
      return lastStudentId++;
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
      if (studentList.contains(newStudent) || studentList.size() > 500) {
        return;
      }
      for (Student student : studentList) {
        if (student.firstName.equals(newStudent.firstName) && student.lastName.equals(newStudent.lastName)) {
          System.out.println("Already Exist");
          return;
        }
      }
      if (studentList.size() >= 500)
        throw new Exception("NoSpaceException");
      if (this.facultyList.size() == 0) {
        throw new Exception("NoFacultyException");
      }
      Faculty assignedFact = this.facultyList.get(0);
      newStudent.setId(generateStudentId());
      newStudent.setFaculty(assignedFact.employeeId);
      assignedFact.setStudent(newStudent.getId());
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
      for (Faculty faculty : facultyList) {
        if (faculty.firstName.equals(f.firstName) && faculty.lastName.equals(f.lastName)) {
          System.out.println("Already Exist");
          return;
        }
      }
      int totalNoFact = compScAdmin.getFactLst().size() + softEndAdmin.getFactLst().size()
          + digitTechAdmin.getFactLst().size();
      if (totalNoFact > 70) {
        return;
      }
      if (compScAdmin.programId == f.programId) {
        if (compScAdmin.getFactLst().size() > 25) {
          return;
        }
        compScAdmin.setFactLst(f);
      }
      if (softEndAdmin.programId == f.programId) {
        if (softEndAdmin.getFactLst().size() > 25) {
          return;
        }
        softEndAdmin.setFactLst(f);
      }
      if (digitTechAdmin.programId == f.programId) {
        if (digitTechAdmin.getFactLst().size() > 25) {
          return;
        }
        digitTechAdmin.setFactLst(f);
      }
      f.employeeId = generateEmpId();
      this.facultyList.add(f);
    }
  
    public void retiredFaculty(int facultyId) {
      Faculty retiredFaculty = null;
      for (Faculty faculty : facultyList) {
        if (faculty.employeeId == facultyId) {
          retiredFaculty = faculty;
          break;
        }
      }
      if (retiredFaculty != null) {
        this.facultyList.remove(retiredFaculty);
      }
      for (Student student : studentList) {
        if (student.getFaculty() == facultyId) {
          student.isAdvising = true;
          break;
        }
      }
      for (Student student : gradStudentList) {
        if (student.getFaculty() == facultyId) {
          student.isTAs = true;
          break;
        }
      }
    }
  
    public void extractAllUGradDetails() {
      ArrayList<String> sortList = new ArrayList<String>();
      for (Student student : studentList) {
        sortList.add(student.getFullName());
      }
      Collections.sort(sortList);
      for (String list : sortList) {
        System.out.println(list);
      }
    }
  
    public void extractAllFacultyDetails() {
      ArrayList<String> sortList = new ArrayList<String>();
      for (Faculty faculty : facultyList) {
        sortList.add(faculty.getFullName());
      }
      Collections.sort(sortList);
      for (String list : sortList) {
        System.out.println(list);
      }
    }
  
    public void extractAllGradDetails() {
      ArrayList<String> sortList = new ArrayList<String>();
      for (Student gradStudent : gradStudentList) {
        sortList.add(gradStudent.getFullName());
      }
      Collections.sort(sortList);
      for (String list : sortList) {
        System.out.println(list);
      }
    }
  
    public void extractAdviseesDetails() {
      ArrayList<String> sortList = new ArrayList<String>();
      for (Student student : studentList) {
        if (student.isAdvising)
          sortList.add(student.getFullName());
      }
      Collections.sort(sortList);
      for (String list : sortList) {
        System.out.println(list);
      }
    }
  
    public void extractTAsDetails() {
      ArrayList<String> sortList = new ArrayList<String>();
      for (Student gradStudent : gradStudentList) {
        if (gradStudent.isTAs)
          sortList.add(gradStudent.getFullName());
      }
      Collections.sort(sortList);
      for (String list : sortList) {
        System.out.println(list);
      }
    }
  
    public Map<Object, Object> getFaculty() {
      return null;
    }
  
    public int getNumOfFaculty() {
      return 0;
    }
  
    public void removeStudentFromFacultyList(int _studentID) {
      for (Faculty faculty : facultyList) {
        List<Integer> studentListIds = faculty.getStudentList();
        for (Integer studentId : studentListIds) {
          if (studentId == _studentID) {
            studentListIds.remove(studentId);
          }
        }
      }
    }
  
    public void upgradeToAlumnusUGrad(int studentID) {
      Student grdStudent = null;
      for (Student student : studentList) {
        if (student.getId() == studentID) {
          grdStudent = student;
        }
      }
      if (grdStudent != null) {
        removeStudentFromFacultyList(studentID);
        studentList.remove(grdStudent);
        if (gradStudentList.size() >= 150) {
          return;
        }
  
        gradStudentList.add(grdStudent);
        int noOfTAs = 0;
        for (Student gStudent : gradStudentList) {
          if (gStudent.isTAs) {
            noOfTAs++;
          }
        }
        if (noOfTAs < 5)
          grdStudent.isTAs = true;
      }
  
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
  
    public String getInfo() {
      return "FirstName-> " + firstName + " lastName-> " + lastName + " age-> " + age + " gender-> " + gender
          + " address-> " + address;
    }
  
    public String getFullName() {
      return firstName + ", " + lastName;
    }
  }
  
  class Academics extends Person {
    int employeeId;
    String programId;
  }
  
  class Administrator extends Academics {
    double salary;
  }
  
  class ProgramDirector extends Administrator {
    private List<Faculty> assignedFactLst = new ArrayList<Faculty>();
  
    public ProgramDirector(String name, String lastName, int age, String gender, String address, String programId) {
      super();
      this.programId = programId;
      this.setInfo(name, lastName, age, gender, address);
    }
  
    public List<Faculty> getFactLst() {
      return assignedFactLst;
    }
  
    public void setFactLst(Faculty faculty) {
      assignedFactLst.add(faculty);
    }
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
    private List<Integer> assignedStudents = new ArrayList<Integer>();
    private List<Grad> assignedGrads = new ArrayList<Grad>();
    private String program;
    private double salary;
  
    public Faculty(String firstName, String lastName, int age, String gender, String address) {
      super();
      this.setInfo(firstName, lastName, age, gender, address);
    }
  
    public void setStudent(int Id) {
      this.assignedStudents.add(Id);
    }
  
    public List<Integer> getStudentList() {
      return assignedStudents;
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
    private int facultyID;
    public boolean isTAs = false;
    public boolean isAdvising = false;
  
    public Student(String firstName, String lastName, int age, String gender, String address) {
      super();
      this.setInfo(firstName, lastName, age, gender, address);
    }
  
    public void setId(int id) {
      studentId = id;
    }
  
    public int getId() {
      return studentId;
    }
  
    public void setFaculty(int assignedFactId) {
      this.facultyID = assignedFactId;
    }
  
    public int getFaculty() {
      return this.facultyID;
    }
  
    @Override
    public int compareTo(Student o) {
      return 0;
    }
  }
  
  class UGrad extends Student {
    public UGrad(String firstName, String lastName, int age, String gender, String address) {
      super(firstName, lastName, age, gender, address);
    }
  
    public boolean getAdvisor() {
      return isAdvising;
    }
  }
  
  class Grad extends Student {
    public Grad(String firstName, String lastName, int age, String gender, String address) {
      super(firstName, lastName, age, gender, address);
    }
  
  }
  