
/* Drop Tables */

DROP TABLE IF EXISTS AddressBook;


create sequence serial_addressbook_nm_seq owned by AddressBook.num;

alter AddressBook.num set default nextval('num');



/* Create Tables */
alter table AddressBook alter column num set int DEFAULT 1 NOT NULL UNIQUE
alter table AddressBook alter column num type int

CREATE UNIQUE INDEX CONCURRENTLY equipment_num
ON AddressBook (num);

ALTER TABLE AddressBook 
ADD CONSTRAINT unique_num 
UNIQUE USING INDEX equipment_num;

alter table AddressBook alter column num add constraint UNIQUE
int DEFAULT 1 NOT NULL UNIQUE
CREATE TABLE AddressBook
(
	-- �ѹ� �⺻Ű
	-- �ڵ����� �߰��ؾ���
	num serial,
	name varchar(3),
	mail_address varchar(30),
	phone_number int,
	-- �ּ�
	address varchar(255),
	reg_date date,
	PRIMARY KEY (num)
) WITHOUT OIDS;



/* Comments */

COMMENT ON COLUMN AddressBook.num IS '�ѹ� �⺻Ű
�ڵ����� �߰��ؾ���';
COMMENT ON COLUMN AddressBook.address IS '�ּ�';



