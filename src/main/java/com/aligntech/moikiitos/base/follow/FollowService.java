package com.aligntech.moikiitos.base.follow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
	@Autowired
	FollowRepository repository;

	public List<Follow> getAll() {
		return repository.findAll();
	}
	public List<Follow> getFollowingsByMemberId(int memberId) {
		return repository.getFollowingsByMemberId(memberId);
	}

	public List<Follow> getFollowersByFollowMemberId(int followMemberId) {
		return repository.getFollowersByFollowMemberId(followMemberId);
	}

	public Follow addFollow(int memberId, int followMemberId) {
		Follow follow = new Follow();
		follow.setMemberId(memberId);
		follow.setFollowMemberId(followMemberId);
		return repository.save(follow);
	}

	public Follow removeFollow(int memberId, int followMemberId) {
		List<Follow> followings = repository.getFollowingsByMemberId(memberId);
		Follow result = followings.stream().filter(following -> following.getFollowMemberId() == followMemberId).findFirst().orElse(null);
		if (result != null) {
			repository.deleteById(result.getId());
		}
		return result;
	}
}
