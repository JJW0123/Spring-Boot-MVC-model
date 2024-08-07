package spring_example.hello_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring_example.hello_spring.repository.MemberRepository;
import spring_example.hello_spring.repository.MemoryMemberRepository;
import spring_example.hello_spring.service.MemberService;

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
