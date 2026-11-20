package velo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

public class Ritenbraucejs {

	public static void main(String[] args) throws MalformedURLException,
	UnsupportedAudioFileException, IOException, LineUnavailableException{
		
		String izvelne;
		int izvelesIndekss;
		String [] darbibas = {"Jauns ritenis", "Riteņu saraksts", "Izsaukt metodi",
				"Apturēt"};
		String[] veidi = {"Velosipeds", "Kalnu ritenis", "Bērnu ritenis"};
		String[] atbilde = {"Jā", "Nē"};
		Object[] riteni = new Object[100];
		int ritIndekss = 0;
		
		do {
			izvelne = (String)JOptionPane.showInputDialog(null, 
					"Izvēlies darbību", "Izvēle", JOptionPane.QUESTION_MESSAGE,
					null, darbibas, darbibas[0]);
			
			izvelesIndekss = Arrays.asList(darbibas).indexOf(izvelne);
			
			switch(izvelesIndekss) {
			case 0:
				izvelne = (String)JOptionPane.showInputDialog(null, 
						"Izvēlies riteņa veidu", "Izvēle", JOptionPane.QUESTION_MESSAGE,
						null, veidi, veidi[0]);
				
			if(izvelne == null)
				break;
			
			izvelesIndekss = Arrays.asList(veidi).indexOf(izvelne);
			
			String razotajs = 
					JOptionPane.showInputDialog("Norādi riteņa ražotāju");
			if (razotajs == null)
				break;
			
			double cena = Double.parseDouble(JOptionPane.showInputDialog("Norādi riteņa cenu EUR"));
			if (cena == -1)
				break;
			
			double diametrs = Double.parseDouble(JOptionPane.showInputDialog("Norādi riteņa diametru"));
			if (diametrs == -1)
				break;
			
			int sedeklaPoz = Integer.parseInt(JOptionPane.showInputDialog("Norādi sēdekļa pozīciju"));
			if (sedeklaPoz == -1)
				break;
			
			String cels, mape;
			// Parastajam ritenim
			if(izvelesIndekss == 0) {
				mape = "imgVelo";
				cels = Metodes.izveletiesBildi(mape);
				if(cels == null)
					break;
				riteni[ritIndekss] = new Velosipeds(sedeklaPoz, diametrs, cena, razotajs, cels);
				JOptionPane.showMessageDialog(null, "Pievienots parastais ritenis!", "Pievienots",
						JOptionPane.INFORMATION_MESSAGE);
				
				
			}else if (izvelesIndekss == 1) {
				mape = "imgKalnu";
				cels = Metodes.izveletiesBildi(mape);
				if(cels == null)
					break;
				
				int iestatitaisAtrums = Integer.parseInt(
						JOptionPane.showInputDialog("Norādi iestatīto ātrumu"));
				
				izvelne = (String) JOptionPane.showInputDialog(null, 
						"Vai ritenim ir papildus atsperes?", "Jautājums",
						JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
				
				izvelesIndekss = Arrays.asList(atbilde).indexOf(izvelne);
				boolean atsperes = (izvelesIndekss == 0) ? true : false;
				
				riteni[ritIndekss] = new KalnuRitenis(iestatitaisAtrums, atsperes, sedeklaPoz, 
						 diametrs, cena, razotajs, cels);
				ritIndekss++;
				JOptionPane.showMessageDialog(null, "Pievienots kalnu ritenis!",
						"Pievienots", JOptionPane.INFORMATION_MESSAGE);
			}
			
			else if (izvelesIndekss == 2) {
				mape = "bernuRImg";
				cels = Metodes.izveletiesBildi(mape);
				if(cels == null)
					break;
				
				izvelne = (String) JOptionPane.showInputDialog(null, 
						"Vai ritenim ir palīgriteņi?", "Jautājums",
						JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
				
				izvelesIndekss = Arrays.asList(atbilde).indexOf(izvelne);
				boolean paligR = (izvelesIndekss == 0) ? true : false;

				izvelne = (String) JOptionPane.showInputDialog(null, 
						"Vai ritenim ir zvaniņš?", "Jautājums",
						JOptionPane.QUESTION_MESSAGE, null, atbilde, atbilde[0]);
				
				izvelesIndekss = Arrays.asList(atbilde).indexOf(izvelne);
				boolean zvanins = (izvelesIndekss == 0) ? true : false;
				
				riteni[ritIndekss] = new BernuRitenis(paligR, zvanins, sedeklaPoz, 
						 diametrs, cena, razotajs, cels);
				ritIndekss++;
				JOptionPane.showMessageDialog(null, "Pievienots bērnu ritenis!",
						"Pievienots", JOptionPane.INFORMATION_MESSAGE);
			}
			break; 
			
			case 1:
				if(riteni.length>0) {
					for(int i=0; i<riteni.length; i++) {
						if(riteni[i] instanceof Velosipeds)
						JOptionPane.showMessageDialog(null, 
								((Velosipeds)riteni[i]).apskatitAtributus(), "Paziņojums",
								JOptionPane.INFORMATION_MESSAGE,
								((Velosipeds) riteni[i]).apskatitBildi());
						
						else if (riteni[i] instanceof KalnuRitenis)
								JOptionPane.showMessageDialog(null, 
								((Velosipeds)riteni[i]).apskatitAtributus(), "Paziņojums",
								JOptionPane.INFORMATION_MESSAGE,
								((KalnuRitenis)riteni[i]).apskatitBildi());
						
						else if (riteni[i] instanceof BernuRitenis)
							JOptionPane.showMessageDialog(null, 
							((Velosipeds)riteni[i]).apskatitAtributus(), "Paziņojums",
							JOptionPane.INFORMATION_MESSAGE,
							((BernuRitenis)riteni[i]).apskatitBildi());
						else
							break;
					}
				}
				break;
			}
		}while(izvelesIndekss != 3);
	
	}
		
}
