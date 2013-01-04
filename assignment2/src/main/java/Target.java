/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.GOval;
import acm.program.GraphicsProgram;

import java.awt.*;

public class Target extends GraphicsProgram {
    private static final double PIXELS_PER_INCH = 72.0;

    public void run() {
        GOval oval1 = new GOval(1 * PIXELS_PER_INCH / 2, 1 * PIXELS_PER_INCH / 2);
        oval1.setFillColor(Color.RED);
        oval1.setFilled(true);
        oval1.setColor(Color.RED);
        makeCenter(oval1);

        GOval oval2 = new GOval(0.65 * PIXELS_PER_INCH / 2, 0.65 * PIXELS_PER_INCH / 2);
        oval2.setFillColor(Color.WHITE);
        oval2.setFilled(true);
        oval2.setColor(Color.WHITE);
        makeCenter(oval2);

        GOval oval3 = new GOval(0.3 * PIXELS_PER_INCH / 2, 0.3 * PIXELS_PER_INCH / 2);
        oval3.setFillColor(Color.RED);
        oval3.setColor(Color.RED);
        oval3.setFilled(true);
        makeCenter(oval3);
        add(oval1);
        add(oval2);
        add(oval3);
    }

    private void makeCenter(GOval oval) {
        oval.setLocation((getWidth() - oval.getWidth()) / 2.0, (getHeight() - oval.getHeight()) / 2.0);
    }
}
