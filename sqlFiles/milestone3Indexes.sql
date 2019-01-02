USE milestone3;

CREATE INDEX EmpManInd ON Manages(employeeID);

CREATE INDEX EmpBrnInd ON Contains(employeeID);

CREATE INDEX ManBrnInd ON RunBy(branchName);

CREATE INDEX CustBuysInd ON Buys(customerID);

CREATE INDEX StockInvestInd ON InvestsIn(stockID);

CREATE INDEX BrnProdInd ON Makes(productID);

