# CA 2 – Algorithms & Architecture

A Java console application that reads a data file from the `data/` folder and prints its contents to the terminal, one line at a time.

## Project structure

```
.
├── data/
│   └── Applicants_Form - Sample data file for read.txt   # Sample input (CSV format)
├── src/
│   └── Main.java                                          # Entry point
└── README.md
```

## Input file

The program reads the first file it finds in the `data/` folder. The sample file is comma-separated, with a header row:

```
First name,Last name,Gender,Email,Salary,Department,Position,Job title,Company
Kate,Summer,Female,ksummer@TechInnovators.com,20000.00,IT Development,senior,QA,TechInnovators
```

## Requirements

- Java JDK 8 or later

## How to run

Run the program from the project root, so it can find the `data/` folder.

### IntelliJ IDEA

1. Open the project folder.
2. Open `src/Main.java` and click **Run**.

### Command line

```bash
javac -d out src/Main.java
java -cp out Main
```

## Example output

```
Reading file: Applicants_Form - Sample data file for read.txt

First name,Last name,Gender,Email,Salary,Department,Position,Job title,Company
Kate,Summer,Female,ksummer@TechInnovators.com,20000.00,IT Development,senior,QA,TechInnovators
Ken,Winter,Male,kwinter@TechInnovators.com,15000.00,IT Development,middle,backend,TechInnovators
...
```

## Author

Pablo Carvalho
