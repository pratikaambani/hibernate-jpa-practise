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
infinite:P@sswo.rd1


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
--------

first hibernate application: project hibernate-jpa-practise
setup and configuration hibernate: xml and props
mapping metadata for entity: annotations
Use a session to perform persistence operations: transactions

Main Notes: Basic Example, Annotations


**Codebase**: initial setup, maven pom and dependencies