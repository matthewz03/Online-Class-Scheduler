# Online-Class-Scheduler

General Info: 
	TEST WAKEUP BEFORE USING DURING LIVE CLASS

To test, input all data as outlined below, set your start and end times to the time you want your test to run (and at least 3 minutes apart), click save info, then click start program. Wait until your specified start time to see if the program runs.

If you do not use 24 hour time, for example inputting 05:30:00 (as 5:30 pm) instead of 17:30:00, then the program will not run at desired time.

	Do not rename/move any files found in the Wakeup folder

	ALL FIELDS MUST BE COMPLETE TO RUN
	WAKEUP WILL NOT WORK PAST THE EMERGENCY STOP TIME

Username/Password:

	The username and password fields are for your FCPS username and password.

Collaborate Links:

The collaborate links are the urls for the "collaborate ultra" module in schoology for the specific class you want to join.

Open your desired class, and click the “Collaborate Ultra” tab. Then copy the url in the search bar.

Your link should be in this format: https://lms.fcps.edu/apps/1234567890/run/course/9876543210

Start/Emergency Stop Time:
Both time fields must be filled out using 24 hour time, in the format "HH:MM:SS". To convert to 24 hour time, click “Click for 24 hour time converter”. The program will then start at the next time your computer clock reaches that time.

The emergency stop time works similarly to the start time and logs out of schoology. This is a failsafe that only happens if other logout conditions fail to be met. I recommend listing emergency stop time around five minutes after class is scheduled to end.

# of Thanks yous in chat/students that leave:
Wakeup is designed to automatically log out when two conditions are met—(A) when a specified number of "thank you" messages are posted in chat and (B) when a specified number of other attendees log out.

If these numbers are not specified, Wakeup will not log you out of class until the emergency stop time is reached. I recommend 5 thank yous and 8 people. This means that you will be logged out if Wakeup reads 5 thank yous AND 8 people leave the session.

Thank You Message:
This is the message that will be sent in the chat just before logging out (for example, "Thank you!"). Leaving the field blank will not send a message.

Start Now:
	Checking this box disregards the start clock timer, meaning the program will 
Launch immediately. Make sure that your Emergency Stop time is set   correctly, otherwise you may be prematurely logged out.
	
Just Login:
	Checking this button will log in normally, but will not check any conditions to log 
	you out. If you have this checked, you must log out manually.
	If no link is selected, Wakeup will only log you into schoology. If you check a link, 
	Wakeup will log you into the selected class.

Example Values for each field:

Username: 1111111
Password: Abc1234!
Link 1: https://lms.fcps.edu/apps/1234567890/run/course/9876543210
Link 2: https://lms.fcps.edu/apps/1234567890/run/course/9876543210
Thank you message: Thank you!
Start time: 08:18:00
End time: 09:45:00
# of students that leave: 8
# of thanks before leaving: 5

Save Info/Start program:

Clicking “Save Info” will save all the fields you filled out so you do not need to fill out the fields each time you open Wakeup. If you need to modify any inputs, make the modifications and then click “Save Info.”

Clicking “Start Program” will start a timer that will launch the program once it reaches the start time. Do not close the window or end the program after clicking “Start Program,” or it will not login.

	To clear out all instances of chrome driver, double click the killchromedriver.bat file (this may not work on school laptops)

