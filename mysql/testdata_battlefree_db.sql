/*
	Testdata for testing the database
*/

USE battlefree;

INSERT INTO player
(username, password, email, score, played_games)
VALUES
("iEzpeN", NULL, NULL, 0, 0),
("pNenad", NULL, NULL, 0, 0),
("mannebind", NULL,NULL, 0, 0),
("shicks", NULL, NULL, 0, 0);

INSERT INTO friend
(playerID, friend_playerID, accepted)
VALUES
(1, 2, true),
(2, 1, true),
(1, 3, true),
(3, 1, true),
(1, 4, false),
(2, 3, true),
(3, 2, true);

