# PPartyImplementation
## Player Party Implementation Repository - CP317
### Main Functionalities
The runnable Player Party application has 4 main functionalities implemented (Register, login, creating a new event, and deleting an existing event). Registering creates an account that does not already exist. Once the account is registered successfully the account details are stored into the database. Login successfully logs into PParty once the correct credentials are used and the user is redirected to the home page. Creating an event creates an event that does not already exist and it can be done through the home page. Once the event is created successfully, the event will be displayed on the home page table with its details accordingly. Deleting an event can be done only when its assumed you are the host of the event. Once the event is deleted successfully, it is removed from the home page table and from the database.

### How to Use PParty
#### Login/Register
Once the runnable PParty application is launched, the login page is displayed to the user. From here, the user may wish to login with his/her existing account details. For implementation sake, we have added testing accounts in the users.txt file that are already stored and can be used to login to PParty. If the user clicks on "Register" from this page, he/she will be redirected to the Register page where the user will be prompted to enter his/her account details accordingly. Once the user registers successfully, the account details are stored and he/she will be redirected to the home page. Account details can be viewed in the users.txt file.

#### Creating/Deleting an Event
Once the "Create Event" button is clicked 
