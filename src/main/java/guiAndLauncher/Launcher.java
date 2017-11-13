package main.java.guiAndLauncher;

import main.java.animTester.AnimationTester;

public class Launcher {

    public static void main(String[] args){
        AnimationTester animationTester = new AnimationTester("test", 500, 500);
        animationTester.start();
    }

}
