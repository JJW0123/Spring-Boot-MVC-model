package spring_example.hello_spring.service;

import java.util.List;
import java.util.Optional;

import spring_example.hello_spring.domain.Member;
import spring_example.hello_spring.repository.MemberRepository;

public class MemberService {

    private final MemberRepository memberRepository;

    // 4.3부터 생성자가 하나라면 @Autowired 생략 가능
    // @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 이름이 같은 중복 회원 금지(예외처리)
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // orElseGet()을 사용하기도 함
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("같은 이름의 회원이 존재함.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}