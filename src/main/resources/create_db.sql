DROP TABLE IF EXISTS level CASCADE;
DROP TABLE IF EXISTS cms_user CASCADE;
DROP TABLE IF EXISTS class CASCADE;
DROP TABLE IF EXISTS wallet CASCADE;
DROP TABLE IF EXISTS team CASCADE;
DROP TABLE IF EXISTS codecooler CASCADE;
DROP TABLE IF EXISTS quest CASCADE;
DROP TABLE IF EXISTS codecooler_quests CASCADE;
DROP TABLE IF EXISTS artifact CASCADE;
DROP TABLE IF EXISTS codecooler_artifacts CASCADE;
DROP TABLE IF EXISTS team_artifacts CASCADE;

CREATE TABLE level(
	level_id serial PRIMARY KEY,
	name varchar(30) NOT NULL,
	description varchar(100) NOT NULL,
	price integer NOT NULL, 
	date_of_adding date NOT NULL DEFAULT CURRENT_DATE,
	picture_url varchar(100)
);


CREATE TABLE cms_user(
	cms_user_id serial PRIMARY KEY,
	name varchar(25) NOT NULL,
	email varchar(25) NOT NULL,
	password varchar(25) NOT NULL,
	city varchar(25) NOT NULL,
	date_of_adding date NOT NULL DEFAULT CURRENT_DATE,  
	picture_url varchar(100),
	is_admin BOOLEAN NOT NULL 
);


CREATE TABLE class(
	class_id serial PRIMARY KEY,
	name varchar(25) NOT NULL,
	city varchar(25) NOT NULL,
	start_date date NOT NULL,
	end_date date NOT NULL
);

CREATE TABLE wallet(
	wallet_id serial PRIMARY KEY,
	coins_total integer NOT NULL DEFAULT 0,
	coins_available integer NOT NULL DEFAULT 0
);

CREATE TABLE team(
	team_id serial PRIMARY KEY,
	name varchar(25) NOT NULL,
	city varchar(25) NOT NULL,
	start_date date NOT NULL
);

CREATE TABLE codecooler(
	codecooler_id serial PRIMARY KEY,
	name varchar(25) NOT NULL,
	email varchar(25) NOT NULL,
	password varchar(25) NOT NULL,
	city varchar(25) NOT NULL,
	date_of_adding date NOT NULL DEFAULT CURRENT_DATE, 	
	picture_url varchar(100),
	class_id integer,
	team_id integer,
	wallet_id integer NOT NULL,
	CONSTRAINT krzystof FOREIGN KEY (class_id)
	REFERENCES class (class_id)
	ON UPDATE CASCADE,
	CONSTRAINT grzegorz FOREIGN KEY (team_id)
	REFERENCES team (team_id)
	ON UPDATE CASCADE,
	CONSTRAINT andrzej FOREIGN KEY (wallet_id)
	REFERENCES wallet (wallet_id)
	ON UPDATE CASCADE
);

CREATE TABLE quest(
	quest_id serial PRIMARY KEY, 
	name varchar(50) NOT NULL, 
	desciption varchar(100) NOT NULL, 
	value integer,
	type BIT NOT NULL, 
	date_of_adding date NOT NULL DEFAULT CURRENT_DATE,
	picture_url varchar(100)
);


CREATE TABLE codecooler_quests(
	codecooler_quests_id serial PRIMARY KEY, 
	codecooler_id integer, 
	quest_id integer, 
	date_of_achieving date NOT NULL DEFAULT CURRENT_DATE,
	CONSTRAINT maciej FOREIGN KEY (codecooler_id) 
	REFERENCES codecooler(codecooler_id)
	ON UPDATE CASCADE,
	CONSTRAINT emil FOREIGN KEY (quest_id)
 	REFERENCES quest(quest_id)
	ON UPDATE CASCADE	
);

CREATE TABLE artifact(
	artifact_id serial PRIMARY KEY, 
	name varchar(50),
	description varchar(100),
	value integer, 
	type BIT, 
	date_of_adding date NOT NULL DEFAULT CURRENT_DATE,
	picture_url varchar(100)
);

CREATE TABLE codecooler_artifacts(
	codecooler_artifacts_id serial PRIMARY KEY, 
	codecooler_id integer, 
	artifact_id integer, 
	date_of_buying date NOT NULL DEFAULT CURRENT_DATE, 
	is_used boolean,
	CONSTRAINT mariusz FOREIGN KEY(codecooler_id) 
	REFERENCES codecooler(codecooler_id)
	ON UPDATE CASCADE,
	CONSTRAINT maciej FOREIGN KEY(artifact_id) 
	REFERENCES artifact(artifact_id)
	ON UPDATE CASCADE	
	);

CREATE TABLE team_artifacts(
	team_artifacts_id serial PRIMARY KEY, 
	team_id integer, 
	artifact_id integer, 
	date_of_buying date NOT NULL DEFAULT CURRENT_DATE, 
	is_used boolean,
	CONSTRAINT borys FOREIGN KEY(team_id) 
	REFERENCES team(team_id)
	ON UPDATE CASCADE,
	CONSTRAINT zbyszek FOREIGN KEY(artifact_id)
 	REFERENCES artifact(artifact_id)
	ON UPDATE CASCADE
);	

INSERT INTO cms_user
VALUES (default,'Jan Truskolaski','jtruskolaski@gmail.com','admin123','Krakow',TO_DATE('2020-01-01','YYYY-MM-DD'),'URL','Y');

INSERT INTO cms_user
VALUES (default,'Andrzej Szampan','aszampan@gmail.com','admin123','Krakow',TO_DATE('2020-01-01','YYYY-MM-DD'),'URL','Y');

INSERT INTO cms_user
VALUES (default,'Dominik Nowak','dnowak@gmail.com','admin123','Krakow',TO_DATE('2020-01-01','YYYY-MM-DD'),'URL','N');

INSERT INTO cms_user
VALUES (default,'Paweł Suryk','psuryk@gmail.com','admin123','Krakow',TO_DATE('2020-01-01','YYYY-MM-DD'),'URL','N');


INSERT INTO class 
values (default,'Class #1','Krakow',TO_DATE('2020-06-01','YYYY-MM-DD'),TO_DATE('2021-06-01','YYYY-MM-DD'));

INSERT INTO team
values(default,'Team #1 in Krakow','Krakow',TO_DATE('2020-07-07','YYYY-MM-DD'));

INSERT INTO wallet
values(default);

INSERT INTO codecooler
values(default,'Paweł Byczek',
'pbyczek@gmail.com',
'pbyczek123',
'Krakow',
TO_DATE('2020-06-01','YYYY-MM-DD'),
'mojezdjecie',
1,
1,
1);


INSERT INTO level
values(default,'Level 1 - Iron Maiden','Basic level on yuur journey','200',default,'level1.png');

INSERT INTO level
values(default,'Level 2 - Silver Warrior','You are getting stronger..','500',default,'level2.png');

INSERT INTO level
values(default,'Level 3 - Golden Level','Higher, higher.','1000',default,'level3.png');

INSERT INTO level
values(default,'Level 4 - Platinium Warrior','Halfway of the journey.','2500',default,'level4.png');

INSERT INTO level
values(default,'Level 5 - Stealth Ninja','Almost on the top.','5000',default,'level5.png');

INSERT INTO level
values(default,'Level 6 - Codecool Buddha','There is nothing more.','10000',default,'level6.png');

INSERT INTO quest
values(default,'Passing a checkpoint.','You have passed a checkopint.','500','0',default,'quest1.png');

INSERT INTO quest
values(default,'Spot a mistake in the assigment.','You fund a mistake in background materials.','500','1',default,'quest2.png');

INSERT INTO quest
values(default,'Do a demo for the class.','You did a demo for the class.','1000','1',default,'quest3.png');

INSERT INTO quest
values(default,'Take a part in student screening.','Blablabla','5000','1',default,'quest4.png');

INSERT INTO quest
values(default,'Attend a month without being late.','Always on time!','10000','1',default,'quest5.png');
	
INSERT INTO quest
values(default,'Set a smart Goal with your tutorial.','Blablabla','10000','1',default,'quest6.png');

INSERT INTO artifact
values(default,'Private mentoring.','Blablabla','500','0',default,'quest1.png');

INSERT INTO artifact
values(default,'Spend a day on home office.','Blablabla','500','0',default,'quest1.png');

INSERT INTO artifact
values(default,'Extend an SI deadline for a week. ','Blablabla','1000','0',default,'quest1.png');

INSERT INTO artifact
values(default,'60 minutes workshop by mentor.','Blablabla','5000','1',default,'quest1.png');

INSERT INTO artifact
values(default,'Mentor joins student for 1 hour.','Blablabla','10000','1',default,'quest1.png');

INSERT INTO artifact
values(default,'Extra materials for chosen topic','Blablabla','10000','1',default,'quest1.png');






