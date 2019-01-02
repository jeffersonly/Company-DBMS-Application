USE milestone3;

/**
Used for Query (b) Show all the names of the branches at the company.
**/

CREATE VIEW branchNames AS
SELECT branchName
FROM Branches;

/**
Used for Query (d) Show the date that a branch was created, the cost the branch requires, and how much profit a branch is generating.
**/
CREATE VIEW branchInfo AS
SELECT branchName, dateCreated, cost, profit
FROM Branches;



