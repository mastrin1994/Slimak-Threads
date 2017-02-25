public class Watek_jedzenia extends Thread			// rozszerzenie klasy watku pozwala na uzycie m.in metody run()
{
	public synchronized void run()
	{
		System.out.println("Watek : Zjadanie");
            try
            {
            	Menu.Slimaki[0].Poruszanie();
            	Menu.Slimaki[0].Slimak_je_trawe();
            	Menu.Slimaki[1].Poruszanie();
            	Menu.Slimaki[1].Slimak_je_trawe();
            	Menu.Slimaki[2].Poruszanie();
            	Menu.Slimaki[2].Slimak_je_trawe();
            	Menu.Slimaki[3].Poruszanie();
            	Menu.Slimaki[3].Slimak_je_trawe();
            	Menu.Slimaki[4].Poruszanie();
            	Menu.Slimaki[4].Slimak_je_trawe();
            	Menu.Symulacja.repaint();				// maluje na nowo obiekt Symulacja klasy Rysowanie
            	Thread.sleep(50);
            }
            catch(InterruptedException e) 
            { 
            	
            }            
	}
}


