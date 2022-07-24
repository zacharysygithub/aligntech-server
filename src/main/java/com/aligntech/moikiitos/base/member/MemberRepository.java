package com.aligntech.moikiitos.base.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
	Member getMemberByEmail(String email);
}
