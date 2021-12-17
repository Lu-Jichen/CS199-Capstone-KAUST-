# Errand Service Web Application
Jichen Lu, 183620

## Introduction
The project aims to build a web application for errands request and service. People can release their needed errands on the application, like doing a delivery or walking a pet. They can also add some detailed demands, like the type of errands and locations, and they can mark a price they would like to offer while creating an errand. For people who would like to do those errands to get some extra money, they can view the list and select the items they would like to do. The application also offer filters, like different types of errands, to help people find their preferred part-time job more quickly.

## Software Specification
### Definition
- Users: Users of the platform. A user can be both provider and customer, depends on the operations on the platform. But one person only has to maintain one account of the platform.
- Customers: Users who want an errand service. They create service they want and offer a price of the service.
- Providers: Users who provide service. They select those errands they would like to do and provide demanded service.
- Demand page: Page to show the errands created by the user.
- Service page: Page to show the errands the user has selected.
- Main errand page: Page to show all unselected errands in the platform.
### Detailed Specification
#### General
- Register: Register, setting user name and password.
  - There will be repeated username check and notification. No repeated username should be created.
- Login: Use user name and password to login.
  - When click the login button, there will be notification if the username or password is wrong.
  - There will be register button on the login page to lead new users to the registration page.
- Basic information: Edit basic information of the user.
  - The basic information includes name, phone number, address and etc.
  - There will be an item to ask user to bind their bank card to offer or receive the money of an errand. (For this application, there is no professional payment section designed.)
#### Customer role operation
- View demand page errand list: The page to show all errands created by themselves.
  - There will be order label and search bar.
  - The demand page is the main operating page when the user act as a customer.
  - For each created errands, there will be buttons of "edit", "delete" and "complete".
- Create an errand: Add an errand with essential information.
  - There will be "add" button at the demand page.
  - The errand will contains a predefined label, like walking a pet.
  - There will be detailed information needed depends on the type, like the location and time of a delivery type errand. The user must select a pre-defined type first.
  - The price will be shown.
- Delete an errand: Delete an existing errand.
  - Click the "delete" button on the errands in demand page, and confirm it.
- Edit existing errands: Edit items of an existing errand.
  - Click the "edit" button of the errands in demand page.
- Mark the errand to be completed.
  - Only if the errand is selected, the user can mark it as complete. (A complete label is for extra payment system to transfer the money.)
#### Provider role operation
- View service page errand list: The service page show all errands the user has selected.
  - The errands can be ordered depends on the time, which help the user arrange their time.
  - Their will be ttwo buttons: "delete" and "done".
- Select an errand: View the main errand page to select an errand.
  - The main errand page is to show all errands in "unselected" state.
  - There will be "select" button on each errand to select the errand.
  - User can click on one errands to view the detailed information.
- Delete an errand: Click on "delete" button of an errand in service page, to give up the errand.
- Mark the errand done after finish it.
  - Click on the "done" button of errand in the service page
### Use case diagram
![avatar](/UML.png)

## Development Language
- Main Language: Java, html
- Backend: SpringBoot
- Database: Mysql
- FrontEnd: Vue
  
## Timeline
|Slot|Content|
|-|-|
| Week 4| ER diagram complete.|
| Week 5| Framework build and login section. Basic build of database.|
| Week 6-8| Several logic implemented, including login, personal information editing and view of main errand page. Back end database complete.|
| Week 9| Presentation and report preparation.|
| Week 10-11| Provider main logic, including backend and frontend. The main work will be on the "service page".|
| Week 12-13| Customer main logic, including backend and frontend. The main work will be on the "demand page".|
| Week 14| Joint testing, solve some problems while working of the application.|
| Week 15| Presentation and report preparation.|


