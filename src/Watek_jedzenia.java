import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Watek_jedzenia extends Thread			// rozszerzenie klasy watku pozwala na uzycie m.in metody run()
{
	private Lock blokadaJedzenia = new ReentrantLock();		// Klasa ReentrantLock implementuje interfejs Lock
	/**
	 * Kiedy jeden watek zablokuje obiekt blokady, zaden inny watek nie bedzie mogł przejsc przez instrukcje lock. 
	 * Jesli jakis inny watek wywola metode lock, zostanie dezaktywowany do czasu az poprzedni watek odblokuje obiekt blokady (Java podstawy wyd. X)
	 */
	public synchronized void run()
	{
		System.out.println("Watek : Zjadanie");
		blokadaJedzenia.lock();
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
            finally { blokadaJedzenia.unlock(); }
	}
}


