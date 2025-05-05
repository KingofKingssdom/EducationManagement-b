# Spring Boot Education Project

## Giới thiệu
Đây là dự án backend REST API được xây dựng với **Spring Boot 3**, **Java 17** và **PostgreSQL**. 
Ứng dụng này cung cấp các API để quản lý dữ liệu giáo dục như thông tin sinh viên, khoá học, điểm số,...

---

##  Công nghệ sử dụng
- Java 17
- Spring Boot 3.x
- PostgreSQL 15+
- Maven

---

## Yêu cầu trước khi chạy
-  Cài đặt **Java 17**
- Cài đặt **PostgreSQL**
- Cài đặt **Maven**


##  Cài đặt database
1. Tạo database mới
    CREATE DATABASE education1;

2. Import dữ liệu từ file SQL
   psql -U postgres -d education1 -f db/education.sql

3. Cấu hình kết nối database
   Mở file src/main/resources/application.properties và chỉnh lại:
   spring.datasource.url=jdbc:postgresql://localhost:5432/education1
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword


