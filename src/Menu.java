import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.util.Random;

public class Menu extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	/// Deklaracja zmiennych
	public static Slimak[]  Slimaki 			= new Slimak[10];			// tablica slimakow
	public static Trawa[][] Trawa				= new Trawa[10][10];		// po prostu trawa
    static boolean[][]    	czy_jest_slimak 	= new boolean[10][10];		// okresla czy w danym polu macierzy znajduje sie juz slimak
	static int[][]  	  	Kolor_lisci			= new int[10][10];			// kolor lisci
    static Rysowanie 	  	Symulacja;										// obiekt klasy rysowanie, odpowiedzialnej za grafike
    public static boolean 	uruchomiony 		= false;					// Symulacja wlaczona lub nie
	
    JButton B_Start, B_Pauza; // Deklaracja przycisków
///------------------------------------------------------------------------
/// Konstruktor
	public Menu()
	{	
		setSize(620,720);						// rozmiar okna (szerokosc, wysokosc)
		setTitle("Wyznikiewicz Michal - Symulator 'Slimaki' ");
		setLayout(null);						// układ okna bez zadnych dodatkow - setLayout() wywołuje LayoutManagera - zarzadce układow
		
		// Rozpoczecie symulacji
		B_Start = new JButton("Start");			// utworzenie przycisku
		B_Start.setBounds(80, 610, 200, 50);	// (od lewej, od gory, szerokosc, wysokosc)
		add(B_Start);							// dodanie elementu do okna (funkcja z klasy JFrame)
		B_Start.addActionListener(this);		// obsluga zdarzenia z klasy ActionListener
		
		// Pauza w symulacji			
		B_Pauza = new JButton("Pauza");			// utworzenie przycisku
		B_Pauza.setBounds(320, 610, 200, 50);	// (od lewej, od gory, szerokosc, wysokosc)
		add(B_Pauza);							// dodanie elementu do okna (funkcja z klasy JFrame)
		B_Pauza.addActionListener(this);		// obsluga zdarzenia z klasy ActionListener
		
		Symulacja = new Rysowanie();
		Symulacja.setBounds(0, 0, 600, 600);
		add(Symulacja);		
	}
///------------------------------------------------------------------------
/// Pozostale funkcje klasy Menu	
	public boolean WlaczSymulacje()  	{ return uruchomiony = true; }		// ustawia uruchomiony na true
	public boolean Wylacz()			 	{ return uruchomiony = false; }		// false
	public static boolean CzyWlaczony() { return uruchomiony; }				// get statusu czy jest wlaczona symulacja
	
	public void actionPerformed(ActionEvent e) 			// metoda "sluchacz" z klasy ActionListener, obsluguje zdarzenia zwiazanie z przyciskami itd.
	{
		Object akcja = e.getSource();					// Obiekt, na którym początkowo wystąpiło zdarzenie.
		if(akcja == B_Start) 							// Wcisniecie przycisku Start wlacza symulacje
			WlaczSymulacje();
		else if (akcja == B_Pauza)	 					// przycisk Pauza wylacza symulacje
			Wylacz();
	}

	///------------------------------------------------------------------------
/// MAIN
	public static void main(String[] args) throws InterruptedException 
	{
		// sworzenie okna dla symulacji
			Menu menu = new Menu();										// nowy obiekt klasy Menu, konstruktor utworzy okno
			menu.setVisible(true);										// ustawia widocznosc okna na true
			menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		// ustawia by domyslnie zamkniecie apki odbywalo sie poprzez zamkniecie okna X
        //-------------------------------------------------
		Random random = new Random();									// nowy obiekt klasy Random (pozwala na losowanie liczb)
		
		// Rozmieszczanie trawy na polach macierzy
        for(int i = 0; i < 10; i++) {									
            for(int j = 0; j < 10; j++) {
                Kolor_lisci[i][j] = random.nextInt(255);				// Poczatkowy stan lisci w macierzy jest losowy
                Trawa[i][j] = new Trawa(Kolor_lisci[i][j]);
                czy_jest_slimak[i][j] = false;							// Domyslnie na zadnym polu nie ma slimaka przy wypelnianiu macierzy
            }
        }
        //-------------------------------------------------
        
        //rozmieszczenie slimakow na planszy
        for(int i = 0; i < 6; i++)
        {
            int wiersz = random.nextInt(10);				// losuje wiersz
            int kolumna = random.nextInt(10);				// losuje kolumne
            
            while(czy_jest_slimak[wiersz][kolumna])			// jesli na danym polu znajduje sie juz slimak losujemy inne miejsce
            {
                wiersz = random.nextInt(10);				// losuje wiersz
                kolumna = random.nextInt(10);				// losuje kolumne
            }
            
            czy_jest_slimak[wiersz][kolumna] = true;		// zaznaczamy obecnosc slimaka
            Slimaki[i] = new Slimak(wiersz, kolumna);		// dodanie slimaka do macierzy
        }
        //-------------------------------------------------
        
		do
		{
			// Uruchamianie watkow
			Watek_jedzenia Jedzenie = new Watek_jedzenia();
			Watek_odrastania Odrastanie = new Watek_odrastania();
			Jedzenie.start();			// uruchamianie jedzenia trawy
			Odrastanie.start();			// uruchamianie odrastania trawy
			//-------------------------------------------------------
			
			try
			{
				for (int i = 5; i > 0; i--) 
					Thread.sleep(100);
			} 
			catch (InterruptedException e)
			{
				
			}
					//System.out.println(" Glowny watek: KONIEC");
			
			// metody ponizej sluza do zatrzytmania symulacji
			while(true)
			{
				if(CzyWlaczony() == true)
				{
					Thread.sleep(500);
					break;
				}
				
				Thread.sleep(500);
				System.out.println(" Czekam");
			}
			
			if (CzyWlaczony() == false)
			{
				while(true)
				{
					if(CzyWlaczony() == true)
					{
						Thread.sleep(500);
						break;
					}
					
					Thread.sleep(500);
					System.out.println(" Czekam");
				}
			}
			//----------------------------------------------------
		}while(true);	
	}
}
