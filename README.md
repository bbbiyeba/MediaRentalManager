**Media Rental System**

Overview
The Media Rental System is designed to manage the rental process for customers and media (movies and music albums). This system keeps track of customers, their rental plans, and the media they are interested in or have already rented. This README will guide you through the expected functionality of the system and how to use it.

Class Structure
MediaRentalManager
The primary class of the system is MediaRentalManager. This class manages customers and media and provides methods to interact with the system. You should not add any public methods beyond those specified in the MediaRentalManagerInt interface. Feel free to add necessary instance variables and private methods.

Supporting Classes and Interfaces
In addition to MediaRentalManager, you can define additional classes and interfaces to represent customers, media (movies and albums), and other necessary components. While not required, it is recommended to use multiple classes to organize the system effectively.

System Functionality
Customers
A customer in the system has:

A name
An address
A rental plan (UNLIMITED or LIMITED)
Two queues:
Interested media queue
Rented media queue
Rental Plans
UNLIMITED: Allows a customer to rent as many media items as they want.
LIMITED: Restricts the customer to renting a default of 2 media items (this value can be changed via a manager method).
Media
The media in the system can be either movies or music albums.

Movies
A movie has:

A title
A number of copies available
A rating (e.g., "PG")
Albums
An album has:

A title
A number of copies available
An artist
A list of songs
Database Representation
The database for the system is represented using two ArrayList objects:

One ArrayList for the customers
One ArrayList for the media (movies and albums)
Usage
Public Tests
To understand the expected functionality of the system, study the public tests and their output files (.txt extension under the expectedResults folder). These files will help you familiarize yourself with the expected behavior of the system.
