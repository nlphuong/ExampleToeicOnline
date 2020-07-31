create table user(
	userid bigint not null primary key auto_increment,
    name varchar(255),
    password varchar(255),
    fullname varchar(300),
    createdDate timestamp
);

create table role(
	roleid bigint not null primary key,
    name varchar(100)
);

create table listenguideline(
    listenguidelineid bigint not null primary key auto_increment,
    title varchar(512),
    image varchar(255),
    content text,
    createdDate timestamp,
    modifiedDate timestamp
);

create table comment(
    commentid bigint not null primary key auto_increment,
    content text,
    userid bigint,
    listenguidelineid bigint,
    createdDate timestamp
);