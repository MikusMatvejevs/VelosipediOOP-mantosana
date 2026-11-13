package velo;

import java.util.Random;
import javax.swing.ImageIcon;

public class Velosipeds {
	//Atribūti
	private int sedeklaPoz;
	private double ritenaD, atrumsMS, cena;
	private String razotajs;
	ImageIcon bilde;
	Random rand = new Random();
	
	//Konstruktors
	public Velosipeds(int sedeklaPoz, double ritenaD, double cena, String razotajs, String cels) {
		this.sedeklaPoz = sedeklaPoz;
		this.ritenaD = ritenaD;
		atrumsMS = kustibasAtrums();
		this.cena = cena;
		this.razotajs = razotajs;
		iestatitBildi(cels);
	}
}
