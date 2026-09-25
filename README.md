# Smart Expense Tracker

A console-based expense management application built using **Java, JDBC, and MySQL**. The application allows users to register and log in, manage their expenses, and generate monthly expense reports.

## 📌 About the Project

The **Smart Expense Tracker** is a Java console application designed to help users manage their daily expenses.

The project uses **JDBC** to connect the Java application with a **MySQL database** and follows a simple **MVC-style structure** to separate data, database operations, and user interaction.

## 🚀 Features

- User registration
- User login
- Add new expenses
- View expenses
- Edit existing expenses
- Delete expenses
- Monthly expense reports
- Total expenses by category
- Input validation
- Exception handling
- MySQL database integration
- JDBC-based CRUD operations

## 🛠️ Technologies Used

- **Java**
- **JDBC**
- **MySQL**
- **Eclipse IDE**
- **Git & GitHub**

## 🏗️ Project Structure

The project follows a simple MVC-style structure:

### Model
Contains classes that represent application data, such as users and expenses.

### Controller
Handles JDBC operations and communication between the application and MySQL database.

### View
Provides the console-based user interface and displays application output.

## 🗄️ Database

The application uses **MySQL** to store user and expense information.

The SQL script used to create the database and required tables is available in:

```text
database/smart_expense_tracker.sql
```

## 📂 Repository Structure

```text
Smart_Expense_Tracker/
│
├── src/
│   └── Java source files
│
├── database/
│   └── smart_expense_tracker.sql
│
├── screenshots/
│   ├── registration.png
│   ├── login.png
│   ├── add-expense.png
│   ├── view-expenses.png
│   └── monthly-report.png
│
├── README.md
└── .gitignore
```

## ▶️ How to Run

### 1. Clone the Repository

Clone this repository to your local system.

### 2. Open the Project

Open the project in **Eclipse IDE**.

### 3. Configure MySQL

Install MySQL and create the required database by running the SQL script:

```text
database/smart_expense_tracker.sql
```

### 4. Configure Database Connection

Update the JDBC database connection details in the project with your own MySQL username and password.

Do not commit personal database credentials to GitHub.

### 5. Add MySQL JDBC Driver

Make sure the MySQL Connector/J driver is available in the project classpath.

### 6. Run the Application

Run the main Java class from Eclipse.

## 📸 Screenshots

### User Registration

![Registration](screenshots/registration.png)

### User Login

![Login](screenshots/login.png)

### Add Expense

![Add Expense](screenshots/add-expense.png)

### View Expenses

![View Expenses](screenshots/view-expenses.png)

### Monthly Expense Report

![Monthly Report](screenshots/monthly-report.png)

## 📚 Concepts Practiced

This project helped me practice:

- Java OOP
- Classes and Objects
- Encapsulation
- Exception Handling
- JDBC
- MySQL
- PreparedStatement
- ResultSet
- CRUD Operations
- SQL Queries
- Database Connectivity
- Input Validation
- MVC-style project organization

## 🎯 Learning Outcome

Through this project, I gained practical experience in connecting a Java application with a relational database using JDBC and implementing complete CRUD operations with MySQL.

## 👨‍💻 Author

**Divyansh Upadhyay**

GitHub: [divyansh-techy](https://github.com/divyansh-techy)
