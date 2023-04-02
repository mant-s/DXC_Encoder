# Completed 'Encoder' Technical Assessment

<br/>

## Instructions

### 2 Methods

1. Run compile and run automatically with RunEncoder.bat
2. Navigate to the downloaded folder and run the following commands in your CLI:

```
javac Main.java ShiftTable.java Encoder.java Decoder.java
java Main
```

<br/>

## Included files

### RunEncoder.bat

    Automatically compiles all .java files with javac, and runs the Main file with java.

### Main.java

    Focused on user inputs. Determines if the user prefers to encode or decode, before runing the relevant methods.

### ShiftTable.java

    Focuses on generating a Shift Table, based on inputted Offset Character.

### Encoder.java

    Encodes the input string based on the inputted Offset Character and the appropriate Shift Table.

### Decoder.java

    Uses the given Offset Character from the first letter of the encoded string, to generate an appropriate Shift Table. Thereafter, returning the decoded string.
