package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import games.GamePanel;

public class TileManager {

	GamePanel gp;
	public Tile[]tile;
	public int mapTileNum[][];
	
	public TileManager(GamePanel gp) {
		
		this.gp = gp;
		
		tile = new Tile[60];
		mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
		
		getTileImage();
		loadMap("/maps/world01.txt");
	}
	public void getTileImage() {
		
		try {
			
			        
			        tile[0] = new Tile();
			        tile[0].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass.png")); // Grass

			        tile[1] = new Tile();
			        tile[1].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water.png")); // Water
			        tile[1].collision =true;
			        
			        tile[2] = new Tile();
			        tile[2].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/earth.png")); // Earth

			        // Grass-related Tiles
			        tile[3] = new Tile();
			        tile[3].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_center.png"));

			        tile[4] = new Tile();
			        tile[4].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_left_top.png"));
			        

			        tile[5] = new Tile();
			        tile[5].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_right_top.png"));

			        tile[6] = new Tile();
			        tile[6].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_right_down.png"));

			        tile[7] = new Tile();
			        tile[7].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_left_down.png"));
			        

			        tile[8] = new Tile();
			        tile[8].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_right.png"));

			        tile[9] = new Tile();
			        tile[9].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_bottom.png"));

			        tile[10] = new Tile();
			        tile[10].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_up.png"));

			        tile[11] = new Tile();
			        tile[11].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_left.png"));

			        tile[12] = new Tile();
			        tile[12].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_bottom.png"));
			        

			        tile[13] = new Tile();
			        tile[13].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_right.png"));

			        tile[14] = new Tile();
			        tile[14].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_left.png"));
			        

			        tile[15] = new Tile();
			        tile[15].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/grass_dead_end_top.png"));

			        // Water and Grass mixed Tiles
			        tile[16] = new Tile();
			        tile[16].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_down_left.png"));
			        tile[16].collision = true;
			        
			        tile[17] = new Tile();
			        tile[17].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_down_right.png"));
			        tile[17].collision = true;
			        
			        tile[18] = new Tile();
			        tile[18].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_top_right.png"));
			        tile[18].collision = true;
			        
			        tile[19] = new Tile();
			        tile[19].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_top_left.png"));
			        tile[19].collision = true;

			        tile[20] = new Tile();
			        tile[20].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_left.png"));
			        tile[20].collision = true;
			        
			        tile[21] = new Tile();
			        tile[21].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_down.png"));
			        tile[21].collision = true;
			        
			        tile[22] = new Tile();
			        tile[22].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_right.png"));
			        tile[22].collision = true;

			        tile[23] = new Tile();
			        tile[23].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_top.png"));
			        tile[23].collision = true;

			        tile[24] = new Tile();
			        tile[24].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_dead_end_left.png"));
			        tile[24].collision = true;

			        tile[25] = new Tile();
			        tile[25].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_dead_end_down.png"));
			        tile[25].collision = true;

			        tile[26] = new Tile();
			        tile[26].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_dead_end_top.png"));
			        tile[26].collision = true;

			        tile[27] = new Tile();
			        tile[27].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_dead_end_right.png"));
			        tile[27].collision = true;

			        tile[28] = new Tile();
			        tile[28].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_right_left.png"));
			        tile[28].collision = true;
			        
			        tile[29] = new Tile();
			        tile[29].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_top_bottom.png"));
			        tile[29].collision = true;
			        
			        tile[30] = new Tile();
			        tile[30].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_center.png"));
			        tile[30].collision = true;
			        
			        // Water and Earth mixed Tiles
			        tile[31] = new Tile();
			        tile[31].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_top_right.png"));
			        tile[31].collision = true;
			        
			        tile[32] = new Tile();
			        tile[32].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_down_right.png"));
			        tile[32].collision = true;
			        
			        tile[33] = new Tile();
			        tile[33].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_down_left.png"));
			        tile[33].collision = true;
			        
			        tile[34] = new Tile();
			        tile[34].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_top_left.png"));
			        tile[34].collision = true;
			        
			        tile[35] = new Tile();
			        tile[35].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_left.png"));
			        tile[35].collision = true;
			        
			        tile[36] = new Tile();
			        tile[36].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_down.png"));
			        tile[36].collision = true;
			        
			        tile[37] = new Tile();
			        tile[37].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_right.png"));
			        tile[37].collision = true;

			        tile[38] = new Tile();
			        tile[38].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_top.png"));
			        tile[38].collision = true;

			        tile[39] = new Tile();
			        tile[39].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_dead_end_left.png"));
			        tile[39].collision = true;

			        tile[40] = new Tile();
			        tile[40].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_dead_end_right.png"));
			        tile[40].collision = true;

			        tile[41] = new Tile();
			        tile[41].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_dead_end_down.png"));
			        tile[41].collision = true;

			        tile[42] = new Tile();
			        tile[42].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_dead_end_top.png"));
			        tile[42].collision = true;

			        tile[43] = new Tile();
			        tile[43].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_top_bottom.png"));
			        tile[43].collision = true;
			        
			        tile[44] = new Tile();
			        tile[44].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_earth_bottom_top.png"));
			        tile[44].collision = true;
			        
			        tile[45] = new Tile();
			        tile[45].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/trees.png"));
			        tile[45].collision = true;
			        
			        tile[46] = new Tile();
			        tile[46].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/stone.png"));
			        tile[46].collision = true;
			        
			        tile[47] = new Tile();
			        tile[47].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_corner_left_down.png"));
			        tile[47].collision = true;
			        
			        tile[48] = new Tile();
			        tile[48].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_corner_right_left.png"));
			        tile[48].collision = true;
			        
			        tile[49] = new Tile();
			        tile[49].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_corner_top_left.png"));
			        tile[49].collision = true;
			        
			        tile[50] = new Tile();
			        tile[50].image = ImageIO.read(getClass().getResourceAsStream("/new_tiles/water_grass_corner_right_down.png"));
			        tile[50].collision = true;
			        
			    } catch (IOException e) {
			        e.printStackTrace();
			    }
			}

	public void loadMap(String filePath) {
		try {
			InputStream is = getClass().getResourceAsStream("/maps/world01.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
		    
			int col = 0;
			int row = 0;
			while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
				String line = br.readLine();
				
				while (col< gp.maxWorldCol ) {
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					mapTileNum[col][row]= num;
					col++;
				}
				if (col == gp.maxWorldCol) {
					col = 0;
					row++;
				}
			}
			br.close();
			
					
		}catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		
		int worldcol = 0;
		int worldrow = 0;

		
		while(worldcol < gp.maxWorldCol && worldrow < gp.maxWorldRow) {
			
			int tileNum = mapTileNum[worldcol][worldrow];
			
			int worldx = worldcol * gp.tileSize;
			int worldy = worldrow * gp.tileSize;
			int screenx = worldx - gp.player.worldx + gp.player.screenx;
			int screeny = worldy - gp.player.worldy + gp.player.screeny;
			
			if (worldx + gp.tileSize > gp.player.worldx - gp.player.screenx && 
					worldx - gp.tileSize < gp.player.worldx + gp.player.screenx && 
					worldy + gp.tileSize > gp.player.worldy - gp.player.screeny && 
					worldy - gp.tileSize < gp.player.worldy + gp.player.screeny) {
				g2.drawImage(tile[tileNum].image, (int)screenx, (int)screeny, gp.tileSize + 1, gp.tileSize + 1, null);
			}
			
			worldcol++;

			 if (worldcol == gp.maxWorldCol) {
				 worldcol =0;

				 worldrow++;

			 }
		}
		
		//g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
		//g2.drawImage(tile[1].image, 0, 0, gp.tileSize, gp.tileSize, null);
		//g2.drawImage(tile[2].image, 48, 0, gp.tileSize, gp.tileSize, null);
		//g2.drawImage(tile[0].image, 96, 0, gp.tileSize, gp.tileSize, null);
		
		
		
	}
}

