### FullCalendarDemo

The following code base has two parts: 
* The backend using Spring-Boot which handles and persists the Calendar event in file storage. It provides the updates to the frontend to display the events in the calendar of the user.
* The small demo frontend using the FullCalendar to display the events in individuals calendar. It supports different views of day, week and month.

#### How to run and use 
* Clone the repo in your local machine. 
* start the spring boot server using the command `mvn spring-boot:run`
* This will create a server listening on port `5544` with two endpoints. One for providing calendar events and another for adding events to the calendar.
* After this navigate to the `src/main/resources` folder. Here you can open the `index.html` in your browser and if the spring-boot server is up and running, it will show you a basic calendar with some pre-saved events.
* On this page, you can navigate to the form on the bottom of the page with 3 input fields. In these fields enter the details of the calendar event like `title`, `start` and `end`. Once you add these details and click on Submit, it will save the event in storage and render the newly created event in your calendar. 
* Example entry can be titled `Team Lunch` with start as `2023-05-18T14:00:00` and end as `2023-05-18T14:45:00`.  This will create an Event called Team Lunch on 18th May for 2PM till 2:45PM.
* To add a full day event you can specify a start as `2023-05-18` which will create a full day even on 18th May 2023.

#### Contact
For any issues or help please reach out on : `ayushyadav@outlook.com`