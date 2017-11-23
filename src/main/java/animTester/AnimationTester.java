package main.java.animTester;

import main.java.Controller.MouseController;
import main.java.gfx.Animation;
import main.java.gfx.Assets;
import main.java.guiAndLauncher.Gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class AnimationTester implements Runnable {


    private Gui gui;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    private Animation endTurnButtonHover, endTurnButtonIdle, endTurnButtonBloom, endTurnButtonDeBloom;



    private MouseController mouseController;

    private boolean hovering = false;

    private Rectangle animHitBox;

    private Assets assets;

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


        //TEST ANIMATION BELOW
        // - - - - - - - - -
        // - - - - - - - - -
        endTurnButtonHover = new Animation(50, Assets.endTurnButtonHover);
        endTurnButtonIdle = new Animation(50, Assets.endTurnButtonIdle);
        endTurnButtonBloom = new Animation(50, Assets.endTurnButtonBloom);
        endTurnButtonDeBloom = new Animation(50, Assets.endTurnButtonDeBloom);
        // - - - - - - - - -
        // - - - - - - - - -
        // TEST ANIMATION ABOVE
    }

    public void tick(){

        endTurnButtonDeBloom.tick();
        endTurnButtonBloom.tick();
        endTurnButtonIdle.tick();
        endTurnButtonHover.tick();

        animHitBox = new Rectangle(120,328, 115, 60);

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

        if(hovering){
            g.drawImage(endTurnButtonBloom.getCurrentFrame(), 120, 328, 115, 60, null);
            endTurnButtonBloom.setLooping(false);
            endTurnButtonDeBloom.setLooping(true);
            if(endTurnButtonBloom.isAnimFinished()){
                g.drawImage(endTurnButtonHover.getCurrentFrame(), 120, 328, 115, 60, null);
            }
        }
        else{
            g.drawImage(endTurnButtonDeBloom.getCurrentFrame(), 120, 328, 115, 60, null);
            endTurnButtonDeBloom.setLooping(false);
            if(endTurnButtonDeBloom.isAnimFinished()){
                g.drawImage(endTurnButtonIdle.getCurrentFrame(), 120, 328, 115, 60, null);
            }
            endTurnButtonBloom.setLooping(true);
        }

        bs.show();
        g.dispose();
    }

    public void onLeftMouseRelease(MouseEvent e){

    }

    public void onMouseMoved(MouseEvent e){
        hovering = (animHitBox.contains(mouseController.getHitBox()));
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
