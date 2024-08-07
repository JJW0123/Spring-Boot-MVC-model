package spring_example.hello_spring.controller;

import org.springframework.stereotype.Controller;

import spring_example.hello_spring.service.MemberService;

@Controller
public class MemberController {
    /*
     * 1.필드주입(멤버 서비스 변경 불가능함)
     * 
     * @Autowired private final MemberService memberService;
     */
    private final MemberService memberService;

    /*
     * 2.setter 주입(public으로 내내 노출되어있어 변경의 위험)
     * 
     * @Autowired
     * public void setMemberController(MemberService memberService) {
     * this.memberService = memberService;
     * }
     */

    /*
     * 3.생성자 주입
     */
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
