package hello.core.member;

public interface MemberService {

    // 회원들이 사용가능한 서비스
    // 로그인, 아이디찾기

    void join(Member member);

    Member findMember(Long memberId);
}
