package com.aligntech.moikiitos.base.member;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class MemberServiceTest {
	@Autowired
	MemberService service;

	@Test
	public void checkInitialUsers() {
		assertEquals(4, service.getAllMembers().size());
		Member member = service.getMemberByEmail("m2@test.com");
		assertEquals("member2", member.getName());
	}

	@Test
	public void createNewMember() {
		String email = "email@address.com";
		Member incoming = service.addMember("name", email, "password");
		Member existing = service.getMemberByEmail(email);
		assertEquals(incoming.getName(), existing.getName());
	}
}
