package main.java.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageLoader {

    InputStream stream;

    public static BufferedImage loadImage(String path){
        try {
            return ImageIO.read(ImageLoader.class.getClassLoader().getResourceAsStream(path));
        } catch (IOException e) {
            System.out.println("Couldnt load image");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}