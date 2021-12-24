create table members(
id VARCHAR(20) NOT NULL Primary Key,
passwd VARCHAR(20) NOT NULL,
username VARCHAR(20) NOT NULL,
mobile VARCHAR(15) NOT NULL, 
address VARCHAR(30),
email VARCHAR(30)
);

create table message(
id VARCHAR(20) NOT NULL Primary Key, 
email VARCHAR(30),
message varchar(300)
);


