package core;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class AssetPool {
	
public static Map<String,BufferedImage> spritesheets=new HashMap();

public static BufferedImage getSpritesheet(String name) {
	  File file = new File(name);
	  BufferedImage texture; 
     
		if (AssetPool.spritesheets.containsKey(file.getAbsolutePath())) {
		      return AssetPool.spritesheets.get(file.getAbsolutePath());
		  } else {
		     // InputStream is=getClass().getResourceAsStream("/Images/Player/Scavengers_Spritesheet.png");
		      try{
//		     	 texture=ImageIO.read(is);
		    	  texture=ImageIO.read(new File(name));
		    	  AssetPool.spritesheets.put(file.getAbsolutePath(), texture);
		    	  return texture;
		      }catch(Exception e) {
		     	 System.out.println(e);
		      }
		  }
	
      return null;
}
}
