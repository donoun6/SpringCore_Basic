package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order create(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId); //멤버 찾고
        int discountPrice = discountPolicy.discount(member, itemPrice);
        //오더 서비스입장에서는 할인정책에 대해 모른다. 디스카운트폴리시가 알아서 해줘 라고 설계한것. 단일 책임원칙을 잘 지켰다.

        //주문생성 요청이 오면 회원 정보를 먼저 조회를 하고 할인정책에다가 회원을 넘긴다.
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}


