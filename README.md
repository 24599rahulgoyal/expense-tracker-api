# 💰 Expense Tracker API

A RESTful API built with **Spring Boot** and **MySQL** that helps users track their daily expenses securely with JWT authentication.

---

## 🛠️ Tech Stack

| Technology | Purpose |
|---|---|
| Java 21 | Programming Language |
| Spring Boot 3.5 | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT (JSON Web Token) | Secure API Access |
| Spring Data JPA | Database ORM |
| Hibernate | JPA Implementation |
| MySQL | Relational Database |
| Lombok | Reduce Boilerplate Code |
| Maven | Dependency Management |
| Postman | API Testing |

---

## ✨ Features

- ✅ User Registration and Login
- ✅ JWT Token Based Authentication
- ✅ Password Encryption with BCrypt
- ✅ Add, View, Update, Delete Expenses
- ✅ Input Validation on all fields
- ✅ Global Exception Handling
- ✅ Clean and Professional Error Responses
- ✅ RESTful API Design

---

## 📁 Project Structure

src/main/java/com/rahul/demo/

│

├── controller/

│   ├── AuthController.java      # Login & Register APIs

│   └── ExpenseController.java   # Expense CRUD APIs

│

├── service/

│   └── ExpenseService.java      # Business Logic

│

├── repository/

│   ├── ExpenseRepository.java   # Expense DB Operations

│   └── UserRepository.java      # User DB Operations

│

├── model/

│   ├── Expense.java             # Expense Entity

│   └── User.java                # User Entity

│

├── security/

│   ├── JwtUtil.java             # JWT Token Utility

│   ├── JwtFilter.java           # JWT Request Filter

│   └── SecurityConfig.java      # Security Configuration

│

└── exception/

├── ResourceNotFoundException.java  # Custom Exception

├── ErrorResponse.java             # Error Response Model

└── GlobalExceptionHandler.java    # Global Error Handler

---

## 🚀 Getting Started

### Prerequisites
- Java 21
- MySQL 8.0
- Maven

### Setup Steps

1. **Clone the repository**
```bash
git clone https://github.com/24599rahulgoyal/expense-tracker-api.git
cd expense-tracker-api
```

2. **Create MySQL Database**
```sql
CREATE DATABASE expense_tracker;
```

3. **Configure application.properties**
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

4. **Run the application**
```bash
./mvnw spring-boot:run
```

5. **API is running at**

http://localhost:8080

---

## 📡 API Endpoints

### 🔐 Authentication APIs

| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| POST | `/api/auth/register` | Register new user | No |
| POST | `/api/auth/login` | Login and get JWT token | No |

### 💰 Expense APIs

| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| GET | `/api/expenses` | Get all expenses | ✅ Yes |
| GET | `/api/expenses/{id}` | Get expense by ID | ✅ Yes |
| POST | `/api/expenses` | Add new expense | ✅ Yes |
| PUT | `/api/expenses/{id}` | Update expense | ✅ Yes |
| DELETE | `/api/expenses/{id}` | Delete expense | ✅ Yes |

---

## 🔐 How Authentication Works

1. Register a new user via `/api/auth/register`
2. Login via `/api/auth/login` — get JWT token in response
3. Add token to every request header:

Authorization: Bearer <your-jwt-token>

---

## 📝 Sample API Requests

### Register User
```json
POST /api/auth/register
{
    "username": "rahul",
    "password": "rahul123"
}
```

### Login
```json
POST /api/auth/login
{
    "username": "rahul",
    "password": "rahul123"
}
```

### Add Expense
```json
POST /api/expenses
Headers: Authorization: Bearer <token>

{
    "title": "Lunch",
    "amount": 150.00,
    "category": "Food",
    "date": "2026-06-28",
    "description": "Ate at restaurant"
}
```

---

## ⚠️ Error Handling

All errors return clean JSON responses:

```json
{
    "status": 404,
    "message": "Expense not found with id: 99",
    "timestamp": "2026-06-28T12:00:00"
}
```

---

## 👨‍💻 Author

**Rahul Goyal**
- GitHub: [@24599rahulgoyal](https://github.com/24599rahulgoyal)

---

## 📄 License

This project is open source and available under the [MIT License](LICENSE).
