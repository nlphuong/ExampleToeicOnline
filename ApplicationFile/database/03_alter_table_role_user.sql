use toeiconline;

alter table user add column roleid bigint;

alter table user add constraint fk_user_role foreign key (roleid) references role(roleid);

alter table comment add constraint fk_user_comment foreign key (userid) references user(userid);

alter table comment add constraint fk_listenguideline_comment foreign key (listenguidelineid) references listenguideline(listenguidelineid);