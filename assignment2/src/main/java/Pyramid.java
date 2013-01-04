/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Height of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;

    private static final class Brick extends GRect {

        public Brick() {
            super(BRICK_WIDTH, BRICK_HEIGHT);
        }
    }

	public void run() {
        setLocation(0, 0);
        for (int i = 1; i <= BRICKS_IN_BASE; i++) {
            drawLevel(i);
        }
	}

    private void drawLevel(int i) {
        double startX = getStartX(i);
        for (int j = 1; j <= i; j++) {
            Brick brick = new Brick();
            brick.setLocation(startX + (j - 1) * BRICK_WIDTH, getHeight() - (14 - i + 1) * BRICK_HEIGHT);
            add(brick);
        }
    }

    private double getStartX(int i) {
        return (getWidth() - i * BRICK_WIDTH) / 2.0;
    }
}

