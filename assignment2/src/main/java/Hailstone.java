/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
        int number = readInt("Enter a number:");
        int sentinel;
        int counter = 1;
        sentinel = process(number);
        while (sentinel != 1) {
            counter++;
            sentinel = process(sentinel);
        }

        println("The process took " + counter + " to reach 1");
	}

    private int process(int number) {
        int result;
        if (number % 2 == 0) {
            result = number / 2;
            println(number + " is even so I take half: " + result);
        } else {
            result = number * 3 + 1;
            println(number + " is odd so I make 3n + 1: " + result);
        }

        return result;
    }
}

