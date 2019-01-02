USE milestone3;

SELECT e.IDNumber, e.firstName, e.lastName
FROM Employees e, Manages m
WHERE m.managerID = 95192
AND m.employeeID = e.IDNumber;

SAVEPOINT SELECT1_DONE;

INSERT INTO Employees VALUES(12000 ,"James", "Deely", "1984-01-01","Mulberry St.", "Joseph City", 95121, "(408)123-4560", "james.deely@evercreek.org", 50000, "2001-12-30");

INSERT INTO Manages VALUES(12000,95192);

SAVEPOINT INSERT_DONE;

SELECT e.IDNumber, e.firstName, e.lastName
FROM Employees e, Manages m
WHERE m.managerID = 95192
AND m.employeeID = e.IDNumber;

SAVEPOINT SELECT2_DONE;

ROLLBACK TO SELECT1_DONE;
