package main.java.gfx;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Assets {

    //Font
    public static Font fontImmortal28, fontImmortal16, fontImmortal10, fontImmortal12, fontImmortal8, fontImmortal9, fontImmortal20;


    public static BufferedImage dirt, grass, stone, plant1, backgroundImage, redDragon, translucent;
    public static BufferedImage[] dragon_down, dragon_idle, dragon_attack;

    public static BufferedImage[] intelligentPlant;

    public static BufferedImage[] skeleton_idle;
    public static BufferedImage[] skeleton_idle_SPRITE;

    public static BufferedImage[] playButton, endTurnButton, manaBubble, actionPoints, guiOverlay, minionHealth;

    public static BufferedImage[] endTurnButtonHover, endTurnButtonBloom, endTurnButtonDeBloom, endTurnButtonIdle;

    public static BufferedImage[] rockTile2, dirtTile2, grassTile2, card_Skeleton, card_redDragon;

    //GUI OverLay
    public static BufferedImage[] cardDock, graveYard, deckDock, activeCardDock, zoomCardDock;

    private static final int ACTION_POINT_WIDTH = 40;
    private static final int ACTION_POINT_HEIGHT = 31;

    private static final int WIDTH = 40, HEIGHT = 39;
    private static final int WIDTH_P = 59, HEIGHT_P = 55;
    private static final int WIDTH_DRAG = 166, HEIGHT_DRAG = 147;


    private static final int FULL_CARD_HEIGHT = 353;
    private  static final int FULL_CARD_WIDTH = 245;
    private static final int SMALL_CARD_HEIGHT = 81;
    private static final int SMALL_CARD_WIDTH = 86;


    public static void init(){

        fontImmortal8 = FontLoader.loadFont("fonts/expressway.ttf", 8);
        fontImmortal8 = FontLoader.loadFont("fonts/expressway.ttf", 9);
        fontImmortal28 = FontLoader.loadFont("fonts/expressway.ttf", 28);
        fontImmortal12 = FontLoader.loadFont("fonts/expressway.ttf", 12);
        fontImmortal16 = FontLoader.loadFont("fonts/expressway.ttf", 16);
        fontImmortal10 = FontLoader.loadFont("fonts/expressway.ttf", 10);
        fontImmortal20 = FontLoader.loadFont("fonts/expressway.ttf", 20);

        SpriteSheet tileSheet = new SpriteSheet(ImageLoader.loadImage("textures/tileSheet.png"));
//        SpriteSheet dragonSheet = new SpriteSheet(ImageLoader.loadImage("textures/reddragon.png"));
        SpriteSheet dragonSheet = new SpriteSheet(ImageLoader.loadImage("textures/dragonfaceSheet.png"));
        SpriteSheet skeletonAnimationsSheet = new SpriteSheet(ImageLoader.loadImage("textures/skeletonSpriteSheet.png"));

        SpriteSheet IPsheet = new SpriteSheet(ImageLoader.loadImage("textures/intelligentPlantSheet.png"));

        SpriteSheet buttonSheet = new SpriteSheet(ImageLoader.loadImage("textures/buttonSheet.png"));
        SpriteSheet card_SkeletonSheet = new SpriteSheet(ImageLoader.loadImage("textures/Skeleton1.png"));
        SpriteSheet card_redDragonSheet = new SpriteSheet(ImageLoader.loadImage("textures/card_RedDragon.png"));

        SpriteSheet actionPointSheet = new SpriteSheet(ImageLoader.loadImage("textures/ActionPointSheet.png"));
        SpriteSheet manaBubbleSheet = new SpriteSheet(ImageLoader.loadImage("textures/manaPotionSheet.png"));
        SpriteSheet minionHealthSheet = new SpriteSheet(ImageLoader.loadImage("textures/minionHealthSheet.png"));

        SpriteSheet endTurnButtonSheet = new SpriteSheet(ImageLoader.loadImage("textures/endTurnButtonSheet3.png"));
        SpriteSheet guiOverlaySheet = new SpriteSheet(ImageLoader.loadImage("textures/GUItest.png"));
        SpriteSheet cardDockSheet = new SpriteSheet((ImageLoader.loadImage("textures/cardDockSheet.png")));
        SpriteSheet activeCardDockSheet = new SpriteSheet((ImageLoader.loadImage("textures/activeCardDockSheet.png")));

        backgroundImage = ImageLoader.loadImage("textures/mBackground1500x937.png");


        //BUTTONS & MANA & MISC

        cardDock = new BufferedImage[9];
        cardDock[0] = cardDockSheet.crop(0, 0, 862, 125);
        cardDock[1] = cardDockSheet.crop(0, 125, 862, 125);
        cardDock[2] = cardDockSheet.crop(0, 250, 862, 125);
        cardDock[3] = cardDockSheet.crop(0, 375, 862, 125);
        cardDock[4] = cardDockSheet.crop(0, 500, 862, 125);
        cardDock[5] = cardDockSheet.crop(0, 375, 862, 125);
        cardDock[6] = cardDockSheet.crop(0, 250, 862, 125);
        cardDock[7] = cardDockSheet.crop(0, 125, 862, 125);
        cardDock[8] = cardDockSheet.crop(0, 0, 862, 125);

        activeCardDock = new BufferedImage[9];
        activeCardDock[0] = activeCardDockSheet.crop(0, 0, 258, 227);
        activeCardDock[1] = activeCardDockSheet.crop(258, 0, 258, 227);
        activeCardDock[2] = activeCardDockSheet.crop(516, 0, 258, 227);
        activeCardDock[3] = activeCardDockSheet.crop(774, 0, 258, 227);
        activeCardDock[4] = activeCardDockSheet.crop(1032, 0, 258, 227);
        activeCardDock[5] = activeCardDockSheet.crop(774, 0, 258, 227);
        activeCardDock[6] = activeCardDockSheet.crop(516, 0, 258, 227);
        activeCardDock[7] = activeCardDockSheet.crop(258, 0, 258, 227);
        activeCardDock[8] = activeCardDockSheet.crop(0, 0, 258, 227);

        guiOverlay = new BufferedImage[3];
        guiOverlay[0] = guiOverlaySheet.crop(0, 0, 1500, 937);
        guiOverlay[1] = guiOverlaySheet.crop(1500, 0, 1500, 937);
        guiOverlay[2] = guiOverlaySheet.crop(3000, 0, 1500, 937);

        playButton = new BufferedImage[2];
        playButton[0] = buttonSheet.crop(0, 0, 60, 30);
        playButton[1] = buttonSheet.crop(60, 0, 60, 30);

        endTurnButton = new BufferedImage[3];
        endTurnButton[0] = buttonSheet.crop(120, 0, 60, 30);
        endTurnButton[1] = buttonSheet.crop(180, 0, 60, 30);
        endTurnButton[2] = buttonSheet.crop(240, 0, 60, 30);

        manaBubble = new BufferedImage[12];
        manaBubble[0] = manaBubbleSheet.crop(1, 0, 85, 85);
        manaBubble[1] = manaBubbleSheet.crop(86, 0, 85, 85);
        manaBubble[2] = manaBubbleSheet.crop(171, 0, 85, 85);
        manaBubble[3] = manaBubbleSheet.crop(256, 0, 85, 85);
        manaBubble[4] = manaBubbleSheet.crop(341, 0, 85, 85);
        manaBubble[5] = manaBubbleSheet.crop(426, 0, 85, 85);
        manaBubble[6] = manaBubbleSheet.crop(511, 0, 85, 85);
        manaBubble[7] = manaBubbleSheet.crop(596, 0, 85, 85);
        manaBubble[8] = manaBubbleSheet.crop(681, 0, 85, 85);
        manaBubble[9] = manaBubbleSheet.crop(766, 0, 85, 85);
        manaBubble[10] = manaBubbleSheet.crop(851, 0, 85, 85);
        manaBubble[11] = manaBubbleSheet.crop(936, 0, 85, 85);

        minionHealth = new BufferedImage[73];
        int j = 0;
        for(int i = 0; i < 73; i++){
            minionHealth[i] = minionHealthSheet.crop(j, 0, 26, 26);
            j += 26;
        }

        actionPoints = new BufferedImage[10];
        actionPoints[0] = actionPointSheet.crop(0, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[1] = actionPointSheet.crop(40, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[2] = actionPointSheet.crop(80, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[3] = actionPointSheet.crop(120, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[4] = actionPointSheet.crop(160, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[5] = actionPointSheet.crop(200, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[6] = actionPointSheet.crop(240, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[7] = actionPointSheet.crop(280, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[8] = actionPointSheet.crop(320, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);
        actionPoints[9] = actionPointSheet.crop(360, 0, ACTION_POINT_WIDTH, ACTION_POINT_HEIGHT);

        endTurnButtonHover = new BufferedImage[56];
        int etb3 = 0;
        for(int i3 = 0; i3 < 7; i3++){
            endTurnButtonHover[i3] = endTurnButtonSheet.crop(etb3, 180, 115, 60);
            etb3 += 115;
        }
        int etb4 = 0;
        for(int i4 = 7; i4 < 14; i4++){
            endTurnButtonHover[i4] = endTurnButtonSheet.crop(etb4, 240, 115, 60);
            etb4 += 115;
        }
        int etb5 = 0;
        for(int i5 = 14; i5 < 21; i5++){
            endTurnButtonHover[i5] = endTurnButtonSheet.crop(etb5, 300, 115, 60);
            etb5 += 115;
        }
        int etb6 = 0;
        for(int i6 = 21; i6 < 28; i6++){
            endTurnButtonHover[i6] = endTurnButtonSheet.crop(etb6, 360, 115, 60);
            etb6 += 115;
        }
        int etb7 = 0;
        for(int i7 = 28; i7 < 35; i7++){
            endTurnButtonHover[i7] = endTurnButtonSheet.crop(etb7, 420, 115, 60);
            etb7 += 115;
        }
        int etb8 = 0;
        for(int i8 = 35; i8 < 42; i8++){
            endTurnButtonHover[i8] = endTurnButtonSheet.crop(etb8, 480, 115, 60);
            etb8 += 115;
        }
        int etb9 = 0;
        for(int i9 = 42; i9 < 49; i9++){
            endTurnButtonHover[i9] = endTurnButtonSheet.crop(etb9, 540, 115, 60);
            etb9 += 115;
        }
        int etb10 = 0;
        for(int i10 = 49; i10 < 56; i10++){
            endTurnButtonHover[i10] = endTurnButtonSheet.crop(etb10, 600, 115, 60);
            etb10 += 115;
        }

        endTurnButtonIdle = new BufferedImage[1];
        endTurnButtonIdle[0] = endTurnButtonSheet.crop(0, 0, 115, 60);

        endTurnButtonBloom = new BufferedImage[21];
        endTurnButtonBloom[0] = endTurnButtonSheet.crop(0, 0, 115, 60);
        endTurnButtonBloom[1] = endTurnButtonSheet.crop(115, 0, 115, 60);
        endTurnButtonBloom[2] = endTurnButtonSheet.crop(230, 0, 115, 60);
        endTurnButtonBloom[3] = endTurnButtonSheet.crop(345, 0, 115, 60);
        endTurnButtonBloom[4] = endTurnButtonSheet.crop(460, 0, 115, 60);
        endTurnButtonBloom[5] = endTurnButtonSheet.crop(575, 0, 115, 60);
        endTurnButtonBloom[6] = endTurnButtonSheet.crop(690, 0, 115, 60);
        endTurnButtonBloom[7] = endTurnButtonSheet.crop(0, 60, 115, 60);
        endTurnButtonBloom[8] = endTurnButtonSheet.crop(115, 60, 115, 60);
        endTurnButtonBloom[9] = endTurnButtonSheet.crop(230, 60, 115, 60);
        endTurnButtonBloom[10] = endTurnButtonSheet.crop(345, 60, 115, 60);
        endTurnButtonBloom[11] = endTurnButtonSheet.crop(460, 60, 115, 60);
        endTurnButtonBloom[12] = endTurnButtonSheet.crop(575, 60, 115, 60);
        endTurnButtonBloom[13] = endTurnButtonSheet.crop(690, 60, 115, 60);
        endTurnButtonBloom[14] = endTurnButtonSheet.crop(0, 120, 115, 60);
        endTurnButtonBloom[15] = endTurnButtonSheet.crop(115, 120, 115, 60);
        endTurnButtonBloom[16] = endTurnButtonSheet.crop(230, 120, 115, 60);
        endTurnButtonBloom[17] = endTurnButtonSheet.crop(345, 120, 115, 60);
        endTurnButtonBloom[18] = endTurnButtonSheet.crop(460, 120, 115, 60);
        endTurnButtonBloom[19] = endTurnButtonSheet.crop(575, 120, 115, 60);
        endTurnButtonBloom[20] = endTurnButtonSheet.crop(690, 120, 115, 60);

        endTurnButtonDeBloom = new BufferedImage[5];
        endTurnButtonDeBloom[0] = endTurnButtonSheet.crop(0, 660, 115, 60);
        endTurnButtonDeBloom[1] = endTurnButtonSheet.crop(115, 660, 115, 60);
        endTurnButtonDeBloom[2] = endTurnButtonSheet.crop(230, 660, 115, 60);
        endTurnButtonDeBloom[3] = endTurnButtonSheet.crop(345, 660, 115, 60);
        endTurnButtonDeBloom[4] = endTurnButtonSheet.crop(460, 660, 115, 60);


        //  TILES #################################################################
        rockTile2 = new BufferedImage[4];
        rockTile2[0] = tileSheet.crop(WIDTH*2, 0, WIDTH, HEIGHT);
        rockTile2[1] = tileSheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
        rockTile2[2] = tileSheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
        rockTile2[3] = tileSheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);

        dirtTile2 = new BufferedImage[4];
        dirtTile2[0] = tileSheet.crop(WIDTH*1, 0, WIDTH, HEIGHT);
        dirtTile2[1] = tileSheet.crop(WIDTH*4, 0, WIDTH, HEIGHT);
        dirtTile2[2] = tileSheet.crop(WIDTH*8, 0, WIDTH, HEIGHT);
        dirtTile2[3] = tileSheet.crop(WIDTH*11, 0, WIDTH, HEIGHT);


        grassTile2 = new BufferedImage[4];
        grassTile2[0] = tileSheet.crop(0, 0, WIDTH, HEIGHT);
        grassTile2[1] = tileSheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
        grassTile2[2] = tileSheet.crop(WIDTH*7, 0, WIDTH, HEIGHT);
        grassTile2[3] = tileSheet.crop(WIDTH*10, 0, WIDTH, HEIGHT);

        dirt = tileSheet.crop(0, 0, WIDTH, HEIGHT);
        grass = tileSheet.crop(WIDTH, 0, WIDTH, HEIGHT);
        stone = tileSheet.crop(WIDTH*2, 0, WIDTH, HEIGHT);
        translucent = tileSheet.crop(WIDTH*3, 0, WIDTH, HEIGHT);
        // ########################################################################





        //  MINIONS ######################################################################################

        intelligentPlant = new BufferedImage[4];

        intelligentPlant[0] = IPsheet.crop(0, 0, 60, 60);
        intelligentPlant[1] = IPsheet.crop(0, 0, 60, 60);
        intelligentPlant[2] = IPsheet.crop(0, 0, 60, 60);
        intelligentPlant[3] = IPsheet.crop(0, 0, 60, 60);

        skeleton_idle_SPRITE = new BufferedImage[10];
        skeleton_idle_SPRITE[0] = skeletonAnimationsSheet.crop(0,0, 60, 60);
        skeleton_idle_SPRITE[1] = skeletonAnimationsSheet.crop(60,0, 60, 60);
        skeleton_idle_SPRITE[2] = skeletonAnimationsSheet.crop(120,0, 60, 60);
        skeleton_idle_SPRITE[3] = skeletonAnimationsSheet.crop(180,0, 60, 60);
        skeleton_idle_SPRITE[4] = skeletonAnimationsSheet.crop(240,0, 60, 60);
        skeleton_idle_SPRITE[5] = skeletonAnimationsSheet.crop(0,60, 60, 60);
        skeleton_idle_SPRITE[6] = skeletonAnimationsSheet.crop(60,60, 60, 60);
        skeleton_idle_SPRITE[7] = skeletonAnimationsSheet.crop(120,60, 60, 60);
        skeleton_idle_SPRITE[8] = skeletonAnimationsSheet.crop(180,60, 60, 60);
        skeleton_idle_SPRITE[9] = skeletonAnimationsSheet.crop(240,60, 60, 60);


//        dragon_idle = new BufferedImage[3];
//        dragon_idle[0] = dragonSheet.crop(0, 515, 153/*width*/, 127/*height*/);
//        dragon_idle[1] = dragonSheet.crop(152, 515, 174, 127);
//        dragon_idle[2] = dragonSheet.crop(338, 515, 173, 127);


//        dragon_down = new BufferedImage[4];
//        dragon_down[0] = dragonSheet.crop(546, 146, WIDTH_DRAG, HEIGHT_DRAG);
//        dragon_down[1] = dragonSheet.crop(752, 146, WIDTH_DRAG, HEIGHT_DRAG);
//        dragon_down[2] = dragonSheet.crop(950, 146, WIDTH_DRAG, HEIGHT_DRAG);
//        dragon_down[3] = dragonSheet.crop(752, 146, WIDTH_DRAG, HEIGHT_DRAG);


//        dragon_attack = new BufferedImage[2];
//        dragon_attack[0] = dragonSheet.crop(168, 354, WIDTH_DRAG/*width*/, HEIGHT_DRAG/*height*/);
//        dragon_attack[1] = dragonSheet.crop(334, 354, WIDTH_DRAG, HEIGHT_DRAG);


        dragon_idle = new BufferedImage[4];
        dragon_idle[0] = dragonSheet.crop(0, 0, 99/*width*/, 127/*height*/);
        dragon_idle[1] = dragonSheet.crop(100, 0, 99, 127);
        dragon_idle[2] = dragonSheet.crop(200, 0, 99, 127);
        dragon_idle[3] = dragonSheet.crop(300, 0, 99, 127);

        dragon_down = new BufferedImage[4];
        dragon_idle[0] = dragonSheet.crop(0, 0, 99/*width*/, 127/*height*/);
        dragon_idle[1] = dragonSheet.crop(100, 0, 99, 127);
        dragon_idle[2] = dragonSheet.crop(200, 0, 99, 127);
        dragon_idle[3] = dragonSheet.crop(300, 0, 99, 127);

        dragon_attack = new BufferedImage[4];
        dragon_idle[0] = dragonSheet.crop(0, 0, 99/*width*/, 127/*height*/);
        dragon_idle[1] = dragonSheet.crop(100, 0, 99, 127);
        dragon_idle[2] = dragonSheet.crop(200, 0, 99, 127);
        dragon_idle[3] = dragonSheet.crop(300, 0, 99, 127);


        // ################################################################################################


        // CARDS   ##########################################################################################

        card_Skeleton = new BufferedImage[3];
        card_Skeleton[0] = card_SkeletonSheet.crop(0, 0, FULL_CARD_WIDTH, FULL_CARD_HEIGHT);
        card_Skeleton[1] = card_SkeletonSheet.crop(246, 0, SMALL_CARD_WIDTH, SMALL_CARD_HEIGHT);
        card_Skeleton[2] = card_SkeletonSheet.crop(332, 0, SMALL_CARD_WIDTH, SMALL_CARD_HEIGHT);

        card_redDragon = new BufferedImage[3];
        card_redDragon[0] = card_redDragonSheet.crop(0, 0, FULL_CARD_WIDTH, FULL_CARD_HEIGHT);
        card_redDragon[1] = card_redDragonSheet.crop(246, 0, SMALL_CARD_WIDTH, SMALL_CARD_HEIGHT);
        card_redDragon[2] = card_redDragonSheet.crop(332, 0, SMALL_CARD_WIDTH, SMALL_CARD_HEIGHT);


        // ###################################################################################################

    }


}