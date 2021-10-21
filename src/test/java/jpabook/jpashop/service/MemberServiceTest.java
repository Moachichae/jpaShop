package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) //junit 시작할때 스프링이랑 엮어서 시작하겠다는것.
@SpringBootTest //스프링 안에서 테스트를 돌리겠다는 것.
@Transactional //커밋이 된 후 insert 를 하는데 하기전 롤백을 자동으로 함.
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    public void 회원가입() throws Exception {
        //given
        Member member = new Member();
        member.setName("kim");

        //when
        Long savedId = memberService.join(member);

        //then
        em.flush();
        assertEquals(member, memberRepository.findOne(savedId));
        //같은 pk를 가지면 같은 영속성 컨텍스트에서 관리가 되므로 true 가 나옴
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        //given
        Member member1 = new Member();
        member1.setName("kim1");

        Member member2 = new Member();
        member2.setName("kim1");
        //when
        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야 한다!!!

        //then
        fail("예외가 발생해야 한다.");
    }

}