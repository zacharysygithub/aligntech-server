package com.aligntech.moikiitos.custom.feed;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostDetailsService {
	@Autowired
	PostDetailsRepository repository;

	public List<PostDetails> getFeed(int memberId, LocalDateTime timestamp) {
		return repository.getPostDetails(memberId, timestamp);
	}
}
