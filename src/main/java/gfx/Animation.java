package main.java.gfx;

import java.awt.image.BufferedImage;

public class Animation {

    private int speed, index;
    private long lastTime, timer;
    private BufferedImage[] frames;
    private boolean looping = true;
    private boolean animFinished;

    public Animation(int speed, BufferedImage[] frames){
        this.speed = speed;
        this.frames = frames;
        index = 0;
        lastTime = System.currentTimeMillis();
    }

    public void tick(){
        timer += System.currentTimeMillis() - lastTime;
        lastTime = System.currentTimeMillis();

        if (timer > speed) {
            index++;
            timer = 0;
            if (index >= frames.length && looping) {
                index = 0;
                animFinished = false;
            }
            else if (index >= frames.length && !looping) {
                index = frames.length - 1;
                animFinished = true;
            }
        }
    }

    public BufferedImage getCurrentFrame(){
        return frames[index];
    }

    public void start(){
    }

    public boolean isLooping() {
        return looping;
    }

    public void setLooping(boolean looping) {
        this.looping = looping;
    }

    public boolean isAnimFinished() {
        return animFinished;
    }

}