package com.aligntech.moikiitos.base.post;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
	List<Post> getPostsByMemberId(int memberId);
}
