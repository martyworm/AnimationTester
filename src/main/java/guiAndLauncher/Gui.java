package main.java.guiAndLauncher;

import main.java.Controller.MouseController;
import main.java.gfx.Assets;
import main.java.gfx.InvisibleTextField;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.*;

public class Gui {

    private JFrame frame;
    private Canvas canvas;

    private String title;
    private MouseController mouseController;
    private int width, height;

    private InvisibleTextField tf;

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

        PlainDocument doc = new PlainDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int off, String str, AttributeSet attr)
                    throws BadLocationException
            {
                fb.insertString(off, str.replaceAll("[^A-Za-z0-9 ]", ""), attr);  // remove non-digits
            }
            @Override
            public void replace(FilterBypass fb, int off, int len, String str, AttributeSet attr)
                    throws BadLocationException
            {
                fb.replace(off, len, str.replaceAll("[^A-Za-z0-9 ]", ""), attr);  // remove non-digits
            }
        });

        this.tf = new InvisibleTextField();
        tf.setLocation(50,50);
        tf.setSize(100, 35);
        tf.setEditable(true);

        tf.setDocument(doc);


        frame.add( tf );
        //tf.requestFocusInWindow();

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas(){
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }

    public InvisibleTextField getTf() {
        return tf;
    }
}
