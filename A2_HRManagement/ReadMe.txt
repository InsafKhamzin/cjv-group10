CJV805 Assignment 2 – Winter 2020

Assignment Submission Form
==========================================================================
I/we declare that the attached assignment is my/our own work in accordance
with Seneca Academic Policy. No part of this assignment has been copied
manually or electronically from any other source (including web sites) or
distributed to other students.

Name(s)             Student ID(s)
Insaf Khamzin       138339189
Lok Prakash Pandey	156066177
Abin Lathikumar		140968181
--------------------------------------------------------------------------

Back end environment:
	Apache Tomcat v9.0
	jdk-11.0.6
	Oracle 12c

Front end environment:
	HTML5
	Bootstrap
	jquery-3.4.1

ca.myseneca.filter -- All filter of application. They can process each request to application. For example log each request response
AuthenticationFilter - this filter checks the session attribute "user" for secured urls. By this we can identify if user is authorized for specific urls

ca.myseneca.model -- Database access layer of application
ConnectionPool - database connections pool management

ca.myseneca.servlet -- All servlets of application

ca.myseneca.util -- Package for different utilities.

Testing Credentials
-------------------

Username/Password : hr/hr
Username/Password : servlet/servlet
Username/Password : java/java