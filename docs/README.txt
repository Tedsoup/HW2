========================================================================
PRITHEE GAME - SHAKESPEAREAN LINE PROMPTER
========================================================================

DESCRIPTION:
This console-based Java application simulates the "Prithee" tradition from
the Blackfriar's Playhouse. The program prints Sonnet 18 up to a randomly
selected word, replacing that word with underscores ("___"). The player must
type the missing word.

RULES:
- Correct guesses earn +1 point toward victory.
- Incorrect guesses add +1 to the error count.
- The game terminates when either 3 correct answers or 3 incorrect answers
  are given.

========================================================================
HOW TO RUN THE PROGRAM
========================================================================

PREREQUISITE:
Ensure Java (JDK 20 or newer recommended) is installed on your system.

1. Open your terminal/command prompt and navigate to the project root directory:
   cd path/to/HW2

2. Execute the Gradle run task with standard input enabled:
        javac -d bin src/main/java/org.example/*.java
        java -cp bin org.example.Main