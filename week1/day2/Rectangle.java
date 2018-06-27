class Rectangle 
{
   
    Integer leftX;
    Integer bottomY;

    Integer width;
    Integer height;

    public Rectangle(Integer leftX, Integer bottomY, Integer width, Integer height) 
    {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width  = width;
        this.height = height;
    }
    public String toString() 
    	{return String.format("(%d, %d, %d, %d)", leftX, bottomY, width, height);}
}