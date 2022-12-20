package hello.core.order;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceImplTest2 {

    @Test
    void createOrder(){
        MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();
        OrderServiceImpl orderService = new OrderServiceImpl(memoryMemberRepository,new FixDiscountPolicy());
        memoryMemberRepository.save(new Member(1L,"kkk", Grade.VIP));
        Order order = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
