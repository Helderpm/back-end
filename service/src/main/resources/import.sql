insert into CLIENT (name) values ('steve.jobs');

insert into ACCOUNT (code, balance, owner_id) values ('14451', 100, (select id from CLIENT where name = 'steve.jobs'));