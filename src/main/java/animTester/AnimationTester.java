package main.java.animTester;

import main.java.gfx.Animation;
import main.java.gfx.Assets;
import main.java.guiAndLauncher.Gui;

import java.awt.*;
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

    private Animation testAnimation;

    private Assets assets;

    public AnimationTester(String title, int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;

    }

    private void init() { //initialize the game and starting pieces/tiles
        gui = new Gui(title, width, height);
        //load assets(images etc)
        Assets.init();

        //TEST ANIMATION BELOW
        // - - - - - - - - -
        // - - - - - - - - -
        testAnimation = new Animation(250, Assets.skeleton_idle_SPRITE);
        // - - - - - - - - -
        // - - - - - - - - -
        // TEST ANIMATION ABOVE
    }

    public void tick(){
        testAnimation.tick();
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

        g.drawImage(testAnimation.getCurrentFrame(), 35, 30, 60, 60, null);
        g.drawImage(testAnimation.getCurrentFrame(), 236, 128, 60, 60, null);
        g.drawImage(testAnimation.getCurrentFrame(), 120, 328, 60, 60, null);


        //


        bs.show();
        g.dispose();
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

    private BufferedImage getCurrentAnimationFrame(){
        return testAnimation.getCurrentFrame();
    }
}
