package velo;

public class BernuRitenis extends Velosipeds {
	//Atribūti
	private boolean paligriteni, zvanins;
	
	public BernuRitenis(boolean paligriteni, boolean zvanins,int sedeklaPoz, 
			double ritenaD, double cena, String razotajs, String cels) {
		super(sedeklaPoz, ritenaD, cena, razotajs, cels);
		this.paligriteni = paligriteni;
		this.zvanins = zvanins;
	}

}
