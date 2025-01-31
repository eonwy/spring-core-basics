package kumaru.core.order;

import kumaru.core.discount.DiscountPolicy;
import kumaru.core.discount.FixDiscountPolicy;
import kumaru.core.discount.RateDiscountPolicy;
import kumaru.core.member.Member;
import kumaru.core.member.MemberRepository;
import kumaru.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    public final MemberRepository memberRepository = new MemoryMemberRepository();
//    public final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    public final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    public DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
