package main.java.gfx;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {

    public static Font loadFont(String path, float size) {
        try{
            InputStream istream = FontLoader.class.getClassLoader().getResourceAsStream(path);
            Font myFont = Font.createFont(Font.TRUETYPE_FONT, istream).deriveFont(Font.PLAIN, size);

            return myFont;
        } catch (FontFormatException | IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}
