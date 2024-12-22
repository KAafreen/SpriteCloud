# SpriteCloud

This project contains UI test for Swag Labs login page and API tests for reqres create user APIs.

## Table of Contents
1. [Getting Started](#getting-started)
2. [Running the Tests](#running-the-tests)
3. [Reporting](#reporting)
4. [Contact](#contact)

## Getting Started

### Prerequisites
- Java 11 or later
- Gradle 8.0 or later
- Selenium grid setup
  - Selenium server : selenium-server-4.11.0.jar

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/KAafreen/SpriteCloud.git

### Setting up selenium grid
1. Download selenium jar selenium-server-4.11.0.jar
   ```bash
    https://www.selenium.dev/downloads/
2. Start hub using below command
    ```bash
   java -jar selenium-server-4.11.0.jar hub
3. Start node using below command
    ```bash
   java -jar selenium-server-4.11.0.jar node --detect-drivers true
4. Check if selenium grid is up and running using http://localhost:4444/ui

## Running the Tests
1. Update below configurations in build.gradle.kts file
    ```bash
    browser=chrome
    hubURL=http://localhost:4444
    environment=qa
    testNG group=sanity, regression, ui etc
2. Run Tests Using Gradle
    ```bash
    ./gradlew test
   
## Reporting
1. On test execution, testNG results are generated as default HTML report
   ```bash
   <project-dir>/build/reports/tests/test/index.html

## Contact
Email: aafreenkhan.qa@gmail.com
LinkedIn: https://www.linkedin.com/in/khan-aafreen/

   


