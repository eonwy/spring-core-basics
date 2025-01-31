package kumaru.core;

import kumaru.core.member.Grade;
import kumaru.core.member.Member;
import kumaru.core.member.MemberService;
import kumaru.core.member.MemberServiceImpl;
import kumaru.core.order.Order;
import kumaru.core.order.OrderService;
import kumaru.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "MemberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
