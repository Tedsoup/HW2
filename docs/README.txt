========================================================================
PROGRAM FILE STRUCT
========================================================================

prithee-project/
├── build.gradle.kts
├── docs/
├── README.txt
├── sources.txt
└── src/
    ├── main/
    │   └── java/
    │       └── org/
    │           └── example/
    │               ├── Main.java
    │               └── PritheeGame.java
    └── test/
        └── java/
            └── org/
                └── example/
                    └── PritheeGameTest.java
========================================================================
PROGRAM PSEUDOCODE
========================================================================
START PROGRAM

Initialize correctCount = 0
Initialize incorrectCount = 0
Load SONNET string and split into array of WORDS

WHILE correctCount < 3 AND incorrectCount < 3 DO

    Select random TARGET_INDEX from 0 to length of WORDS - 1
    Extract TARGET_WORD from WORDS[TARGET_INDEX] and remove punctuation

    FOR i FROM 0 TO TARGET_INDEX DO
        IF i EQUALS TARGET_INDEX THEN
            PRINT "___ "
        ELSE
            PRINT WORDS[i] + " "
        END IF

        IF WORDS[i] ends with line-break punctuation THEN
            PRINT NEWLINE
        END IF
    END FOR

    PRINT "Prithee! What is the missing word?"
    READ USER_GUESS

    Clean USER_GUESS (trim spaces)

    IF USER_GUESS equals TARGET_WORD (ignoring case) THEN
        INCREMENT correctCount
        PRINT "Correct!"
    ELSE
        INCREMENT incorrectCount
        PRINT "Error! The word was: " + TARGET_WORD
    END IF

    PRINT Current Score (correctCount, incorrectCount)

END WHILE

IF correctCount EQUALS 3 THEN
    PRINT "Bravo! You saved the show!"
ELSE
    PRINT "Curtain falls! 3 errors made."
END IF

END PROGRAM

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
        javac -d bin src/main/java/org/example/*.java
        java -cp bin org.example.Main

========================================================================
HOW TO RUN THE TEST CASES
========================================================================

.\gradlew.bat test



