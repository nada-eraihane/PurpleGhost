package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int worldx, worldy;
    public int speed;
    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2, up3, up4, down3, down4, left3, left4, right3, right4;
    public String direction;
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;
}
