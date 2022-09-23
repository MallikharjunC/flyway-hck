DROP TABLE AccountInfo;

UPDATE UserInfo set email=NULL;

ALTER TABLE UserInfo DROP email;

ALTER TABLE SellerInfo DROP email;


