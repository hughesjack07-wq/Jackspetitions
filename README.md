# Jackspetitions

A Spring Boot web application for creating, viewing, searching, and signing petitions.
Built for CT5209 – Cloud DevOps, University of Galway.

---

## Prerequisites

Before running the application, make sure you have the following installed:

- [Java 17](https://adoptium.net/)
- [Maven](https://maven.apache.org/) (or use the included Maven wrapper)
- [Git](https://git-scm.com/)

---

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/hughesjack07-wq/Jackspetitions.git
cd Jackspetitions/Jackspetitions
```

### 2. Run the Application Locally

Using the Maven wrapper (no Maven installation required):

```bash
chmod +x mvnw
./mvnw spring-boot:run
```

Or on Windows:

```bash
mvnw.cmd spring-boot:run
```

The application will start on **http://localhost:8080**

---

## Application Pages

| Page | URL | Description |
|------|-----|-------------|
| Petitions List | `/` | View all petitions |
| Create Petition | `/create` | Submit a new petition |
| Search Petitions | `/search` | Search petitions by keyword |
| View & Sign | `/view/{id}` | View a petition and add your signature |

Two sample petitions are pre-loaded on startup.

---

## Building a WAR File

To package the application as a deployable WAR file:

```bash
./mvnw clean package -DskipTests
```

The WAR file will be generated at:

```
target/jackspetitions.war
```

---

## Running Tests

```bash
./mvnw test
```

---

## CI/CD Pipeline

This project uses a Jenkins declarative pipeline defined in the `Jenkinsfile` at the root of the repository.

### Pipeline Stages

1. **Get Code** – Pulls the latest code from the `main` branch on GitHub
2. **Build** – Compiles the project using Maven and Java 17
3. **Test** – Runs the unit test suite
4. **Package & Archive** – Packages as `jackspetitions.war` and archives as a Jenkins artifact
5. **Deploy** – Deploys to Apache Tomcat on Amazon EC2 after manual developer approval

### Jenkins Setup Requirements

- Jenkins running with Java 21+
- Java 17 JDK installed on the Jenkins server (for Maven compilation)
- [Deploy to Container](https://plugins.jenkins.io/deploy/) Jenkins plugin installed
- Tomcat credentials configured in Jenkins with ID `tomcat-credentials`

---

## Live Deployment

The application is publicly accessible at:

**http://13.48.249.160:9090/jackspetitions**

Deployed on Apache Tomcat 10 running on Amazon EC2 (Ubuntu).

---

## Project Structure

```
Jackspetitions/
├── src/
│   ├── main/
│   │   ├── java/jackspetitions/
│   │   │   ├── JackspetitionsApplication.java
│   │   │   ├── Petition.java
│   │   │   ├── PetitionController.java
│   │   │   └── ServletInitializer.java
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── view-all.html
│   │       │   ├── create-petition.html
│   │       │   ├── search-results.html
│   │       │   └── view-petition.html
│   │       └── application.properties
│   └── test/
├── Jenkinsfile
├── pom.xml
└── README.md
```

---

## Author

**Jack Hughes**  
Student ID: 25105068  
j.hughes19@universityofgalway.ie  
University of Galway
