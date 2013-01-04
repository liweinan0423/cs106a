/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GLine;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class ProgramHierarchy extends GraphicsProgram {
    private static final double BOX_WIDTH = 100;
    private static final double BOX_HEIGHT = 30;
    private static final double BOX_HORIZONTAL_SPACE = 20;
    private static final double BOX_VERTICAL_SPACE = 50;

    private static final String PROGRAM = "Program";
    private static final String GRAPHICS_PROGRAM = "GraphicsProgram";
    private static final String CONSOLE_PROGRAM = "ConsoleProgram";
    private static final String DIALOG_PROGRAM = "DialogProgram";


    private static final class Graph extends GCompound {


        public Graph() {


        }
    }

    public void run() {

        TextBox program         = new TextBox(PROGRAM,          BOX_WIDTH, BOX_HEIGHT);
        TextBox graphicsProgram = new TextBox(GRAPHICS_PROGRAM, BOX_WIDTH, BOX_HEIGHT);
        TextBox consoleProgram  = new TextBox(CONSOLE_PROGRAM,  BOX_WIDTH, BOX_HEIGHT);
        TextBox dialogProgram   = new TextBox(DIALOG_PROGRAM,   BOX_WIDTH, BOX_HEIGHT);

        program.setLocation((getWidth() - program.getWidth()) / 2.0,  getHeight() / 2.0 - BOX_VERTICAL_SPACE / 2.0 - program.getHeight());
        consoleProgram.setLocation((getWidth() - consoleProgram.getWidth()) / 2.0, getHeight() / 2.0 + BOX_VERTICAL_SPACE / 2.0);

        graphicsProgram.setLocation(
                getWidth() / 2.0 - consoleProgram.getWidth() / 2.0 - BOX_HORIZONTAL_SPACE - graphicsProgram.getWidth(),
                getHeight() / 2.0 + BOX_VERTICAL_SPACE / 2.0
        );

        dialogProgram.setLocation(
                getWidth() / 2.0 + consoleProgram.getWidth() / 2.0 + BOX_HORIZONTAL_SPACE,
                getHeight() / 2.0 + BOX_VERTICAL_SPACE / 2.0
        );

        add(program);
        add(graphicsProgram);
        add(consoleProgram);
        add(dialogProgram);
        add(program.linkTo(consoleProgram));
        add(program.linkTo(graphicsProgram));
        add(program.linkTo(dialogProgram));

    }


    private static final class TextBox extends GCompound {

        private GLabel label;
        private GRect rect;

        public TextBox(String text, double width, double height) {
            label = new GLabel(text);

            if (width < label.getWidth()) {
                width = label.getWidth();
            }

            if (height < label.getHeight()) {
                height = label.getHeight();
            }

            rect = new GRect(width, height);
            label.setLocation((width - label.getWidth()) / 2.0, (height + label.getAscent()) / 2.0);


            add(rect);
            add(label);
        }

        public GPoint getBottomCenterLocation() {
            double x = getX() + getWidth() / 2.0;
            double y = getY() + getHeight();
            return new GPoint(x, y);
        }

        public GPoint getTopCenterLocation() {
            double x = getX() + getWidth() / 2.0;
            double y = getY();
            return new GPoint(x, y);
        }

        public GLine linkTo(TextBox target) {
            return new GLine(
                    this.getBottomCenterLocation().getX(),
                    this.getBottomCenterLocation().getY(),
                    target.getTopCenterLocation().getX(),
                    target.getTopCenterLocation().getY()
            );
        }

    }
}

