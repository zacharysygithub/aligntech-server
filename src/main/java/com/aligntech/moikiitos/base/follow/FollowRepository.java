package com.aligntech.moikiitos.base.follow;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Integer> {
	List<Follow> getFollowingsByMemberId(int memberId);
	List<Follow> getFollowersByFollowMemberId(int followMemberId);
}
