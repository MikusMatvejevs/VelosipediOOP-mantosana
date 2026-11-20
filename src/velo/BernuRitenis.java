package velo;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class BernuRitenis extends Velosipeds {
	//Atribūti
	private boolean paligriteni, zvanins;
	
	public BernuRitenis(boolean paligriteni, boolean zvanins,int sedeklaPoz, 
			double ritenaD, double cena, String razotajs, String cels) {
		super(sedeklaPoz, ritenaD, cena, razotajs, cels);
		this.paligriteni = paligriteni;
		this.zvanins = zvanins;
	}
	
	public void darbsArPaligRit(boolean darbiba) {
		if(darbiba && !paligriteni) {
			paligriteni = true;
			JOptionPane.showMessageDialog(null, "Palīgriteņi pievienoti!", "Paziņojums",
					JOptionPane.INFORMATION_MESSAGE);
		}else if (!darbiba && paligriteni) {
			paligriteni = false;
			JOptionPane.showMessageDialog(null, "Palīgriteņi noņemti!", "Pazņojums", 
					JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, "Darbība nav iespējama!", "Paziņojums",
					JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public void zvanit () throws MalformedURLException,
	UnsupportedAudioFileException, IOException, LineUnavailableException {
		if(irZvanins()) {
			File f = new File("SFX"+File.separator+"ring.wav");
			AudioInputStream ais = 
					AudioSystem.getAudioInputStream(f.getAbsoluteFile());
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		}else {
			JOptionPane.showMessageDialog(null, "Nav zvaniņš pieejams!", "Kļūda",
					JOptionPane.ERROR_MESSAGE);
		}
	}
		
	public boolean irZvanins() {
		return zvanins;
	}
	
	public boolean irPaligriteni() {
		return paligriteni;
	}
	
	public String apskatitAtributus() {
		return "Velosipēda ražotājs: "+noteiktRazotaju()+
				"\nVelosipēda cena: "+noteiktCenu()+
				"\nRiteņu diametrs collās: "+noteiktRitenaD()+
				"\nSēdekļa pozīcija: "+noteiktSedPoz()+
				"\nKustības ātrums: "+noteiktKustAtr()+" m/s\n"+
				"\nPalīgriteņi "+((irPaligriteni()) ? "Ir" : "Nav")+"\n"+
				"\nZvaniņš "+((irZvanins()) ? "Ir" : "Nav")+"\n";
	}
}
