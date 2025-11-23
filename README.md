

#  Team2 HerBalance – Selenium Hackathon (Nov 2025)

##  Overview
**HerBalance** is a women’s health app that analyzes lab reports and tracks menstrual and medical conditions.  
It provides personalized weight management plans, diet suggestions, and exercise logging tailored to each user.  
With advanced health metrics and premium support, it empowers women to visualize progress and take control of their wellness.  

During the hackathon, the app was unstable, so we worked with **static HTML pages** generated from screenshots provided by the organizers.

---

##  Key Features
- **Unlimited Blood Work Analysis**  
  Advanced insights from all your lab reports, helping you understand your health metrics in detail.  

- **Personalized Weight Management**  
  Custom recommendations based on your health data, tailored to your unique needs.  

- **Advanced Health Metrics**  
  Track and visualize your health progress over time with clear dashboards and reports.  

- **Premium Support**  
  Priority assistance whenever you need help, ensuring a smooth and reliable user experience.  

---

## Demo Flow
1. **Upload Lab Reports**  
   Users upload their blood work or medical lab reports into the app.  
   The system analyzes the data to provide **Unlimited Blood Work Analysis** with advanced insights.  

2. **Receive Personalized Recommendations**  
   Based on health data, the app generates **custom weight management plans**.  
   Diet suggestions, food intake tracking, and exercise logs are tailored to the individual.  

3. **Track Health Metrics**  
   Users can view **advanced health metrics** through dashboards and visualizations.  
   Progress is tracked over time, making it easy to monitor improvements or spot issues early.  

4. **Access Premium Support**  
   Priority assistance is available for troubleshooting, guidance, or health-related queries.  
   Ensures users always have help when they need it.  

---

## Tech Stack
- **BDD Framework**: Java + Selenium  
- **Static Hosting**: Python HTTP server (`localhost:8000`)  
- **Reporting Tools**:  
  - Allure Reports  
  - Cucumber Reports  
  - ChainTest Reports  
  - Extent Reports  

---

## Implementation Details
- **Static Pages**: HTML pages were created from screenshots and hosted locally using Python’s simple HTTP server.  
- **Hosting Path**: Navigate to the static HTML directory before starting the server:  
  ```bash
  cd manalishinde-03/Team2_HerBalance_SeleniumHackathon_Nov2025/src/test/resources/HTML_Pages
  python -m http.server 8000
  ```
- **Automation**: Selenium scripts were written in Java following BDD principles.  
- **Error Handling**:  
  - Implemented `try–catch` blocks to capture **specific exceptions** (e.g., `NoSuchElementException` or other relevant runtime errors).  
  - Ensured Allure reports display **failed test cases** instead of marking them as **broken**, improving clarity in reporting.  
- **Reports**: Multiple reporting frameworks were integrated to provide comprehensive visibility into test execution and results.  

---

##  Reports
- **Allure** → Enhanced visualization of test results  
- **Cucumber** → BDD-style reporting  
- **ChainTest** → API and workflow validation  
- **Extent** → Rich HTML-based reporting  

---


##  Hackathon Notes
- Demonstrates **QA automation practices** even when the app under test is unstable.  
- By leveraging static HTML and robust reporting, we ensured meaningful test coverage and insights for the organizers.  
- Exception handling was carefully designed to capture **real errors** (like missing elements) and reflect them properly in reports.  
- Future enhancements could include:  
  - Integrating real APIs for lab report ingestion  
  - Improving mobile app stability  
  - Adding CI/CD pipelines for automated test execution and reporting  
## Allure report
<img width="1336" height="616" alt="image" src="https://github.com/user-attachments/assets/09dcc9c0-be2b-45c0-8eff-71646b76035e" />


## Extent report
<img width="1334" height="718" alt="image" src="https://github.com/user-attachments/assets/1019fd7e-c701-40c4-a85b-ae60b48b19a0" />

## Cucumber report

<img width="1306" height="693" alt="image" src="https://github.com/user-attachments/assets/b97744da-7cc6-4d7f-9a81-b40389289a5f" />

## Jenkins report
<img width="1335" height="656" alt="image" src="https://github.com/user-attachments/assets/ab28e677-9caf-43b7-921d-d2c357e56334" />


