public class Student {
    String name;
    int[] grades;
    double AvgGrade;

    public Student(String name, int subjectCount) {
        this.name = name;
        this.grades = new int[subjectCount];
    }

    public void setGrade(int index, int grade) {
        grades[index] = grade;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        this.AvgGrade = (double) sum / grades.length;
        return AvgGrade;
    }

    public boolean isPassed() {
        return AvgGrade >= 6;
    }
}