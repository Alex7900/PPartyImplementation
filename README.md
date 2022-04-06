# PPartyImplementation
## Player Party Implementation Repository - CP317
### Main Functionalities
The runnable Player Party application has 4 main functionalities implemented (Register, login, creating a new event, and deleting an existing event). Registering creates an account that does not already exist. Once the account is registered successfully the account details are stored into the database. Login successfully logs into PParty once the correct credentials are used and the user is redirected to the home page. Creating an event creates an event that does not already exist and it can be done through the home page. Once the event is created successfully, the event will be displayed on the home page table with its details accordingly. Deleting an event can be done only when it is assumed you are the host of the event. Once the event is deleted successfully, it is removed from the home page table and from the database.

### How to Use PParty
#### Login/Register
Once the runnable PParty application is launched, the login page is displayed to the user. From here, the user may wish to login with his/her existing account details. For implementation sake, we have added testing accounts in the users.txt file that are already stored and can be used to login to PParty. If the user clicks on "Register" from this page, he/she will be redirected to the Register page where the user will be prompted to enter his/her account details accordingly. Once the user registers successfully, the account details are stored and he/she will be redirected to the home page. Account details can be viewed in the users.txt file.

#### Creating/Deleting an Event
Once the "Create New Event" button is clicked, the page for creating an event will be displayed. From here, the user will enter the appropriate details for the event he/she wishes to create. Once the user fills in all the fields and clicks on "Create Event", the event will be created successfully and will be displayed on the home page table with its details accordingly. If the user tries to create an event with blank fields, a popup window will be displayed notifying the user to enter the correct details in order for the event to be created successfully.Event creation is limited to 1 per user. Once the event is created the user can delete the event if he/she wishes to. From the home page, the event that was created can be selected and will be deleted from the table and the database successfully once the "Delete Event" button is clicked. If the user is not the host of an event and attempts to delete it, an error message will be displayed notifying the user the he/she is not the host. 

### Dependencies
In order to successfully run the program, a working internet connection is required to download the application and Windows OS. PParty is at very early implementation stages, so it is dependant on the users following this README file to run the appplication successfully.

### Functionality Exclusions
Due to resource and time constraints, our team has only implemented these 4 main functionalities mentioned above. Other functionalities that were excluded are editing user profile, editing the event details, searching and joining events, and removing a user from an event. These functionalities are planned to be implemented in a future update.

### Authors and Contributors
- Alexandros Ioannou, 191699620
- Brian Ha, 190376250
- Eric Wildfong, 190559940
- Mark Luong, 170995900
- Nihal Medak, 190827670
- Shaheer Khan, 190693830
