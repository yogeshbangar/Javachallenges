import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        // test.CheckChairEmployeeID100();
        // test.ShouldCompareDeptChairPerson();
        // test.CheckChairID102AndFacultyID103();
        // test.CheckProgramNameCorrect();
        // test.CheckToStringChair();
        // test.CheckToStringFaculty();
        // test.CheckToStringUgrad();
        // test.CheckToStringGrad();
        // test.HireFaculty();
        // test.HireFacultyDuplicate();
        // test.HireMultipleFaculty();
        // test.AdmitStudent();
        // test.AdmitStudentDuplicate();
        // test.AdmitStudentMultiple();
        // test.HireTA();
        // test.HireTADuplicate();
        // test.HireTAMultiple();
        // test.GraduateUndergrad();
        // test.GraduateTA();
        // test.ExtractAllGradDetails();
        // test.ExtractAllUGradDetails();
        // test.ExtractAllFacultyDetails();
        // test.ExtractFacultyDetails();
        // test.ExtractAdviseesDetails();
        // test.ExtractTAsDetails();
        // test.RetireFacultyReassignTAs();
        // test.RetireFacultyReassignUndergrads();
        // test.RetireFacultyNoOtherFacultyInProgramException();
        test.RetireFacultyNoOtherTAException();
    }
}

class Test {
    void fail() {
        System.out.println("~~~~~~~~~~~~~~fail~~~~~~~~~~~~~~");
    }

    CSD getCSD() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");

        ProgramDirector compScAdmin = new ProgramDirector("Comp", "Admin", 59, "Male", "Birchmount Road");
        ProgramDirector softEndAdmin = new ProgramDirector("softEnd", "Admin", 59, "Male", "Birchmount Road");
        ProgramDirector digitTechAdmin = new ProgramDirector("digitTechAdmin", "Admin", 59, "Male", "Birchmount Road");
        return new CSD(chair);
    }

    void basicTest() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("ZRyan", "Mark", 35, "Male", "Canlish Road");
        UGrad s2 = new UGrad("Yog", "Shon", 23, "Male", "nariman Road");

        try {
            csd.HireFaculty(f);
            csd.AdmitStudent(s);
            csd.AdmitStudent(s2);
            // csd.upgradeToAlumnusUGrad(1000);
        } catch (Exception e) {
            fail();
        }

        System.out.println(csd); // prints Hello World
    }

    void CheckChairEmployeeID100() {
        CSD csd = getCSD();
        System.out.println(
                csd.getChairPerson().getEmployeeID() == 100 ? "ChairPerson getID Pass" : "ChairPerson getID Fail");
    }

    void ShouldCompareDeptChairPerson() {
        CSD csd = getCSD();
        System.out.println(
                csd.getChairPerson().getEmployeeID() == 100 ? "ChairPerson getID Pass" : "ChairPerson getID Fail");
        // assertEquals(chair, csd.getChairPerson(), "CS Dept getChairPerson Fail");
    }

    void CheckChairID102AndFacultyID103() throws NoSpaceException {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female",
                "Lawrence Avenue East");
        f.setProgram("Computer Science");
        csd.HireFaculty(f);
        System.out.println(csd.getChairPerson().getEmployeeID() == 100 ? "ChairPerson getID Pass"
                : "ChairPerson getID Fail");
        System.out.println(f.getEmployeeID() == csd.getFaculty().get(0).employeeId ? "Faculty getID Pass"
                : "ChairPerson getID Fail");
        // assertEquals(102, chair.getEmployeeID(), "ChairPerson getID Fail");
        // assertEquals(103, f.getEmployeeID(), "Faculty getID Fail");

    }

    void CheckProgramNameCorrect() {
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female",
                "Lawrence Avenue East");
        f.setProgram("Computer Science");

        System.out.println(f.getProgram() == "Computer Science" ? "CS Dept getProgram Pass"
                : "CS Dept getProgram Fail");
        System.out.println(f.getProgram().contains("Computer") ? "CS Dept getProgram Pass"
                : "CS Dept getProgram Fail");
        // assertEquals("Computer Science", f.getProgram(), "CS Dept getProgram Fail");
        // assertFalse(f.getProgram().equals("Computer"), "CS Dept getProgram Fail");
    }

    void CheckToStringChair() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        chair.setSalary(12345.6);
        System.out.println(chair.getFullName().equals("Rebert, Jack"));
        System.out.println(chair.salary == 12345.6);
        // assertEquals("Chair Person [[[106, 12345.6[Rebert, Jack, 59, Male, Birchmount
        // Road]]]]", chair.toString());
    }

    void CheckToStringFaculty() {
        Faculty f = new Faculty("Rebert", "Jack", 59, "Male", "Birchmount Road");
        f.setProgram("Computer Science");
        f.setSalary(123.4);
        System.out.println(f.getFullName().equals("Rebert, Jack"));
        System.out.println(f.getSalary() == 123.4);
        // assertEquals("Faculty Computer Science[[107, 123.4[Rebert, Jack, 59, Male,
        // Birchmount Road]]]", f.toString());
    }

    // @Order(7)
    void CheckToStringUgrad() {
        UGrad s = new UGrad("Rebert", "Jack", 59, "Male", "Birchmount Road");
        System.out.println(s.getFullName().equals("Rebert, Jack"));
        System.out.println(s.address.equals("Birchmount Road"));
        // assertEquals("Undergraduate [1000[[Rebert, Jack, 59, Male, Birchmount
        // Road]]]", s.toString());
    }

    // @Order(8)
    void CheckToStringGrad() {
        Grad s = new Grad("Rebert", "Jack", 59, "Male", "Birchmount Road");
        System.out.println(s.age == 59);
        System.out.println(s.gender.equals("Male"));
    }

    // @Order(9)
    void HireFaculty() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f);
        } catch (Exception e) {
        }
        System.out.println(csd.getFaculty().get(0).getInfo());
        // assertEquals(f, csd.getFaculty().get(0), "Hire Faculty Failed");
        // assertEquals(1, csd.getNumOfFaculty(), "Hire Faculty Failed");
    }

    // @Order(10)
    void HireFacultyDuplicate() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f);
            csd.HireFaculty(f);
            csd.AdmitStudent(s);
        } catch (Exception e) {
        }
        System.out.println(csd.getFaculty().get(0).getFullName().equals("Elizabeth, Smith"));
        System.out.println(csd.getFaculty().size() == 1);
        // assertEquals(f, csd.getFaculty().get(0), "Hire Faculty Failed");
        // assertEquals(1, csd.getNumOfFaculty(), "Hire Faculty Failed");
    }

    // @Order(11)
    void HireMultipleFaculty() {
        CSD csd = getCSD();
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Adam", "Tom", 55, "Male", "Danforth Road");
        f2.setProgram("Computer Science");
        Grad s = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f1);
        } catch (Exception e) {
        }
        System.out.println(csd.getFaculty().get(0).getFullName().equals("Elizabeth, Smith"));
        System.out.println(csd.getFaculty().get(1).getFullName().equals("Adam, Tom"));
        System.out.println(csd.getFaculty().size() == 2);
        // assertEquals(f1, csd.getFaculty().get(0), "Hire Faculty Failed");
        // assertEquals(f2, csd.getFaculty().get(1), "Hire Faculty Failed");
        // assertEquals(2, csd.getNumOfFaculty(), "Hire Faculty Failed");
    }

    // @Order(12)
    void AdmitStudent() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        s.isAdvising = true;
        try {
            csd.HireFaculty(f);
            csd.AdmitStudent(s);
        } catch (Exception e) {
            fail();
        }
        System.out.println(csd.getStudents().get(0).isAdvising);
        System.out.println(csd.getStudents().size() == 1);
        // assertEquals(true, f.getAdvisingUgrads().contains(s), "Admit Undergrad
        // Failed");
        // assertEquals(s, f.getAdvisingUgrads().get(0), "Admit Undergrad Failed");
        // assertEquals(s.getAdvisor(), f, "Assign Advisor Undergrad Failed");
        // assertEquals(1, csd.getNumOfUGradStudents(), "Increment UGrad count in Dept
        // Failed");

    }

    // @Test @Order(13)
    void AdmitStudentDuplicate() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f);
            csd.AdmitStudent(s);
            csd.AdmitStudent(s);
        } catch (Exception e) {
            fail();
        }
        System.out.println(csd.getStudents().get(0).isAdvising);
        System.out.println(csd.getStudents().size() == 1);
        // assertEquals(true, f.getAdvisingUgrads().contains(s), "Admit Undergrad
        // Failed");
        // assertEquals(s, f.getAdvisingUgrads().get(0), "Admit Undergrad Failed");
        // assertEquals(s.getAdvisor(), f, "Assign Advisor Undergrad Failed");
        // assertEquals(1, csd.getNumOfUGradStudents(), "Increment UGrad count in Dept
        // Failed");
    }

    // @Test @Order(14)
    void AdmitStudentMultiple() {
        CSD csd = getCSD();
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        UGrad s1 = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        UGrad s2 = new UGrad("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
        UGrad s3 = new UGrad("Adam", "Tom", 55, "Male", "Danforth Road");
        UGrad s4 = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        UGrad s5 = new UGrad("George", "Hardy", 45, "Male", "Rockwood Drive");
        UGrad s6 = new UGrad("Radi", "Aman", 32, "Male", "Tawoon Road");
        UGrad s7 = new UGrad("John", "Mark", 27, "Male", "Pizza Road");
        UGrad s8 = new UGrad("Perseus", "Jackson", 21, "Male", "Candy Road");
        UGrad s9 = new UGrad("Sarah", "Walker", 15, "Female", "Qudra Road");
        UGrad s10 = new UGrad("Radi", "Mark", 35, "Male", "Some Road");

        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.AdmitStudent(s1);
            csd.AdmitStudent(s2);
            csd.AdmitStudent(s3);
            csd.AdmitStudent(s4);
            csd.AdmitStudent(s5);
            csd.AdmitStudent(s6);
            csd.AdmitStudent(s7);
            csd.AdmitStudent(s3);
            csd.AdmitStudent(s8);
            csd.AdmitStudent(s9);
            csd.AdmitStudent(s10);

        } catch (NoSpaceException e) {
            System.out.println("~~~~~~~~~~fail~~~~~~~~~~");
            fail();
        }

        System.out.println(f1.getAdvisingUgrads().contains(s1));
        System.out.println(f1.getAdvisingUgrads().contains(s2));
        System.out.println(f1.getAdvisingUgrads().contains(s3));
        System.out.println(f1.getAdvisingUgrads().contains(s4));
        System.out.println(f1.getAdvisingUgrads().contains(s5));
        System.out.println(f1.getAdvisingUgrads().contains(s6));
        System.out.println(f1.getAdvisingUgrads().contains(s7));
        System.out.println(f1.getAdvisingUgrads().contains(s8));

        System.out.println(f1.getAdvisingUgrads().contains(s9));

        System.out.println(f2.getAdvisingUgrads().contains(s9));
        System.out.println(f2.getAdvisingUgrads().contains(s10));

        // assertTrue(f1.getAdvisingUgrads().contains(s1), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f1.getAdvisingUgrads().contains(s2), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f1.getAdvisingUgrads().contains(s3), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f1.getAdvisingUgrads().contains(s4), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f1.getAdvisingUgrads().contains(s5), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f1.getAdvisingUgrads().contains(s6), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f1.getAdvisingUgrads().contains(s7), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f1.getAdvisingUgrads().contains(s8), "Assign Undergrad to Advisor
        // Failed");
        // assertFalse(f1.getAdvisingUgrads().contains(s9), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f2.getAdvisingUgrads().contains(s9), "Assign Undergrad to Advisor
        // Failed");
        // assertTrue(f2.getAdvisingUgrads().contains(s10), "Assign Undergrad to Advisor
        // Failed");
        // assertEquals(s3.getAdvisor(), f1, "Assign Advisor to Undergrad Failed");
        // assertEquals(10, csd.getNumOfUGradStudents(), "Increment UGrad count in Dept
        // Failed");
        // assertEquals(2, csd.getNumOfFaculty(), "Increment Faculty count in Dept
        // Failed");

    }

    // @Test @Order(15)
    void HireTA() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        Grad s = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f);
            csd.HireTA(s);
        } catch (Exception e) {
            fail();
        }
        System.out.println(f.getTAs().contains(s));
        System.out.println(f.getTAs().get(0) == s);
        System.out.println(s.getAdvisor() == f);
        System.out.println(csd.getNumOfGradStudents() == 1);

        // assertEquals(true, f.getTAs().contains(s), "Admit Undergrad Failed");
        // assertEquals(s, f.getTAs().get(0), "Admit Undergrad Failed");
        // assertEquals(s.getAdvisor(), f, "Assign Advisor Undergrad Failed");
        // assertEquals(1, csd.getNumOfGradStudents(), "Increment UGrad count in Dept
        // Failed");

    }

    // @Test @Order(16)
    void HireTADuplicate() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        Grad s = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f);
            csd.HireTA(s);
            csd.HireTA(s);
        } catch (Exception e) {
            fail();
        }
        System.out.println(f.getTAs().contains(s));
        System.out.println(s == f.getTAs().get(0));
        System.out.println(s.getAdvisor() == f);
        System.out.println(csd.getNumOfGradStudents() == 1);
        // assertEquals(true, f.getTAs().contains(s), "Admit Undergrad Failed");
        // assertEquals(s, f.getTAs().get(0), "Admit Undergrad Failed");
        // assertEquals(s.getAdvisor(), f, "Assign Advisor Undergrad Failed");
        // assertEquals(1, csd.getNumOfGradStudents(), "Increment UGrad count in Dept
        // Failed");
    }

    // @Test @Order(17)
    void HireTAMultiple() {
        CSD csd = getCSD();
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        Grad s1 = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        Grad s2 = new Grad("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
        Grad s3 = new Grad("Adam", "Tom", 55, "Male", "Danforth Road");
        Grad s4 = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        Grad s5 = new Grad("George", "Hardy", 45, "Male", "Rockwood Drive");
        Grad s6 = new Grad("Radi", "Aman", 32, "Male", "Tawoon Road");
        Grad s7 = new Grad("John", "Mark", 27, "Male", "Pizza Road");
        Grad s8 = new Grad("Perseus", "Jackson", 21, "Male", "Candy Road");
        Grad s9 = new Grad("Sarah", "Walker", 15, "Female", "Qudra Road");
        Grad s10 = new Grad("Radi", "Mark", 35, "Male", "Some Road");

        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireTA(s1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.HireTA(s4);
            csd.HireTA(s5);
            csd.HireTA(s6);
            csd.HireTA(s7);
            csd.HireTA(s3);
            csd.HireTA(s8);
            csd.HireTA(s9);
            csd.HireTA(s10);

        } catch (Exception e) {
            fail();
        }
        System.out.println(f1.getTAs().contains(s1));
        System.out.println(f1.getTAs().contains(s2));
        System.out.println(f1.getTAs().contains(s3));
        System.out.println(f1.getTAs().contains(s4));
        System.out.println(f1.getTAs().contains(s5));
        System.out.println(f2.getTAs().contains(s6));
        System.out.println(f2.getTAs().contains(s7));
        System.out.println(f2.getTAs().contains(s8));
        System.out.println(f1.getTAs().contains(s9) == false);
        System.out.println(f2.getTAs().contains(s9));
        System.out.println(f2.getTAs().contains(s10));
        System.out.println(s3.getAdvisor() == f1);
        System.out.println(s10.getAdvisor() == f2);
        System.out.println(10 == csd.getNumOfGradStudents());
        System.out.println(2 == csd.getNumOfFaculty());

    }

    // @Test @Order(18)
    void GraduateUndergrad() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f);
            csd.AdmitStudent(s);
            csd.AlumnusUGrad(s);
            // csd.upgradeToAlumnusUGrad(s.getId());
            ;
        } catch (Exception e) {
            fail();
        }
        System.out.println(f.getAdvisingUgrads().contains(s) == false);
        System.out.println(s.getAdvisor() == f);
        System.out.println(0 == csd.getNumOfUGradStudents());
        System.out.println(0 == f.getNumOfAdvisingUGrads());
    }

    // @Test @Order(19)
    void GraduateTA() {
        CSD csd = getCSD();
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        Grad s1 = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        Grad s2 = new Grad("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
        Grad s3 = new Grad("Adam", "Tom", 55, "Male", "Danforth Road");
        Grad s4 = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireTA(s1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.AlumnusGrad(s1);
            csd.HireTA(s4);
        } catch (NoTAException e) {
            fail();
        } catch (NoSpaceException e) {
            fail();
        }

        System.out.println(false == f1.getTAs().contains(s1));
        System.out.println(s1.getAdvisor() == f1);
        System.out.println(3 == csd.getNumOfGradStudents());
        System.out.println(3 == f1.getNumOfTAs());

        Grad s5 = new Grad("George", "Hardy", 45, "Male", "Rockwood Drive");
        Grad s6 = new Grad("Radi", "Aman", 32, "Male", "Tawoon Road");
        Grad s7 = new Grad("John", "Mark", 27, "Male", "Pizza Road");
        boolean caught = false;
        try {
            csd.HireTA(s5);
            csd.HireTA(s6);
            csd.HireTA(s7);
            csd.AlumnusGrad(s7);
        } catch (NoTAException e) {
            caught = true;
        } catch (NoSpaceException e) {
            // fail();
        }

        System.out.println(caught);
        System.out.println(f1.getTAs().contains(s1) == false);
        System.out.println(s1.getAdvisor() == f1);
        System.out.println(5 == csd.getNumOfGradStudents());
        System.out.println(5 == f1.getNumOfTAs());
    }

    // @Test @Order(20)
    void ExtractAllGradDetails() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        CSD csd = getCSD();
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        Grad s0 = new Grad("Zara", "Mark", 30, "Male", "Canlish Road");
        Grad s1 = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        Grad s2 = new Grad("Jeremy", "Dave", 45, "Male", "Guildwood Parkway");
        Grad s3 = new Grad("Adam", "Tom", 55, "Male", "Danforth Road");
        Grad s4 = new Grad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireTA(s0);
            csd.HireTA(s1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.AlumnusGrad(s1);
            csd.HireTA(s1);
        } catch (NoTAException e) {
            fail();
        } catch (NoSpaceException e) {
            fail();
        }
        List<Grad> lst = new ArrayList<Grad>();
        lst.add(s3);
        lst.add(s2);
        lst.add(s1);
        lst.add(s0);
        System.out.println(lst.equals(csd.ExtractAllGradDetails()));
    }

    // @Test @Order(21)
    void ExtractAllUGradDetails() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        UGrad s1 = new UGrad("z", "Mark", 35, "Male", "Canlish Road");
        UGrad s2 = new UGrad("x", "Dave", 45, "Male", "Guildwood Parkway");
        UGrad s3 = new UGrad("y", "Tom", 55, "Male", "Danforth Road");
        UGrad s4 = new UGrad("a", "Mark", 35, "Male", "Canlish Road");
        UGrad s5 = new UGrad("b", "Hardy", 45, "Male", "Rockwood Drive");
        UGrad s6 = new UGrad("w", "Aman", 32, "Male", "Tawoon Road");
        UGrad s7 = new UGrad("c", "Mark", 27, "Male", "Pizza Road");
        UGrad s8 = new UGrad("j", "Jackson", 21, "Male", "Candy Road");
        UGrad s9 = new UGrad("l", "Walker", 15, "Female", "Qudra Road");
        UGrad s10 = new UGrad("t", "Mark", 35, "Male", "Some Road");

        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.AdmitStudent(s1);
            csd.AdmitStudent(s2);
            csd.AdmitStudent(s3);
            csd.AdmitStudent(s4);
            csd.AdmitStudent(s5);
            csd.AdmitStudent(s6);
            csd.AdmitStudent(s7);
            csd.AdmitStudent(s3);
            csd.AdmitStudent(s8);
            csd.AdmitStudent(s9);
            csd.AdmitStudent(s10);

        } catch (NoSpaceException e) {
            fail();
        }

        List<UGrad> lst = new ArrayList<UGrad>();
        lst.add(s4);
        lst.add(s5);
        lst.add(s7);
        lst.add(s8);
        lst.add(s9);
        lst.add(s10);
        lst.add(s6);
        lst.add(s2);
        lst.add(s3);
        lst.add(s1);
        System.out.println(lst.equals(csd.ExtractAllUGradDetails()));
    }

    // @Test @Order(22)
    void ExtractAllFacultyDetails() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        Faculty f1 = new Faculty("z", "Mark", 35, "Male", "Canlish Road");
        Faculty f2 = new Faculty("x", "Dave", 45, "Male", "Guildwood Parkway");
        Faculty f3 = new Faculty("y", "Tom", 55, "Male", "Danforth Road");
        Faculty f4 = new Faculty("a", "Mark", 35, "Male", "Canlish Road");
        Faculty f5 = new Faculty("b", "Hardy", 45, "Male", "Rockwood Drive");
        Faculty f6 = new Faculty("w", "Aman", 32, "Male", "Tawoon Road");
        Faculty f7 = new Faculty("c", "Mark", 27, "Male", "Pizza Road");
        Faculty f8 = new Faculty("j", "Jackson", 21, "Male", "Candy Road");
        Faculty f9 = new Faculty("l", "Walker", 15, "Female", "Qudra Road");
        Faculty f10 = new Faculty("t", "Mark", 35, "Male", "Some Road");

        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f3);
            csd.HireFaculty(f4);
            csd.HireFaculty(f5);
            csd.HireFaculty(f6);
            csd.HireFaculty(f7);
            csd.HireFaculty(f3);
            csd.HireFaculty(f8);
            csd.HireFaculty(f9);
            csd.HireFaculty(f10);

        } catch (NoSpaceException e) {
            fail();
        }

        List<Faculty> lst = new ArrayList<Faculty>();
        lst.add(f4);
        lst.add(f5);
        lst.add(f7);
        lst.add(f8);
        lst.add(f9);
        lst.add(f10);
        lst.add(f6);
        lst.add(f2);
        lst.add(f3);
        lst.add(f1);
        System.out.println(lst.equals(csd.ExtractAllFacultyDetails()));
    }

    // @Test @Order(23)
    void ExtractFacultyDetails() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        Faculty f1 = new Faculty("z", "Mark", 35, "Male", "Canlish Road");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("x", "Dave", 45, "Male", "Guildwood Parkway");
        f2.setProgram("Computer Science");
        Faculty f3 = new Faculty("y", "Tom", 55, "Male", "Danforth Road");
        f3.setProgram("Digital Technology");
        Faculty f4 = new Faculty("a", "Mark", 35, "Male", "Canlish Road");
        f4.setProgram("Software Engineering");
        Faculty f5 = new Faculty("b", "Hardy", 45, "Male", "Rockwood Drive");
        f5.setProgram("Computer Science");
        Faculty f6 = new Faculty("w", "Aman", 32, "Male", "Tawoon Road");
        f6.setProgram("Digital Technology");
        Faculty f7 = new Faculty("c", "Mark", 27, "Male", "Pizza Road");
        f7.setProgram("Software Engineering");
        Faculty f8 = new Faculty("j", "Jackson", 21, "Male", "Candy Road");
        f8.setProgram("Computer Science");
        Faculty f9 = new Faculty("l", "Walker", 15, "Female", "Qudra Road");
        f9.setProgram("Digital Technology");
        Faculty f10 = new Faculty("t", "Mark", 35, "Male", "Some Road");
        f10.setProgram("Software Engineering");
        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f3);
            csd.HireFaculty(f4);
            csd.HireFaculty(f5);
            csd.HireFaculty(f6);
            csd.HireFaculty(f7);
            csd.HireFaculty(f3);
            csd.HireFaculty(f8);
            csd.HireFaculty(f9);
            csd.HireFaculty(f10);
        } catch (NoSpaceException e) {
            fail();
        }
        List<Faculty> lstCS = new ArrayList<Faculty>();
        List<Faculty> lstDT = new ArrayList<Faculty>();
        List<Faculty> lstSE = new ArrayList<Faculty>();
        lstSE.add(f4);
        lstSE.add(f7);
        lstSE.add(f10);
        lstSE.add(f1);
        lstCS.add(f5);
        lstCS.add(f8);
        lstCS.add(f2);
        lstDT.add(f9);
        lstDT.add(f6);
        lstDT.add(f3);
        System.out.println(lstCS.equals(csd.ExtractFacultyDetails("Computer Science")));
        System.out.println(lstSE.equals(csd.ExtractFacultyDetails("Software Engineering")));
        System.out.println(lstDT.equals(csd.ExtractFacultyDetails("Digital Technology")));
        System.out.println(false == lstDT.equals(csd.ExtractFacultyDetails("Digital")));
    }

    // @Test @Order(24)
    void ExtractAdviseesDetails() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        UGrad s1 = new UGrad("z", "Mark", 35, "Male", "Canlish Road");
        UGrad s2 = new UGrad("x", "Dave", 45, "Male", "Guildwood Parkway");
        UGrad s3 = new UGrad("y", "Tom", 55, "Male", "Danforth Road");
        UGrad s4 = new UGrad("a", "Mark", 35, "Male", "Canlish Road");
        UGrad s5 = new UGrad("b", "Hardy", 45, "Male", "Rockwood Drive");
        UGrad s6 = new UGrad("w", "Aman", 32, "Male", "Tawoon Road");
        UGrad s7 = new UGrad("c", "Mark", 27, "Male", "Pizza Road");
        UGrad s8 = new UGrad("j", "Jackson", 21, "Male", "Candy Road");
        UGrad s9 = new UGrad("l", "Walker", 15, "Female", "Qudra Road");
        UGrad s10 = new UGrad("t", "Mark", 35, "Male", "Some Road");

        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.AdmitStudent(s1);
            csd.AdmitStudent(s2);
            csd.AdmitStudent(s3);
            csd.AdmitStudent(s4);
            csd.AdmitStudent(s5);
            csd.AdmitStudent(s6);
            csd.AdmitStudent(s7);
            csd.AdmitStudent(s3);
            csd.AdmitStudent(s8);
            csd.AdmitStudent(s9);
            csd.AdmitStudent(s10);

        } catch (NoSpaceException e) {
            fail();
        }

        List<UGrad> lst1 = new ArrayList<UGrad>();
        List<UGrad> lst2 = new ArrayList<UGrad>();

        lst1.add(s4);
        lst1.add(s5);
        lst1.add(s7);
        lst1.add(s8);
        lst1.add(s6);
        lst1.add(s2);
        lst1.add(s3);
        lst1.add(s1);

        lst2.add(s9);
        lst2.add(s10);
        System.out.println(lst1.equals(csd.ExtractAdviseesDetails(f1)));
        System.out.println(lst2.equals(csd.ExtractAdviseesDetails(f2)));
    }

    // @Test @Order(25)
    void ExtractTAsDetails() throws NoTAException {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Software Engineering");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        Grad s1 = new Grad("aaRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s2 = new Grad("bbJeremy", "Dave", 45, "Male", "Guildwood Parkway");
        Grad s3 = new Grad("cc2Adam", "Tom", 55, "Male", "Danforth Road");
        Grad s4 = new Grad("ddRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s5 = new Grad("eeGeorge", "Hardy", 45, "Male", "Rockwood Drive");
        Grad s6 = new Grad("ffRadi", "Aman", 32, "Male", "Tawoon Road");
        Grad s7 = new Grad("ggJohn", "Mark", 27, "Male", "Pizza Road");
        Grad s8 = new Grad("hhPerseus", "Jackson", 21, "Male", "Candy Road");
        Grad s9 = new Grad("iiSarah", "Walker", 15, "Female", "Qudra Road");
        Grad s10 = new Grad("jjRadi", "Mark", 35, "Male", "Some Road");

        try {
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireTA(s10);
            csd.HireTA(s9);
            csd.HireTA(s8);
            csd.HireTA(s7);
            csd.HireTA(s6);
            csd.HireTA(s5);
            csd.HireTA(s4);
            csd.HireTA(s3);
            csd.HireTA(s2);
            csd.HireTA(s1);

        } catch (NoSpaceException e) {
            fail();
        }
        List<Grad> lst1 = new ArrayList<Grad>();
        List<Grad> lst2 = new ArrayList<Grad>();

        lst1.add(s6);
        lst1.add(s7);
        lst1.add(s8);
        lst1.add(s9);
        lst1.add(s10);

        lst2.add(s1);
        lst2.add(s2);
        lst2.add(s3);
        lst2.add(s4);
        lst2.add(s5);

        System.out.println(lst1.equals(csd.ExtractTAsDetails(f1)));
        System.out.println(false == lst2.equals(csd.ExtractTAsDetails(f1)));
        System.out.println(lst2.equals(csd.ExtractTAsDetails(f2)));
    }

    // @Test @Order(25)
    void RetireFacultyReassignTAs() throws NoTAException {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        ProgramDirector p1 = new ProgramDirector("pd1", "lastName", 50, "Male", "Californnia");
        p1.setProgram(("Computer Science"));
        ProgramDirector p2 = new ProgramDirector("pd2", "lastName", 50, "Male", "America");
        p2.setProgram(("Software Engineering"));
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Computer Science");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        Faculty f3 = new Faculty("Radi", "Riyas", 20, "Male", "Avenue East");
        f3.setProgram("Software Engineering");
        Grad s1 = new Grad("aaRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s2 = new Grad("bbJeremy", "Dave", 45, "Male", "Guildwood Parkway");
        Grad s3 = new Grad("cc2Adam", "Tom", 55, "Male", "Danforth Road");
        Grad s4 = new Grad("ddRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s5 = new Grad("eeGeorge", "Hardy", 45, "Male", "Rockwood Drive");
        Grad s6 = new Grad("ffRadi", "Aman", 32, "Male", "Tawoon Road");
        Grad s7 = new Grad("ggJohn", "Mark", 27, "Male", "Pizza Road");
        Grad s8 = new Grad("hhPerseus", "Jackson", 21, "Male", "Candy Road");
        Grad s9 = new Grad("iiSarah", "Walker", 15, "Female", "Qudra Road");
        try {
            csd.addProgramDirector(p1);
            csd.addProgramDirector(p2);
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f3);
            csd.HireTA(s1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.HireTA(s4);
            csd.HireTA(s5);
            csd.HireTA(s6);
            csd.HireTA(s7);
            csd.HireTA(s8);
            csd.HireTA(s9);
            csd.RetireFaculty(f1);
        } catch (NoSpaceException e) {
            fail();
        } catch (NoSpecialtyException e) {
            fail();
        }
        List<Grad> lst1 = new ArrayList<Grad>();
        List<Grad> lst2 = new ArrayList<Grad>();

        lst1.add(s2);
        lst1.add(s3);
        lst1.add(s4);
        lst1.add(s5);

        lst2.add(s1);
        lst2.add(s6);
        lst2.add(s7);
        lst2.add(s8);
        lst2.add(s9);

        System.out.println(lst1.equals(csd.ExtractTAsDetails(f3)));
        System.out.println(false == lst2.equals(csd.ExtractTAsDetails(f1)));
        System.out.println(lst2.equals(csd.ExtractTAsDetails(f2)));
    }

    // @Test @Order(26)
    void RetireFacultyReassignUndergrads() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        ProgramDirector p1 = new ProgramDirector("pd1", "lastName", 50, "Male", "Californnia");
        p1.setProgram(("Computer Science"));
        ProgramDirector p2 = new ProgramDirector("pd2", "lastName", 50, "Male", "America");
        p2.setProgram(("Software Engineering"));
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Computer Science");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        Faculty f3 = new Faculty("Radi", "Riyas", 20, "Male", "Avenue East");
        f3.setProgram("Software Engineering");
        UGrad s1 = new UGrad("aaRyan", "Mark", 35, "Male", "Canlish Road");
        UGrad s2 = new UGrad("bbJeremy", "Dave", 45, "Male", "Guildwood Parkway");
        UGrad s3 = new UGrad("cc2Adam", "Tom", 55, "Male", "Danforth Road");
        UGrad s4 = new UGrad("ddRyan", "Mark", 35, "Male", "Canlish Road");
        UGrad s5 = new UGrad("eeGeorge", "Hardy", 45, "Male", "Rockwood Drive");
        UGrad s6 = new UGrad("ffRadi", "Aman", 32, "Male", "Tawoon Road");
        UGrad s7 = new UGrad("ggJohn", "Mark", 27, "Male", "Pizza Road");
        UGrad s8 = new UGrad("hhPerseus", "Jackson", 21, "Male", "Candy Road");
        UGrad s9 = new UGrad("iiSarah", "Walker", 15, "Female", "Qudra Road");
        try {
            csd.addProgramDirector(p1);
            csd.addProgramDirector(p2);
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f3);
            csd.AdmitStudent(s1);
            csd.AdmitStudent(s2);
            csd.AdmitStudent(s3);
            csd.AdmitStudent(s4);
            csd.AdmitStudent(s5);
            csd.AdmitStudent(s6);
            csd.AdmitStudent(s7);
            csd.AdmitStudent(s8);
            csd.AdmitStudent(s9);
            csd.RetireFaculty(f1);
        } catch (NoSpaceException e) {
            fail();
        } catch (NoSpecialtyException e) {
            fail();
        }
        List<UGrad> lst1 = new ArrayList<UGrad>();
        List<UGrad> lst2 = new ArrayList<UGrad>();

        lst1.add(s1);
        lst1.add(s2);
        lst1.add(s3);
        lst1.add(s4);
        lst1.add(s5);
        lst1.add(s6);
        lst1.add(s7);
        lst1.add(s9);

        lst2.add(s8);

        System.out.println(lst1.equals(csd.ExtractAdviseesDetails(f2)));
        System.out.println(lst2.equals(csd.ExtractAdviseesDetails(f3)));
    }

    // SPECIAL CASES:
    // @Test @Order(27)
    void RetireFacultyNoOtherFacultyInProgramException() throws NoTAException {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        ProgramDirector p1 = new ProgramDirector("pd1", "lastName", 50, "Male", "Californnia");
        p1.setProgram(("Computer Science"));
        ProgramDirector p2 = new ProgramDirector("pd2", "lastName", 50, "Male", "America");
        p2.setProgram(("Software Engineering"));
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Computer Science");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male", "Avenue East");
        f2.setProgram("Computer Science");
        Faculty f3 = new Faculty("Radi", "Riyas", 20, "Male", "Avenue East");
        f3.setProgram("Software Engineering");
        Grad s1 = new Grad("aaRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s2 = new Grad("bbJeremy", "Dave", 45, "Male", "Guildwood Parkway");
        Grad s3 = new Grad("cc2Adam", "Tom", 55, "Male", "Danforth Road");
        Grad s4 = new Grad("ddRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s5 = new Grad("eeGeorge", "Hardy", 45, "Male", "Rockwood Drive");
        Grad s6 = new Grad("ffRadi", "Aman", 32, "Male", "Tawoon Road");
        Grad s7 = new Grad("ggJohn", "Mark", 27, "Male", "Pizza Road");
        Grad s8 = new Grad("hhPerseus", "Jackson", 21, "Male", "Candy Road");
        Grad s9 = new Grad("iiSarah", "Walker", 15, "Female", "Qudra Road");
        boolean exceptionCaught = false;
        try {
            csd.addProgramDirector(p1);
            csd.addProgramDirector(p2);
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f3);
            csd.HireTA(s1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.HireTA(s4);
            csd.HireTA(s5);
            csd.HireTA(s6);
            csd.HireTA(s7);
            csd.HireTA(s8);
            csd.HireTA(s9);
            csd.RetireFaculty(f3);
        } catch (NoSpaceException e) {
            fail();
        } catch (NoSpecialtyException e) {
            exceptionCaught = true;
        }
        System.out.println(exceptionCaught);
    }

    // @Test @Order(28)
    void RetireFacultyNoOtherTAException(){
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = new CSD(chair);
        ProgramDirector p1 = new ProgramDirector("pd1","lastName", 50, "Male", "Californnia");
        p1.setProgram(("Computer Science"));
        ProgramDirector p2 = new ProgramDirector("pd2","lastName", 50, "Male", "America");
        p2.setProgram(("Software Engineering"));
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female","Lawrence Avenue East");
        f1.setProgram("Computer Science");
        Faculty f2 = new Faculty("Sean", "Smith", 48, "Male","Avenue East");
        f2.setProgram("Computer Science");
        Grad s1 = new Grad("aaRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s2 = new Grad("bbJeremy", "Dave", 45, "Male", "Guildwood Parkway");
        Grad s3 = new Grad("cc2Adam", "Tom", 55, "Male", "Danforth Road");
        Grad s4 = new Grad("ddRyan", "Mark", 35, "Male", "Canlish Road");
        Grad s5 = new Grad("eeGeorge", "Hardy", 45, "Male", "Rockwood Drive");
        Grad s6 = new Grad("ffRadi", "Aman", 32, "Male", "Tawoon Road");
        Grad s7 = new Grad("ggJohn", "Mark", 27, "Male", "Pizza Road");
        Grad s8 = new Grad("hhPerseus", "Jackson", 21, "Male", "Candy Road");
        Grad s9 = new Grad("iiSarah", "Walker", 15, "Female", "Qudra Road");
        boolean exceptionCaught = false;
        try{
            csd.addProgramDirector(p1);
            csd.addProgramDirector(p2);
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireTA(s1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.HireTA(s4);
            csd.HireTA(s5);
            System.out.println("~~~~~~~~~~~~~~~~~");
            csd.HireTA(s6);
            csd.AlumnusGrad(s6);
        }
        catch(NoSpaceException e){
            fail();
        }
        catch (NoTAException e){
            exceptionCaught = true;
        }
        System.out.println(exceptionCaught);
    }
}

class CSD {
    private ChairPerson chairPerson;
    ProgramDirector compScAdmin;
    ProgramDirector softEndAdmin;
    ProgramDirector digitTechAdmin;
    private List<ProgramDirector> programDirectors = new ArrayList<ProgramDirector>();
    private List<Faculty> facultyList = new ArrayList<Faculty>();
    private List<Student> studentList = new ArrayList<Student>();
    private List<Student> gradStudentList = new ArrayList<Student>();
    int lastStudentId = 1000;
    int lastEmployeeId = 100;

    public int generateEmpId() {
        return lastEmployeeId++;
    }

    public void addProgramDirector(ProgramDirector p) {
        programDirectors.add(p);
    }

    public int generateStudentId() {
        return lastStudentId++;
    }

    public CSD(ChairPerson chair) {
        chairPerson = chair;
        // ChairPerson(chair.firstName, chair.lastName, chair.age, chair.gender,
        // chair.address);

    }

    public ChairPerson getChairPerson() {
        return chairPerson;

    }

    public void AlumnusUGrad(Student alumnusUGrad) {
        studentList.remove(alumnusUGrad);
        gradStudentList.add(alumnusUGrad);
        alumnusUGrad.getFaculty().getGrads().add(alumnusUGrad);
        alumnusUGrad.getFaculty().getStudentList().remove(alumnusUGrad);

    }

    public void AdmitStudent(Student newStudent) throws NoSpaceException {
        Faculty assignedFact = null;
        for (Faculty faculty : facultyList) {
            if (faculty.getStudentList().size() < 8) {
                assignedFact = faculty;
                break;
            }
        }
        if (assignedFact == null) {
            throw new NoSpaceException();
        }
        if (studentList.size() > 500) {
            throw new NoSpaceException();
        }
        if (studentList.contains(newStudent)) {
            return;
        }
        /*
         * for (Student student : studentList) {
         * if (student.firstName.equals(newStudent.firstName) &&
         * student.lastName.equals(newStudent.lastName)) {
         * throw new NoSpaceException();
         * }
         * }
         */
        if (studentList.size() >= 500)
            throw new NoSpaceException();
        if (this.facultyList.size() == 0) {
            throw new NoSpaceException();
        }
        newStudent.setId(generateStudentId());
        newStudent.setFaculty(assignedFact);
        assignedFact.setStudent(newStudent);
        this.studentList.add(newStudent);
    }

    public void HireTA(Student grdStudent) throws NoSpaceException, NoTAException {
        Faculty assignedFact = null;
        for (Faculty faculty : facultyList) {
            if (faculty.getTAs().size() < 5) {
                assignedFact = faculty;
                break;
            }
        }
        if (assignedFact == null) {
            throw new NoSpaceException();
        }
        if (gradStudentList.contains(grdStudent)) {
            System.out.println("Already Exist");
            return;
        }

        if (grdStudent != null) {
            // removeStudentFromFacultyList(grdStudent.getId());
            if (grdStudent.getId() < 1000) {
                grdStudent.setId(generateStudentId());
            }
            studentList.remove(grdStudent);

            if (gradStudentList.size() >= 150) {
                return;
            }

            grdStudent.isTAs = true;
            gradStudentList.add(grdStudent);
            assignedFact.setGrads(grdStudent);
            grdStudent.setFaculty(assignedFact);
        }

    }

    public int getNumOfGradStudents() {
        int no = 0;
        for (Student student : gradStudentList) {
            if (student.isAlumnusGrad == false)
                no++;
        }
        return no;

    }

    public void HireFaculty(Faculty f) throws NoSpaceException {
        if (facultyList.contains(f)) {
            return;
        }

        // int totalNoFact = compScAdmin.getFactLst().size() +
        // softEndAdmin.getFactLst().size()
        // + digitTechAdmin.getFactLst().size();
        /*
         * if (totalNoFact > 70) {
         * throw new NoSpaceException();
         * }
         */
        /*
         * if(compScAdmin != null) {
         * if (compScAdmin.programId == f.programId) {
         * if (compScAdmin.getFactLst().size() > 25) {
         * throw new NoSpaceException();
         * }
         * compScAdmin.setFactLst(f);
         * }
         * }
         * if(softEndAdmin != null) {
         * if (softEndAdmin.programId == f.programId) {
         * if (softEndAdmin.getFactLst().size() > 25) {
         * throw new NoSpaceException();
         * }
         * softEndAdmin.setFactLst(f);
         * }
         * }
         * if(digitTechAdmin != null) {
         * if (digitTechAdmin.programId == f.programId) {
         * if (digitTechAdmin.getFactLst().size() > 25) {
         * throw new NoSpaceException();
         * }
         * digitTechAdmin.setFactLst(f);
         * }
         * }
         */
        f.employeeId = generateEmpId();
        this.facultyList.add(f);
    }

    public void RetireFaculty(Faculty retireFaculty) throws NoSpecialtyException {
        Faculty programFacultyAvailable = null;
        int grads = 0;
        int uGrads = 0;
        for (Faculty faculty : facultyList) {
            if (faculty.employeeId != retireFaculty.employeeId) {
                programFacultyAvailable = faculty;
                for (; grads < retireFaculty.getGrads().size()
                        && programFacultyAvailable.getGrads().size() < 5; grads++) {
                    programFacultyAvailable.getGrads().add(retireFaculty.getGrads().get(grads));
                }
                for (; uGrads < retireFaculty.getStudentList().size()
                        && programFacultyAvailable.getStudentList().size() < 8; uGrads++) {
                    programFacultyAvailable.getStudentList().add(retireFaculty.getStudentList().get(uGrads));
                }

            }
        }
        if (programFacultyAvailable != null) {
            // programFacultyAvailable.getStudentList().addAll(retireFaculty.getStudentList());
            // programFacultyAvailable.getAssignedGrads().addAll(retireFaculty.getAssignedGrads());

            // programFacultyAvailable.getStudentList().add(retireFaculty.getStudentList().get(0));
            // programFacultyAvailable.getGrads().add(retireFaculty.getGrads().get(0));
        }

        if (retireFaculty != null) {
            this.facultyList.remove(retireFaculty);
        }
        for (Student student : studentList) {
            if (student.getFaculty() == retireFaculty) {
                student.isAdvising = true;
                break;
            }
        }
        for (Student student : gradStudentList) {
            if (student.getFaculty() == retireFaculty) {
                student.isTAs = true;
                break;
            }
        }
        programFacultyAvailable = null;
        for (Faculty faculty : facultyList) {
            if (faculty.employeeId != retireFaculty.employeeId) {
                if (faculty.programId == retireFaculty.programId && faculty.employeeId != retireFaculty.employeeId) {
                    programFacultyAvailable = faculty;
                }
            }
        }
        if (programFacultyAvailable == null) {
            throw new NoSpecialtyException();
        }
    }

    public List<Faculty> ExtractFacultyDetails(String programId) {
        List<Faculty> progFacultyList = new ArrayList<Faculty>();
        for (Faculty faculty : facultyList) {
            if (faculty.programId == programId) {
                progFacultyList.add(faculty);
            }
        }
        Collections.sort(progFacultyList, new Comparator<Faculty>() {
            @Override
            public int compare(Faculty lhs, Faculty rhs) {
                return lhs.firstName.compareTo(rhs.firstName);
            }
        });
        return progFacultyList;
    }

    public List<Student> ExtractAllUGradDetails() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student lhs, Student rhs) {
                return lhs.firstName.compareTo(rhs.firstName);
            }
        });
        return studentList;
    }

    public List<Faculty> ExtractAllFacultyDetails() {
        Collections.sort(facultyList, new Comparator<Faculty>() {
            @Override
            public int compare(Faculty lhs, Faculty rhs) {
                return lhs.firstName.compareTo(rhs.firstName);
            }
        });
        return facultyList;
    }

    public List<Student> ExtractAllGradDetails() {
        Collections.sort(gradStudentList, new Comparator<Student>() {
            @Override
            public int compare(Student lhs, Student rhs) {
                return lhs.firstName.compareTo(rhs.firstName);
            }
        });
        return gradStudentList;
    }

    public List<Student> ExtractAdviseesDetails(Faculty f) {
        Collections.sort(f.getAdvisingUgrads(), new Comparator<Student>() {
            @Override
            public int compare(Student lhs, Student rhs) {
                return lhs.firstName.compareTo(rhs.firstName);
            }
        });
        return f.getAdvisingUgrads();
    }

    public List<Student> ExtractTAsDetails(Faculty f) {
        List<Student> list = new ArrayList();
        list.addAll(f.getTAs());
        Collections.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student lhs, Student rhs) {
                return lhs.firstName.compareTo(rhs.firstName);
            }
        });
        return list;
    }

    public List<Faculty> getFaculty() {
        return facultyList;
    }

    public List<Faculty> getCompFaculty() {
        ArrayList<Faculty> faculty = new ArrayList<Faculty>();
        for (Faculty element : facultyList) {
            if (element.getProgram() == "Computer Science") {
                faculty.add(element);
            }
        }
        return faculty;
    }

    public List<Faculty> getSoftFaculty() {
        ArrayList<Faculty> faculty = new ArrayList<Faculty>();
        for (Faculty element : facultyList) {
            if (element.getProgram() == "Software Engineering") {
                faculty.add(element);
            }
        }
        return faculty;
    }

    public List<Faculty> getDigFaculty() {
        ArrayList<Faculty> faculty = new ArrayList<Faculty>();
        for (Faculty element : facultyList) {
            if (element.getProgram() == "Digital Technology") {
                faculty.add(element);
            }
        }
        return faculty;
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public boolean isStudentInList(int studentID) {
        for (Student student : studentList) {
            if (student.getId() == studentID) {
                return true;
            }
        }
        return false;
    }

    public List<Student> getGradStudent() {
        return gradStudentList;
    }

    public int getNumOfFaculty() {
        return facultyList.size();
    }

    public void removeStudentFromFacultyList(int _studentID) {
        for (Faculty faculty : facultyList) {
            int id = -1;
            List<Student> studentListIds = faculty.getStudentList();
            for (int i = 0; i < studentListIds.size(); i++) {
                id = i;
            }
            if (id >= 0)
                studentListIds.remove(id);
        }

    }

    public void AlumnusUGrad(int studentID) {
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

    public Integer getNumOfUGradStudents() {
        return studentList.size();
    }

    public void AlumnusGrad(Student s) throws NoTAException {
        s.isAlumnusGrad = true;
        String programId = null;
        for (Student student : studentList) {
            if (s.getId() != student.getId() && s.getFaculty().programId == student.getFaculty().programId) {
                programId = s.getFaculty().programId;
            }
        }
        for (Student student : s.getFaculty().getGrads()) {
            if (s.getId() != student.getId() && s.getFaculty().programId == student.getFaculty().programId) {
                programId = s.getFaculty().programId;
            }
        }
        if (programId == null) {
            throw new NoTAException();
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
    int employeeId = 100;
    String programId;
}

class Administrator extends Academics {
    double salary;
}

class ProgramDirector extends Administrator {
    private List<Faculty> assignedFactLst = new ArrayList<Faculty>();
    private String program;

    public ProgramDirector(String name, String lastName, int age, String gender, String address) {
        // super();
        this.setInfo(name, lastName, age, gender, address);
    }

    public List<Faculty> getFactLst() {
        return assignedFactLst;
    }

    public void setFactLst(Faculty faculty) {
        assignedFactLst.add(faculty);
    }

    public void setProgram(String program) {
        this.program = program;
        // TODO Auto-generated method stub

    }
}

class ChairPerson extends Administrator {

    public ChairPerson(String name, String lastName, int age, String gender, String address) {
        super();
        this.setInfo(name, lastName, age, gender, address);
    }

    public int getEmployeeID() {
        return employeeId++;
    }

    public void setSalary(double salary) {
        this.salary = salary;

    }
}

class Faculty extends Academics implements Comparable<Academics> {
    private List<Student> assignedStudents = new ArrayList();
    private List<Student> assignedGrads = new ArrayList();
    private double salary;

    public Faculty(String firstName, String lastName, int age, String gender, String address) {
        super();
        this.setInfo(firstName, lastName, age, gender, address);
    }

    public void setStudent(Student Id) {
        this.assignedStudents.add(Id);
    }

    public List<Student> getStudentList() {
        return assignedStudents;
    }

    public List<Student> getAssignedGrads() {
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
        this.programId = program;
    }

    public String getProgram() {
        return this.programId;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return this.salary;
    }

    public List<Student> getAdvisingUgrads() {
        ArrayList sortList = new ArrayList();
        for (Student student : assignedStudents) {
            // if (student.isAdvising)
            sortList.add(student.getFullName());
        }
        Collections.sort(sortList);
        return assignedStudents;
    }

    public int getNumOfAdvisingUGrads() {
        return assignedStudents.size();
    }

    public List<Student> getTAs() {
        ArrayList<Student> sortList = new ArrayList();
        for (Student student : assignedGrads) {
            if (student.isAlumnusGrad == false)
                sortList.add(student);
        }
        return sortList;

    }

    public void setGrads(Student g) {
        assignedGrads.add(g);
    }

    public List<Student> getGrads() {
        // TODO Auto-generated method stub
        return assignedGrads;
    }

    public int getNumOfTAs() {
        return getTAs().size();
    }

}

class Student extends Person implements Comparable<Student> {
    private int studentId;
    private Faculty facultyID;
    public boolean isTAs = false;
    public boolean isAdvising = false;
    public boolean isAlumnusGrad = false;

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

    public void setFaculty(Faculty assignedFactId) {
        this.facultyID = assignedFactId;
    }

    public Faculty getFaculty() {
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

    public Faculty getAdvisor() {
        return getFaculty();
    }
}

class Grad extends Student {
    public Grad(String firstName, String lastName, int age, String gender, String address) {
        super(firstName, lastName, age, gender, address);
    }

    public Faculty getAdvisor() {
        // TODO Auto-generated method stub
        return getFaculty();
    }

}

class NoSpaceException extends Exception {
    public NoSpaceException() {
    }

    public NoSpaceException(String message) {
        super(message);
    }
}

class NoTAException extends Exception {
    public NoTAException() {
    }

    public NoTAException(String message) {
        super(message);
    }
}

class NoSpecialtyException extends Exception {
    public NoSpecialtyException() {
    }

    public NoSpecialtyException(String message) {
        super(message);
    }
}