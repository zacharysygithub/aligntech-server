package com.aligntech.moikiitos.custom.feed;

public class MemberWebDto {
	private int memberId;

	private int followMemberId;
	private String followName;
	private String followEmail;
	private boolean followerOfMember;
	private boolean followedByMember;

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getFollowMemberId() {
		return followMemberId;
	}
	public void setFollowMemberId(int followMemberId) {
		this.followMemberId = followMemberId;
	}

	public String getFollowName() {
		return followName;
	}
	public void setFollowName(String followName) {
		this.followName = followName;
	}

	public String getFollowEmail() {
		return followEmail;
	}
	public void setFollowEmail(String followEmail) {
		this.followEmail = followEmail;
	}

	public boolean isFollowerOfMember() {
		return followerOfMember;
	}
	public void setFollowerOfMember(boolean followerOfMember) {
		this.followerOfMember = followerOfMember;
	}

	public boolean isFollowedByMember() {
		return followedByMember;
	}
	public void setFollowedByMember(boolean followedByMember) {
		this.followedByMember = followedByMember;
	}
}
