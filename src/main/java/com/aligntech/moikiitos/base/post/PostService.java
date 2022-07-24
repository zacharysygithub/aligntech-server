package com.aligntech.moikiitos.base.post;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	@Autowired
	PostRepository repository;

	public List<Post> getPostsByMemberId(int memberId) {
		return repository.getPostsByMemberId(memberId);
	}

	public Post addPost(int memberId, String message) {
		Post post = new Post();
		post.setMemberId(memberId);
		post.setMessage(message);
		post.setTimestamp(LocalDateTime.now());
		return repository.save(post);
	}
}
