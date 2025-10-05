# GOS3

## Summary

An attempt to redo the semester-long project I did in an operating systems course in university. In the course project, each student built their own command-line operating system from scratch. In this redo, I will add some twists: I will use a build system (Gradle) and dependency injection (Guice), and make the OS graphical (Swing).

## Run Instructions

### Tested

On Windows 11 in Powershell 7 on October 5, 2025

### Commands

```
git clone https://github.com/wharvex/GOS3.git
cd GOS3
.\gradlew run
```

## Resources

A Guice guideline I want to remember, especially since I will be multi-threading extensively: "Wherever possible, use constructor injection to create immutable objects." ~ [Source](https://github.com/google/guice/wiki/MinimizeMutability)
