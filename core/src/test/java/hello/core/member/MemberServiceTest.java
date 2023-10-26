package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        // given 어떤 일이 주어졌고
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when 다음과 같은 방법으로 했을 떄
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then 다음과 같이 된다.
        Assertions.assertThat(member).isEqualTo(findMember);

    }
}
