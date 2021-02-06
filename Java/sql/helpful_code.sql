CREATE USER java_statistics IDENTIFIED BY 'java_statistics'; -- Made User for java application
GRANT ALL ON `world`.* TO 'java_statistics';

mariadb --user=java_statistics --password=java_statistics;
mariadb -N -B world < ../sql/get_city.sql > sql_response -- 

