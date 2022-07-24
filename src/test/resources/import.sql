INSERT INTO member(name, email, password) VALUES ('member1', 'm1@test.com', 'pass1');
INSERT INTO member(name, email, password) VALUES ('member2', 'm2@test.com', 'pass2');
INSERT INTO member(name, email, password) VALUES ('member3', 'm3@test.com', 'pass3');
INSERT INTO member(name, email, password) VALUES ('member4', 'm4@test.com', 'pass4');

INSERT INTO post(member_id, message, timestamp) VALUES(1, 'Greetings, I am member one!', '2022-01-01 00:00:00');
INSERT INTO post(member_id, message, timestamp) VALUES(1, 'Nice to meet you!', '2022-01-02 00:00:00');
INSERT INTO post(member_id, message, timestamp) VALUES(1, 'Today is my birthday', '2022-01-03 00:00:00');

INSERT INTO post(member_id, message, timestamp) VALUES(2, 'Greetings, I am member two!', '2022-01-01 01:00:00');
INSERT INTO post(member_id, message, timestamp) VALUES(2, 'Nice to meet you too!', '2022-01-02 01:00:00');
INSERT INTO post(member_id, message, timestamp) VALUES(2, 'Happy Birthday member one', '2022-01-03 01:00:00');

INSERT INTO post(member_id, message, timestamp) VALUES(4, 'Greetings, I am member four!', '2022-01-01 03:00:00');
INSERT INTO post(member_id, message, timestamp) VALUES(4, 'Very happy to be here!', '2022-01-02 03:00:00');
INSERT INTO post(member_id, message, timestamp) VALUES(4, 'Here is a gift for you member one', '2022-01-03 03:00:00');

INSERT INTO follow(member_id, follow_member_id) VALUES (1, 2);
INSERT INTO follow(member_id, follow_member_id) VALUES (1, 4);
INSERT INTO follow(member_id, follow_member_id) VALUES (2, 1);
INSERT INTO follow(member_id, follow_member_id) VALUES (3, 1);
INSERT INTO follow(member_id, follow_member_id) VALUES (4, 1);