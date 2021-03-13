package com.playground.mall.service;

import com.playground.mall.entity.Member;
import com.playground.mall.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    public void 회원가입() throws Exception {
        // Given
        Member member = new Member("kim");

        // When
        Long saveId = memberService.join(member);

        Member savedMember = memberRepository.findById(saveId).orElseGet(null);

        // That
        assertEquals(saveId, savedMember.getId());
    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception {
        // Given
        Member member1 = new Member("kim");
        Member member2 = new Member("kim");

        // When
        memberService.join(member1);
        memberService.join(member2);

        fail("예외가 발생해야 한다");
    }

}