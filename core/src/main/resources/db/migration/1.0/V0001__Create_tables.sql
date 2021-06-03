-- Leave a large ID space reserved for master-data and test-data
CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 1000000;

CREATE TABLE Product (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  name VARCHAR (255) NULL,
  category VARCHAR (255) NULL,
  quantity BIGINT (120) NULL,
  price DOUBLE NOT NULL,
  CONSTRAINT PK_Product PRIMARY KEY(id)
);

INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (10001, 1, 'Food1', 'Food', 100, 10);
INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (10002, 1, 'Food2', 'Food', 200, 20);
INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (10003, 1, 'Food3', 'Food', 300, 30);

INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (20001, 1, 'Fashion1', 'Fashion', 300, 3000);
INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (20002, 1, 'Fashion2', 'Fashion', 200, 4000);
INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (20003, 1, 'Fashion3', 'Fashion', 100, 5000);

INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (30001, 1, 'Electronic1', 'Electronics', 200, 400);
INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (30002, 1, 'Electronic2', 'Electronics', 300, 300);
INSERT INTO Product (id, modificationCounter, name, category, quantity, price) VALUES (30003, 1, 'Electronic3', 'Electronics', 400, 200);


CREATE TABLE User (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  userName VARCHAR (255) NOT NULL,
  password VARCHAR (255) NULL,
  roles VARCHAR (255) NULL,
  CONSTRAINT PK_User PRIMARY KEY(id),
  CONSTRAINT UK_UserName UNIQUE KEY(userName)
);

INSERT INTO User (id, modificationCounter, userName, password, roles) VALUES (1001, 1, 'admin', 'admin', 'user,admin');
INSERT INTO User (id, modificationCounter, userName, password, roles) VALUES (2001, 1, 'user', 'user', 'user');

CREATE TABLE Card (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  creditCardNumber VARCHAR (255) NOT NULL,
  userName VARCHAR (255) NOT NULL,
  amount DOUBLE NOT NULL,
  status VARCHAR (255),
  CONSTRAINT PK_Card PRIMARY KEY(id),
  CONSTRAINT UK_CardNumber UNIQUE KEY(creditCardNumber)
);

INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (1, 1, '1111-1111-1111-1111', 'admin', 100000, 'active');
INSERT INTO Card (id, modificationCounter, creditCardNumber, userName, amount, status) VALUES (2, 1, '2222-2222-2222-2222', 'user', 20000, 'active');


CREATE TABLE Payment (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  userName VARCHAR (255) NOT NULL,
  cardId BIGINT NOT NULL,
  amount DOUBLE NOT NULL,
  paymentStatus BOOLEAN,
  CONSTRAINT PK_Payment PRIMARY KEY(id),
  CONSTRAINT FK_CardId FOREIGN KEY(cardId) REFERENCES Card(id)
);

CREATE TABLE Orders (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  paymentId BIGINT NULL,
  userName VARCHAR (255) NOT NULL,
  products OTHER NOT NULL,
  amount DOUBLE NOT NULL,
  status BOOLEAN,
  orderTime TIMESTAMP NULL,
  CONSTRAINT PK_Order PRIMARY KEY(id),
  CONSTRAINT FK_userName FOREIGN KEY(userName) REFERENCES User(userName)
);

CREATE TABLE Cart (
  id BIGINT NOT NULL AUTO_INCREMENT,
  modificationCounter INTEGER NOT NULL,
  userName VARCHAR (255) NOT NULL,
  products OTHER NOT NULL,
  CONSTRAINT PK_Cart PRIMARY KEY(id),
  CONSTRAINT FK_UserNameFk FOREIGN KEY(userName) REFERENCES User(userName)
);