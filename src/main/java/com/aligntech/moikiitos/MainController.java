package com.aligntech.moikiitos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aligntech.moikiitos.base.member.Member;
import com.aligntech.moikiitos.base.member.MemberService;

@CrossOrigin
@RestController
public class MainController {
	@Autowired
	MemberService memberService;

	@GetMapping("/login")
	public ResponseEntity<Member> getMember(@RequestParam(value="email") String email, @RequestParam(value="password") String password) {
		Member result = memberService.getMemberByEmail(email);
		if (result != null && result.getPassword().equals(password)) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(new Member(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/register")
	public ResponseEntity<Member> addMember(@RequestBody Member member) {
		Member existing = memberService.getMemberByEmail(member.getEmail());
		if (existing != null) {
			return new ResponseEntity<>(new Member(), HttpStatus.CONFLICT);
		}

		Member result = memberService.addMember(member.getName(), member.getEmail(), member.getPassword());
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}
}
