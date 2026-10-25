
# Student Record & Grading System

## About
A console-based student management application developed using Core Java. It allows users to add student details, enter subject marks, calculate results, and view student reports.

## Features
- Add student records
- Store student name and roll number
- Enter marks for three subjects
- Validate marks between 0 and 100
- Calculate total marks and percentage
- Assign grades automatically
- Display student records
- Prevent duplicate roll numbers

## Technologies Used
- Java
- Eclipse IDE
- Java Collections (ArrayList)
- Scanner for console input

## Grading System
- 90% and above: A+
- 80% to below 90%: A
- 70% to below 80%: B
- 60% to below 70%: C
- 50% to below 60%: D
- Below 50%: Pass, provided each subject mark is at least 35
- Any subject below 35: Fail

## How to Run
1. Open Eclipse IDE.
2. Create or import the Java project.
3. Ensure the class is in the `studentgrading` package.
4. Open `StudentGradingSystem.java`.
5. Run it as a Java Application.
6. Follow the console menu.

## Storage Limitation
Student records are stored in memory using an ArrayList. Records disappear when the program closes. File or database storage can be added in a future version.

## Author
Prasanna D
