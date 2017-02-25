import java.awt.Color;
import java.awt.Graphics;		// The Graphics class allow an application to draw onto components that are realized on various devices[...]
import javax.swing.JPanel;		

/**
 * Klasa rysuje elementy symulacji
 */

public class Rysowanie extends JPanel
{
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g)		// metoda odpowiedzialna za rysowanie
    {
        super.paintComponent(g);				// super - Sluzy do wywolywania konstruktorww klasy z ktorej dziedziczymy o podanych parametrach (Graphics g)
        
        /** Jeśli uzyjemy slowa "synchronized" blokada obiektu chroni cala metode i aby ja wywolac, watek musi zalozyc wewnetrzna blokade obiektu */
        synchronized(Menu.Kolor_lisci)			// skladnia bloku synchronizowanego
        {
        	// Trawa
            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    g.setColor(new Color(0, Menu.Trawa[i][j].get_kolor(), 0));		// ustawia kolor trawy
                    g.fillRect(i*60, j*60, 60, 60);		// doslownie oznacza rozmiar macierzy i poszczegolnych pol do pomalowania
                    /**
                    fillRect(x, y, width, height) Parameters: 
                    	x - the x coordinate of the rectangle to be filled.
                    	y - the y coordinate of the rectangle to be filled.
                    	width - the width of the rectangle to be filled.
                    	height - the height of the rectangle to be filled.
                	*/
                }
            }
            //--------
            
            // Slimaki
            g.setColor(new Color(250,000,100));		// ustawia kolor slimaka, w nawiasie mamy 3 parametry RGB
            for(int j = 0; j < 5; j++)
            	g.fillOval(3 + 60 * Menu.Slimaki[j].get_wiersz(), 3 + 60 * Menu.Slimaki[j].get_kolumna(), 53, 53);		// maluje kolo na podanych wspolrzednych
            //--------         
        }
        // Koniec bloku synchronizowanego ------------------------------------------------------------------
    }

}
