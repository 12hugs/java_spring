package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // 로그인 및 회원가입을 하면 일단 인터페이스를 가지게 되고, 만약 값이 null포인트 인셉션이 나지 않는다면,
    // 정상적으로 로그인 및 회원가입이 완료되었다는 뜻이므로 그렇게 개발을 진행해야한다.

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
