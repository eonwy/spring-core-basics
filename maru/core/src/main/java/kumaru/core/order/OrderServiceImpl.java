package kumaru.core.order;

import kumaru.core.discount.DiscountPolicy;
import kumaru.core.member.Member;
import kumaru.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    public final MemberRepository memberRepository;
    public final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
