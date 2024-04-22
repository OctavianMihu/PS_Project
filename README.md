# Project PS documentation
## Overview

The Uber-like app is a platform that connects riders with drivers for on-demand transportation services. It facilitates seamless booking, tracking, and payment for rides, offering convenience and efficiency to users.


### Features

- **Ride Booking:** Users can easily request rides through the app, specifying pickup and drop-off locations.
- **Real-time Tracking:** Riders can track their driver's location in real-time, providing transparency and peace of mind.
- **Fare Estimation:** Before confirming a ride, users can get an estimate of the fare based on the chosen route.
- **Payment Processing:** Secure payment processing allows users to pay for rides directly through the app, using various payment methods.
- **Driver Rating and Review:** After each ride, both riders and drivers can rate and review each other, ensuring accountability and maintaining service quality.


### Endpoints

# UserController

Controller class for managing User entities.

### Add User
- **Method:** PUT
- **URL:** /user/add
- **Description:** Adds a new user.
- **Request Body:** User object
- **Response:** "New user added"

### Get All Users
- **Method:** GET
- **URL:** /user/getall
- **Description:** Retrieves all users.
- **Response:** List of all users

### Delete User
- **Method:** DELETE
- **URL:** /user/deleteUser
- **Description:** Deletes a user by ID.
- **Request Body:** ID of the user to be deleted
- **Response:** "User deleted successfully" if successful, "Could not find user" if the user doesn't exist

### Update Wants Ride Status
- **Method:** PATCH
- **URL:** /user/wantsRide
- **Description:** Updates the wantsRide status for a user identified by ID.
- **Request Body:** ID of the user to update
- **Response:** "Updated user successfully"
	
# DriverController

Controller class for managing Driver entities.

### Add Driver
- **Method:** POST
- **URL:** /driver/adddriver
- **Description:** Adds a new driver.
- **Request Body:** Driver object
- **Response:** "New driver added"

### Get All Drivers
- **Method:** GET
- **URL:** /driver/getalldriver
- **Description:** Retrieves all drivers.
- **Response:** List of all drivers

### Delete Driver
- **Method:** DELETE
- **URL:** /driver/deletedriver
- **Description:** Deletes a driver by ID.
- **Request Body:** ID of the driver to be deleted
- **Response:** "Driver deleted successfully" if successful, "Could not find user" if the driver doesn't exist

### Start Work
- **Method:** PATCH
- **URL:** /driver/startWork
- **Description:** Starts the work for a driver identified by ID.
- **Request Body:** ID of the driver to start work

### Stop Work
- **Method:** PATCH
- **URL:** /driver/stopWork
- **Description:** Stops the work for a driver identified by ID.
- **Request Body:** ID of the driver to stop work

### Send Notification
- **Method:** GET
- **URL:** /driver/sendNotif
- **Description:** Sends notification to drivers.


## Database diagram
![Uber-like App](https://i.ibb.co/wSFfVrh/Screenshot-2024-04-01-003148.png)