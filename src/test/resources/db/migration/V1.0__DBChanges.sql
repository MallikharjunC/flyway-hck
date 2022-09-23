CREATE TABLE UserInfo (
    id INT NOT NULL PRIMARY KEY,
    name VARCHAR NOT NULL
);

CREATE TABLE SellerInfo (
    id INT NOT NULL PRIMARY KEY,
    org VARCHAR NOT NULL
);

INSERT into UserInfo (id,name) values (1,'John');
INSERT into UserInfo (id,name) values (2,'Mike');


INSERT into SellerInfo (id,org) values (1,'ABC');
INSERT into SellerInfo (id,org) values (2,'XYZ');
