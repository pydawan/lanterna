package com.googlecode.lanterna.gui2;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TextColor;

/**
 * Created by martin on 19/07/14.
 */
public class SolidColorComponent implements TextGUIElement {
    private final TextColor color;
    private final boolean bold;

    public SolidColorComponent(TextColor color) {
        this(color, false);
    }

    public SolidColorComponent(TextColor color, boolean bold) {
        this.color = color;
        this.bold = bold;
    }

    @Override
    public void draw(TextGUI textGUI, Window window, TextGraphics graphics) {
        graphics.setBackgroundColor(color);
        if(bold) {
            graphics.enableModifiers(Terminal.SGR.BOLD);
        }
        graphics.fillScreen(' ');
    }

    @Override
    public boolean isInvalid() {
        return false;
    }
}
