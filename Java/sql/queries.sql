SELECT ALL FROM city;
SELECT ALL FROM country;
SELECT ALL FROM countrylanguage;
-- getting arrays


SELECT ALL FROM country ORDER BY Population;
SELECT ALL FROM country ORDER BY Population WHERE Continent = 'given';
SELECT ALL FROM country ORDER BY Population WHERE Region = 'given';

SELECT ALL FROM country ORDER BY Population LIMIT 'given integer';
SELECT ALL FROM country ORDER BY Population WHERE Continent = 'given' LIMIT 'given integer';
SELECT ALL FROM country ORDER BY Population WHERE Region = 'given' LIMIT 'given integer';


SELECT ALL FROM city ORDER BY Population;
SELECT ALL FROM city ORDER BY Population WHERE Continent = 'given';
SELECT ALL FROM city ORDER BY Population WHERE Region = 'given';
SELECT ALL FROM city ORDER BY Population WHERE Country = 'given';
SELECT ALL FROM city ORDER BY Population WHERE District = 'given';

SELECT ALL FROM city ORDER BY Population LIMIT 'given integer';
SELECT ALL FROM city ORDER BY Population WHERE Continent = 'given' LIMIT 'given integer';
SELECT ALL FROM city ORDER BY Population WHERE Region = 'given' LIMIT 'given integer';
SELECT ALL FROM city ORDER BY Population WHERE Country = 'given' LIMIT 'given integer';
SELECT ALL FROM city ORDER BY Population WHERE District = 'given' LIMIT 'given integer';


SELECT ALL FROM city ORDER BY Population WHERE ID IN ( SELECT Capital FROM country );
SELECT ALL FROM city ORDER BY Population WHERE ID IN ( SELECT Capital FROM country ) AND Continent = 'given';
SELECT ALL FROM city ORDER BY Population WHERE ID IN ( SELECT Capital FROM country ) AND Region = 'given';

SELECT ALL FROM city ORDER BY Population WHERE ID IN ( SELECT Capital FROM country ) LIMIT 'given integer';
SELECT ALL FROM city ORDER BY Population WHERE ID IN ( SELECT Capital FROM country ) AND Continent = 'given' LIMIT 'given integer';
SELECT ALL FROM city ORDER BY Population WHERE ID IN ( SELECT Capital FROM country ) AND Region = 'given' LIMIT 'given integer';


SELECT SUM(Population) FROM country GROUP BY Continent; -- group by Continent
SELECT SUM(Country_City_Population) FROM ( SELECT CountryCode, SUM(Population) AS Country_City_Population FROM city GROUP BY CountryCode ) AS City_Populations INNER JOIN country ON CountryCode = Code GROUP BY Continent; 

SELECT SUM(Population) FROM country GROUP BY Region; -- grou by Region
SELECT SUM(Country_City_Population) FROM ( SELECT CountryCode, SUM(Population) AS Country_City_Population FROM city GROUP BY CountryCode ) AS City_Populations INNER JOIN country ON CountryCode = Code GROUP BY Region; 

SUM(Population) FROM country GROUP BY Code; -- group by Country
SELECT SUM(Population) FROM city GROUP BY CountryCode;
-- make difference to get city and country population


SELECT SUM(Population) FROM country; -- Earth
SELECT SUM(Population) FROM country WHERE Continent = 'given';
SELECT SUM(Population) FROM country WHERE Region = 'given';
SELECT SUM(Population) FROM country WHERE Code = 'given';
SELECT SUM(Population) FROM country WHERE Continent = 'given';
SELECT SUM(Population) FROM city WHERE District = 'given';
SELECT SUM(Population) FROM city WHERE ID = 'given';


SELECT Code, Population, Language, Percentage FROM country INNER JOIN ( SELECT CountryCode, Language, Percentage FROM countrylanguage ) AS Languages ON CountryCode = Code;
