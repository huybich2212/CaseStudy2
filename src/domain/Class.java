package domain;

public class Class {

    private Long id;
    private String name;
    private String teacherName;

    public Class() {
    }

    public Class(Long id, String name, String teacherName) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "Class{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
