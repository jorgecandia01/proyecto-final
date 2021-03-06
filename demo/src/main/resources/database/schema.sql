DROP TABLE IF EXISTS TABLE_USER;
CREATE TABLE TABLE_USER (
  ID INTEGER IDENTITY PRIMARY KEY,
  EMAIL VARCHAR(127) UNIQUE,
  PASSWORD VARCHAR(127)
   );

DROP TABLE IF EXISTS TABLE_CONTACT;
CREATE TABLE TABLE_CONTACT(
    ID INTEGER IDENTITY PRIMARY KEY,
    FECHA DATE NOT NULL,
    BODY VARCHAR(2047) NOT NULL,
    IDUSER INTEGER NOT NULL,
    CONSTRAINT FKC FOREIGN KEY (IDUSER) REFERENCES TABLE_USER (ID) ON DELETE CASCADE
);

DROP TABLE IF EXISTS TABLE_PRODUCT;
CREATE TABLE TABLE_PRODUCT(
    ID INTEGER IDENTITY PRIMARY KEY,
    NAME VARCHAR(127) NOT NULL,
    PRICE NUMERIC NOT NULL
);

DROP TABLE IF EXISTS TABLE_CARRITO;
CREATE TABLE TABLE_PRODUCTS(
    ID INTEGER IDENTITY PRIMARY KEY,
    IDUSER INTEGER NOT NULL,
    IDPRODUCT INTEGER NOT NULL,
    CONSTRAINT FKCUSER FOREIGN KEY (IDUSER) REFERENCES TABLE_USER (ID) ON DELETE CASCADE,
    CONSTRAINT FKCPRODUCT FOREIGN KEY (IDPRODUCT) REFERENCES TABLE_PRODUCT (ID) ON DELETE CASCADE
);