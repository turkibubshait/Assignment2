package pkg;

import java.util.ArrayList;

public class Student {

    private final String id;
    private final String name;
    private final ArrayList<Course> courses; // contains all courses the student is registered in

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        courses = new ArrayList<>();
    }

    @Override
    public String toString() {
        // return a string representation of a student using the following format:
        // 100234546 John McDonald
        // Registered courses: ELEE 2110, ELEE 2790, SOFE 2710, SOFE 2800, SOFE 2850
        String str = id + "\nCourses : ";
        for (Course c : courses) {
            str = str + c.getTitle() + " ";
        }
        return str;
    }

    public void registerFor(Course c) {

        courses.add(c);

    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the courses
     */
    public ArrayList<Course> getCourses() {
        return courses;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    String isRegisteredInCourse(Course sofe2710) {
        if (courses.contains(sofe2710)) {
            return "yes";
        } else {
            return "No";
        }
    }
}
