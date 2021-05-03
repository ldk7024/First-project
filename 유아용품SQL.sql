-- ������ Oracle SQL Developer Data Modeler 20.4.1.406.0906
--   ��ġ:        2021-04-24 16:39:04 KST
--   ����Ʈ:      Oracle Database 11g
--   ����:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE
drop table customer cascade constraint;
drop table production cascade constraint;
drop table rent cascade constraint;
drop table return cascade constraint;
select * from customer;
select * from production;
select * from rent;
select * from return;

CREATE TABLE customer (
    id           VARCHAR2(30) NOT NULL,
    pw           VARCHAR2(30) NOT NULL,
    name         VARCHAR2(30) NOT NULL,
    phonenumber  VARCHAR2(30) NOT NULL,
    address      VARCHAR2(50) NOT NULL,
    account      VARCHAR2(30) NOT NULL,
    money        NUMBER(10)
);

ALTER TABLE customer ADD CONSTRAINT customer_pk PRIMARY KEY ( id );


CREATE TABLE production (
    pnumber       VARCHAR2(30) NOT NULL,
    pname         VARCHAR2(30) NOT NULL,
    currentprice  NUMBER(20) NOT NULL,
    monthmoney    NUMBER(20) NOT NULL,
    pdetail       VARCHAR2(500),
    bigctg        VARCHAR2(30) NOT NULL,
    smallctg      VARCHAR2(30) NOT NULL,
    rcount        NUMBER(20),
    rstate        CHAR(1),
    customer_id   VARCHAR2(30) 
);

COMMENT ON COLUMN production.currentprice IS
    '�� ��ǰ�� ���� ����';

COMMENT ON COLUMN production.monthmoney IS
    '�� ��ǰ�� ���� �Ѵ� �뿩�ݾ�';

COMMENT ON COLUMN production.rcount IS
    '�ݳ� �Ϸῡ ���� ī��Ʈ';

ALTER TABLE production ADD CONSTRAINT production_pk PRIMARY KEY ( pnumber );

CREATE TABLE rent (
    rnumber             VARCHAR2(30) NOT NULL,
    deposit             NUMBER(10) NOT NULL,
    rmonth              NUMBER(3) NOT NULL,
    rmoney              NUMBER(10) NOT NULL,
    tpmoney             NUMBER(10) NOT NULL,
    rstart              DATE NOT NULL,
    rfinish             DATE NOT NULL,
    rback               VARCHAR2(30),  --�ݳ���û����
    latepayment         CHAR(1),
    epayback            NUMBER(10) NOT NULL,
    rbackdate           DATE,
    customer_id         VARCHAR2(30) NOT NULL,
    production_pnumber  NUMBER(20) NOT NULL
);

COMMENT ON COLUMN rent.deposit IS
    '��ü �� �Ѽ� �н� ������ ���� �ݾ�
����*0.3';

COMMENT ON COLUMN rent.rmonth IS
    '��ǰ�뿩�� �뿩�� �Ⱓ
';

COMMENT ON COLUMN rent.rmoney IS
    '���ݾ�*������';

COMMENT ON COLUMN rent.tpmoney IS
    '������+�뿩�ݾ�';

COMMENT ON COLUMN rent.rstart IS
    '�뿩������';

COMMENT ON COLUMN rent.rfinish IS
    '�뿩��+�뿩������';

COMMENT ON COLUMN rent.epayback IS
    '������ ���';

--CREATE UNIQUE INDEX rent__idx ON
--    rent (
--        production_pnumber
--    ASC );

ALTER TABLE rent ADD CONSTRAINT rent_pk PRIMARY KEY ( rnumber );

CREATE TABLE return (
    tnumber        VARCHAR2(30) NOT NULL,
    pstatescore         NUMBER(10),
    tdeposit       NUMBER(10),
    tmoney         NUMBER(10),
    tstate         CHAR(1),
    customer_id         VARCHAR2(30) NOT NULL,
    production_pnumber  VARCHAR2(30) NOT NULL,
    rent_rnumber        VARCHAR2(30) NOT NULL
); 
COMMENT ON COLUMN return.returndeposit IS
    '������~��ǰ��������
~: %�� ��������ؼ� 1�� 10%.......ġȯ�ؼ� ����ϼ�
2. ���� (�ݳ�������-�ݳ���û�� ==0  =>������ ��� ��ȯ';

COMMENT ON COLUMN return.returnmoney IS
    '1. ���� (�ݳ�������-�ݳ���û��) < 0 && �ݳ���û�� > �ݳ�������+3���� => ������ ���� ����
2. ����(�ݳ�������-�ݳ���û��) > 0   => (�ݳ�������-�ݳ���û��) * 0.5
';

--CREATE UNIQUE INDEX return__idx ON
--    return (
--        production_pnumber
--    ASC );
--
--CREATE UNIQUE INDEX return__idxv1 ON
--    return (
--        rent_rnumber
--    ASC );

ALTER TABLE return ADD CONSTRAINT return_pk PRIMARY KEY ( returnnumber );

ALTER TABLE production
    ADD CONSTRAINT production_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( id );

ALTER TABLE rent
    ADD CONSTRAINT rent_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( id );

ALTER TABLE rent
    ADD CONSTRAINT rent_production_fk FOREIGN KEY ( production_pnumber )
        REFERENCES production ( pnumber );

ALTER TABLE return
    ADD CONSTRAINT return_customer_fk FOREIGN KEY ( customer_id )
        REFERENCES customer ( id );

ALTER TABLE return
    ADD CONSTRAINT return_production_fk FOREIGN KEY ( production_pnumber )
        REFERENCES production ( pnumber );

ALTER TABLE return
    ADD CONSTRAINT return_rent_fk FOREIGN KEY ( rent_rnumber )
        REFERENCES rent ( rnumber );


        
insert into customer values ('admin','1234','������','010-1234-5678','����','123-12345-1234',0);
insert into customer values ('star1','12344','�̼���','010-1235-5679','���','124-12346-1235',0);
insert into customer values ('star2','12345','�ִϳڷ�','010-1236-5680','����','125-12347-1236',860);
insert into customer values ('star3','12346','�����','010-1237-5681','����','126-12348-1237',150000);
insert into customer values ('star4','12347','�踷��','010-1238-5682','��õ','127-12349-1238',50000);
insert into customer values ('star5','12348','������','010-1239-5683','����','128-12350-1239',10);
insert into customer values ('star6','12349','�ּ���','010-1240-5684','�λ�','129-12351-1240',36000);
insert into customer values ('star7','123410','�����','010-1241-5685','ȭõ','130-12352-1241',79000);
insert into customer values ('star8','123411','������','010-1242-5686','�뱸','131-12353-1242',15000);
insert into customer values ('star9','123412','������','010-1243-5687','����','132-12354-1243',20000);
insert into customer values ('star10','123413','���ָ�','010-1244-5688','��õ','133-12355-1244',25000);

--===============================================================================================================


insert into production values('P001','ġ�� �ν���',100000,25000,'3�ܰ� ������ ���� ������� �Ʊ� ����ܰ迡 ���߾� ��밡��', '���ƿ�ǰ�뿩','��Ź����',17,'T','�����');
insert into production values('P002','������ ���۷�',100000,25000,'������ ���� ����Ȱ�뿡 ����,��Ʈ�� ���� �и��Ͽ� ��Ź', '���ƿ�ǰ�뿩','���۷�',7,'T', '�̼���');
insert into production values('P003','��ũ �����',90000,25000,'��鸮�� �ʴ� �����', '���ƿ�ǰ�뿩','���۷�',0,'F', NULL);
insert into production values('P004','������������',230000,58000,'�ڵ鸵�� ���� ������ �ִ��� �ٿ� �̵��� ����', '���ƿ�ǰ�뿩','������',10,'T', '�ִϳڷ�');
insert into production values('P005','������ ���۷�',95000,24000,'��Ʈ ���� �и����� �� ��ô�� ����', '���ƿ�ǰ�뿩','���۷�',0,'F', NULL);
insert into production values('P006','Ʈ������ �Ƹ���',130000,34000,'�Ҹ����� �ϱ��� �������� �ʼ� �� ��Ʈ�е�� �߼������� ����Ź', '���ƿ�ǰ�뿩','���۷�',15,'F', '�����');
insert into production values('P007','����ħ��',100000,25000,'��鸮�� �ʴ� ����԰� ������ ����', '���ƿ�ǰ�뿩','���ƿ� ħ��',23,'T', '�踷��');
insert into production values('P008','������ؽ� ī��Ʈ',180000,45000,'5���� ������Ʈ, �����Ʈ ��������', '���ƿ�ǰ�뿩','ī��Ʈ',12,'T', '������');
insert into production values('P009','Ʈ���� �� ����',80000,25000,'�Ҹ����� �ϱ��� �������� �ʼ� �� ��Ʈ�е�� �߼������� ����Ź', '���۷�','������',0,'F', NULL);
insert into production values('P010','������ ���� ����',70000,20000,'������ ü���� ������ �����ΰ� ����̿� �߰��̷� ������ ����', '��Ÿ���� ��ǰ','������',0,'F',NULL);
insert into production values('P011','ABC����Ʈ ����',100000,25000,'��Ʈ�� �¿� 360�� ȸ������', '���ƿ�ǰ�뿩','����',30,'T', '�ּ���');
insert into production values('P012','�ٿ ��ٿ�',100000,25000,'���ڸ����� ���Ÿ��� �Ѿ����� ����, ������ �ټ� ��', '���ƿ�ǰ�뿩','����',0,'F',NULL);
insert into production values('P013','����� ����',100000,25000,'20�������� �پ��� ����� ���̱��', '���ƿ�ǰ�뿩','���۷�',0,'F', NULL);
insert into production values('P014','Ʈ���� �� �Ƹ���',130000,30000,'�Ҹ����� �ϱ��� �������� �ʼ� �� ��Ʈ�е�� �߼������� ����Ź', '���ƿ�ǰ�뿩','���۷�',0,'F',NULL);
insert into production values('P015','������ ����ħ��',80000,20000,'���ڼ� ������ ��������', '���ƿ�ǰ�뿩','���ƿ� ħ��',24,'T', '������');
insert into production values('P016','������ؽ� ��ũ����',140000,35000,'�����浹�� ��� ����� ���� �ý���', '���ƿ�ǰ�뿩','ī��Ʈ',0,'F', NULL);
insert into production values('P017','ġ�ں����',100000,25000,'������ ���� �ӵ��� �°� 3�ܰ� ���� ��������', '���ƿ�ǰ�뿩','����� ',28,'F', '������');
insert into production values('P018','�Ǽ������̽��ν���',86000,20000,'��ä�ο������ �پ��� �峭������ �ü� ��Ż', '���ƿ�ǰ�뿩','��Ź����',0,'F', NULL);
insert into production values('P019','����Ż���ī��Ʈ',145000,30000,'�ٿ�� ��ȣ���� �޽Ľð� ����,����ħ�� �� ĳ����� ��밡��', '���ƿ�ǰ�뿩','ī��Ʈ',0,'F',NULL);
insert into production values('P020','�Դ��÷� ī��Ʈ',115000,30000,'�ȶ����� �ִ� ������ ���� ����', '���ƿ�ǰ�뿩','ī��Ʈ',0,'F', NULL);
insert into production values('P021','ġ��������Ź����',130000,30000,'����ġ ���̵� ����,7�ܰ� ��������', '���ƿ�ǰ�뿩','��Ÿ����',4,'T', '�����');
insert into production values('P022','�ָ� ��Ź����',155000,40000,'�ս��� Ż/���� ���� �� �ռ�Ź�� ������ 2�� �к긯 ��Ʈ', '���ƿ�ǰ�뿩','��Ź����',17,'F', '�ִϳڷ�');
insert into production values('P023','���� ��Ź����',80000,20000,'ǫ��ǫ���� ���ڿ� �ö�ƽ �� ����ġ �극��ũ ���� ���� 6�ܰ� ����', '���ƿ�ǰ�뿩','��Ź����',0,'F', NULL);
insert into production values('P024','���� ����',83000,20000,'���� ���� �ƱⰡ �ٷ� ���� �� �ֵ��� ����', '���ƿ�ǰ�뿩','��Ź����',0,'F', NULL);
insert into production values('P025','ġ�� �ν���',100000,25000,'3�ܰ� ������ ���� ������� �Ʊ� ����ܰ迡 ���߾� ��밡��', '���ƿ�ǰ�뿩','������',0,'F', NULL);
insert into production values('P026','������ ���۷�',100000,25000,'������ ���� ����Ȱ�뿡 ����,��Ʈ�� ���� �и��Ͽ� ��Ź', '���ƿ�ǰ�뿩','�Ҽ�',8,'T', '������');
insert into production values('P027','��ũ�����',90000,25000,'��鸮�� �ʴ� �����', '���ƿ�ǰ�뿩','������',0,'F', NULL);
insert into production values('P028','ġ�� �ν���',100000,25000,'3�ܰ� ������ ���� ������� �Ʊ� ����ܰ迡 ���߾� ��밡��', '���ƿ�ǰ�뿩','������',0,'F', NULL);
insert into production values('P029','������ ������',230000,58000,'�ڵ鸵�� ���� ������ �ִ��� �ٿ� �̵��� ����', '���ƿ�ǰ�뿩','������',0,'F', NULL);
insert into production values('P030','ġ�ں����',100000,25000,'������ ���� �ӵ��� �°� 3�ܰ� ���� ��������', '���ƿ�ǰ�뿩','�����',7,'T', '���ָ�');

--====================================================================================================================



insert into rent values('R001',30000,1,25000,55000,'2020-01-20','2020-02-20','�ݳ���û','T',30000,'2020-02-24','�����',001);
insert into rent values('R002',30000,3,25000,105000,'2020-02-24','2020-05-24','�ݳ��Ϸ�','F',30000,'2020-04-24','�̼���',002);
insert into rent values('R003',69000,2,58000,185000,'2020-03-24','2020-05-24','�ݳ���û','F',69000,'2020-05-24','�ִϳڷ�',004);
insert into rent values('R004',39000,1,34000,73000,'2020-04-24','2020-05-24','�ݳ���û','F',39000,'2020-05-24','�����',006);
insert into rent values('R005',30000,1,25000,55000,'2020-05-24','2020-06-24','�ݳ��Ϸ�','F',30000,'2020-06-24','�踷��',007);
insert into rent values('R006',54000,3,45000,189000,'2020-06-24','2020-09-24','�ݳ��Ϸ�','F',54000,'2020-09-24','������',008);
insert into rent values('R007',30000,3,25000,105000,'2020-07-24','2020-10-24','�ݳ���û','T',30000,'2021-01-01','�ּ���',011);
insert into rent values('R008',24000,2,20000,64000,'2021-04-24','2021-06-24',NULL,NULL,24000,NULL,'������',015);
insert into rent values('R009',30000,2,25000,80000,'2021-04-24','2021-06-24',NULL,NULL,30000,NULL,'������',017);
insert into rent values('R010',39000,1,30000,69000,'2021-04-24','2021-05-24',NULL,NULL,39000,NULL,'�����',021);
insert into rent values('R011',46500,1,40000,86500,'2021-04-24','2021-05-24',NULL,NULL,46500,NULL,'�ִϳڷ�',022);
insert into rent values('R012',30000,2,25000,80000,'2021-04-24','2021-06-24',NULL,NULL,30000,NULL,'������',026);
insert into rent values('R013',30000,1,25000,55000,'2021-04-24','2021-05-24',NULL,NULL,30000,NULL,'���ָ�',030);

--===================================================================================================================



insert into return values('T001',10,0,0,'T','�����','P001','R001');
insert into return values('T002',4,12000,25000,'T','�̼���','P002','R002');
insert into return values('T003',1,6900,0,'T','�ִϳڷ�','P004','R003'); 
insert into return values('T004',10,0,0,'T','�����','P006','R004');
insert into return values('T005',10,0,0,'T','�踷��','P007','R005');
insert into return values('T006',10,0,0,'T','������','P008','R006');
insert into return values('T007',1,0,0,'T','�ּ���','P011','R007');


select pname "��ǰ��",pnumber "��ǰ��ȣ",bigctg "��з�",smallctg "�Һз�",currentprice "����",rstate "�뿩����(T/F)" from production;
delete from production where pnumber='P029';
select * from production;
select * from rent;
Select customer_id, production_pnumber, rstart, rfinish, latepayment, tpmoney,epayback from rent;

Select rnumber, deposit, rmonth, rmoney, tpmoney,latepayment ,epayback  from rent where rback ='�ݳ���û' or rback ='�ݳ��Ϸ�';
select * from return;
Select rnumber, deposit, rmonth, rmoney, tpmoney,latepayment ,epayback  from rent where latepayment!='null';
--select P.currentprice from production P, rent R where R.TO_DATE(rfinish) - R.TO_DATE(backdate)>=15 and P.customer_id = R.customer_id;
select rnumber from rent where to_date(rfinish) - to_date(rbackdate) >=15;
Select customer_id,production_pnumber,rmoney,rstart,rfinish,epayback,rback from rent;








--latepayment = char���� null�� �츮�� ���� �Է������ ������ 'null'���� 
