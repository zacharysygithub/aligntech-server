package com.aligntech.moikiitos.base.follow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.aligntech.moikiitos.base.follow.Follow;
import com.aligntech.moikiitos.base.follow.FollowService;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class FollowServiceTest {
	@Autowired
	FollowService service;

	@Test
	public void testInitialData() {
		List<Follow> followers = service.getFollowersByFollowMemberId(1);

		assertEquals(3, followers.size());
		assertTrue(followers.stream().anyMatch(ff -> ff.getMemberId() == 2));
		assertTrue(followers.stream().anyMatch(ff -> ff.getMemberId() == 3));
		assertTrue(followers.stream().anyMatch(ff -> ff.getMemberId() == 4));

		List<Follow> subs = service.getFollowingsByMemberId(1);
		assertEquals(2, subs.size());
		assertTrue(subs.stream().anyMatch(sub -> sub.getFollowMemberId() == 2));
		assertTrue(subs.stream().anyMatch(sub -> sub.getFollowMemberId() == 4));
	}

	@Test
	public void testSubscribe() {
		service.addFollow(3, 4);
		List<Follow> subs = service.getFollowingsByMemberId(3);
		assertEquals(2, subs.size());
		assertTrue(subs.stream().anyMatch(sub -> sub.getFollowMemberId() == 4));
	}
}
