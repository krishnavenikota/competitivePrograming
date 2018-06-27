import java.lang.Math;

public class Intersector
{      
    public static void main(String[] args) 
    {
        Rectangle X = new Rectangle(1 ,1 , 6, 6);
        Rectangle Y = new Rectangle(3, 3, 2, 2); 
        System.out.println(getIntersection(X, Y));
    }
	
	static Rectangle getIntersection(Rectangle A, Rectangle B) 
    {
        Integer rXA = A.leftX + A.width; 
        Integer rXB = B.leftX + B.width; 
        Integer tYA = A.bottomY + A.height; 
        Integer tYB = B.bottomY + B.height; 
        Integer lX = Math.max(A.leftX, B.leftX); 
        Integer bY = Math.max(A.bottomY, B.bottomY);
        Integer w = Math.min(rXA, rXB) - lX; 
        Integer h = Math.min(tYA, tYB) - bY;
        
        if (w<0 || h<0) return new Rectangle(-1, -1, -1, -1); 
        else return new Rectangle(lX, bY, w, h);
    }
}