-- getting arrays
SELECT ID, Name, CountryCode, District, Population FROM city;
SELECT Code, Name, Continent, Region, Population, Capital FROM country;
SELECT CountryCode, Language, Percentage FROM countrylanguage;


-- largest to smallest
SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population;
SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population WHERE Continent = 'given';
SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population WHERE Region = 'given';

SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population LIMIT 'given integer';
SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population WHERE Continent = 'given' LIMIT 'given integer';
SELECT Code, Name, Continent, Region, Population, Capital FROM country ORDER BY Population WHERE Region = 'given' LIMIT 'given integer';


SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population;
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE Continent = 'given';
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE Region = 'given';
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE Country = 'given';
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE District = 'given';

SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population LIMIT 'given integer';
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE Continent = 'given' LIMIT 'given integer';
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE Region = 'given' LIMIT 'given integer';
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE Country = 'given' LIMIT 'given integer';
SELECT city.Name, country.Name, District, city.Population FROM city INNER JOIN country ON CountryCode = Code ORDER BY Population WHERE District = 'given' LIMIT 'given integer';


SELECT ID, city.Name, Continent, Region, city.Population, Capital FROM city INNER JOIN country ON ID = Capital ORDER BY city.Population;
SELECT ID, city.Name, Continent, Region, city.Population, Capital FROM city INNER JOIN country ON ID = Capital ORDER BY city.Population AND Continent = 'given';
SELECT ID, city.Name, Continent, Region, city.Population, Capital FROM city INNER JOIN country ON ID = Capital ORDER BY city.Population AND Region = 'given';

SELECT ID, city.Name, Continent, Region, city.Population, Capital FROM city INNER JOIN country ON ID = Capital ORDER BY city.Population LIMIT 'given integer';
SELECT ID, city.Name, Continent, Region, city.Population, Capital FROM city INNER JOIN country ON ID = Capital ORDER BY city.Population AND Continent = 'given' LIMIT 'given integer';
SELECT ID, city.Name, Continent, Region, city.Population, Capital FROM city INNER JOIN country ON ID = Capital ORDER BY city.Population AND Region = 'given' LIMIT 'given integer';


-- get population statistics 
SELECT City.Continent, Total_Population, City_Population, ( City_Population / Total_Population * 100 ) AS City_Percent, ( Total_Population - City_Population ) AS Country_Population, ( ( Total_Population - City_Population ) / Total_Population * 100 ) AS Country_Percent FROM ( SELECT SUM(Population) AS Total_Population, Continent FROM country GROUP BY Continent ) AS Total INNER JOIN ( SELECT SUM(Country_City_Population) AS City_Population, Continent FROM ( SELECT CountryCode, SUM(Population) AS Country_City_Population FROM city GROUP BY CountryCode ) AS City_Populations INNER JOIN country ON CountryCode = Code GROUP BY Continent ) AS City ON Total.Continent = City.Continent;

SELECT City.Region, Total_Population, City_Population, ( City_Population / Total_Population * 100 ) AS City_Percent, ( Total_Population - City_Population ) AS Country_Population, ( ( Total_Population - City_Population ) / Total_Population * 100 ) AS Country_Percent FROM ( SELECT SUM(Population) AS Total_Population, Region FROM country GROUP BY Region ) AS Total INNER JOIN ( SELECT SUM(Country_City_Population) AS City_Population, Region FROM ( SELECT CountryCode, SUM(Population) AS Country_City_Population FROM city GROUP BY CountryCode ) AS City_Populations INNER JOIN country ON CountryCode = Code GROUP BY Region ) AS City ON Total.Region = City.Region;

SELECT Country.Name, Total_Population, City_Population, ( City_Population / Total_Population * 100 ) AS City_Percent, ( Total_Population - City_Population ) AS Country_Population, ( ( Total_Population - City_Population ) / Total_Population * 100 ) AS Country_Percent FROM ( SELECT SUM(Population) AS Total_Population, Code, Name FROM country GROUP BY Code ) AS Country INNER JOIN ( SELECT SUM(Population) AS City_Population, CountryCode FROM city GROUP BY CountryCode ) AS City ON Country.Code = City.CountryCode;


-- get population
SELECT SUM(Population) FROM country; -- Earth
SELECT SUM(Population) FROM country WHERE Continent = 'given';
SELECT SUM(Population) FROM country WHERE Region = 'given';
SELECT SUM(Population) FROM country WHERE Code = 'given';
SELECT SUM(Population) FROM country WHERE Continent = 'given';
SELECT SUM(Population) FROM city WHERE District = 'given';
SELECT SUM(Population) FROM city WHERE ID = 'given';


-- population by spoken language
SELECT Language, SUM( Population * Percentage / 100 ) AS Language_Population , ( SUM( Population * Percentage / 100 ) / Total_Population * 100 ) AS Total_Percentage FROM country INNER JOIN countrylanguage ON CountryCode = Code, ( SELECT SUM( Population ) AS Total_Population FROM country ) AS Total_Population_Sum GROUP BY Language ORDER BY Total_Percentage DESC LIMIT 5; -- most spoken 5 languages ( same as requirement languages )

SELECT Language, SUM( Population * Percentage / 100 ) AS Language_Population , ( SUM( Population * Percentage / 100 ) / Total_Population * 100 ) AS Total_Percentage FROM country INNER JOIN countrylanguage ON CountryCode = Code, ( SELECT SUM( Population ) AS Total_Population FROM country ) AS Total_Population_Sum WHERE Language IN ( 'Chinese', 'English', 'Hindi', 'Spanish', 'Arabic' ) GROUP BY Language; -- requirement languages
