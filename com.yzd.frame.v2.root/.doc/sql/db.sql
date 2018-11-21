drop table if exists tb_test_data;

/*==============================================================*/
/* Table: tb_test_data (临时的测试表)                                        */
/* 阿里巴巴Java开发规范手册.pdf                                 */
/*==============================================================*/
create table tb_test_data
(
   id                   bigint  not null auto_increment,
   name                 varchar(30),
   password             varchar(100),
   gmt_create           datetime comment '创建时间',
   gmt_modified         datetime comment '修改时间',
   gmt_is_deleted       int  comment '是否被删除',
   primary key (id)
);