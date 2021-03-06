package main.java.guiAndLauncher;

import main.java.Controller.MouseController;

import javax.swing.*;
import java.awt.*;

public class Gui {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private MouseController mouseController;
    private int width, height;

    public Gui(MouseController mouseController, String title, int width, int height){
        this.title = title;
        this.width = width;
        this.height = height;
        this.mouseController = mouseController;

        createDisplay();
    }



    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

}
