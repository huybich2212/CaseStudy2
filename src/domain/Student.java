package domain;

public class Student implements Comparable<Student> {
    private String id;
    private String name;
    private int yearBirth;
    private float point;

    public Student() {
        this.id = id;
    }

    public Student(String id, String name, int yearBirth, float point) {
        this.id = id;
        this.name = name;
        this.yearBirth = yearBirth;
        this.point = point;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(int yearBirth) {
        this.yearBirth = yearBirth;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", yearBirth=" + yearBirth +
                ", point=" + point +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return 0;
    }

    public void input() {
    }
}


