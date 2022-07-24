package com.aligntech.moikiitos.custom.feed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aligntech.moikiitos.base.post.Post;
import com.aligntech.moikiitos.base.post.PostService;

@CrossOrigin
@RestController
@RequestMapping("/feed")
public class FeedController {
	@Autowired
	PostService postService;
	@Autowired
	PostDetailsService postDetailsService;

	@GetMapping("/posts")
	public ResponseEntity<List<PostDetails>> getFeed(
			@RequestParam(value="id") int memberId, 
			@RequestParam(value="timestamp", required=false)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime timestamp) {
		LocalDateTime dateTime = timestamp == null ? LocalDateTime.of(LocalDate.of(1970, 01, 01), LocalTime.MIN) : timestamp;
		List<PostDetails> results = postDetailsService.getFeed(memberId, dateTime);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@PostMapping("/postMessage")
	public ResponseEntity<Post> postMessage(@RequestBody Post post) {
		Post result = postService.addPost(post.getMemberId(), post.getMessage());
		return new ResponseEntity<>(result, HttpStatus.CREATED);
	}

}
