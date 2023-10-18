package repository;

import java.util.List;
import java.util.Optional;

import domain.Member;

public interface MemberRepositoty {
	Member save(Member member);
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String name);
	List<Member> findAll();
}