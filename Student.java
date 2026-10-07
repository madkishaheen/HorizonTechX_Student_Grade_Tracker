import java.util.ArrayList;

public class Student {

    private String name;
    private String studentId;

    private ArrayList<String> subjects;
    private ArrayList<Double> marks;

    // Constructor
    public Student(
            String name,
            String studentId,
            ArrayList<String> subjects,
            ArrayList<Double> marks) {

        this.name = name;
        this.studentId = studentId;
        this.subjects = subjects;
        this.marks = marks;
    }

    // Get student name
    public String getName() {
        return name;
    }

    // Get student ID
    public String getStudentId() {
        return studentId;
    }

    // Get subjects
    public ArrayList<String> getSubjects() {
        return subjects;
    }

    // Get marks
    public ArrayList<Double> getMarks() {
        return marks;
    }

    // Calculate total marks
    public double getTotalMarks() {

        double total = 0;

        for (double mark : marks) {
            total += mark;
        }

        return total;
    }

    // Calculate average
    public double getAverage() {

        if (marks.isEmpty()) {
            return 0;
        }

        return getTotalMarks() / marks.size();
    }

    // Find highest score
    public double getHighestScore() {

        if (marks.isEmpty()) {
            return 0;
        }

        double highest = marks.get(0);

        for (double mark : marks) {

            if (mark > highest) {
                highest = mark;
            }
        }

        return highest;
    }

    // Find lowest score
    public double getLowestScore() {

        if (marks.isEmpty()) {
            return 0;
        }

        double lowest = marks.get(0);

        for (double mark : marks) {

            if (mark < lowest) {
                lowest = mark;
            }
        }

        return lowest;
    }

    // Calculate grade
    public String getGrade() {

        double average = getAverage();

        if (average >= 90) {
            return "A+";
        }
        else if (average >= 80) {
            return "A";
        }
        else if (average >= 70) {
            return "B";
        }
        else if (average >= 60) {
            return "C";
        }
        else if (average >= 50) {
            return "D";
        }
        else {
            return "F";
        }
    }

    // Performance message
    public String getPerformanceMessage() {

        double average = getAverage();

        if (average >= 90) {
            return "Outstanding performance!";
        }
        else if (average >= 80) {
            return "Excellent performance!";
        }
        else if (average >= 70) {
            return "Very good performance.";
        }
        else if (average >= 60) {
            return "Good performance.";
        }
        else if (average >= 50) {
            return "You passed. Keep improving.";
        }
        else {
            return "Needs improvement.";
        }
    }
}