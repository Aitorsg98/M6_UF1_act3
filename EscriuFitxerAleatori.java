package uf1;

import java.io.*;

public class EscriuFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori per llegir
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "rw");
		//Les dades per inserir
		String nom[] = {"Nom1", "Nom2", "Nom3", "Nom4", "Nom5"};
		String cognoms[] = {"Cognom1.1 Cognom1.2", "Cognom2.1 Cognom2.2", "Cognom3.1 Cognom3.2", "Cognom4.1 Cognom4.2", "Cognom5.1 Cognom5.2"};
		String edat[] = {"20", "21", "22", "23", "24"};
		String alçada[] = {"1.68", "1.69", "1.70", "1.71", "1.72"};
		String pes[] = {"70", "71", "72", "73", "74"};
		//Construeix un buffer (memòria intermèdia) de strings
		StringBuffer buffer = null;
		
		for (int i=0; i<nom.length; i++) {
			aleatoriFile.writeInt(i+1);//1 enter ocupa 4 bytes
			//20 caràcters a 2bytes/caràcter 40 bytes
			buffer = new StringBuffer (nom[i]);
			buffer.setLength(20);
			aleatoriFile.writeChars(buffer.toString());
			//30 caràcters a 2bytes/caràcter 60 bytes
			buffer = new StringBuffer (cognoms[i]);
			buffer.setLength(30);
			aleatoriFile.writeChars(buffer.toString());
			//3 caràcters a 2bytes/caràcter 6 bytes
			buffer = new StringBuffer (edat[i]);
			buffer.setLength(3);
			aleatoriFile.writeChars(buffer.toString());
			//4 caràcters a 2bytes/caràcter 8 bytes
			buffer = new StringBuffer (alçada[i]);
			buffer.setLength(4);
			aleatoriFile.writeChars(buffer.toString());
			//4 caràcters a 2bytes/caràcter 8 bytes
			buffer = new StringBuffer (pes[i]);
			buffer.setLength(4);
			aleatoriFile.writeChars(buffer.toString());
			//Total 126 bytes
		}
		aleatoriFile.close();
	}
}
