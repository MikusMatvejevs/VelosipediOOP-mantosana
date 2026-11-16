package velo;

public class KalnuRitenis extends Velosipeds {
	//Atribūti
	private int iestatitaisAtrums;
	private boolean atsperes;
	
	public KalnuRitenis(int iestatitaisAtrums, boolean atsperes, int sedeklaPoz, 
			double ritenaD, double cena, String razotajs, String cels) {
		super(sedeklaPoz, ritenaD, cena, razotajs, cels);
		this.iestatitaisAtrums = iestatitaisAtrums;
		this.atsperes = atsperes;
	}
	
	//Metodes
	public int noteiktAtrumu() {
		return iestatitaisAtrums;
	}
	
	public void parslegtAtrumu(int atr) {
		iestatitaisAtrums = atr;
	}
	
	public String apskatitAtributus() {
		return "Velosipēda ražotājs: "+noteiktRazotaju()+
				"\nVelosipēda cena: "+noteiktCenu()+
				"\nRiteņu diametrs collās: "+noteiktRitenaD()+
				"\nSēdekļa pozīcija: "+noteiktSedPoz()+
				"\nKustības ātrums: "+noteiktKustAtr()+" m/s\n"+
				"\nIestatītais atrums: "+noteiktAtrumu()+
				"\nPapildus amortizācija: "+((atsperes) ? "Ir" : "Nav")+"\n";
				
	}

}
