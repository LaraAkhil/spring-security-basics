INSERT INTO users(username,password,enabled) values('user','user',true);
INSERT INTO users(username,password,enabled) values('root','root',true);

INSERT INTO authorities(username,authority) values('user','ROLE_user');
INSERT INTO authorities(username,authority) values('root','ROLE_admin');
