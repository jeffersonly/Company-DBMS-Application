USE milestone3;

/**
Query (a) Show the list of employee names and their id number who work for the manager identified by the id number 95192.
**/

SELECT e.IDNumber, e.firstName, e.lastName
FROM Employees e, Manages m
WHERE m.managerID = 95192
AND m.employeeID = e.IDNumber;
/**
Query (b) Show all the names of the branches at the company.
**/

SELECT branchName
FROM Branches;

/**
Query (c) Show the names and id of all the employees and managers that work for the HR Branch of the company.
**/
(SELECT e.IDNumber, e.firstName, e.lastName
FROM Employees e, Contains c
WHERE c.branchName LIKE '%HR%'
AND c.employeeID = e.IDNumber)
UNION
(SELECT m.IDNumber, m.firstName, m.lastName
FROM Managers m, RunBy r
WHERE r.branchName LIKE '%HR%'
AND r.managerID = m.IDNumber);

/**
Query (d) Show the date that a branch was created, the cost the branch requires, and how much profit a branch is generating.
**/
SELECT branchName, dateCreated, cost, profit
FROM Branches;

/**
Query (e) Show the customers of a product, whose product ID is 28739.
**/

SELECT c.customerID, c.firstName, c.lastName
FROM Customers c, Buys b
WHERE b.productID = 28739
AND b.customerID = c.customerID;

/**
Query (f) For each stock owned by an investor, whose investor ID is 93193, show the amount of shares and the price. 
**/

SELECT s.stockID, s.price, s.numShared
FROM Stocks s, InvestsIn i
WHERE i.InvestorID = 93193
AND i.stockID = s.stockID;

/**
Query (g) Show the customers that bought more than one product from the company.	
**/

SELECT DISTINCT c.customerID, c.firstName, c.lastName
FROM Customers c, Has h, Has h2
WHERE h.customerID = h2.customerID
AND h.orderID != h2.orderID
AND h.customerID = c.customerID;

/**
Query (h) (h) Show the number of employees and managers that have been working at the company for over 10 years.
**/
SELECT
(SELECT COUNT(*)
FROM employees
WHERE startDate < DATE_SUB(SYSDATE(), INTERVAL 10 YEAR)) 
+
(SELECT COUNT(*)
FROM managers
WHERE startDate < DATE_SUB(SYSDATE(), INTERVAL 10 YEAR))
AS LongTermEmployees;

/**
Query (i)  Show the salaries paid to the employees and managers of the Software branch.
**/
(SELECT e.salary
FROM Employees e, Contains c
WHERE e.IDNumber = c.employeeID
AND c.branchName LIKE '%Software%')
UNION
(SELECT m.salary
FROM Managers m, RunBy r
WHERE m.IDNumber = r.managerID
AND r.branchName LIKE '%Software%');

/**
Query (j) Display the price(s) and cost(s) of the most commonly sold product(s) from the company.
**/
SELECT p.priceSold, p.costToMake
FROM Products p, MadeOf m
WHERE m.productID = p.productID
AND m.quantity >= ALL(SELECT quantity FROM MadeOf);

/**
Query (k) Display the names and ids of employees and managers that own stock in the company.
**/
(SELECT e.IDNumber, e.firstName, e.lastName
FROM Employees e, Investors i
WHERE e.IDNumber = i.IDNumber)
UNION
(SELECT m.IDNumber, m.firstName, m.lastName
FROM Managers m, Investors i
WHERE m.IDNumber = i.IDNumber);

/**
Query (l) Out of all the least commonly sold product(s) of the company, display the product name and id of the products that had the highest cost to make.
**/
SELECT p.name, p.productID
FROM Products p, MadeOf m
WHERE m.productID = p.productID
AND m.quantity <= ALL(SELECT quantity FROM MadeOf)
AND p.costToMake >= ALL 
(SELECT p2.costToMake
FROM Products p2, MadeOf m2
WHERE m2.productID = p2.productID
AND m2.quantity <= ALL(SELECT quantity FROM MadeOf));

/**
Query (m) Show the product(s) from the Electronics branch that took the lowest cost to make.
**/
SELECT p.name, p.productID
FROM Products p, Makes m
WHERE p.productID = m.productID
AND m.branchName LIKE '%Electronics%'
AND p.costToMake>= ALL
(SELECT p2.costToMake
FROM Products p2, Makes m2
WHERE p2.productID = m2.productID
AND m2.branchName LIKE '%Electronics%');

/**
Query (n) Show the order number(s), name(s), and email(s) of customers who had purchased the most expensive product from the Software branch.
**/
SELECT Has.orderID, firstName, lastName, email
FROM Customers, Has
WHERE Customers.customerID IN (
	SELECT customerID
    FROM Buys
    WHERE Buys.productID IN (
		SELECT productID
		FROM Products
		WHERE priceSold = (
			SELECT MAX(priceSold) 
			FROM Products 
			WHERE productID IN (
				SELECT productID 
				FROM Makes
				WHERE branchName LIKE '%Software%'))))
	AND Has.customerID = Customers.customerID;


/**
Query (o)  Show the name, email, and ID of distinct Managers, Employees, and Investors of the company. 
**/
(SELECT firstName, lastName, email, IDNumber
FROM Employees)
UNION
(SELECT firstName, lastName, email, IDNumber
FROM Managers)
UNION
(SELECT firstName, lastName, email, IDNumber
FROM Investors
WHERE IDNumber != ANY (SELECT IDNumber FROM Employees)
AND IDNumber != ANY (SELECT IDNumber FROM Managers));


