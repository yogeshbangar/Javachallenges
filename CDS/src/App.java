import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        test.CheckChairEmployeeID100();
        test.ShouldCompareDeptChairPerson();
        test.CheckChairID102AndFacultyID103();
        test.CheckProgramNameCorrect();
        test.CheckToStringChair();
        test.CheckToStringFaculty();
        test.CheckToStringUgrad();
        test.CheckToStringGrad();
        test.HireFaculty();
        test.HireFacultyDuplicate();
        test.HireMultipleFaculty();
        test.AdmitStudent();
        test.AdmitStudentDuplicate();
        test.AdmitStudentMultiple();
        test.HireTA();
        test.HireTADuplicate();
        test.HireTAMultiple();
        test.GraduateUndergrad();
        test.GraduateTA();
        test.ExtractAllGradDetails();
        test.ExtractAllUGradDetails();
        test.ExtractAllFacultyDetails();
        test.ExtractFacultyDetails();
        test.ExtractAdviseesDetails();
        test.ExtractTAsDetails();
        test.RetireFacultyReassignTAs();
    }
}

class Test {
    CSD getCSD() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");

        ProgramDirector compScAdmin = new ProgramDirector("Comp", "Admin", 59, "Male", "Birchmount Road",
                "Computer Science");
        ProgramDirector softEndAdmin = new ProgramDirector("softEnd", "Admin", 59, "Male", "Birchmount Road",
                "Software Engineering");
        ProgramDirector digitTechAdmin = new ProgramDirector("digitTechAdmin", "Admin", 59, "Male", "Birchmount Road",
                "Digital Technology");
        return new CSD(chair, compScAdmin, softEndAdmin, digitTechAdmin);
    }

    void basicTest() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("ZRyan", "Mark", 35, "Male", "Canlish Road");
        UGrad s2 = new UGrad("Yog", "Shon", 23, "Male", "nariman Road");

        try {
            csd.HireFaculty(f);
            csd.AdmitStudent(s, f);
            csd.AdmitStudent(s2, f);
            // csd.upgradeToAlumnusUGrad(1000);
        } catch (Exception e) {
            // fail();
        }

        csd.showDetail();
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

    void CheckChairID102AndFacultyID103() {
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
            csd.AdmitStudent(s, f);
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
            csd.AdmitStudent(s, f);
        } catch (Exception e) {
            // fail();
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
            csd.AdmitStudent(s, f);
            csd.AdmitStudent(s, f);
        } catch (Exception e) {
            // fail();
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
            csd.AdmitStudent(s1, f1);
            csd.AdmitStudent(s2, f1);
            csd.AdmitStudent(s3, f1);
            csd.AdmitStudent(s4, f1);
            csd.AdmitStudent(s5, f1);
            csd.AdmitStudent(s6, f1);
            csd.AdmitStudent(s7, f1);
            csd.AdmitStudent(s3, f1);
            csd.AdmitStudent(s8, f1);
            csd.AdmitStudent(s9, f2);
            csd.AdmitStudent(s10, f2);

        } catch (Exception e) {
            // fail();
        }

        System.out.println(csd.getFaculty().get(0).getStudentList().contains(s1.getId()));
        System.out.println(csd.getFaculty().get(0).getStudentList().contains(s2.getId()));
        System.out.println(csd.getFaculty().get(0).getStudentList().contains(s3.getId()));
        System.out.println(false == csd.getFaculty().get(0).getStudentList().contains(s4.getId()));
        System.out.println(csd.getFaculty().get(0).getStudentList().contains(s5.getId()));
        System.out.println(csd.getFaculty().get(0).getStudentList().contains(s6.getId()));
        System.out.println(csd.getFaculty().get(0).getStudentList().contains(s7.getId()));
        System.out.println(csd.getFaculty().get(0).getStudentList().contains(s8.getId()));

        System.out.println(csd.getFaculty().get(1).getStudentList().contains(s9.getId()));
        System.out.println(csd.getFaculty().get(1).getStudentList().contains(s10.getId()));

        System.out.println(csd.getStudents().size() == 9);

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
            csd.AdmitStudent(s, f);
            csd.upgradeToAlumnusUGrad(s.getId());
        } catch (Exception e) {
            // fail();
        }
        System.out.println(csd.getGradStudent().get(0).isTAs);
        System.out.println(csd.getGradStudent().size() == 1);
        System.out.println(csd.getStudents().size() == 0);
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
            // fail();
        }
        System.out.println(csd.getGradStudent().get(0).isTAs);
        System.out.println(csd.getGradStudent().size() == 1);
        System.out.println(csd.getStudents().size() == 0);
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
            // fail();
        }
        System.out.println(csd.getGradStudent().get(0).isTAs);
        System.out.println(csd.getGradStudent().size() == 5);
        System.out.println(csd.getStudents().size() == 0);
        // assertTrue(f1.getTAs().contains(s1), "Assign Undergrad to Advisor Failed");
        // assertTrue(f1.getTAs().contains(s2), "Assign Undergrad to Advisor Failed");
        // assertTrue(f1.getTAs().contains(s3), "Assign Undergrad to Advisor Failed");
        // assertTrue(f1.getTAs().contains(s4), "Assign Undergrad to Advisor Failed");
        // assertTrue(f1.getTAs().contains(s5), "Assign Undergrad to Advisor Failed");
        // assertTrue(f2.getTAs().contains(s6), "Assign Undergrad to Advisor Failed");
        // assertTrue(f2.getTAs().contains(s7), "Assign Undergrad to Advisor Failed");
        // assertTrue(f2.getTAs().contains(s8), "Assign Undergrad to Advisor Failed");
        // assertFalse(f1.getTAs().contains(s9), "Assign Undergrad to Advisor Failed");
        // assertTrue(f2.getTAs().contains(s9), "Assign Undergrad to Advisor Failed");
        // assertTrue(f2.getTAs().contains(s10), "Assign Undergrad to Advisor Failed");
        // assertEquals(s3.getAdvisor(), f1, "Assign Advisor to Undergrad Failed");
        // assertEquals(s10.getAdvisor(), f2, "Assign Advisor to Undergrad Failed");
        // assertEquals(10, csd.getNumOfGradStudents(), "Increment UGrad count in Dept
        // Failed");
        // assertEquals(2, csd.getNumOfFaculty(), "Increment Faculty count in Dept
        // Failed");

    }

    // @Test @Order(18)
    void GraduateUndergrad() {
        CSD csd = getCSD();
        Faculty f = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f.setProgram("Software Engineering");
        UGrad s = new UGrad("Ryan", "Mark", 35, "Male", "Canlish Road");
        try {
            csd.HireFaculty(f);
            csd.AdmitStudent(s, f);
            csd.upgradeToAlumnusUGrad(s.getId());
            ;
        } catch (Exception e) {
            // fail();
        }
        System.out.println(csd.getGradStudent().get(0).isTAs);
        System.out.println(csd.getGradStudent().size() == 1);
        System.out.println(csd.getStudents().size() == 0);
        // assertFalse(f.getAdvisingUgrads().contains(s), "Graduate Undergrad Failed");
        // assertEquals(s.getAdvisor(), f, "Remove Advisor Link Failed");
        // assertEquals(0, csd.getNumOfUGradStudents(), "Decrement UGrad count in Dept
        // Failed");
        // assertEquals(0, f.getNumOfAdvisingUGrads(), "Decrement UGrad count in Faculty
        // Failed");
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
            csd.AdmitStudent(s1, f1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.upgradeToAlumnusUGrad(s1.getId());
            csd.HireTA(s4);
        } catch (Exception e) {
            // fail();
        }
        System.out.println(csd.getGradStudent().get(0).isTAs);
        System.out.println(csd.getGradStudent().size() == 3);
        System.out.println(csd.getStudents().size() == 0);

        // assertFalse(f1.getTAs().contains(s1), "Delete Grad Student after graduating
        // failed");
        // assertEquals(s1.getAdvisor(), f1, "Remove Grad Advisor Link failed after
        // graduation");
        // assertEquals(3, csd.getNumOfGradStudents(), "Decrement Grad count in Dept
        // Failed");
        // assertEquals(3, f1.getNumOfTAs(), "Decrement Grad count in Faculty Failed");
        Grad s5 = new Grad("George", "Hardy", 45, "Male", "Rockwood Drive");
        Grad s6 = new Grad("Radi", "Aman", 32, "Male", "Tawoon Road");
        Grad s7 = new Grad("John", "Mark", 27, "Male", "Pizza Road");
        boolean caught = false;
        try {
            csd.HireTA(s5);
            csd.HireTA(s6);
            csd.AdmitStudent(s7, f1);
            csd.upgradeToAlumnusUGrad(s7.getId());
        } catch (Exception e) {
            caught = true;
        }
        System.out.println(s1.isTAs);
        System.out.println(csd.getGradStudent().size() == 6);
        System.out.println(csd.isStudentInList(s1.getId()) == false);
        // assertTrue(caught, "NoTAException not thrown!");
        // assertFalse(f1.getTAs().contains(s1), "Delete Grad Student after graduating
        // failed");
        // assertEquals(s1.getAdvisor(), f1, "Remove Grad Advisor Link failed after
        // graduation");
        // assertEquals(5, csd.getNumOfGradStudents(), "Decrement Grad count in Dept
        // Failed");
        // assertEquals(5, f1.getNumOfTAs(), "Decrement Grad count in Faculty Failed");
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
            csd.AdmitStudent(s4, f2);
            csd.upgradeToAlumnusUGrad(s4.getId());
            csd.HireTA(s1);
        } catch (Exception e) {
            // fail();
        }

        List<Grad> lst = new ArrayList<Grad>();
        lst.add(s3);
        lst.add(s2);
        lst.add(s1);
        lst.add(s0);

        System.out.println(csd.getGradStudent().get(1).firstName == s1.firstName);
        System.out.println(s2.isTAs);
        System.out.println(s3.isTAs);
        System.out.println(csd.getGradStudent().size() == 5);
        System.out.println(csd.extractAllGradDetails());

        // assertTrue(lst.equals(csd.ExtractAllGradDetails()), "Extract All Grad Details
        // Failed");
    }

    // @Test @Order(21)
    void ExtractAllUGradDetails() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        CSD csd = getCSD();
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
            csd.AdmitStudent(s1, f1);
            csd.AdmitStudent(s2, f1);
            csd.AdmitStudent(s3, f1);
            csd.AdmitStudent(s4, f1);
            csd.AdmitStudent(s5, f1);
            csd.AdmitStudent(s6, f1);
            csd.AdmitStudent(s7, f1);
            csd.AdmitStudent(s3, f1);
            csd.AdmitStudent(s8, f1);
            csd.AdmitStudent(s9, f2);
            csd.AdmitStudent(s10, f2);
            s2.isAdvising = true;

        } catch (Exception e) {
            // fail();
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
        System.out.println(csd.getStudents().get(0).firstName == s1.firstName);
        System.out.println(csd.getStudents().get(1).isAdvising);
        System.out.println(s2.isTAs == false);
        System.out.println(csd.getStudents().size() == 10);
        System.out.println(csd.extractAllUGradDetails());
        // assertEquals(true ,lst.equals(csd.ExtractAllUGradDetails()), "Extract All
        // Grad Details Failed");
    }

    // @Test @Order(22)
    void ExtractAllFacultyDetails() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        CSD csd = getCSD();
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
        f1.setProgram("Software Engineering");
        f2.setProgram("Software Engineering");
        f3.setProgram("Software Engineering");
        f4.setProgram("Computer Science");
        f5.setProgram("Computer Science");
        f6.setProgram("Computer Science");
        f7.setProgram("Digital Technology");
        f8.setProgram("Digital Technology");
        f9.setProgram("Digital Technology");
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

        } catch (Exception e) {
            // fail();
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
        System.out.println(csd.getFaculty().get(0).firstName == f1.firstName);
        System.out.println(csd.getFaculty().get(1).programId == "Software Engineering");
        System.out.println(csd.getCompFaculty().size() == 3);
        System.out.println(csd.getSoftFaculty().size() == 4);
        System.out.println(csd.getDigFaculty().size() == 3);
        System.out.println(csd.extractAllFacultyDetails());
        // assertEquals(true ,lst.equals(csd.ExtractAllFacultyDetails()), "Extract All
        // Faculty Details Failed");
    }

    // @Test @Order(23)
    void ExtractFacultyDetails() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        CSD csd = getCSD();
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
        } catch (Exception e) {
            // fail();
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

        System.out.println(csd.getFaculty().get(0).firstName == f1.firstName);
        System.out.println(csd.getFaculty().get(1).programId == "Software Engineering");
        System.out.println(csd.getFaculty().size() == 10);
        System.out.println(csd.extractAllFacultyDetails());

        // assertTrue(lstCS.equals(csd.ExtractFacultyDetails("Computer Science")),
        // "Extract All Faculty Details for CS Failed");
        // assertTrue(lstSE.equals(csd.ExtractFacultyDetails("Software Engineering")),
        // "Extract All Faculty Details for SE Failed");
        // assertTrue(lstDT.equals(csd.ExtractFacultyDetails("Digital Technology")),
        // "Extract All Faculty Details for DT Failed");
        // assertFalse(lstDT.equals(csd.ExtractFacultyDetails("Digital")), "Extract All
        // Faculty Details for DT Failed");
    }

    // @Test @Order(24)
    void ExtractAdviseesDetails() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        CSD csd = getCSD();
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
            csd.AdmitStudent(s1, f1);
            csd.AdmitStudent(s2, f1);
            csd.AdmitStudent(s3, f1);
            csd.AdmitStudent(s4, f1);
            csd.AdmitStudent(s5, f1);
            csd.AdmitStudent(s6, f1);
            csd.AdmitStudent(s7, f1);
            csd.AdmitStudent(s3, f1);
            csd.AdmitStudent(s8, f2);
            csd.AdmitStudent(s9, f2);
            csd.AdmitStudent(s10, f2);
            s1.isAdvising = true;
            s2.isAdvising = true;
            s3.isAdvising = true;
        } catch (Exception e) {
            // fail();
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
        System.out.println(csd.extractAdviseesDetails());
        // assertTrue(lst1.equals(csd.ExtractAdviseesDetails(f1)), "Extract First
        // Advisor Students Failed");
        // assertTrue(lst2.equals(csd.ExtractAdviseesDetails(f2)), "Extract Second
        // Advisor Students Failed");
    }

    // @Test @Order(25)
    void ExtractTAsDetails() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        CSD csd = getCSD();
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

        } catch (Exception e) {
            // fail();
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

        System.out.println(csd.extractTAsDetails());

        // assertTrue(lst1.equals(csd.ExtractTAsDetails(f1)), "Extract All TAs of first
        // faculty Failed");
        // assertFalse(lst2.equals(csd.ExtractTAsDetails(f1)), "ExtractTA not working
        // properly");
        // assertTrue(lst2.equals(csd.ExtractTAsDetails(f2)), "Extract All TAs of first
        // faculty Failed");
    }

    // @Test @Order(25)
    void RetireFacultyReassignTAs() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        // CSD csd = new CSD(chair);
        // ProgramDirector p1 = new ProgramDirector("pd1","lastName", 50, "Male",
        // "Californnia");
        // p1.setProgram(("Computer Science"));
        // ProgramDirector p2 = new ProgramDirector("pd2","lastName", 50, "Male",
        // "America");
        // p2.setProgram(("Software Engineering"));
        CSD csd = getCSD();
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
            // csd.addProgramDirector(p1);
            // csd.addProgramDirector(p2);
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f3);
            csd.AdmitStudent(s1, f1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.HireTA(s4);
            csd.HireTA(s5);
            csd.HireTA(s6);
            csd.HireTA(s7);
            csd.HireTA(s8);
            csd.HireTA(s9);
            csd.retiredFaculty(f1.getEmployeeID());
        } catch (Exception e) {
            // fail();
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

        System.out.println(csd.getFaculty().size());
        System.out.println(csd.extractAdviseesDetails().size() == 1);
        System.out.println(csd.extractTAsDetails().size() == 5);

        // assertTrue(lst1.equals(csd.ExtractTAsDetails(f3)), "Reassign TAs to new
        // Faculty Failed");
        // assertFalse(lst2.equals(csd.ExtractTAsDetails(f1)), "Delete oldFaculty Links
        // Failed");
        // assertTrue(lst2.equals(csd.ExtractTAsDetails(f2)), "Reassign TAs Failed");
    }

    // @Test @Order(26)
    void RetireFacultyReassignUndergrads() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        // CSD csd = new CSD(chair);
        // ProgramDirector p1 = new ProgramDirector("pd1","lastName", 50, "Male",
        // "Californnia");
        // p1.setProgram(("Computer Science"));
        // ProgramDirector p2 = new ProgramDirector("pd2","lastName", 50, "Male",
        // "America");
        // p2.setProgram(("Software Engineering"));
        CSD csd = getCSD();
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
            // csd.addProgramDirector(p1);
            // csd.addProgramDirector(p2);
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireFaculty(f3);
            csd.AdmitStudent(s1, f1);
            csd.AdmitStudent(s2, f1);
            csd.AdmitStudent(s3, f1);
            csd.AdmitStudent(s4, f1);
            csd.AdmitStudent(s5, f1);
            csd.AdmitStudent(s6, f1);
            csd.AdmitStudent(s7, f1);
            csd.AdmitStudent(s8, f1);
            csd.AdmitStudent(s9, f1);
            csd.retiredFaculty(f1.getEmployeeID());
        } catch (Exception e) {
            // fail();
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

        // assertTrue(lst1.equals(csd.ExtractAdviseesDetails(f2)), "Reassign TAs to new
        // Faculty Failed");
        // assertTrue(lst2.equals(csd.ExtractAdviseesDetails(f3)), "Reassign TAs
        // Failed");
        System.out.println(csd.getFaculty().size());
        System.out.println(csd.extractAdviseesDetails().size() == 1);

    }

    // SPECIAL CASES:
    // @Test @Order(27)
    void RetireFacultyNoOtherFacultyInProgramException() {
        ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount Road");
        CSD csd = getCSD();
        // ProgramDirector p1 = new ProgramDirector("pd1","lastName", 50, "Male",
        // "Californnia");
        // p1.setProgram(("Computer Science"));
        // ProgramDirector p2 = new ProgramDirector("pd2","lastName", 50, "Male",
        // "America");
        // p2.setProgram(("Software Engineering"));
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
            // csd.addProgramDirector(p1);
            // csd.addProgramDirector(p2);
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
            csd.retiredFaculty(f3.getEmployeeID());
        } catch (Exception e) {
            // fail();
        }

        // assertTrue(exceptionCaught, "No other prof under Progam Exception Not
        // thrown");
    }

    // @Test @Order(28)
    void RetireFacultyNoOtherTAException() {
        // ChairPerson chair = new ChairPerson("Rebert", "Jack", 59, "Male", "Birchmount
        // Road");
        CSD csd = getCSD();
        // ProgramDirector p1 = new ProgramDirector("pd1","lastName", 50, "Male",
        // "Californnia");
        // p1.setProgram(("Computer Science"));
        // ProgramDirector p2 = new ProgramDirector("pd2","lastName", 50, "Male",
        // "America");
        // p2.setProgram(("Software Engineering"));
        Faculty f1 = new Faculty("Elizabeth", "Smith", 53, "Female", "Lawrence Avenue East");
        f1.setProgram("Computer Science");
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
        boolean exceptionCaught = false;
        try {
            // csd.addProgramDirector(p1);
            // csd.addProgramDirector(p2);
            csd.HireFaculty(f1);
            csd.HireFaculty(f2);
            csd.HireTA(s1);
            csd.HireTA(s2);
            csd.HireTA(s3);
            csd.HireTA(s4);
            csd.HireTA(s5);
            csd.HireTA(s6);
            // csd.AlumnusGrad(s6);
        } catch (Exception e) {
            // fail();
        }

        // assertTrue(exceptionCaught, "No TA under Faculty Exception Not thrown");
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

    public CSD(ChairPerson chair, ProgramDirector comChair, ProgramDirector softChair, ProgramDirector digitChair) {
        chair.employeeId = generateEmpId();
        this.compScAdmin = comChair;
        this.softEndAdmin = softChair;
        this.digitTechAdmin = digitChair;
        setChairPerson(chair);
    }

    private void setChairPerson(ChairPerson chair) {
        this.chairPerson = new ChairPerson(chair.firstName, chair.lastName, chair.age, chair.gender,
                chair.address);
    }

    public void AdmitStudent(Student newStudent, Faculty assignedFact) throws Exception {
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
        newStudent.setId(generateStudentId());
        newStudent.setFaculty(assignedFact.employeeId);
        assignedFact.setStudent(newStudent.getId());
        this.studentList.add(newStudent);
    }

    public void HireTA(Student grdStudent) {
        for (Student student : gradStudentList) {
            if (student.firstName.equals(grdStudent.firstName) && student.lastName.equals(grdStudent.lastName)) {
                System.out.println("Already Exist");
                return;
            }
        }
        if (grdStudent != null) {
            removeStudentFromFacultyList(grdStudent.getId());
            studentList.remove(grdStudent);

            if (gradStudentList.size() >= 150) {
                return;
            }

            int noOfTAs = 0;
            for (Student gStudent : gradStudentList) {
                if (gStudent.isTAs) {
                    noOfTAs++;
                }
            }
            if (noOfTAs < 5)
                grdStudent.isTAs = true;
            else
                return;
            gradStudentList.add(grdStudent);
        }

    }

    public ChairPerson setChairPerson() {
        return new ChairPerson(chairPerson.firstName, chairPerson.lastName, chairPerson.age, chairPerson.gender,
                chairPerson.address);
    }

    public ChairPerson getChairPerson() {
        return chairPerson;

    }

    public void HireFaculty(Faculty f) {
        System.out.println("~~~~~~~~~~~~~~~1~~~~~");
        for (Faculty faculty : facultyList) {
            if (faculty.firstName.equals(f.firstName) && faculty.lastName.equals(f.lastName)) {
                System.out.println("Already Exist");
                return;
            }
        }
        System.out.println("~~~~~~~~~~~~~~~2~~~~~");
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

    public List<String> extractAllUGradDetails() {
        ArrayList<String> sortList = new ArrayList<String>();
        for (Student student : studentList) {
            sortList.add(student.getFullName());
        }
        Collections.sort(sortList);
        for (String list : sortList) {
            System.out.println(list);
        }
        return sortList;
    }

    public List<String> extractAllFacultyDetails() {
        ArrayList<String> sortList = new ArrayList<String>();
        for (Faculty faculty : facultyList) {
            sortList.add(faculty.getFullName());
        }
        Collections.sort(sortList);
        for (String list : sortList) {
            System.out.println(list);
        }
        return sortList;
    }

    public List<String> extractAllGradDetails() {
        ArrayList<String> sortList = new ArrayList<String>();
        for (Student gradStudent : gradStudentList) {
            sortList.add(gradStudent.getFullName());
        }
        Collections.sort(sortList);
        for (String list : sortList) {
            System.out.println(list);
        }
        return sortList;
    }

    public List<String> extractAdviseesDetails() {
        ArrayList<String> sortList = new ArrayList<String>();
        for (Student student : studentList) {
            if (student.isAdvising)
                sortList.add(student.getFullName());
        }
        Collections.sort(sortList);
        for (String list : sortList) {
            System.out.println(list);
        }
        return sortList;
    }

    public List<String> extractTAsDetails() {
        ArrayList<String> sortList = new ArrayList<String>();
        for (Student gradStudent : gradStudentList) {
            if (gradStudent.isTAs)
                sortList.add(gradStudent.getFullName());
        }
        Collections.sort(sortList);
        for (String list : sortList) {
            System.out.println(list);
        }
        return sortList;
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
        return 0;
    }

    public void removeStudentFromFacultyList(int _studentID) {
        for (Faculty faculty : facultyList) {
            int id = -1;
            List<Integer> studentListIds = faculty.getStudentList();
            for (int i = 0; i < studentListIds.size(); i++) {
                id = i;
            }
            if (id >= 0)
                studentListIds.remove(id);
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
        this.setInfo(name, lastName, age, gender, address);
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
