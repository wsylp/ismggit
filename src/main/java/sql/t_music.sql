drop table EXISTS t_music;
create table t_music(
  id BIGINT AUTO_INCREMENT PRIMARY KEY ,
  music_name VARCHAR(50) ,
  music_star VARCHAR(50),
  path	VARCHAR(100),
  file_name VARCHAR(100),
  type VARCHAR(50),
  sort INTEGER,
  create_time Timestamp
) DEFAULT CHARSET = 'utf8';

insert into t_music VALUES ('1','我的老家','刘德华','upload/music','20171119111111.MP3','流行',1,'2017-11-19');