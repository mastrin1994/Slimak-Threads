import java.util.Random;

public class Slimak
{
	private int wiersz, kolumna ;						// okresla wiersz i kolumne w ktorej znajduje sie slimak
	Random generator = new Random();					// obiekt klasy random pozwoli na losowanie liczb
	
	public Slimak(int wiersz, int kolumna)				// konstruktor z polozeniem slimaka
	{
		this.wiersz = wiersz;
		this.kolumna = kolumna;
	}
	
	public int get_wiersz()  { return wiersz;  }		// pobiera wiersz
	public int get_kolumna() { return kolumna; }		// pobiera kolumne
	
	public void Poruszanie ()							// funkcja odpowiadajaca za poruszanie slimaka
	{
		int kierunek = generator.nextInt(4); 			// losuje liczbe int <0;3>
		
		Menu.czy_jest_slimak[wiersz][kolumna] = false;	// ustawia ze pole w ktorym byl slimak jest teraz puste
		do 
		{
			if(kierunek == 0)
			{
				wiersz++;
				if(wiersz >= 10)
					wiersz -= 2;
			}
			else if(kierunek == 1)
			{
				wiersz--;
				if(wiersz <= 0)
					wiersz += 2;
			}
			else if(kierunek == 2)
			{
				kolumna++;
				if(kolumna >= 10)
					kolumna -= 2;
			}
			else if(kierunek == 3)
			{
				kolumna--;
				if(kolumna <= 0)
					kolumna += 2;
			}
		}while(Menu.czy_jest_slimak[wiersz][kolumna] == true && Menu.Trawa[wiersz][kolumna].kolor != 0); // rob poki slamaki sie nie zderzaja
			
		Menu.czy_jest_slimak[wiersz][kolumna] = true;		// ustawia ze pole jest zajete teraz
				
	}
	
	public void Slimak_je_trawe()
	{
		Menu.Trawa[wiersz][kolumna].kolor = Menu.Trawa[wiersz][kolumna].kolor - 100;	// obiekt klasy Trawa utworzony w klasie Menu, zmienia jego kolor na ciemniejszy
		if(Menu.Trawa[wiersz][kolumna].kolor <= 0)		// jesli kolor spadnie ponizej zera to resetuje jego wartosc na zero
			Menu.Trawa[wiersz][kolumna].kolor = 0;
	}
}
