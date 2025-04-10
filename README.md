project-root/
│
├── src/
│   └── main/
│       └── java/
│           ├── baseclass/
│           │   ├── BaseClass.java
│           │   ├── ConfigurationManager.java
│           │   ├── ReportManager.java
│           │   ├── TestListener.java
│           │   └── Utility.java
│           │
│           ├── pompages/
│           │   └── [PageClasses].java
│           │
│           └── demotest/
│               └── [TestClasses].java
│
├── reports/
│   └── [ExtentReportsOutput].html
│
├── configration/
│   └── config.properties
│
├── pom.xml
└── README.md

1. BaseClass.java
This file sets up and tears down the test environment:
@BeforeMethod: runs before each test (e.g., launches browser)

@AfterMethod: runs after each test (e.g., closes browser)

Helps in avoiding code duplication and keeps your tests clean.

2. ConfigurationManager.java
A utility to read from config.properties, where you store values like:

browser=chrome

url=https://yourapp.com

This allows you to change settings without editing code.

3. ReportManager.java
Manages ExtentReports setup — which provides beautiful, interactive test reports in HTML format. These reports include pass/fail status, logs, screenshots, etc.

4. TestListener.java
Hooks into TestNG's test lifecycle (start, success, failure, etc.). It:

Logs results in reports

Takes screenshots on failure

This is crucial for debugging failed tests.

4. Utility.java
Contains reusable helper methods like:

Taking screenshots

Waiting for elements

Keeps common actions in one place.

5. Page Object Classes (pompages package)
Each web page of your application gets its own class:

Defines web elements using @FindBy

Contains methods to perform actions

This helps separate UI structure from test logic
