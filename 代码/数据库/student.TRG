TYPE=TRIGGERS
triggers='CREATE DEFINER=`root`@`%` TRIGGER `info`.`student_AFTER_INSERT` AFTER INSERT ON `student` FOR EACH ROW\nBEGIN\n	 insert into register_record (sequence,name,Time) values (new.id,new.name,sysdate());\nEND'
sql_modes=1075838976
definers='root@%'
client_cs_names='utf8'
connection_cl_names='utf8_general_ci'
db_cl_names='latin1_swedish_ci'
created=148187249542
