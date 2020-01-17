package uf1;

import java.io.*;
import java.util.*;

public class ConsultarFitxerAleatori {
	public static void main(String[] args) throws IOException {
		File fitxer = new File("persones.txt");
		//Crea un flux (stream) d'arxiu d'accés aleatori només lectura
		RandomAccessFile aleatoriFile = new RandomAccessFile(fitxer, "r");

		String text;
		int apuntador, id, seleccio, opcio;
		char nom[] = new char[20], cognom[] = new char[30], edat[] = new char[3], alçada[] = new char[4], pes[] = new char[4], aux;
		//Demana a l'usuari que seleccioni la persona pel seu identificador
		System.out.println("Per quin camp vols cercar: 1.Id 2.Resta de camps");

		Scanner stdin = new Scanner (System.in);

		opcio = stdin.nextInt();

		if (opcio == 1) {

			System.out.println("Introdueix un id");
			seleccio = stdin.nextInt();
			apuntador = (seleccio-1)*126;

			if (apuntador >= aleatoriFile.length()) {
				System.out.println("ERROR: ID incorrecte, no existeix aquest llibre");
			} else {//Apuntar a l'inici de la persona seleccionada al fitxer
				aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada persona al fitxer
				//Llegeix ID
				id = aleatoriFile.readInt();
				//Llegeix Nom
				for(int i = 0; i<nom.length; i++) {
					aux = aleatoriFile.readChar();
					nom[i] = aux;
				}
				String noms = new String(nom);
				//Llegeix Cognom
				for(int i = 0; i<cognom.length; i++) {
					aux = aleatoriFile.readChar();
					cognom[i] = aux;
				}
				String cognoms = new String(cognom);
				//Llegeix Edat
				for(int i = 0; i<edat.length; i++) {
					aux = aleatoriFile.readChar();
					edat[i] = aux;
				}
				String edats = new String(edat);
				//Llegeix Alçada
				for(int i = 0; i<alçada.length; i++) {
					aux = aleatoriFile.readChar();
					alçada[i] = aux;
				}
				String alçades = new String(alçada);
				//Llegeix Pes
				for(int i = 0; i<pes.length; i++) {
					aux = aleatoriFile.readChar();
					pes[i] = aux;
				}
				String pesos = new String(pes);
				//Sortida de les dades de cada persona
				System.out.println("ID: "+id+"\nNom: "+noms+"\nCognoms: "+cognoms+"\nEdat: "+edats+"\nAlçada: "+alçades+"\nPes: "+pesos+"\n\n");
			}
		} else if (opcio == 2) {
			System.out.println("Introdueix un text per fer la cerca");
			stdin.nextLine();
			text = stdin.nextLine();
			apuntador = 0;

			//Recorrer el fitxer llibres
			for (;;) {
				aleatoriFile.seek(apuntador);//Apuntar a l'inici de cada llibre al fitxer
				//Llegeix ID
				id = aleatoriFile.readInt();
				//Llegeix Nom
				for(int i = 0; i<nom.length; i++) {
					aux = aleatoriFile.readChar();
					nom[i] = aux;
				}
				String noms = new String(nom);
				//Llegeix Cognom
				for(int i = 0; i<cognom.length; i++) {
					aux = aleatoriFile.readChar();
					cognom[i] = aux;
				}
				String cognoms = new String(cognom);
				//Llegeix Edat
				for(int i = 0; i<edat.length; i++) {
					aux = aleatoriFile.readChar();
					edat[i] = aux;
				}
				String edats = new String(edat);
				//Llegeix Alçada
				for(int i = 0; i<alçada.length; i++) {
					aux = aleatoriFile.readChar();
					alçada[i] = aux;
				}
				String alçades = new String(alçada);
				//Llegeix Pes
				for(int i = 0; i<pes.length; i++) {
					aux = aleatoriFile.readChar();
					pes[i] = aux;
				}
				String pesos = new String(pes);
				//Sortida de les dades de cada persona si algun camp coincideix amb el text introduït
				if (text.equals(noms.trim()) || text.equals(cognoms.trim()) || text.equals(edats.trim()) || text.equals(alçades.trim()) || text.equals(pesos.trim())) {
					System.out.println("ID: "+id+"\nNom: "+noms+"\nCognoms: "+cognoms+"\nEdat: "+edats+"\nAlçada: "+alçades+"\nPes: "+pesos+"\n\n");
				}
				//S'ha de posicionar l'apuntador a la següent persona.
				apuntador += 126;
				//Si coincideix on s'està apuntat amb el final del fitxer, sortim
				if(aleatoriFile.getFilePointer()==aleatoriFile.length()) break;
			}
			aleatoriFile.close();//Tancar el fitxer
		}
	}
}

