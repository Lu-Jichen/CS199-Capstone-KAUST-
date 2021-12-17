# Final Report of Capstone Project
Jichen Lu, 183620

## Introduction
The project implements an object which allows people to create and receive errands on a platform. It allows new users to create a new account, and edit his or her own information. When enter the system, users can either query an errand or receive an errand. Users can edit the detailed information of the errands they create, like the demand and the price. Users can see all the errands list, with order buttons and filter items, which can help the users find errands they want more quickly. And when receive an errand, the user can also drop the errand or mark the errand as done. The platform can help people solve their own demands, or find their preferred part-time jobs more quickly.

## Development Language and Frameworks
- Main Language: Java, html
- Backend Framework: SpringBoot
- Database: Mysql
- FrontEnd Framework: Vue

## Implemented Functions
### Login and Registration
![avatar](/login.png)
- Register: Setting user name and password, and click the register button.
  - There is repeated username check and notification. No repeated username should be created.
- Login: Use user name and password to login.
  - When click the login button, there will be notification if the username or password is wrong.
### Personal Homepage
![avatar](/personal_homepage.png)
- It is in the sidebar under `User Info`, click `Personal Homepage` to jump to.
- Basic information: Edit basic information of the user.
  - The basic information includes name, phone number, address and etc.
  - There will be an item to ask user to bind their bank card to offer or receive the money of an errand. (For this application, there is no professional payment section designed.)
### My Errand
![avatar](/my_errand.png)
- View `MyErrand` page errand list: The page to show all errands created by users themselves.
  - The demand page is the main operating page when the user act as an errand creator.
  - For each created errands, there are buttons of "view" and "delete".
- View and edit: When click the "view", the detailed information of this errand will be shown. And there is an edit button at top right, by clicking one can edit his or her own errands.
![avatar](/edit_errand_1.png)
![avatar](/edit_errand_2.png)
- Create: When click the right top create button, there will be options of which type of errands will be created, different errand has different template to fill.
![avatar](/create_errand_1.png)
![avatar](/create_errand_2.png)
- Delete: Click the "delete" button on each item, the errand will be delete and the status will turn to "close".
### My Work
![avatar](/my_work.png)
- View `MyWork` page errand list: The page to show all errands received by users.
  - Here users can see all the errands they have selected.
  - For each created errands, there are buttons of "view", "drop" and "done".
- View: When click the "view", the detailed information of this errand will be shown.
![avatar](/view_1.png)
- Drop: Click the "drop" button on each item, the errand will be given up and vanish from the list.
- Done: Click the "done" button on each item, the errand will be marked as done and the status will turn to "Finish".
### Errand List
![avatar](/errand_list.png)
- View `Errand List` page errand list: The page to show all errands on the platform.
  - Here users can see all the errands.
  - For each created errands, there are buttons of "view", "select".
- View: When click the "view", the detailed information of this errand will be shown.
![avatar](/view_2.png)
- Select: Click the "select" button on each item, the errand will be moved to `MyWork` and the status will turn to "On".
- Order: Click the order triangles on each column and users can get ordered errand list.
- Filter: Select the filter item for each of column and click the "Search", then user can get all errands fit the search conditions. And the brush icon can clear the filter conditions.


## Possible Improvements
### Framework and Security
- Speed: The current framework directly query the database, which may cause some speed bottleneck when access number is huge, maybe can add redis cache to solve the problem.
- Security: Now the cookies of the browser store the username and userId, which has security risks. It can be replaced with token or other authentication mechanism.
### Functional
- The UI can be re-designed to look better.
- There should be some section to deal with how to transform money when one errand is finished.
- More drop-down table may help users to select items more easily.

## Conclusion
The project is a meaningful practice on how to build a web application. The knowledge of frontend backend intersection could be helpful for later career in industry. Because of limited experience of frontend, the most difficult part of the project is to figure out how the frontend exchange data with backend, and how to show these data.
There are still some possible improvements to be done, like the performance under high access pressure, or the security problems. The final result implemented almost every functions described in proposal. The operation are straightforward, and the data is synchronous within different users. 




