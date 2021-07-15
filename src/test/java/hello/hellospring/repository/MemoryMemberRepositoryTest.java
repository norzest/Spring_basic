package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 각각의 메소드가 끝날 때마다 해당 작업 실행
    @AfterEach
    public void afterEach() {
        // 메소드가 실행돼고 끝날떄바다 repository를 지워줌
        repository.clearStore();
    }

    @Test
    public void save() {
        // 멤버 클래스 생성 후 저장
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        // 검증 (false면 오류뜸)
        // == assertThat(member).isEqualTo(result);
        // 위의 코드랑 서로 다른 Assertions임(위에껀 import 참조)
        Assertions.assertEquals(result, member);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
