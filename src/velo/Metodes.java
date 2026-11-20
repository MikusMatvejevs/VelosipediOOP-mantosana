package velo;

import java.io.File;
import javax.swing.JOptionPane;

public class Metodes {
	static String izveletiesBildi(String mape) {
	    File bilzuMape = new File(mape);
	    File[] failuSaraksts = bilzuMape.listFiles();

	    if (failuSaraksts == null || failuSaraksts.length == 0) {
	        JOptionPane.showMessageDialog(null, "Mapē nav bilžu!");
	        return null;
	    }

	    Object izvele = JOptionPane.showInputDialog(
	        null,
	        "Izvēlēties bildi:",
	        "Izvēle",
	        JOptionPane.INFORMATION_MESSAGE,
	        null,
	        failuSaraksts,
	        failuSaraksts[0]
	    );

	    if (izvele == null) {
	        return null;
	    }

	    return mape + File.separator + ((File) izvele).getName();
	}
}
