package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    // 컴포넌트 스캔을 통한 자동 의존관계 주입
    // 컨테이너에서 MemberService를 가져와
    // 한개만(Singleton) 사용할 수 있도록 관리
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
