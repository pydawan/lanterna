/*
 * This file is part of lanterna (http://code.google.com/p/lanterna/).
 * 
 * lanterna is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Copyright (C) 2010-2011 mabe02
 */

package org.lantern.test.gui;

import org.lantern.LanternException;
import org.lantern.LanternTerminal;
import org.lantern.gui.Action;
import org.lantern.gui.Border;
import org.lantern.gui.Button;
import org.lantern.gui.EmptySpace;
import org.lantern.gui.GUIScreen;
import org.lantern.gui.Label;
import org.lantern.gui.Panel;
import org.lantern.gui.TextBox;
import org.lantern.gui.Window;

/**
 *
 * @author mabe02
 */
public class TextBoxTest
{
    public static void main(String[] args) throws LanternException
    {
        if(args.length > 0) {
            try {
                Thread.sleep(15000);
            }
            catch(InterruptedException e) {
            }
        }

        LanternTerminal terminal = new LanternTerminal();
        final GUIScreen terminalGUIScreen = terminal.getGUIScreen();
        if(terminalGUIScreen == null) {
            System.err.println("Couldn't allocate a terminal!");
            return;
        }

        terminal.start();
        final Window window1 = new Window("Text box window");
        //window1.addComponent(new Widget(1, 1));

        Panel mainPanel = new Panel(new Border.Invisible(), Panel.Orientation.VERTICAL);
        for(int i = 0; i < 5; i++) {
            Panel editPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
            editPanel.addComponent(new Label("TextBox " + (i+1) + ":"));
            editPanel.addComponent(new TextBox(20, ""));
            mainPanel.addComponent(editPanel);
        }
        window1.addComponent(mainPanel);

        Panel buttonPanel = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
        Button exitButton = new Button("Exit", new Action() {
                public void doAction()  {
                    terminalGUIScreen.closeWindow(window1);
                }
            });
        buttonPanel.addComponent(new EmptySpace(20, 1));
        buttonPanel.addComponent(exitButton);
        window1.addComponent(buttonPanel);
        terminalGUIScreen.showWindow(window1, GUIScreen.Position.CENTER);
        terminal.stopAndRestoreTerminal();
    }
}