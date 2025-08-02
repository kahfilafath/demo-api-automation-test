# Demo API Automation Test

📦 Setup & Requirements

This project demonstrates API automation testing using Java, RestAssured, and JUnit Framework.

✅ Prerequisites

| Tool / Application | Version            | Description                                           |
| ------------------ | ------------------ | ----------------------------------------------------- |
| **Java JDK**       | 21                 | Required to compile and execute test classes.         |
| **Gradle**         | 8+                 | Build tool to manage dependencies and run test tasks. |
| **Git**            | Any                | Used for cloning the project.                         |
| **IDE (Optional)** | IntelliJ / Eclipse | For easier navigation, running, and debugging tests.  |


🔧 Installation Steps

1. Clone the Repository: 

   git clone https://github.com/kahfilafath/demo-api-automation-test.git
3. Make sure to set up JAVA_HOME first in the zshrc profile (for Mac Users), and in the Environment Variable (for Windows Users):
   
   export JAVA_HOME=$(/usr/libexec/java_home)
   export PATH=$JAVA_HOME/bin:$PATH
   
5. Run Tests via Gradle:
   
   ./gradlew clean test

