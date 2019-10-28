## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Execution of Project](#execution-of-project)
* [Reports](#reports)

## General info
 * This project is about creating a UI based automation framework for testing  [FreeCRM ](https://freecrm.com) site
 
  Have tested the following features of the applications - 

    * LoginPage
    * HomePage
    * ContactsPage
	
## Technologies
Project is created with:
* Concepts of JAVA & Selenium.
* Page Object Design Patter (POM) for creating automation framework for UI testing.
* Separate class files are created for Pages where object properties are stored using FindBy annotations.
* TestNG concepts for writing test cases in separate folders and putting assertions.
* Event listeners for printing logs in the console for debugging and analysis purpose.
* Extent Reports for reporting purpose of the entire suite.
	
## Setup

* **Clone repository:**

        git clone https://github.com/sk24100/FreeCRMTest
 
* **Prerequisites:**
    * Install the latest version of [Java](https://java.com) (1.8) and [Maven](https://maven.apache.org/download.html).
    * Set the environment variable: 
    * You may need to set your `JAVA_HOME`and `MAVEN_HOME`


After you done with it you have to do **mvn clean test**
* $ mvn clean
* $ mvn test

## Execution of Project

  Maven project will trigger the POM.xml and which in turn will run the Testng.xml suite.
  
## Reports
 
  Once the project is successfully build and execution completed the results got stored in **test-output** folder by the name of **CRM_Extent.html**
  On opening the html file you will see execution status per test cases as Pass or Fail.
