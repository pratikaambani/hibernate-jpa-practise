Hibernate

Ch01|02:
--------
What is Hibernate:
ORM Tool
Used in data layer
Implements JPA: Set of standards 


Problem Hibernate solves:

Class: ID, Name, Address, Phone, DOB
Ideally we'll use JDBC to connect with RDBMS.

datatype issues
object mapping with classes


Steps:
JDBC connectivity
Model Objects, using annotation
Service methods to create model object, using hibernate api
DB Design, not required
DAO Method, not required


password:password

new schema: ifinances

add account in users
pratika:ambani

ORM framework that implements JPA Specifications.
JPA Specifications part of Java EE Platform, defines specifications for persisting data
Contains HQL


How it works:
Configurations		: hibernate.cfg.xml or hibernate.properties
Annotations			: Mapping metadata, getters and setters
session.save(entity): Create session and persistence models, obtain session from Sessionfactory

SessionFactory		: Contains holds all configurations and metadata


+ves:
Removes SQL from codebase
Reduces development time
Reduces lines of code
improves maintainability
increases portability by abstracting RDBMS(DB independence)
Well Documented



Data Model vs Object Model
							Data Model		|		Object Model
Identity				|	Primary Keys	|	equals()
Associations			|	Foreign Keys	|	Object References
Association Navigation	|		Joins		|	Accessors/References
Inheritance				|	Not Available	|	Available


Challenges with JDBC:
Bulky Code
Error Handling
Key Management(primary, ordered....)
developer wise different implementation style
potential for errors
Too many open db connections would be disastrous


------------------------------------------------------------------------------------------------------------------------

Ch03 : Getting Started
----------------------

first hibernate application: project hibernate-jpa-practise
setup and configuration hibernate: xml and props
mapping metadata for entity: annotations
Use a session to perform persistence operations: transactions

Main Notes: Basic Example, Annotations


**Codebase**: initial setup, maven pom and dependencies

Class: User

@Entity: L8W8 persistence domain object, represents table in db
@Table:
@Id: Primary Key
@GeneratedValue: Specify how we obtain value of primary key for perticular field()
@Column:

Class: HibernateUtil - Hibernate connectivity

dependency: mysql-connector-java
hibernate.properties: un, pw, driver

hibenate.connection.username=pratika
hibenate.connection.password=ambani
hibenate.connection.url=jdbc:mysql://localhost:3306/ifinances
hibenate.connection.driver_class=com.mysql.jdbc.Driver
hibenate.dialect=org.hibernate.dialect.MySQL5Dialect


XML Based configuration

    <session-factory>
        <!--Database Settings-->
        <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
        <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/ifinances?useSSL=false</property>
        <property name="hibernate.connection.username">partik</property>
        <property name="hibernate.connection.password">password</property>
        <!--SQL Dialect-->
        <property name="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</property>
        <!--Echoes all SQL Statements-->
        <property name="hibernate.show_sql">true</property>
        <property name="hibernate.format_sql">true</property>
        <!--PoJo Class-->
        <mapping class="com.practise.hibernate.data.entities.User"/>
    </session-factory>


Calling Perstance Methods
retrieve session from SessionFactory and call persistance operations on that session

Inserting data into Table: select * from finances_user;
ApplicationCallingPersistanceMethods.java

        User user = new User();
        user.setBirthDate(new Date());
        user.setCreatedBy("Developer");
        user.setCreatedDate(new Date());
        user.setEmailAddress("send@sender.sending");
        user.setFirstName("Sachin");
        user.setLastName("Tendulkar");
        user.setLastUpdatedDate(new Date());
        user.setLastUpdatedBy("Pratik");


------------------------------------------------------------------------------------------------------------------------

Ch04 : Basic Mapping Annotations
--------------------------------

JPA-Interfaces
Hibernate-Implementation

JPA Annotations-
    Defined by JPA 2.0 Specification,
    Provices standard API on which ORM Vendors should base their implementation,
    package: javax.persistence

Hibernate Annotations-
    Provides features beyond the ones specified in JPA,
    Couples application to Hibernate

Anything you can do with JPA, you can do with Hibernate.
means, you can not do everything that you can do with Hibernate


Field vs Property Access:
These are the two ways Hibernate can access the values(using fields and getters)

Use @Access Annotation to define any of the two types
