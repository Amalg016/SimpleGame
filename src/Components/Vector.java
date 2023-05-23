package Components;

public class Vector {
public int x,y, width , height;

public Vector(int x,int y,int width,int height) {
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
}


public boolean intersects(Vector t) {
	 return !(this.x + this.width < t.x || y + height < t.y || x > t.x + t.width || y > t.y + t.height);

}

}
