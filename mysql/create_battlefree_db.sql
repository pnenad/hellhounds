/* 
	Create BattleFree database (MySQL)
	
	Version: 0.02
*/

/* Database name */
CREATE SCHEMA battlefree;

USE battlefree;

/* Creates player table */
CREATE TABLE player(
playerID	INTEGER NOT NULL AUTO_INCREMENT,
username	VARCHAR(20) NOT NULL UNIQUE,
password	VARCHAR(80),
email		VARCHAR(50) UNIQUE,
score		LONG,
played_games 	INTEGER,

CONSTRAINT playerID_pk PRIMARY KEY(playerID)
);


/* Creates friend table 
	Both player must add the other to their friendlist. 
	If not only one will be friend with the other.
*/
CREATE TABLE friend(
playerID 	INTEGER NOT NULL,
friend_playerID INTEGER NOT NULL,
accepted	BOOLEAN,

CONSTRAINT friend_pk PRIMARY KEY(playerID, friend_playerID),
CONSTRAINT playerID_fk FOREIGN KEY(playerID) REFERENCES player(playerID)
ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT friend_playerID_fk FOREIGN KEY(friend_playerID) REFERENCES player(playerID)
ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE VIEW pendingfriends AS
SELECT username,
(SELECT username FROM player WHERE player.playerID=friend.friend_playerID) AS friend 
FROM player JOIN friend 
ON player.playerID=friend.playerID 
AND friend.accepted = 0;

CREATE VIEW acceptedfriends AS
SELECT username,
(SELECT username FROM player WHERE player.playerID=friend.friend_playerID) AS friend 
FROM player JOIN friend 
ON player.playerID=friend.playerID 
AND friend.accepted = 1;

/* 	TODO: (1) ....
*/

