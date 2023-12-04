package fr.eni.demonstration;

import java.util.Scanner;

public class bulletin {

	public static void main(String[] args) {

		/*Variables*/		
	String nomSala = null;
	String prenom = null;
	int statut = 0;
	int nbEnfant = 0 ;
	double nbHeure = 0;
	double nbHS = 0;
	double nbHD = 0;
	double txHoraire = 0; 
	double salaireBrut = 0;
	double salaireNet = 0;
	double cotisationsSociales ;
	double primeEnf = 0 ;
	
	
		Scanner sc = new Scanner(System.in);
		
/*demande des informations du salarié*/			
	while(nomSala == null) {	
		System.out.println("Nom de la personne:");
		nomSala = sc.nextLine();
	}
	while(prenom == null) {
		System.out.println("Prénom de la personne : ");
		prenom = sc.nextLine();
	}
	while(statut == 0) {
		System.out.println("Statut : 1- Agent ; 2- Employé ; 3- Cadre") ;
		statut = sc.nextInt();	}
	
		System.out.println("Nombre d'enfants :") ;
		nbEnfant = sc.nextInt();
		
	while(txHoraire<=0) {		
		System.out.println("Taux horaire :") ;
		txHoraire = sc.nextDouble();}
	
	while(nbHeure<=0) {
		System.out.println("Nombre d'heures travaillées :") ;
		nbHeure = sc.nextInt();}

	
	/*calcul du salaire brut  */
		if (nbHeure <= 169) {
			salaireBrut = txHoraire * nbHeure;
		}
		else if (nbHeure <= 180) {
			nbHS = nbHeure-169 ;
			salaireBrut = txHoraire * 169 + nbHS*1.5*txHoraire;				
					}
		else {
			nbHS = 180-169;
			nbHD = nbHeure-180 ;
			salaireBrut = txHoraire * 169 + nbHS*1.5*txHoraire + nbHD*1.6*txHoraire;
				}
	
/*calcul du salaire net*/
		
	/*	salaireNet = SalaireBrut - Charges + prime*/
		cotisationsSociales = salaireBrut * (0.0349+0.0615+0.0095+0.0844+0.0305+0.0381+0.0102) ;
						
		if (nbEnfant == 0) {
			primeEnf = 0;
		}
		else if (nbEnfant == 1) {
			primeEnf  = 20;
		}
		else if (nbEnfant == 2) {
			primeEnf  = 50;
		}
		else {
			primeEnf = 70 + 20 * (nbEnfant-2);
		}
			
		salaireNet = salaireBrut - cotisationsSociales + primeEnf ;
		
		
		System.out.println("---------------------------------------------------");
		System.out.println("---------------BULLETIN DE SALAIRE-----------------");
		System.out.println("---------------------------------------------------");
		System.out.println( "Nom du salarié : ");
		System.out.println( nomSala +" "+ prenom);
		/* affichage du statut*/
		if (statut == 1) {
			System.out.println("Statut : Agent");
		}
		else if (statut == 2) {
			System.out.println("Statut : Employé");
		}
		else {
			System.out.println("Statut : Cadre");
		}
		System.out.println("---------------------------------------------------");
		System.out.println("Nombre d'heures travaillées :               "+ nbHeure +"h");
		System.out.println("Taux horaire :                              "+ String.format("%.2f",txHoraire) +"€");
		System.out.println("Nombre d'enfants :                          "+ nbEnfant);
		System.out.println("---------------------------------------------------");
		System.out.println("Salaire brut :                              "+ String.format("%.2f",salaireBrut) + "€"); 
		System.out.println("---------------------------------------------------");
		System.out.println("Nombre d'heures majorées à 50 % : " + nbHS + " h soit "+String.format("%.2f",nbHS*1.5*txHoraire)+" €"); 
		System.out.println("Nombre d'heures majorées à 60 % : " + nbHD + " h soit "+String.format("%.2f",nbHD*1.6*txHoraire)+" €"); 
		System.out.println("---------------------------------------------------");	
		System.out.println("COTISATIONS SALARIALE"); 
		System.out.println("Contribution Remboursement Dette   (3.49 %) "+  String.format("%.2f", salaireBrut*0.0349) + " €"); 
		System.out.println("Contribution Sociale Généralisée   (6.15 %) "+  String.format("%.2f",salaireBrut*0.0615) + " €"); 
		System.out.println("Assurance Maladie                  (0.95 %) "+  String.format("%.2f",salaireBrut*0.0095) + " €"); 
		System.out.println("Assurance Vieillesse               (8.44 %) "+  String.format("%.2f",salaireBrut*0.0844) + " €"); 
		System.out.println("Assurance Chomage                  (3.05 %) "+  String.format("%.2f",salaireBrut*0.0305) + " €"); 
		System.out.println("IRCEM                              (3.81 %) "+  String.format("%.2f",salaireBrut*0.0381) + " €");
		System.out.println("Cotisation AGFF                    (1.02 %) "+  String.format("%.2f",salaireBrut*0.0102) + " €");
		System.out.println("TOTAL DES COTISATIONS SALARIALES            "+  String.format("%.2f",cotisationsSociales) + " €"); 
		System.out.println("---------------------------------------------------");	
		System.out.println("Prime :                                     "+ String.format("%.2f",primeEnf) +" €"); 
		System.out.println("---------------------------------------------------");	
		System.out.println("Salaire net à payer :                       "+ String.format("%.2f",salaireNet)  + "€"); 
		System.out.println("---------------------------------------------------");	
		
	
	
	}
}



