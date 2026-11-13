package velo;

import java.awt.Image;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

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
		bilde = iestatitBildi(cels);
	}
	
	//Metodes
	public double kustibasAtrums() {
		double celsM = rand.nextDouble()*(1000-1)+1;
		double laiksS = rand.nextDouble()*(60-10)+10;
		return Math.round(celsM/laiksS);
	}
	
	public ImageIcon iestatitBildi(String cels) {
		if (!cels.endsWith(".png"))
			cels += ".png";
		
		URL resurss = getClass().getResource("/atteli/"+cels);
		if (resurss != null)
			return new ImageIcon(new ImageIcon(resurss).getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
		else {
			JOptionPane.showMessageDialog(null, "Nevar atrast bildi: "+cels, "Brīdinājums", JOptionPane.WARNING_MESSAGE);
			return null;
		}
	}
	
	public ImageIcon apskatitBildi() {
		return bilde;
	}
	
	public double noteiktRitenaD() {
		return ritenaD;
	}
	
	public int noteiktSedPoz() {
		return sedeklaPoz;
	}
	
	public String noteiktRazotaju() {
		return razotajs;
	}
	
	public double noteiktCenu() {
		return cena;
	}
	
	public double noteiktKustAtr() {
		return atrumsMS;
	} 
	
	public String apskatitAtributus() {
		return "Velosipēda ražotājs: "+noteiktRazotaju()+
				"\nVelosipēda cena: "+noteiktCenu()+
				"\nRiteņu diametrs collās: "+noteiktRitenaD()+
				"\nSēdekļa pozīcija: "+noteiktSedPoz()+
				"\nKustības ātrums: "+noteiktKustAtr()+" m/s\n";
	}
	
	public void reguletSedPoz(int poz) {
		sedeklaPoz = poz;
	}
	
	public void mities(int minienuSk) {
		atrumsMS += 0.15*minienuSk;
	}
	
	public void bremzet(int berze) {
		if(noteiktKustAtr() > 0) 
			atrumsMS -= (noteiktKustAtr()*0.55)*berze;
		
		if(noteiktKustAtr() < 0)
			atrumsMS = 0;
	}
	
}
