<ins>**Media Rental System**</ins>

**Overview**

The Media Rental System is designed to manage the rental process for customers and media (movies and music albums). This system keeps track of customers, their rental plans, and the media they are interested in or have already rented. This README will guide you through the expected functionality of the system and how to use it.

**Class Structure**

**MediaRentalManager:**
The primary class of the system is MediaRentalManager. This class manages customers and media and provides methods to interact with the system. You should not add any public methods beyond those specified in the MediaRentalManagerInt interface. Feel free to add necessary instance variables and private methods.

**Supporting Classes and Interfaces:**
In addition to MediaRentalManager, you can define additional classes and interfaces to represent customers, media (movies and albums), and other necessary components. While not required, it is recommended to use multiple classes to organize the system effectively.

<ins>**System Functionality**</ins>

**Customers:**
A customer in the system has:
1. A name
2. An address
3. A rental plan (UNLIMITED or LIMITED)
4. Two queues:
   a.Interested media queue
   b.Rented media queue
5. Rental Plans
   a. UNLIMITED: Allows a customer to rent as many media items as they want.
   b.LIMITED: Restricts the customer to renting a default of 2 media items (this value can be changed via a manager method).

<ins>**Media:**</ins>
The media in the system can be either movies or music albums.

**Movies** -
A movie has:
1. A title
2. A number of copies available
3. A rating (e.g., "PG")
4. Albums
   An album has:
   a. A title
   b. A number of copies available
   c. An artist
   d. A list of songs
   e. Database Representation
   
The database for the system is represented using two ArrayList objects:
1. One ArrayList for the customers
2. One ArrayList for the media (movies and albums)

**Public Tests:**
To understand the expected functionality of the system, study the public tests and their output files (.txt extension under the expectedResults folder). These files will help you familiarize yourself with the expected behavior of the system.
