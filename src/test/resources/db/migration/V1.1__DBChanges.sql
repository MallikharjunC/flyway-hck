CREATE TABLE AccountInfo (
    id INT NOT NULL PRIMARY KEY,
    acc_name VARCHAR NOT NULL
);

ALTER TABLE UserInfo ADD email VARCHAR;

ALTER TABLE SellerInfo ADD email VARCHAR;

UPDATE UserInfo set email="john@abc.com";

