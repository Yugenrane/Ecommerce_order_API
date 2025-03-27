# E-commerce Order Microservice

## Overview
Complete order management system with payment processing, shipping address handling, and customer order history.

## Features
✅ Order placement with Razorpay integration  
✅ Shipping address management  
✅ Customer order history  
✅ Product-order relationships  
✅ Comprehensive repository layer  

---

## 🏗️ Project Structure (Key Components)
```
src/
├── main/
│   ├── java/com/example/Ecommerce_order/
│   │   ├── entities/
│   │   │   ├── Orders.java
│   │   │   ├── OrderItem.java
│   │   │   ├── ShippingAddress.java
│   │   │   ├── Customer.java
│   │   │   ├── Product.java
│   │   ├── repositories/
│   │   │   ├── CustomerRepo.java
│   │   │   ├── OrderRepo.java
│   │   │   ├── OrderItemRepo.java
│   │   │   ├── ShippingAddressRepo.java
│   │   ├── services/
│   │   │   ├── OrderService.java
│   │   ├── dto/
│   │   │   ├── OrderRequestDTO.java
│   │   │   ├── OrderResponseDTO.java
│   │   ├── controllers/
│   │   │   ├── OrderController.java
```

---

## 🚀 Core Endpoints
| Endpoint | Method | Request | Response | Description |
|----------|--------|---------|----------|-------------|
| `/api/orders` | **POST** | `OrderRequestDTO` | `OrderResponseDTO` | Places an order with payment |
| `/api/orders/{orderId}` | **GET** | `orderId` (Path Variable) | `OrderResponseDTO` | Retrieves order details |
| `/api/orders/customer/{customerId}` | **GET** | `customerId` (Path Variable) | `List<OrderResponseDTO>` | Fetches order history for a customer |

---

## 🔧 Service Layer
Key services include:
- Order processing with payment validation
- Shipping address persistence
- Order-item relationship management
- Customer order history tracking

---

## ⚙️ Tech Stack
- **Backend**: Spring Boot 3.4.2 + JPA
- **Database**: MySQL (JPA repositories)
- **Payment**: Razorpay integration
- **Architecture**: Repository pattern + DTOs

---

## 🛠️ Setup
1. **Configure MySQL** in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/order_db
spring.datasource.username=root
spring.datasource.password=Yugen@1998
spring.jpa.hibernate.ddl-auto=update
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

2. **Add Razorpay credentials**
3. **Start the application**:
```bash
mvn spring-boot:run
```

---

## 📄 License
MIT © 2024

