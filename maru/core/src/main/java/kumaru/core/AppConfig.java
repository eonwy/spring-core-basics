package kumaru.core;

import kumaru.core.discount.DiscountPolicy;
import kumaru.core.discount.FixDiscountPolicy;
import kumaru.core.discount.RateDiscountPolicy;
import kumaru.core.member.MemberService;
import kumaru.core.member.MemberServiceImpl;
import kumaru.core.member.MemoryMemberRepository;
import kumaru.core.order.OrderService;
import kumaru.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
