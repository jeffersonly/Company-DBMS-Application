USE milestone3;

/**
Employees
**/

CREATE TABLE employeeHistory_table
(action VARCHAR(50),
IDNumber INT DEFAULT NULL);

CREATE TRIGGER insertIntoEmployeeHistory
BEFORE INSERT ON Employees
FOR EACH ROW
INSERT INTO employeeHistory_table(action, IDNumber) VALUES('Inserting', NEW.IDNumber);

CREATE TRIGGER deletionFromEmployeeHistory
BEFORE DELETE ON Employees
FOR EACH ROW
INSERT INTO employeeHistory_table(action, IDNumber) VALUES('Deleting', OLD.IDNumber);

/**
Managers
**/

CREATE TABLE managerHistory_table
(action VARCHAR(50),
IDNumber INT DEFAULT NULL);

CREATE TRIGGER insertIntoManagerHistory
BEFORE INSERT ON Managers
FOR EACH ROW
INSERT INTO managerHistory_table(action, IDNumber) VALUES('Inserting', NEW.IDNumber);

CREATE TRIGGER deletionFromManagerHistory
BEFORE DELETE ON Managers
FOR EACH ROW
INSERT INTO managerHistory_table(action, IDNumber) VALUES('Deleting', OLD.IDNumber);

/**
Branches
**/
CREATE TABLE branchesHistory_table
(action VARCHAR(50),
branchName VARCHAR(25) DEFAULT NULL);

CREATE TRIGGER insertIntoBranchHistory
BEFORE INSERT ON Branches
FOR EACH ROW
INSERT INTO branchesHistory_table(action, branchName) VALUES('Inserting', NEW.branchName);

CREATE TRIGGER deletionFromBranchHistory
BEFORE DELETE ON Branches
FOR EACH ROW
INSERT INTO branchesHistory_table(action, branchName) VALUES('Deleting', OLD.branchName);

/**
Investors
**/
CREATE TABLE investorHistory_table
(action VARCHAR(50),
IDNumber INT DEFAULT NULL);

CREATE TRIGGER insertIntoInvestorHistory
BEFORE INSERT ON Investors
FOR EACH ROW
INSERT INTO investorHistory_table(action, IDNumber) VALUES('Inserting', NEW.IDNumber);

CREATE TRIGGER deletionFromInvestorHistory
BEFORE DELETE ON Investors
FOR EACH ROW
INSERT INTO investorHistory_table(action, IDNumber) VALUES('Deleting', OLD.IDNumber);


/**
Products
**/
CREATE TABLE productsHistory_table
(action VARCHAR(50),
productID INT DEFAULT NULL);

CREATE TRIGGER insertIntoProductsHistory
BEFORE INSERT ON Products
FOR EACH ROW
INSERT INTO productsHistory_table(action, productID) VALUES('Inserting', NEW.productID);

CREATE TRIGGER deletionFromProductsHistory
BEFORE DELETE ON Products
FOR EACH ROW
INSERT INTO productsHistory_table(action, productID) VALUES('Deleting', OLD.productID);

/**
Stocks
**/

CREATE TABLE stockHistory_table
(action VARCHAR(50),
stockID INT DEFAULT NULL);

CREATE TRIGGER insertIntoStockHistory
BEFORE INSERT ON Stocks
FOR EACH ROW
INSERT INTO stockHistory_table(action, stockID) VALUES('Inserting', NEW.stockID);

CREATE TRIGGER deletionFromStockHistory
BEFORE DELETE ON Stocks
FOR EACH ROW
INSERT INTO stockHistory_table(action, stockID) VALUES('Deleting', OLD.stockID);

/**
Customers
**/
CREATE TABLE customersHistory_table
(action VARCHAR(50),
customerID INT DEFAULT NULL);

CREATE TRIGGER insertIntoCustomersHistory
BEFORE INSERT ON Customers
FOR EACH ROW
INSERT INTO customersHistory_table(action, customerID) VALUES('Inserting', NEW.customerID);

CREATE TRIGGER deletionFromCustomersHistory
BEFORE DELETE ON Customers
FOR EACH ROW
INSERT INTO customersHistory_table(action, customerID) VALUES('Deleting', OLD.customerID);

/**
Orders
**/

CREATE TABLE ordersHistory_table
(action VARCHAR(50),
orderNum INT DEFAULT NULL);

CREATE TRIGGER insertIntoOrdersHistory
BEFORE INSERT ON Orders
FOR EACH ROW
INSERT INTO ordersHistory_table(action, orderNum) VALUES('Inserting', NEW.orderNum);

CREATE TRIGGER deletionFromOrdersHistory
BEFORE DELETE ON Orders
FOR EACH ROW
INSERT INTO ordersHistory_table(action, orderNum) VALUES('Deleting', OLD.orderNum);
