public class Trawa
{
	public int kolor;
	
	public Trawa(int kolor) { this.kolor = kolor; }
	public int get_kolor()  { return kolor; 	  }
	public int trawa_rosnie()
	{
		kolor += 10;
		if (kolor > 255)
			kolor = 255;
		return kolor;	
	}
}
