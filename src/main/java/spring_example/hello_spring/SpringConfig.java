package spring_example.hello_spring;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring_example.hello_spring.repository.JdbcMemberRepository;
import spring_example.hello_spring.repository.MemberRepository;
import spring_example.hello_spring.service.MemberService;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    // @Autowired 생성자 하나라 생략
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new JdbcMemberRepository(dataSource);
    }
}
