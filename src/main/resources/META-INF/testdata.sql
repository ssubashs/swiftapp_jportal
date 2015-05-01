INSERT INTO `profile` (`profileid`, `firstname`, `lastname`,  `username`) VALUES ('1','subash', 'soundrapandi', 'ssubashs');
INSERT INTO `profile` (`profileid`, `firstname`, `lastname`,  `username`) VALUES ('2','admin', 'user', 'admin');
INSERT INTO `profile` (`profileid`, `firstname`, `lastname`,  `username`) VALUES ('3','global', 'user', 'global');

INSERT INTO `useraccess` (`profileid`,  `password`,  `username`) VALUES ('1','$2a$11$Hz0YDf98WUowPjlQwSzSA.X3GXIVpf5okPr1LjRvQZlK2m7C8n2r.', 'ssubashs');
INSERT INTO `useraccess` (`profileid`, `password`,  `username`) VALUES ('2','$2a$11$Hz0YDf98WUowPjlQwSzSA.X3GXIVpf5okPr1LjRvQZlK2m7C8n2r.', 'admin');
INSERT INTO `useraccess` (`profileid`, `password`,  `username`) VALUES ('3','$2a$11$Hz0YDf98WUowPjlQwSzSA.X3GXIVpf5okPr1LjRvQZlK2m7C8n2r.', 'global');

INSERT INTO `userrole` VALUES (1,'ROLE_USER','Active',1),(2,'ROLE_ADMIN','Active',2),(3,'ROLE_USER','Active',3);
