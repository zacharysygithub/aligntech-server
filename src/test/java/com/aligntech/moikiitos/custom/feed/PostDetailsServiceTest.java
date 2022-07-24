package com.aligntech.moikiitos.custom.feed;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
public class PostDetailsServiceTest {
	@Autowired
	PostDetailsService service;

	@Test
	public void testInitialData() {
		List<PostDetails> feed = service.getFeed(1, LocalDateTime.of(LocalDate.of(1900, 01, 01), LocalTime.MIN));
		assertNotNull(feed);
		assertEquals(9, feed.size());
		feed.forEach(f -> {
			System.out.println(f.getMemberId() + "/" + f.getName() + ") == " + f.getEmail() + "/" + f.getMessage() + " T " + f.getTimestamp());
		});
	}
}
