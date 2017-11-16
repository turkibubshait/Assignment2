package pkg;

import java.util.ArrayList;

public class Department {

    private final String name; // the name of school �Dept of Computing and Info Science�
    private final String id; // short name for courses �SOFE�, �ELEE�, �STAT�, etc
    ArrayList<Course> courseList; // all courses offered by the department
    ArrayList<Student> registerList; // all students taking courses in the department.

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Department(String name, String id) {
        this.name = name;
        this.id = id;
        courseList = new ArrayList<>();
        registerList = new ArrayList<>();

    }

    public void offerCourse(Course c) {
        courseList.add(c);
    }

    public void printCoursesOffered() {
        for (Course c : courseList) {
            System.out.println(c.toString());
        }
    }

    public void printStudentsByName() {
        for (Student s : registerList) {
            System.out.println(s.getName());
        }
    }

    void printStudentsRegisteredInCourse(int i) {

        Course c1 = null;
        for (Course c : courseList) {
            if (c.getNumber() == i) {
                c1 = c;
                break;
            }
        }
        for (Student s : registerList) {
            if (c1 != null) {
                if ("yes".equals(s.isRegisteredInCourse(c1))) {
                    System.out.println(s.toString());
                }
            }
        }
    }

    String isStudentRegistered(Student emily) {
        if (registerList.contains(emily)) {
            return "yes";
        }
        return "No";
    }

    String largestCourse() {
        int large = -99;
        Course largestCourse = null;
        for (Course c : courseList) {
            if (c.getClassList().size() > large) {
                large = c.getClassList().size();
                largestCourse = c;
            }
        }
        if (largestCourse != null) {
            return largestCourse.getTitle();
        } else {
            return "Error finding largest course";
        }
    }

    @Override
    public String toString() {
        // returns a string representation of department name, number 
        // of courses offered and number of students registered in the
        // department. Use the format:
        // ECSE: 53 courses, 460 students

        String str = "Department. " + name + "\n"
                + +courseList.size() + " Courses " + registerList.size() + " Students";
        return str;
    }

}
