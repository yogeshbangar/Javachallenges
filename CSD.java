package PE2;


import java.util.*;
/* PLEASE DO NOT MODIFY A SINGLE STATEMENT IN THE TEXT BELOW.
READ THE FOLLOWING CAREFULLY AND FILL IN THE GAPS

I hereby declare that all the work that was required to 
solve the following problem including designing the algorithms
and writing the code below, is solely my own and that I received
no help in creating this solution and I have not discussed my solution 
with anybody. I affirm that I have read and understood
the Senate Policy on Academic honesty at 
https://secretariat-policies.info.yorku.ca/policies/academic-honesty-senate-policy-on/
and I am well aware of the seriousness of the matter and the penalties that I will face as a 
result of committing plagiarism in this assignment.

BY FILLING THE GAPS,YOU ARE SIGNING THE ABOVE STATEMENTS.

Full Name: 
Student Number: 
Course Section: 
*/


public class CSD {
    private ChairPerson chairPerson;
    ProgramDirector compScAdmin;
    ProgramDirector softEndAdmin;
    ProgramDirector digitTechAdmin;
    private List<Faculty> facultyList;
    private List<Student> studentList;
    private List<Student> gradStudentList;

    public CSD(Object chair) {
    }

    public void AdmitStudent(Student newStudent) throws Exception {
        if(studentList.contains(newStudent))
            return;

        if(facultyList.size()>=500)
            throw new Exception("NoSpaceException");

        this.studentList.add(newStudent);


    }

    public ChairPerson getChairPerson() {
        return new ChairPerson(chairPerson.firstName, chairPerson.lastName, chairPerson.age, chairPerson.gender, chairPerson.address);

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
class ProgramDirector extends Administrator{
    private List<Faculty> assignedFactLst;

}
class ChairPerson extends Administrator{

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




