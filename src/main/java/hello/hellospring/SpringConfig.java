package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// @Service 와 @Repository 와 같은 컴포넌트 스캔 외에도
// 자바 코드로 직접 스프링 빈(@Bean) 을 등록하여
// 별도로(SpringConfig) 관리할 수 있음
// 단, 컨트롤러는 @Autowired 로 같음
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
