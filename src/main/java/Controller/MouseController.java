package main.java.Controller;

import main.java.animTester.AnimationTester;
import main.java.gfx.Animation;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseController implements MouseInputListener {

    private boolean leftPressed, rightPressed, clicked;
    private int mouseX, mouseY;

    private Rectangle hitBox;
    private AnimationTester animationTester;

    public MouseController(){
        this.hitBox = new Rectangle(mouseX, mouseY, 1, 1);
    }

    public void setAnimationTester(AnimationTester animtester){
        this.animationTester = animtester;
    }

    public void mousePressed(MouseEvent e) {
        leftPressed = e.getButton() == MouseEvent.BUTTON1;
        rightPressed = e.getButton() == MouseEvent.BUTTON3;
    }

    public void mouseReleased(MouseEvent e) {

        if(e.getButton() == MouseEvent.BUTTON1) {
            leftPressed = false;
            if(animationTester != null){
                animationTester.onLeftMouseRelease(e);
            }
        }
        if(e.getButton() == MouseEvent.BUTTON3){
            rightPressed = false;
        }
    }



    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();

        hitBox.x = mouseX;
        hitBox.y = mouseY;
        if(animationTester != null){
            animationTester.onMouseMoved(e);
        }
    }



    public void mouseDragged(MouseEvent e) {

    }


    public void mouseClicked(MouseEvent e) {
        clicked = true;
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }


    public void setHitBox(Rectangle bounds) {
        this.hitBox = bounds;
    }

    public Rectangle getHitBox() {
        return this.hitBox;
    }


    public boolean isLeftPressed(){
        return leftPressed;
    }
    public boolean isRightPressed(){
        return rightPressed;
    }
    public int getMouseX(){
        return mouseX;
    }
    public int getMouseY(){
        return mouseY;
    }

    public boolean isClicked() {
        return clicked;
    }

}
