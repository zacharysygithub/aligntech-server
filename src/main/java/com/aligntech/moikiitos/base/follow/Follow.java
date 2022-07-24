package com.aligntech.moikiitos.base.follow;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="follow")
public class Follow {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="member_id")
	private int memberId;

	@Column(name="follow_member_id")
	private int followMemberId;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

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
}