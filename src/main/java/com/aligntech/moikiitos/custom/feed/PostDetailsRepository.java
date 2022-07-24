package com.aligntech.moikiitos.custom.feed;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PostDetailsRepository extends CrudRepository<PostDetails, Integer> {
	@Query(
		value = 
			"SELECT * FROM (" + 
				"SELECT " +
					"p.id, " + 
					"m.id AS member_id, " +
					"m.name, " +
					"m.email, " +
					"p.message, " +
					"p.timestamp " +
				"FROM follow f " + 
				"INNER JOIN member m ON f.follow_member_id = m.id " + 
				"INNER JOIN post p ON f.follow_member_id = p.member_id " +
				"WHERE f.member_id = :member_id " + 
				"UNION " + 
				"SELECT " + 
					"p.id, " +
					"m.id AS member_id, " +
					"m.name, " +
					"m.email, " +
					"p.message, " +
					"p.timestamp " +
				"FROM member m " +
				"INNER JOIN post p ON m.id = p.member_id " +
				"WHERE m.id = :member_id " + 
			") tbl " + 
			"WHERE timestamp > :timestamp " + 
			"ORDER BY 6 DESC ",
		nativeQuery = true
	)
	List<PostDetails> getPostDetails(@Param("member_id") Integer memberId, @Param("timestamp") LocalDateTime timestamp);
}
