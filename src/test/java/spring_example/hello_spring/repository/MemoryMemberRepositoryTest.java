package spring_example.hello_spring.repository;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import spring_example.hello_spring.domain.Member;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        // 서로 다른 테스트 간에는 의존관계가 없어야 함
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("Spring");

        repository.save(member);

        // Optional에서는 get()으로 값을 꺼내올 수 있음
        // 좋은 방법은 아니지만 테스트니까 사용
        Member result = repository.findById(member.getId()).get();

        // 테스트 결과 검증
        System.out.println("result = " + (result == member));
        Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member result = repository.findByName("Spring2").get();

        Assertions.assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("Spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("Spring2");
        repository.save(member2);

        Member member3 = new Member();
        member3.setName("Spring3");
        repository.save(member3);

        List<Member> result = repository.findAll();

        Assertions.assertThat(result.size()).isEqualTo(3);
    }
}
