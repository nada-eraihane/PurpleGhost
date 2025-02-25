package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import games.GamePanel; // Update import to match your package
import games.KeyHandler; // Update import to match your package

public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyH;
    public final int screenx;
    public final int screeny;

    public Player(GamePanel gp, KeyHandler keyH) {
        this.gp = gp;
        this.keyH = keyH;
        
        screenx = gp.screenWidth/2 - (gp.tileSize/2);
        screeny = gp.screenHeight/2 - (gp.tileSize/2);
        
        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 16;
        solidArea.height = 24;
        		
        
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldx = gp.tileSize * 23 ;
        worldy = gp.tileSize * 21 ;
        speed=4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = loadImage("/players/ghost_back_1.png");
            up2 = loadImage("/players/ghost_back_2.png");
            up3 = loadImage("/players/ghost_back_1.png");
            up4 = loadImage("/players/ghost_back_2.png");
            down1 = loadImage("/players/ghost_front_1.png");
            down2 = loadImage("/players/ghost_front_2.png");
            down3 = loadImage("/players/ghost_front_1.png");
            down4 = loadImage("/players/ghost_front_2.png");
            right1 = loadImage("/players/ghost_right_1.png");
            right2 = loadImage("/players/ghost_right_2.png");
            right3 = loadImage("/players/ghost_right_1.png");
            right4 = loadImage("/players/ghost_right_2.png");
            left1 = loadImage("/players/ghost_left_1.png");
            left2 = loadImage("/players/ghost_left_2.png");
            left3 = loadImage("/players/ghost_left_1.png");
            left4 = loadImage("/players/ghost_left_2.png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage loadImage(String path) throws IOException {
        BufferedImage img = ImageIO.read(getClass().getResourceAsStream(path));
        if (img == null) {
            System.out.println("Error: Image " + path + " not found!");
        }
        return img;
    }

    public void update() {
    	if(keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true|| keyH.rightPressed == true) {
            if (keyH.upPressed) {
                direction = "up";
            }
            if (keyH.downPressed) {
                direction = "down";
            }
            if (keyH.rightPressed) {
                direction = "right"; 
            }
            if (keyH.leftPressed) {
                direction = "left";
            }
            
            //check tile collision
            
            collisionOn = false;
            gp.checker.checkTile(this);
            
            //if collision is false the player can move
            if (collisionOn== false) {
            	switch(direction) {
            	case "up":
            		worldy -= speed;
            		break;
            	case "down":
            		worldy += speed;
            		break;
            	case "right":
            		worldx += speed;
            		break;
            	case "left":
            		worldx -= speed;
            		break;
            	}
            }
            worldx = Math.max(0, Math.min(worldx, gp.worldWidth - gp.tileSize));
        	worldy = Math.max(0, Math.min(worldy, gp.WorldHeight - gp.tileSize));
		
            
            spriteCounter++;
            if(spriteCounter > 10) {
            	if(spriteNum == 1) {
            		spriteNum = 2;
            	}
            	else if (spriteNum==2) {
            		spriteNum = 3;
            	}
            	else if (spriteNum == 3) {
            		spriteNum = 4;
            	}
            	else if (spriteNum == 4) {
            		spriteNum = 1;
            	}
            	spriteCounter =0;
            	
            }
            
    	}

    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
            	if (spriteNum == 1) {
            		image = up1;
            	}
            	if(spriteNum ==2) {
            		image = up2;
            	}
            	if (spriteNum == 3) {
            		image = up3;
            	}
            	if(spriteNum == 4) {
            		image = up4;
            	}
            	break;
            case "down":
            	if (spriteNum == 1) {
            		image = down1;
            	}
            	if(spriteNum ==2) {
            		image = down2;
            	}
            	if (spriteNum == 3) {
            		image = down3;
            	}
            	if(spriteNum == 4) {
            		image = down4;
            	}
                break;
            case "right":
            	if (spriteNum == 1) {
            		image = right1;
            	}
            	if(spriteNum ==2) {
            		image = right2;
            	}
            	if (spriteNum == 3) {
            		image = right3;
            	}
            	if(spriteNum == 4) {
            		image = right4;
            	}
                break;
            case "left":
            	if (spriteNum == 1) {
            		image = left1;
            	}
            	if(spriteNum ==2) {
            		image = left2;
            	}
            	if (spriteNum == 3) {
            		image = left3;
            	}
            	if(spriteNum == 4) {
            		image = left4;
            	}
                break;
        }
        g2.drawImage(image, screenx, screeny, gp.tileSize, gp.tileSize, null);
    }
}


