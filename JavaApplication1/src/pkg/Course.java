package pkg;

import java.util.ArrayList;

public class Course {

    private final Department dept;
    private final String title; // title of the course (e.g. �Intro to programming�);
    private final String code; // course code, e.g. SOFE, ELEE, MANE, etc.
    private final int number; // course number, e.g. 1200, 2710, 2800, etc.
    private ArrayList<Course> classList; // contains all students registered in this course

    public Course(String code,int number,Department dept,String title) {
        this.dept = dept;
        this.title = title;
        this.code = code;
        this.number = number;
        this.classList = new ArrayList<>();
    }

    public String getDept() {
        return dept.getName();
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
     // return a string representation of the course with the course code,
        // name, and number of people registered in the course in the following
        // format:
        // SOFE 2710 Object Oriented Programming and Design, Enrollment = 260

        String str = code + " " + getNumber() + " " + getTitle() + ", Enrollment = " + getClassList().size();
        return str;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return the classList
     */
    public ArrayList<Course> getClassList() {
        return classList;
    }
}
