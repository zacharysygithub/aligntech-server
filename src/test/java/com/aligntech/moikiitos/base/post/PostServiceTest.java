package com.aligntech.moikiitos.base.post;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class PostServiceTest {
	@Autowired
	PostService service;

	@Test
	public void checkInitialData() {
		List<Post> m1Posts = service.getPostsByMemberId(1);
		assertEquals(3, m1Posts.size());
	}

	@Test
	public void addPost() {
		service.addPost(3, "Hello I'm member three");
		Post secondPost = service.addPost(3, "Nice to meet all of you!");
		List<Post> m3Posts = service.getPostsByMemberId(3);
		assertEquals(2, m3Posts.size());
		Post greeting = m3Posts.stream().filter(post -> "Nice to meet all of you!".equals(post.getMessage())).findFirst().orElse(null);
		assertEquals(secondPost.getMessage(), greeting.getMessage());
	}
}
