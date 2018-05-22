package main.java.animTester;

import main.java.Controller.MouseController;
import main.java.gfx.Animation;
import main.java.gfx.Assets;
import main.java.gfx.FontLoader;
import main.java.gfx.InvisibleTextField;
import main.java.guiAndLauncher.Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;

public class AnimationTester implements Runnable {


    private Gui gui;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private MouseController mouseController;
    private boolean hovering = false;

    private Assets assets;
    private HashSet<String> words = new HashSet<>();
    private boolean finishedSearching = false;
    private String currentSearchedString = "";

    public AnimationTester(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        mouseController = new MouseController();

    }

    private void init() { //initialize the game and starting pieces/tiles
        gui = new Gui(mouseController, title, width, height);
        gui.getFrame().addMouseListener(mouseController);
        gui.getFrame().addMouseMotionListener((MouseMotionListener) mouseController);
        gui.getCanvas().addMouseListener(mouseController);
        gui.getCanvas().addMouseMotionListener((MouseMotionListener) mouseController);

        //load assets(images etc)
        Assets.init();
        mouseController.setAnimationTester(this);

        initWords();

        Font font1 = Assets.fontImmortal12;
        GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        genv.registerFont(font1);
        font1 = font1.deriveFont(22f);

        gui.getTf().setForeground(Color.BLACK);

        gui.getTf().setFont(font1);
        //TEST ANIMATION BELOW
        // - - - - - - - - -
        // - - - - - - - - -


        // - - - - - - - - -
        // - - - - - - - - -
        // TEST ANIMATION ABOVE
    }

    public void tick(){
        if(gui.getTf().getText().equals("")){
            currentSearchedString = "";
        }
        if(currentSearchedString.equals("")){
            System.out.println("current is empty string as well");
        }

        if(!gui.getTf().getText().equals("") && !finishedSearching) {
            searchForMatches();
        }
        if(newSearch()){
            finishedSearching = false;
        }
    }

    public void render(Graphics g){
        bs = gui.getCanvas().getBufferStrategy();
        if(bs == null){
            gui.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);

        //DRAW

        g.drawImage(Assets.dirtTile2[0], 0, 0, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 40, 0, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 80, 0, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 0, 40, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 40, 40, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 80, 40, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 0, 80, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 40, 80, 40, 40, null);
        g.drawImage(Assets.dirtTile2[0], 80, 80, 40, 40, null);

        g.drawImage(Assets.grassTile2[0], 200, 100, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 240, 100, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 280, 100, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 200, 140, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 240, 140, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 280, 140, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 200, 180, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 240, 180, 40, 40, null);
        g.drawImage(Assets.grassTile2[0], 280, 180, 40, 40, null);

        //EDIT SIZE OF ANIMATION BELOW
//        g.drawImage(testAnimation.getCurrentFrame(), 35, 30, 115, 60, null);
//        g.drawImage(testAnimation.getCurrentFrame(), 236, 128, 115, 60, null);
//        g.drawImage(testAnimation.getCurrentFrame(), 120, 328, 115, 60, null);


        bs.show();
        g.dispose();
    }

    public void onLeftMouseRelease(MouseEvent e){

    }

    public void onMouseMoved(MouseEvent e){

    }

    private boolean newSearch(){
        if(gui.getTf().getText().equals(currentSearchedString)){
            return false;
        }
        return true;
    }

    private void searchForMatches(){
        for(String s : this.words){
            String lowerS = s.toLowerCase();
            if(lowerS.contains(gui.getTf().getText())){
                System.out.println(s);
            }
        }
        finishedSearching = true;
        currentSearchedString = gui.getTf().getText();
    }

    private void initWords(){
        this.words.add("Black Powder Goblin");
        this.words.add("Red Dragon");
        this.words.add("Intelligent Plant");
        this.words.add("Skeleton");
        this.words.add("Devouring Pact");
        this.words.add("Transmogrify");
        this.words.add("Fireball");
        this.words.add("Bolt of Lightning");
        this.words.add("Whip");
        this.words.add("Flesh Offering");
        this.words.add("Faith");

    }

    public void run(){

        init();


        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render(g);
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

        stop();

    }


    public synchronized void start(){
        if(running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop(){
        if(!running)
            return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
