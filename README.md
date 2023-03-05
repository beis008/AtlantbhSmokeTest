# AtlantbhSmokeTest
QA Application: Manual Testing and Test Automation

Welcome to my project! In this assignment, I was tasked with creating test cases for a shopping page, focusing on real user flows, and identifying what represented a smoke test. Using the Selenium testing framework and Java programming language, I automated the smoke test and created a comprehensive Readme file to document the process. This project aims to showcase my skills in automated testing, particularly using Selenium and Java.

Prerequisites: 
Java SE Development Kit 11.0.18
Eclipse 4.26 (2022-12)

Dependencies: Selenium 4.8. 0

Selenium Java libraries: Downloaded from https://www.oracle.com/in/java/technologies/downloads/#jdk19-windows

![Jav Library 1](https://cdn.discordapp.com/attachments/1031956501792837665/1080809731880394822/JAR_1.PNG)



![Jav Library 2](https://cdn.discordapp.com/attachments/1031956501792837665/1080809732304023582/JAR_2.PNG)


The following images show the Manual and Automation process of the code and action on the smoke test

Here is the Excel link if the one I sent on email cant be donwloaded.
https://docs.google.com/spreadsheets/d/1pf27FkwiZ1RLtwdBd3URkjvfU1UZfZgACRpS5XqnUl0/edit#gid=1603720232
'''
void openHomePage() throws InterruptedException {
		driver.get(baseUrl);
		Thread.sleep(1000);
		String currentUrl = driver.getCurrentUrl();
		assertEquals(currentUrl, baseUrl);
'''
![Case 1](https://user-images.githubusercontent.com/98764556/222982501-1b55b2c4-0b20-4b70-9956-3a12d0604b0d.png)
