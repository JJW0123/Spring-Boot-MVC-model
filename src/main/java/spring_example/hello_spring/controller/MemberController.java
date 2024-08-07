package spring_example.hello_spring.controller;

import org.springframework.stereotype.Controller;

import spring_example.hello_spring.service.MemberService;

@Controller
public class MemberController {
    private final MemberService memberService;

    // 4.3부터 생성자가 하나라면 @Autowired 생략 가능
    // @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 임시
    public int ex() {
        memberService.join(null);
        return 1;
    }
}
