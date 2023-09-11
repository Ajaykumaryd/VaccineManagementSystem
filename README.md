# Vaccination Management System

The Vaccine Management System (Backend) is a robust and efficient backend system developed using Spring Boot, Hibernate, JPA, and MySQL. It serves as the core component of a comprehensive vaccine management solution, focusing on managing data and providing APIs for seamless interaction with the system. This backend system plays a crucial role in tracking doctors, vaccination centers, appointments, and doses administered to users.

# Features
User Management: The system allows the registration and management of users who can book vaccination appointments.

Doctor Management: Healthcare professionals can register themselves, providing essential information for scheduling appointments and administering vaccinations.

Vaccination Center Management: The system maintains a database of vaccination centers, making it easier to allocate appointments and vaccines efficiently.

Appointment Booking: Users can schedule vaccination appointments, choose their preferred vaccination center, and select a suitable time slot.

Dose Administration: Healthcare providers can record the doses administered to users, ensuring accurate and up-to-date vaccination records.

APIs: The system offers a robust set of more than 20 APIs that enable integration with other systems and applications, making it versatile and adaptable to various use cases.












## Models
    User
    Dose
    Doctor
    Appointment
    VaccinationCentre

## Technology and Tools used
  * **Java**
  * **Spring Boot**
  * **Spring Data JPA**
  * **RESTful APIs**
  * **Hibernate(MySQL)**
  * **Postman**
  * **Swagger**
  * **Email Integration**
  * **Maven**
  * **Git & GitHub**
  * **Intellij**
# Overview of Project

## Flow Diagram
![flowchart.png](src%2Fmain%2Fjava%2Fcom%2Fexample%2FvaccineManagementSystem%2FImages%2Fflowchart.png)
## APIs Screen Shots

![User.png](src%2Fmain%2Fjava%2Fcom%2Fexample%2FvaccineManagementSystem%2FImages%2FUser.png)

![Doctor.png](src%2Fmain%2Fjava%2Fcom%2Fexample%2FvaccineManagementSystem%2FImages%2FDoctor.png)

![Appointment.png](src%2Fmain%2Fjava%2Fcom%2Fexample%2FvaccineManagementSystem%2FImages%2FAppointment.png)

![Centre And Dose.png](src%2Fmain%2Fjava%2Fcom%2Fexample%2FvaccineManagementSystem%2FImages%2FCentre%20And%20Dose.png)

# Usage
Users, doctors, and vaccination center administrators can interact with the system through the web interface or by utilizing the provided APIs. Below are some common usage scenarios:

User Registration: Users can create accounts and log in to book vaccination appointments.

Doctor Registration: Healthcare professionals can register their profiles, making them available for appointment scheduling.

Vaccination Center Management: Administrators can add, modify, or remove vaccination centers as needed.

Appointment Booking: Users can search for available appointments and book slots convenient for them.

Dose Administration: Doctors can record the doses administered to users, updating their vaccination status.

API Integration: Developers can integrate the system with other applications or services using the provided APIs.





## Code Organization
The code for this Vaccination Management system can be organized into separate classes or packages for each entity, along with any necessary helper classes or functions. The code follow Object-Oriented Programming principles and best practices such as encapsulation, modularity, and proper separation of concerns.

## Setup and Installation
To set up the Vaccination Management System locally, follow these steps:

1. Clone the repository from GitHub.
2. Open the project in your preferred IDE.
3. Build the project to resolve dependencies.
4. Configure the application properties with your database connection details.
5. Run the application.
6. Access the API endpoints using a tool like **Swagger** or **Postman**.
## Contributions
Contributions to the Vaccination Management System are welcome! If you encounter any issues or have suggestions for improvement, please create a new issue or submit a pull request.
