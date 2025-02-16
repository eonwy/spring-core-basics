package kumaru.core.discount;

import kumaru.core.annotation.MainDiscountPolicy;
import kumaru.core.member.Grade;
import kumaru.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Qualifier("mainDiscountPolicy")
@MainDiscountPolicy
@Primary
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }

}
