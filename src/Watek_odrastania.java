public class Watek_odrastania extends Thread
{
	public synchronized void run()
	{
		System.out.println(" Watek : Odrastanie");
		try
		{
			for (int i = 0; i <10; i++) 
			{
				for (int j = 0; j<10; j++)
				{
					if(Menu.czy_jest_slimak[i][j] == false)
					{
						Menu.Trawa[i][j].trawa_rosnie();		// dodaje koloru
						Menu.Trawa[9-i][9-j].trawa_rosnie();	
			            Menu.Symulacja.repaint();				//odswiezenie rysunku
					}
				}
				Thread.sleep(5000);
			}
		} catch (InterruptedException e) 
		{
		}
		System.out.println(" Odrastanie : KONIEC");
	}
}
