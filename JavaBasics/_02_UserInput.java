package JavaBasics;

import java.util.Scanner;

public class _02_UserInput {
    public static void main(String[] args) {
        // Input example (each value may be separated by spaces or new lines):
        // 25 120 5000 9000000000 5.5 99.99 true A Java Scanner
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter a byte: ");
            if (sc.hasNextByte()) {
                byte byteValue = sc.nextByte();
                System.out.println("byte = " + byteValue);
            } else {
                System.out.println("Invalid byte input.");
                return;
            }

            System.out.print("Enter a short: ");
            if (sc.hasNextShort()) {
                short shortValue = sc.nextShort();
                System.out.println("short = " + shortValue);
            } else {
                System.out.println("Invalid short input.");
                return;
            }

            System.out.print("Enter an int: ");
            if (sc.hasNextInt()) {
                int intValue = sc.nextInt();
                System.out.println("int = " + intValue);
            } else {
                System.out.println("Invalid integer input.");
                return;
            }

            System.out.print("Enter a long: ");
            if (sc.hasNextLong()) {
                long longValue = sc.nextLong();
                System.out.println("long = " + longValue);
            } else {
                System.out.println("Invalid long input.");
                return;
            }

            System.out.print("Enter a float: ");
            if (sc.hasNextFloat()) {
                float floatValue = sc.nextFloat();
                System.out.println("float = " + floatValue);
            } else {
                System.out.println("Invalid float input.");
                return;
            }

            System.out.print("Enter a double: ");
            if (sc.hasNextDouble()) {
                double doubleValue = sc.nextDouble();
                System.out.println("double = " + doubleValue);
            } else {
                System.out.println("Invalid double input.");
                return;
            }

            System.out.print("Enter true or false: ");
            if (sc.hasNextBoolean()) {
                boolean booleanValue = sc.nextBoolean();
                System.out.println("boolean = " + booleanValue);
            } else {
                System.out.println("Invalid boolean input. Use true or false.");
                return;
            }

            System.out.print("Enter one character: ");
            if (sc.hasNext()) {
                char characterValue = sc.next().charAt(0);
                System.out.println("char = " + characterValue);
            } else {
                System.out.println("No character was provided.");
                return;
            }

            System.out.print("Enter one word: ");
            if (sc.hasNext()) {
                String word = sc.next();
                System.out.println("word = " + word);
            } else {
                System.out.println("No word was provided.");
                return;
            }

            // nextLine() reads the remaining input on the current line.
            // Call it once to consume the line break left by next().
            sc.nextLine();
            System.out.print("Enter a full line: ");
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println("line = " + line);
            } else {
                System.out.println("No line was provided.");
            }

            // Conditional input: keep reading only while the next token is an integer.
            System.out.println("Enter integers to print them (any non-integer stops):");
            while (sc.hasNextInt()) {
                int number = sc.nextInt();
                System.out.println("Read integer: " + number);
            }

            // A token is still available when the loop stopped because it was not an int.
            if (sc.hasNext()) {
                System.out.println("Stopped at non-integer input: " + sc.next());
            }
        }
    }
}