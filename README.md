# fruit-shop-backend


Fruit Shop Java Application


How to use:

    • Install Postgresql https://www.postgresql.org/download/

    • Change password of postgres to "soraya" or change file /fruitshop/src/main/resources/application.properties:
        ◦ "spring.datasource.password=your password"

	To change password of postgres run:  $ sudo su postgres
					      	  $ psql
					      	  $ ALTER USER postgres WITH PASSWORD 'soraya'

    • Install dbeaver https://dbeaver.io/download/
    • Run scripts that are in file /fruitshop/src/main/resources/scripts/database.sql in dbeaver
    • Install JDK https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html
    • Set variable JAVA_HOME:
          In terminal:
        ◦ $ export JAVA_HOME=/usr/lib/jvm/java-8-openjdk
	(Note: /usr/lib/jvm/java-8-openjdk is symbolically used here just for demonstration, you should use your path as per your installation.)

        ◦ Set PATH (Environment Variable): $ export PATH=$PATH:$JAVA_HOME/bin
        ◦ Check your installation: $ java – version
    • Install Eclipse IDE for Java EE Developers https://www.eclipse.org/downloads/packages/installer
    • In eclipse go to Help>EclipseMarketplace.. and install Spring Tools 4 for Spring Boot
    • Clone project from git
    • In eclipse select File>Import>Existing Maven Project and then select project cloned
    • In eclipse select project, right click on it and Run as > Spring Boot App

