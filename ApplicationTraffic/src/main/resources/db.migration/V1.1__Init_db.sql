
create table message
(
  id            bigint       not null
    primary key,
  creation_date datetime     null,
  text          varchar(255) null
)
  engine = MyISAM;

