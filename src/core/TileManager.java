package core;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

public class TileManager {
<<<<<<< HEAD
boolean loaded=false;
=======

>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
	   public static int[][] map ;
//           {
//            {  1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 ,1,1,1,1,1,1,1,1,1,1,1,1,7,1,},
//            {  1 , 0 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 ,1,1,1,1,1,1,1,1,1,1,1,1,0,1,},
//            {  1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 1 , 1 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 1 , 0 , 0 , 1 , 1 , 1 , 1 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 1 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 0 , 1 , 0 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,0,0,0,0,0,0,0,1,},
//            {  1 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,1,1,1,1,1,0,0,1,},
//            {  1 , 0 , 0 , 0 , 1 , 1 , 0 , 0 , 0 , 0 , 0 ,0,0,0,0,0,0,1,1,1,1,1,0,0,1,},
//            {  1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 , 1 ,1,1,1,1,1,1,1,1,1,1,1,1,1,1,}
//      };
//	BufferedImage[] levelSprites;
<<<<<<< HEAD
  // public Tile[] tiles;
=======
   public Tile[] tiles;
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
	BufferedImage image;
   Window window;
   boolean drawPath=true;
   
<<<<<<< HEAD
	public TileManager(Window window)
	{
	  this.window=window;
	  image=AssetPool.getSpritesheet("spritesheet1");  
	  map=new int[Window.maxScreenCol][Window.maxScreenRow];
	  loadMap("/Assets/Maps/map1.txt");	
//	   tiles[0]=new Tile();
//	   tiles[0].image=image.getSubimage(30, 32*4, 30, 32);
//	     
//	     for(int i=1;i<7;i++) {	    	 
//	    	tiles[i]=new Tile(); 
//	    	 tiles[i].image=image.getSubimage((i)*32, 3*32, 32, 32);	     
//	     }
//	     tiles[1].collision=true;
//	     tiles[7]=new Tile();
//	     tiles[7].image=image.getSubimage(4*32, 2*32, 32, 32);
	}
   
	Tile[][] tiles;
=======
	public TileManager(Window window) {
	  this.window=window;
	  map=new int[Window.maxScreenCol][Window.maxScreenRow];
	  loadMap("/Assets/Maps/map1.txt");	
	  tiles=new Tile[8];
	   image=AssetPool.getSpritesheet("spritesheet1");
	   
	   tiles[0]=new Tile();
	   tiles[0].image=image.getSubimage(30, 32*4, 30, 32);
	     
	     for(int i=1;i<7;i++) {	    	 
	    	tiles[i]=new Tile(); 
	    	 tiles[i].image=image.getSubimage((i)*32, 3*32, 32, 32);	     
	     }
	     tiles[1].collision=true;
	     tiles[7]=new Tile();
	     tiles[7].image=image.getSubimage(4*32, 2*32, 32, 32);
	}
   
	
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
	public void loadMap(String file) {
		try {
			InputStream is=getClass().getResourceAsStream(file);
			BufferedReader br=new BufferedReader(new InputStreamReader(is));
			
			int col =0;
			int row=0;
<<<<<<< HEAD
			tiles=new Tile[Window.maxScreenCol][Window.maxScreenRow];

=======
			
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
			while(col<window.maxScreenCol&&row<window.maxScreenRow) {
				String line=br.readLine();
				while(col<window.maxScreenCol) {
					String numbers[]=line.split(" ");
				    int num=Integer.parseInt(numbers[col]);
				    map[col][row]=num;
<<<<<<< HEAD
				    tiles[col][row]=new Tile();
				    if(num==1) {
				    	tiles[col][row].collision=true;	
				    }
				    else if(num==0) {
				    	tiles[col][row].image=image.getSubimage(30, 32*4, 30, 32);
				    }
				    else if(num==7) {
				    	tiles[col][row].image=image.getSubimage(4*32, 2*32, 32, 32);
				    }
				    if(num!=0&&num!=7) {
				    	tiles[col][row].image=image.getSubimage(num*32, 3*32, 32, 32);				    	
				    }
				    col++;
				}
				if(col==window.maxScreenCol) {
				
					//	tiles[col][row].image=image.getSubimage(4*32, 2*32, 32, 32);
					col=0;
					
=======
				    col++;
				}
				if(col==window.maxScreenCol) {
					col=0;
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
					row++;
				}
			}
			br.close();
<<<<<<< HEAD
			loaded=true;
=======
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
		}
		catch(Exception e) {
		e.printStackTrace();	
		}
	}
	
	   public void render(Graphics g)
       {
		   
//            for (int x = 0; x < map[0].length; x++)
//           {
//               for (int y = 0; y < map.length; y++)
//               {
//            	   int worldX=x*30;
//            	   int worldY=y*30;
//            	   int screenX=worldX-window.player.x+window.player.screenX;
//            	   int screenY=worldY-window.player.y+window.player.screenY;
////            	   g.drawImage(levelSprites[map[y][x]], x*30, (y+2)*30, 30, 30,  null); 
//                  if(worldX+30>window.player.x- window.player.screenX&&
//        		  worldX-30<window.player.x+window.player.screenX&&
//        		  worldY+30>window.player.y-window.player.screenY&&
//        		  worldY-30<window.player.y+window.player.screenY
//        		  )
//                  { 
//                	  System.out.print(map.length);
//            	  // g.drawImage(tiles[map[x][y]].image, screenX, screenY, 30, 30,  null); 
//                  }
//               }
//           }
//           
<<<<<<< HEAD
           if(!loaded)return;
=======
           
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
           int col =0;
			int row=0;
			
			while(col<window.maxScreenCol&&row<window.maxScreenRow) {
				//String line=br.readLine();
				while(col<window.maxScreenCol) {
				 
					   int worldX=col*30;
	            	   int worldY=row*30;
	            	   int screenX=worldX-window.player.x+window.player.screenX;
	            	   int screenY=worldY-window.player.y+window.player.screenY;
//	            	   g.drawImage(levelSprites[map[y][x]], x*30, (y+2)*30, 30, 30,  null); 
	                  if(worldX+30>window.player.x- window.player.screenX&&
	        		  worldX-30<window.player.x+window.player.screenX&&
	        		  worldY+30>window.player.y-window.player.screenY&&
	        		  worldY-30<window.player.y+window.player.screenY
	        		  ) {
<<<<<<< HEAD
	                	  g.drawImage(tiles[col][row].image, screenX, screenY, 30, 30,  null); 
=======
	                	  g.drawImage(tiles[map[col][row]].image, screenX, screenY, 30, 30,  null); 
>>>>>>> 93556c48c2d3e38a5fb35b97ef3135327b53e195
	                  }
				    col++;
				}
				if(col==window.maxScreenCol) {
					col=0;
					row++;
				}
			}

            if(drawPath) {
            	g.setColor(new Color(255,0,0,70));
            	for(int i=0;i<window.pFinder.pathList.size();i++) {
            	   int worldX=window.pFinder.pathList.get(i).col*30;
            	   int worldY=window.pFinder.pathList.get(i).row*30;
              	   int screenX=worldX-window.player.x+window.player.screenX;
              	   int screenY=worldY-window.player.y+window.player.screenY;

              	   g.fillRect(screenX, screenY, 30, 30);
            	}
            	
            }
            
       }
}
