DROP TABLE IF EXISTS level CASCADE;
DROP TABLE IF EXISTS cms_user CASCADE;
DROP TABLE IF EXISTS class CASCADE;
DROP TABLE IF EXISTS wallet CASCADE;
DROP TABLE IF EXISTS team CASCADE;
DROP TABLE IF EXISTS codecooler CASCADE;


CREATE TABLE level(
	level_id serial PRIMARY KEY,
	name varchar(25) NOT NULL,
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


INSERT INTO class 
values (default,'first class','krakow',TO_DATE('2020-07-07','YYYY-MM-DD'),TO_DATE('2021-07-07','YYYY-MM-DD'));

INSERT INTO team
values(default,'first team','krakow',TO_DATE('2020-07-07','YYYY-MM-DD'));

INSERT INTO wallet
values(default);

INSERT INTO codecooler
values(default,'jan kowalski',
'ads@gmail.com',
'haslo123',
'krakow',
TO_DATE('2020-07-07','YYYY-MM-DD'),
'mojezdjecie',
1,
1,
1);

select codecooler.name,
	codecooler.codecooler_id,
	wallet.coins_total,
	wallet.coins_available
FROM codecooler
INNER JOIN wallet ON codecooler.wallet_id = wallet.wallet_id;



