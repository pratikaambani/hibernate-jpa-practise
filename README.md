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

@Column Annotation:

insertable && updatable(Optional):
Whether the column is included in SQL INSERT statements generated by the persistence provider,
Check SQL Query, fields marked with "updatable = false" will not be available

       update
           FINANCES_USER
       set
           BIRTH_DATE=?,
           EMAIL_ADDRESS=?,
           FIRST_NAME=?,
           LAST_NAME=?,
           LAST_UPDATED_BY=?,
           LAST_UPDATED_DATE=?
       where
           USER_ID=?

nullable(Optional):
    Whether the database column is nullable
    Optional, default = true
    fields marked with "nullable = false" can not be null
    @Basic can also be used

Without using this, we'll face error from DB
<pre><code>
Caused by: com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException: Column 'BIRTH_DATE' cannot be null
	at sun.reflect.NativeConstructorAccessorImpl.newInstance0(Native Method)
	at sun.reflect.NativeConstructorAccessorImpl.newInstance(NativeConstructorAccessorImpl.java:62)
	at sun.reflect.DelegatingConstructorAccessorImpl.newInstance(DelegatingConstructorAccessorImpl.java:45)
	at java.lang.reflect.Constructor.newInstance(Constructor.java:423)
ERROR - Column 'BIRTH_DATE' cannot be null
</code></pre>

Upon using nullable=false, hibernate will only throw the exception

`Exception in thread "main" org.hibernate.PropertyValueException: not-null property references a null or transient value : com.practise.hibernate.data.entities.User.birthDate
	at org.hibernate.engine.internal.Nullability.checkNullability(Nullability.java:106)
	at org.hibernate.action.internal.AbstractEntityInsertAction.nullifyTransientReferencesIfNotAlready(AbstractEntityInsertAction.java:132)
	at org.hibernate.action.internal.EntityIdentityInsertAction.execute(EntityIdentityInsertAction.java:86)
	at org.hibernate.engine.spi.ActionQueue.execute(ActionQueue.java:490)
	at org.hibernate.engine.spi.ActionQueue.addResolvedEntityInsertAction(ActionQueue.java:195)
	at org.hibernate.engine.spi.ActionQueue.addInsertAction(ActionQueue.java:179)
	at org.hibernate.engine.spi.ActionQueue.addAction(ActionQueue.java:214)
	at org.hibernate.event.internal.AbstractSaveEventListener.addInsertAction(AbstractSaveEventListener.java:324)
	at org.hibernate.event.internal.AbstractSaveEventListener.performSaveOrReplicate(AbstractSaveEventListener.java:288)
	at org.hibernate.event.internal.AbstractSaveEventListener.performSave(AbstractSaveEventListener.java:194)
	at org.hibernate.event.internal.AbstractSaveEventListener.saveWithGeneratedId(AbstractSaveEventListener.java:125)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.saveWithGeneratedOrRequestedId(DefaultSaveOrUpdateEventListener.java:209)
	at org.hibernate.event.internal.DefaultSaveEventListener.saveWithGeneratedOrRequestedId(DefaultSaveEventListener.java:55)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.entityIsTransient(DefaultSaveOrUpdateEventListener.java:194)
	at org.hibernate.event.internal.DefaultSaveEventListener.performSaveOrUpdate(DefaultSaveEventListener.java:49)
	at org.hibernate.event.internal.DefaultSaveOrUpdateEventListener.onSaveOrUpdate(DefaultSaveOrUpdateEventListener.java:90)
	at org.hibernate.internal.SessionImpl.fireSave(SessionImpl.java:715)
	at org.hibernate.internal.SessionImpl.save(SessionImpl.java:707)
	at org.hibernate.internal.SessionImpl.save(SessionImpl.java:702)
	at com.practise.hibernate.data.ApplicationCallingPersistanceMethods.main(ApplicationCallingPersistanceMethods.java:27)`


Identifiers:

comparing identities: equals(), =
@GeneratedValue and @TableGenerator tweaks
- strategy = GenerationType.SEQUENCE, will be used when using Oracle DB, coz it doesn't have auto increment feature like MYSQL, fast
- strategy = GenerationType.AUTO, default, based on provider: oracle:seq, mysql:identity : PREFERABLE
- strategy = GenerationType.IDENTITY, slower 
- strategy = GenerationType.TABLE, generator = "user_table_generator": maintains primary keys in db tables


@Transient:
When do not wish to add field in Hibernate metadata
Ex. Added new member variable: valid but it is not available as a column in table, Below error.
Solution: Add @Transient

`ERROR - Unknown column 'valid' in 'field list'
INFO - HHH000010: On release of batch it still contained JDBC statements
Exception in thread "main" org.hibernate.exception.SQLGrammarException: could not execute statement
	at org.hibernate.exception.internal.SQLExceptionTypeDelegate.convert(SQLExceptionTypeDelegate.java:80)
	at org.hibernate.exception.internal.StandardSQLExceptionConverter.convert(StandardSQLExceptionConverter.java:49)
	at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:126)
	at org.hibernate.engine.jdbc.spi.SqlExceptionHelper.convert(SqlExceptionHelper.java:112)
	at org.hibernate.engine.jdbc.internal.ResultSetReturnImpl.executeUpdate(ResultSetReturnImpl.java:211)
	at org.hibernate.engine.jdbc.batch.internal.NonBatchingBatch.addToBatch(NonBatchingBatch.java:62)
	at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3124)
	at org.hibernate.persister.entity.AbstractEntityPersister.insert(AbstractEntityPersister.java:3581)
	at org.hibernate.action.internal.EntityInsertAction.execute(EntityInsertAction.java:104)
	at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:463)
	at org.hibernate.engine.spi.ActionQueue.executeActions(ActionQueue.java:349)
	at org.hibernate.event.internal.AbstractFlushingEventListener.performExecutions(AbstractFlushingEventListener.java:350)
	at org.hibernate.event.internal.DefaultFlushEventListener.onFlush(DefaultFlushEventListener.java:56)
	at org.hibernate.internal.SessionImpl.flush(SessionImpl.java:1222)
	at org.hibernate.internal.SessionImpl.managedFlush(SessionImpl.java:425)
	at org.hibernate.engine.transaction.internal.jdbc.JdbcTransaction.beforeTransactionCommit(JdbcTransaction.java:101)
	at org.hibernate.engine.transaction.spi.AbstractTransactionImpl.commit(AbstractTransactionImpl.java:177)`
	

@Temporal
Date and Time
We have java.util.Date as well as java.sql.Date


@Formula
To dynamically assign value of column
To derive a property based upon calculation performed at runtime

Hibernate annotation
`@Formula("lower(datediff(curdate(), birth_date)/365)")`

    select
        user0_.USER_ID as USER_ID1_0_0_,
        user0_.BIRTH_DATE as BIRTH_DA2_0_0_,
        user0_.CREATED_BY as CREATED_3_0_0_,
        user0_.CREATED_DATE as CREATED_4_0_0_,
        user0_.EMAIL_ADDRESS as EMAIL_AD5_0_0_,
        user0_.FIRST_NAME as FIRST_NA6_0_0_,
        user0_.LAST_NAME as LAST_NAM7_0_0_,
        user0_.LAST_UPDATED_BY as LAST_UPD8_0_0_,
        user0_.LAST_UPDATED_DATE as LAST_UPD9_0_0_,
        lower(datediff(curdate(),
        user0_.birth_date)/365) as formula0_0_ 
    from
        FINANCES_USER user0_ 
    where
        user0_.USER_ID=?



Basic Value Types:

- Entity Types: have a db identity
corresponds with a db row
They have typical hibernate lifecycle

- Value Types: don't have a db identity
   - Basic: String, Long
   - Composite: Contains other fields in it : Address
   - Collection: Holds other value types : List<String>


------------------------------------------------------------------------------------------------------------------------

Ch05 : Composite and Collection Value Type Mappings
----------------------------------------------------

Provide mapping metadata for a composite value type
Map a collection of basic value types
Map a collection of composite value types

Composite Value Type:
Represents a group of values in a single Java Type
Composite(Hibernate) == Embedded(JPA)
They do not have id or table
They are only persisted or queried in the context of its parent
Data is embedded in source object's table

Example:
Bank has: id(@Id), name, List<String>(Collection), Address(Composite), mobileNumber


- Collection Value Type:
Can define collection of basic or composite value types
They don't have unique identity

@AttributeOverrides

* For Collection Types
@ElementCollection
@CollectionTable(name, jointables)
@JoinColumn

- Mapping:
@MapKeyColumn

Composite + Collection
@ElementCollection
@CollectionTable(name="USER_ADDRESS", joinColumns=@JoinColumn(name="USER_ID"))
List<Address> address = new ArrayList<Address>();





Entity Associations

Relationship == Association
Reference from one entity to another
Map collections of entity types
bi and uni directional relationship

Owning Entities and Nonowning Entities

Example: 1-1, 1-*, *-1, *-*


1-1
Unidirectional:
@OneToOne(cascade)
@JoinColumn(column_name, reference_column_name):  To persist data that is stored in field, foreign key

Bidirectional Relationships
@OneToOne(mappedBy)

1-*
Bank Account Holder: 1Account - *Transacions
Unidirectional:
@OneToMany(name, nullable)

Bidirectional:
@ManyToOne
@JoinColumn(name)


@JoinTable:

	
====================================================================

@Embedded

Usually we primary key in the table but what if,
example: Employee.Id is primary and people don't wanna search employees by id.
And they wanna use it by name with dept combination.

In this situation it doesn't make sense to have single primary key.

Rather use compositely unique values ==> @Embedded on class and @EmbeddedId on the Class of composite unique fields. Use this class in main class containing @Embedded annotation

Session vs SessionFactory
=========================

SessionFactorySessionFactory is a factory class for Session objects. It is available for the whole application while a Session is only available for particular transaction.
SessionFactory is an instance which will create Session objects.

Session:
Short lived
Handles first level cache (once db called for get, doesn't give another call)
Methods: byId(), clear(), close(), contains(), delete(), disconnect(), flush(), save(), update()

SessionFactory:
Long lived
Handles second level cache (ex. ehCache)
Methods: getCacge, isClosed(), openSession(), getCurrentSession()
