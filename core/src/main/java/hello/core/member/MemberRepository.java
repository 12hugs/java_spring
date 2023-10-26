package hello.core.member;

public interface MemberRepository {

    // 인터페이스를 설정해줌으로써 다른 곳에서는 오버라이딩을 통해서 상속을 받아
    // 그냥 구현만 하면 된다.

    // 인터페이스 구축을 잘 해놔야 개발의 종지부를 맞이할 때까지 편하게 관리를 할 수 있음.

    void save(Member member);

    Member findById(Long memberId);
}
