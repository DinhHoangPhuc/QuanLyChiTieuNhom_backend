# Group Budget App Back end

## Overview
This project is a backend for [Android Mobile Group Budget App](https://github.com/DinhHoangPhuc/QuanLyChiTieuNhom). It is built using Spring Boot for the backend and Android Studio for the mobile application.

## Features
- RESTful API implementation
- JWT authentication
- Refresh token
- MySQL database integration
- Input validation using Spring Boot Starter Validation
- Mobile application development with Android Studio

## Technologies Used
- Java
- Spring Boot
- MySQL
- Lombok
- Android Studio

## Getting Started

### Prerequisites
- Java 8 or higher
- Maven
- MySQL
- Android Studio
- VScode (or IntelliJ IDEA)

### Installation

1. **Clone the repository:**
    ```sh
    git clone https://github.com/DinhHoangPhuc/QuanLyChiTieuNhom.git
    cd QuanLyChiTieuNhom
    ```

2. **Backend Setup:**
    - Navigate to the backend directory:
      ```sh
      cd backend
      ```
    - Create the `application.properties` file in the `backend/src/main/resources` with your MySQL database credentials.
        ```sh
        spring.application.name=backend
        spring.datasource.url=
        spring.datasource.username=
        spring.datasource.password=
        spring.jpa.hibernate.ddl-auto=update

        spring.jackson.date-format=yyyy-MM-dd
        spring.jackson.time-zone=GMT

        spring.app.jwtSecret=
        spring.app.jwtExpirationMs=
        spring.app.jwtRefreshExpirationMs=
        ```
    - Build the project using Maven:
      ```sh
      mvn clean install
      ```
    - Run the Spring Boot application:
      ```sh
      mvn spring-boot:run
      ```

3. **Mobile Application Setup:**
    - Open the mobile project in Android Studio.
    - Sync the project with Gradle files.
    - Build and run the application on an emulator or physical device.

## Dependencies
The project uses the following dependencies as specified in the [`pom.xml`](command:_github.copilot.openRelativePath?%5B%7B%22scheme%22%3A%22file%22%2C%22authority%22%3A%22%22%2C%22path%22%3A%22%2Fc%3A%2FUsers%2FDINH%20HOANG%20PHUC%2FDesktop%2FOneDrive%20-%20Ho%20Chi%20Minh%20city%20University%20of%20Food%20Industry%2FHOC_TAP%2FHK_6%2FAndroid%2FNhom5_ST4%2FApi%2Fbackend%2Fpom.xml%22%2C%22query%22%3A%22%22%2C%22fragment%22%3A%22%22%7D%5D "c:\Users\DINH HOANG PHUC\Desktop\OneDrive - Ho Chi Minh city University of Food Industry\HOC_TAP\HK_6\Android\Nhom5_ST4\Api\backend\pom.xml") file:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency> 
        <groupId>org.springframework.boot</groupId> 
        <artifactId>spring-boot-starter-validation</artifactId> 
    </dependency>
</dependencies>