# HKAselenium-google-automate-search
               This repository demonstrates the automation of a Google search using Selenium WebDriver with Java. The 
               project includes a simple script that interacts with Google's homepage, performs a search query, and 
               validates the results page.

A. Project Overview

         A.1. Purpose
                  The goal of this project is to showcase the use of Selenium WebDriver to automate a basic workflow: 
                  performing a Google search and validating the results. This serves as a foundational example for learning 
                  Selenium automation with Java.

         A.2. Features
                  - Launches a browser using Selenium WebDriver.
                  - Navigates to Google's homepage.
                  - Inputs a search query ("Selenium with Java") into the search box.
                  - Submits the search form.
                  - Validates that the results page contains the query in the title.
                  - Closes the browser gracefully after the test.

B. Requirements

         B.1. Prerequisites
                 - Java Development Kit (JDK) 8 or higher.
                 - Selenium WebDriver 4.x or higher.
                 - Google Chrome browser.
                 - ChromeDriver compatible with your browser version.
                 - Integrated Development Environment (IDE) such as Eclipse or IntelliJ IDEA.

         B.2. Dependencies
                Ensure the following Maven dependency is included in your pom.xml if you're using Maven:

                        <dependency>
                               <groupId>org.seleniumhq.selenium</groupId>
                               <artifactId>selenium-java</artifactId>
                               <version>4.11.0</version>
                        </dependency>

C. Setup Instructions

         C.1. Clone the Repository
                   - git clone https://github.com/yourusername/selenium-google-automate-search.git
                   - cd selenium-google-automate-search

         C.2. Set Up ChromeDriver
                    - Download the ChromeDriver binary from https://chromedriver.chromium.org/downloads.
                    - Place the chromedriver executable in the server/ directory of this repository.
                    - Update the path in the code if necessary:
                    - System.setProperty("webdriver.chrome.driver", "server/chromedriver.exe");

         C.3. Run the Project
                    - Open the project in your preferred IDE.
                    - Compile and run the SeleniumGoogleAutomateSearch class.

D. Code Explanation : Key Components

         D.1. ChromeDriver Setup
                   System.setProperty("webdriver.chrome.driver", "server/chromedriver.exe");
                   WebDriver driver = new ChromeDriver();
                       // Configures the ChromeDriver executable to enable browser automation.
 
         D.2. Opening Google
                   driver.get("https://www.google.com");
                       // Navigates to Google's homepage.

         D.3. Interacting with the Search Box

                   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                   WebElement searchBox = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
                   searchBox.sendKeys("Selenium with Java");
                   searchBox.submit();
                       //Waits for the search box to be clickable.
                       //Inputs the search query and submits the form.

         D.4. Validating Results

                   wait.until(ExpectedConditions.titleContains("Selenium with Java"));
                   String pageTitle = driver.getTitle();
                   if (pageTitle.contains("Selenium with Java")) 
                   {
                            System.out.println("Test is Passed");
                   } 
                   else 
                   {
                            System.out.println("Test is Failed");
                   }
                          //Waits for the results page to load.
                          //Validates that the page title contains the query.

          D.5. Closing the Browser
                  driver.quit();
                        //Closes the browser and releases resources.

E. Expected Output

          The script will output one of the following:
                    - Test is Passed: If the results page title contains the search query.
                    - Test is Failed: If the title validation fails.
 
F. Troubleshooting

         F.1. Common Issues

                 F.1.1. ChromeDriver Path Issues:
                               - Ensure the path to chromedriver is correctly set.
                               - Verify the ChromeDriver version matches your browser version.

                 F.1.2. Timeout Errors:
                               - Increase the timeout duration in WebDriverWait if elements are not loading in time.

                 F.1.3. Incompatible Selenium Version:
                               - Use Selenium 4.x or higher to match the updated WebDriverWait API.

         F.2. Debugging Tips

                 - Enable detailed logging in Selenium by setting System.setProperty("webdriver.chrome.verboseLogging", 
                      "true");.
                 - Check the browser console for errors during automation.

G. Contributions

              Contributions are welcome! If you encounter issues or have suggestions for improvement, feel free to open an 
              issue or submit a pull request.





