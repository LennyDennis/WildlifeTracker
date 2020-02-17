# Wildlife Tracker

[Wildlife Tracker](https://github.com/LennyDennis/WildlifeTracker) is a web application that allows Rangers to track wildlife sightings in the area.

# Getting Started
These instructions will get you a copy of the project up and running on your local machine for testing purposes.

# Running
Clone the repository or download it.

In PSQL:
`CREATE DATABASE wildlife_tracker;`
`CREATE TABLE animals(id SERIAL PRIMARY KEY,health varchar, age varchar, type varchar,name varchar);`
`CREATE TABLE sightings(id SERIAL PRIMARY KEY, ranger varchar , location varchar, animalid int);`

For tests:
`CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;`

# Built With
Java
HTML
CSS
Jquery
Spark 
Sql
Handlebars
Postgress DB

# Codebeat Badge


# Behaviour Driven Development
On visit, the user will directed to the welcome page.

The user is able to enter a non-endangered  animal and after that view it in a table.

The user is also able to enter an endangered animal and after that view all animals in a table.

The user is able  to register when he viewed an animal and view all sightings afterwards.

# Development
Want to contribute? Great!

To fix a bug or enhance an existing module, follow these steps:

# Fork the repo
Create a new branch
Make the appropriate changes in the files
Add changes to reflect the changes made
Commit your changes
Push to the branch
Create a Pull Request.
Known Bugs
No known bugs however if you find any bug kindly reach out.

# License
*MIT License

# Copyright (c) [2020] [Lenny Dennis Macharia]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
