CREATE TABLE UserInfo (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE SellerInfo (
    id INT NOT NULL PRIMARY KEY,
    org VARCHAR NOT NULL
);

INSERT into UserInfo (id,name) values (1,'John');
INSERT into UserInfo (id,name) values (1,'Mike');


INSERT into UserInfo (id,org) values (1,'ABC');
INSERT into UserInfo (id,org) values (1,'XYZ');
