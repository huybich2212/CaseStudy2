package domain;

public class Student {

    private Long id;
    private String name;
    private Integer age;
    private Integer gender;
    private String classId;

    public Student(Long id, String name, Integer age, Integer gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.classId = classId;
    }

    public Student(int name, Object o, String classId) {
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer isGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", classId='" + classId + '\'' +
                '}';
    }
}
