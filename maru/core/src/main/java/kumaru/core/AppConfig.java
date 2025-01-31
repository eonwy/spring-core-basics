package kumaru.core;

import kumaru.core.discount.FixDiscountPolicy;
import kumaru.core.member.MemberService;
import kumaru.core.member.MemberServiceImpl;
import kumaru.core.member.MemoryMemberRepository;
import kumaru.core.order.OrderService;
import kumaru.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); // 생성자 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
