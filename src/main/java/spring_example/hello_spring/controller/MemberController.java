package spring_example.hello_spring.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import spring_example.hello_spring.domain.Member;
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

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }

}
