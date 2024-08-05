package spring_example.hello_spring.repository;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import spring_example.hello_spring.domain.Member;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    // 실무에서는 동시성 문제로 concurrentHashMap을 사용
    private static Map<Long, Member> store = new HashMap<>();
    // 실무에서는 동시성 문제로 AtomicLong을 사용
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> member.getName().equals(name)).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
