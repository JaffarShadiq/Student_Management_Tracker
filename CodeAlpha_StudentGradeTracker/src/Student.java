import java.util.ArrayList;
import java.util.List;

/** Represents one student and the grades entered for that student. */
public class Student {
    private final String name;
    private final List<Double> grades = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public int getGradeCount() {
        return grades.size();
    }

    public double getAverage() {
        if (grades.isEmpty()) {
            return 0;
        }
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }

    public double getHighestGrade() {
        double highest = Double.NEGATIVE_INFINITY;
        for (double grade : grades) {
            highest = Math.max(highest, grade);
        }
        return grades.isEmpty() ? 0 : highest;
    }

    public double getLowestGrade() {
        double lowest = Double.POSITIVE_INFINITY;
        for (double grade : grades) {
            lowest = Math.min(lowest, grade);
        }
        return grades.isEmpty() ? 0 : lowest;
    }

    public String getLetterGrade() {
        double average = getAverage();
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    public List<Double> getGrades() {
        return new ArrayList<>(grades);
    }
}
