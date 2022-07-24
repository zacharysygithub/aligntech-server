package com.aligntech.moikiitos.custom.feed;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aligntech.moikiitos.base.follow.Follow;
import com.aligntech.moikiitos.base.follow.FollowService;
import com.aligntech.moikiitos.base.member.Member;
import com.aligntech.moikiitos.base.member.MemberService;

@CrossOrigin
@RestController
@RequestMapping("/subs")
public class SubscriptionController {
	@Autowired
	MemberService memberService;
	@Autowired
	FollowService followService;

	@GetMapping("/members")
	public ResponseEntity<List<MemberWebDto>> getFollowers(@RequestParam(value="id") int memberId) {
		List<MemberWebDto> results = new ArrayList<>();

		List<Member> members = memberService.getAllMembers();

		List<Follow> followers = followService.getFollowersByFollowMemberId(memberId);
		List<Integer> followerIds = followers.stream().map(follower -> follower.getMemberId()).collect(Collectors.toList());

		List<Follow> followings = followService.getFollowingsByMemberId(memberId);
		List<Integer> followingIds = followings.stream().map(following -> following.getFollowMemberId()).collect(Collectors.toList());

		members.forEach(member -> {
			if (member.getId() == memberId) return;

			MemberWebDto result = new MemberWebDto();
			result.setMemberId(memberId);
			result.setFollowMemberId(member.getId());
			result.setFollowName(member.getName());
			result.setFollowEmail(member.getEmail());
			if (followerIds.contains(member.getId())) result.setFollowerOfMember(true);
			if (followingIds.contains(member.getId())) result.setFollowedByMember(true);

			results.add(result);
		});
		members.forEach(result -> result.setPassword(""));

		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@PostMapping("/follow")
	public ResponseEntity<Follow> follow(@RequestBody MemberWebDto member) {
		Follow result = followService.addFollow(member.getMemberId(), member.getFollowMemberId());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/unfollow")
	public ResponseEntity<Follow> unfollow(@RequestBody MemberWebDto member) {
		Follow result = followService.removeFollow(member.getMemberId(), member.getFollowMemberId());
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}
