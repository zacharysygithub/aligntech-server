package com.aligntech.moikiitos.base.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	MemberRepository repository;

	public List<Member> getAllMembers() {
		List<Member> results = new ArrayList<>();
		repository.findAll().forEach(results::add);
		return results;
	}

	public Member getMemberByEmail(String email) {
		return repository.getMemberByEmail(email);
	}

	public Member addMember(String name, String email, String password) {
		Member m = new Member();
		m.setName(name);
		m.setEmail(email);
		m.setPassword(password);
		return repository.save(m);
	}
}
