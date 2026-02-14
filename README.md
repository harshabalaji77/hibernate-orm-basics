## 🖇️ Hibernate ORM Basics

A comprehensive learning project demonstrating fundamental Hibernate ORM operations through practical examples. This repository contains eight modular Maven projects, each focusing on specific Hibernate concepts and database operations.

### Project Structure

- **firstHibernate** - Basic entity creation and persistence (INSERT)
- **secondHibernate** - Reading entities from database (SELECT)
- **thirdHibernate** - Deleting entities from database (DELETE)
- **fourthHibernate** - Updating entities in database (UPDATE)
- **fifthHibernate** - Advanced querying techniques
- **sixthHibernate** - Relationship mappings and associations
- **seventhHibernate** - Caching strategies and performance optimization
- **eighthHibernate** - Transaction management and error handling

### Technology Stack

- **Java 17** - Programming language
- **Hibernate 7.2.2.Final** - ORM framework
- **MySQL 8.0.33** - Database system
- **Maven** - Build and dependency management

### Prerequisites

- Java Development Kit (JDK) 17 or higher
- Apache Maven 3.6 or higher
- MySQL Server 8.0 or higher

### Database Setup

1. Create a database named `hibernatedb`
2. Update database credentials in `hibernate.cfg.xml` for each project:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/hibernatedb</property>
<property name="hibernate.connection.username">your_username</property>
<property name="hibernate.connection.password">your_password</property>
```

### Running the Projects

Navigate to any project directory and run:

```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.kodnest.{projectName}.App"
```

**Example for firstHibernate:**
```bash
cd firstHibernate
mvn clean compile
mvn exec:java -Dexec.mainClass="com.kodnest.firstHibernate.App"
```

### Core Concepts

- **Entity Management** - JPA annotations, primary keys, column mappings
- **CRUD Operations** - Create, Read, Update, Delete operations
- **Session Management** - Session factory, transactions, resource handling
- **Configuration** - Database connections, dialects, SQL logging

### Learning Path

Progress through projects sequentially: firstHibernate → secondHibernate → thirdHibernate → fourthHibernate → advanced modules
