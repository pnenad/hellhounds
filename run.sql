drop schema battlefree;

create schema battlefree;

use battlefree;

create table player(
id int not null auto_increment,
name varchar(45),
score int(11),
constraint player_id primary key (id)
) engine=innodb;

create table friend(
player_id int not null,
friend_id int not null,
matches int(11),
accepted int(1),
constraint friend_pk primary key (player_id, friend_id),
constraint player_fk foreign key (player_id) references player(id),
constraint friend_fk foreign key (friend_id) references player(id)
) engine=inndodb;

insert into player (name, score) values("Nenad", 151);
insert into player (name, score) values("Espen", 155);
insert into player (name, score) values("Endre", 166);
