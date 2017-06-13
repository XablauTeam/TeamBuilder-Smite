drop table if exists hibernate_sequence;
drop table if exists USUARIO;
create table hibernate_sequence (next_val bigint) engine=MyISAM;
insert into hibernate_sequence values ( 1 );
create table USUARIO (id_usuario integer not null, email varchar(255), login varchar(255), nome varchar(255), senha varchar(255), primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
drop table if exists USUARIO;
create table USUARIO (id_usuario integer not null auto_increment, email varchar(255), login varchar(255), nome varchar(255), senha varchar(255), primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
drop table if exists USUARIO;
create table USUARIO (id_usuario integer not null auto_increment, email varchar(255), login varchar(255), nome varchar(255), password varchar(255), primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
drop table if exists USUARIO;
create table USUARIO (id_usuario integer not null auto_increment, email varchar(255), login varchar(255), nome varchar(255), password varchar(255), primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
drop table if exists LOLPLAYER;
drop table if exists USUARIO;
create table LOLPLAYER (playerId bigint, playerLevel bigint, playerName varchar(255), lolPosicao integer, id_usuario integer not null, primary key (id_usuario)) engine=MyISAM;
create table USUARIO (id_usuario integer not null auto_increment, email varchar(255), login varchar(255), nome varchar(255), password varchar(255), primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
alter table LOLPLAYER add constraint FK39g70tnggfh74crwesc24doyk foreign key (id_usuario) references USUARIO (id_usuario);
drop table if exists LOLPLAYER;
drop table if exists LOLTEAM;
drop table if exists USUARIO;
create table LOLPLAYER (id_player integer not null auto_increment, gamePlayerID bigint, playerLevel bigint, playerName varchar(255), playerStatus varchar(255), teamID integer, lolregion varchar(255), lolrole varchar(255), primary key (id_player)) engine=MyISAM;
create table LOLTEAM (id_time integer not null auto_increment, status_time varchar(255), bottom integer, jungler integer, mid integer, support integer, top integer, primary key (id_time)) engine=MyISAM;
create table USUARIO (id_usuario integer not null auto_increment, email varchar(255), login varchar(255), nome varchar(255), password varchar(255), player_id_player integer, primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
alter table LOLTEAM add constraint FKabev227npn1n31sol22ick9lc foreign key (bottom) references LOLPLAYER (id_player);
alter table LOLTEAM add constraint FKcqulsmxargvhluvlmwct5g76w foreign key (jungler) references LOLPLAYER (id_player);
alter table LOLTEAM add constraint FKaoov74sytd13ujrcu4hw8hxh1 foreign key (mid) references LOLPLAYER (id_player);
alter table LOLTEAM add constraint FKmj31cuvd5cjfghoc9rkbe5t0n foreign key (support) references LOLPLAYER (id_player);
alter table LOLTEAM add constraint FKoyn3jhjfan1i06ubrhs8jtjqj foreign key (top) references LOLPLAYER (id_player);
alter table USUARIO add constraint FK9kjaljj25ppkddfobodkkadq3 foreign key (player_id_player) references LOLPLAYER (id_player);
drop table if exists LOLPLAYER;
drop table if exists lolteam;
drop table if exists USUARIO;
create table LOLPLAYER (id_player integer not null auto_increment, gamePlayerID bigint, playerLevel bigint, playerName varchar(255), playerStatus varchar(255), teamID integer, lolregion varchar(255), lolrole varchar(255), primary key (id_player)) engine=MyISAM;
create table lolteam (id_time integer not null auto_increment, status_time varchar(255), bottom integer, jungler integer, mid integer, support integer, top integer, primary key (id_time)) engine=MyISAM;
create table USUARIO (id_usuario integer not null auto_increment, email varchar(255), login varchar(255), nome varchar(255), password varchar(255), player_id_player integer, primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
alter table lolteam add constraint FK5a8njbdwurrlk3lq9rgqgw3h5 foreign key (bottom) references LOLPLAYER (id_player);
alter table lolteam add constraint FKerodbrf0bxkho2e3lf20jgqdw foreign key (jungler) references LOLPLAYER (id_player);
alter table lolteam add constraint FKauoatk2dsrc2ltsithb7h1oo4 foreign key (mid) references LOLPLAYER (id_player);
alter table lolteam add constraint FKjkyioiroh3j8ppsjm4918bfo5 foreign key (support) references LOLPLAYER (id_player);
alter table lolteam add constraint FKq9khsbithtisl943hlwe1ih1x foreign key (top) references LOLPLAYER (id_player);
alter table USUARIO add constraint FK9kjaljj25ppkddfobodkkadq3 foreign key (player_id_player) references LOLPLAYER (id_player);
drop table if exists LOLPLAYER;
drop table if exists lolteam;
drop table if exists USUARIO;
create table LOLPLAYER (id_player integer not null auto_increment, gamePlayerID bigint, playerLevel bigint, playerName varchar(255), playerStatus varchar(255), teamID integer, lolregion varchar(255), lolrole varchar(255), primary key (id_player)) engine=MyISAM;
create table lolteam (id_time integer not null auto_increment, status_time varchar(255), bottom integer, jungler integer, mid integer, support integer, top integer, primary key (id_time)) engine=MyISAM;
create table USUARIO (id_usuario integer not null auto_increment, email varchar(255), login varchar(255), nome varchar(255), password varchar(255), player_id_player integer, primary key (id_usuario)) engine=MyISAM;
alter table USUARIO add constraint UK_fiaj0vs5nduv6knel78ihnfs3 unique (login);
alter table lolteam add constraint FK5a8njbdwurrlk3lq9rgqgw3h5 foreign key (bottom) references LOLPLAYER (id_player);
alter table lolteam add constraint FKerodbrf0bxkho2e3lf20jgqdw foreign key (jungler) references LOLPLAYER (id_player);
alter table lolteam add constraint FKauoatk2dsrc2ltsithb7h1oo4 foreign key (mid) references LOLPLAYER (id_player);
alter table lolteam add constraint FKjkyioiroh3j8ppsjm4918bfo5 foreign key (support) references LOLPLAYER (id_player);
alter table lolteam add constraint FKq9khsbithtisl943hlwe1ih1x foreign key (top) references LOLPLAYER (id_player);
alter table USUARIO add constraint FK9kjaljj25ppkddfobodkkadq3 foreign key (player_id_player) references LOLPLAYER (id_player);
