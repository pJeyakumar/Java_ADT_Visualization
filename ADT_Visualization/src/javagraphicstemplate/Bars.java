package javagraphicstemplate;

public class Bars 
{
	// Variable Declaration
	int intX;
	int intY;
	public int intLength;
	int intWidth;
	// Constructor
	Bars(int intX, int intY, int intLength, int intWidth)
	{
		this.intX = intX;
		this.intY = intY;
		this.intLength = intLength;
		this.intWidth = intWidth;
	}
	// return length value
	public int getLength() 
	{
		return this.intLength;
	}
	// return x value
	public int getX() 
	{
		return this.intX;
	}
	// return y value
	public int getY() 
	{
		return this.intY;
	}
	// set this length to specified length
	public void setLength(int intLength) 
	{
		this.intLength = intLength;
	}
	// return width value
	public int getWidth() 
	{
		return this.intWidth;
	}
}
