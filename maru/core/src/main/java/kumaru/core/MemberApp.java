package kumaru.core;

import kumaru.core.member.Grade;
import kumaru.core.member.Member;
import kumaru.core.member.MemberService;
import kumaru.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appconfig = new AppConfig();
        MemberService memberService = appconfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member);
        System.out.println("find findMember = " + findMember);

    }
}
