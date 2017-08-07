select * from person;
select * from category;
select * from board;
select * from thread;
select * from reply;
select * from board_administrator;
delete from thread where id=14;
select board_id from board_administrator where person_id=2;
update board set threadCount=0 ,last_thread_id=null where id=8;
select id,name from board where id in (select board_id from board_administrator where person_id=2);
select account from person where id in (select person_id from board_administrator where board_id=3);
select count(*) from thread where board_id=4;


select id from thread where dateCreated =(select max(dateCreated) from (select * from thread where title='莎士比亚的文学之路') lsb);
