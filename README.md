Sample Spring Java App (employees-spring-mvc)
======================
Provides RESTful services using Spring MVC and JdbcTemplate

Prior to deploying application

Configuring New Relic
* Edit newrelic.yml in src/main/resources/newrelic_agent.zip
  * enter newrelic key in (license_key:)
  * enter your application name in (app_name:)

To deploy application to Stackato
$ stackato push

or if application already exists in stackto environment
$ stackato update

To setup MySQL datatbase and test data:
$ stackato dbshell
$ mysql> source db/mysql-schema-data.sql;





