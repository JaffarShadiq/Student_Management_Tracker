# CodeAlpha Student Grade Tracker

A beginner-friendly Java console application created for **CodeAlpha Java Programming - Task 1**.

## What it does

- Adds and manages multiple students.
- Stores each student's grades in an `ArrayList`.
- Calculates average, highest, and lowest grades for every student.
- Assigns an A-F letter grade from the student's average.
- Displays an all-student report and a class-wide summary.
- Validates menu input and accepts grades only from 0 to 100.

## Project structure

```text
CodeAlpha_StudentGradeTracker/
├── src/
│   ├── Student.java              # Student data and grade calculations
│   └── StudentGradeTracker.java  # Menu, input, reports, and main method
├── .gitignore
└── README.md
```

## Requirements

- Java Development Kit (JDK) 11 or newer
- A terminal such as Command Prompt, PowerShell, or the VS Code terminal

Check that Java is installed:

```powershell
java -version
javac -version
```

## Run the project

Open a terminal in the project folder and run:

```powershell
cd src
javac Student.java StudentGradeTracker.java
java StudentGradeTracker
```

## Suggested demo

1. Choose `1` and add `Asha`.
2. Choose `1` and add `Ravi`.
3. Choose `2` and add several grades, such as `92`, `84`, and `88` for Asha.
4. Choose `3` to show every student's grade report.
5. Choose `4` to show the overall class average, highest score, and lowest score.

## How the code works

- `Student` is an object with a name and an `ArrayList<Double>` of grades.
- The `Student` methods calculate each student's average, highest score, lowest score, and letter grade.
- `StudentGradeTracker` keeps an `ArrayList<Student>` and shows a repeating console menu.
- Input validation prevents invalid menu choices and grades outside `0` to `100`.

## Honest explanation for a reviewer

> I created a console-based Student Grade Tracker using Java OOP and ArrayLists. Each Student object holds a name and its grades. The program uses loops to calculate averages, highest and lowest scores, then prints reports for individual students and the class. I included input validation to make the program safer for users.

## Possible improvements

- Add options to edit or remove a grade.
- Save students and grades to a file.
- Add a Swing or JavaFX interface.
- Export the summary report to CSV.
