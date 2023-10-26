package hello.core.member;

public class Member {

    private Long id;
    private String name;
    private Grade grade;

    // lombok이 없으므로 생성자 메소드 만들어주기

    public Member(Long id, String name, Grade grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    // lombok은 아직 하지 않았으므로 getter와 setter 만들어주기

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Grade getGrade() {
        return grade;
    }
}
