# guestbook
Small guestbook-like java web app.
Users can add entries and comment on them. 

###About 
Back end built with Spring boot, Gradle.  
Front end with bootstrap, jQuery, thymleaf

###Configuration
1. Uses postgres database named "andmevara", user and password information must be set at db.properties.  
2. Port set to 8080.
2. Context path /guestbook
3. Database tables created at launch.

###Known issues
1. No way to identify commentators.
2. No way to delete comments or main entries.
3. User email if entered is saved but not displayed anywhere.
