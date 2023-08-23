# get_hookd_ai_web_ui_autiomation

## Technology Used

* Test Tool: Selenium
* Language: Java
* Build Tool: Maven
* Architecture: POM (Page Object Model)
* Test Framework: TestNG
* IDE: VSCode
* Version Control: Github and Github Desktop


## Environment Setup

* Install JDK 1.8
* Install Maven (https://maven.apache.org/install.html)
* Install "Extension Pack for Java" in VSCode
* Add jdk directory as JAVA_HOME at system variables
* Add jdk bin directory in Path at system variables
* Add maven bin directory in Path at system variables
* Check your current Chrome version and download the corresponding Chrome driver
* Add chromedriver.exe file location in Path at system variables

## Overview of the Test Files

* There are 2 test files in total:
    * LoginTest.java 
        * contains only the login test
    * HomePageTest.java 
        * contains 3 tests:
            * folder creation
            * board creation
            * save an ad to the created board 



## How to Run the Script

### This will run all the test files arbitrarily

* mvn clean
* mvn install

### To run with proper order use the following command

[Replace the testng.xml file absolute path with yours]

* mvn clean test "-Dsurefire.suiteXmlFiles=C:/Users/username/directory/GetHookdAI Automaiton/get_hookd_ai_web_ui_automation/get-hookd-ai/src/test/resources/testng.xml"

### Note

Each test functions independently, so they all begin with the login process.
