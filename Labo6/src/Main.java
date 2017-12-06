/*
 -----------------------------------------------------------------------------------
 Laboratoire : 06
 Fichier     : Etudiant.java
 Auteur(s)   : Loic Frueh et Yann Lederrey
 Date        : 28.11.2017

 But         : Tester les méthodes des class Groupe et Etudiant

 Remarque(s) : Certaine fonctions n'on pas besoin d'etre testées à plusieurs reprises
               car elle sont réutilisées par d'autre fonctions.

 Compilateur : jdk 1.8.0_144-b01
 -----------------------------------------------------------------------------------
 */

public class Main {
   public static void main (String[] args) {

      System.out.println("PROGRAMME DE TEST");
      System.out.println("-------------------------------------\n");

      System.out.println("Test constructeur etudiant sans groupe : \n");

      Etudiant e1 = new Etudiant("Markus");
      System.out.println("Etudiant Markus créé : " + e1);
      System.out.println("Son groupe est : " + e1.getGroupe()+ "\n");

      System.out.println("**************************************\n");

      System.out.println("Test constructeur groupe sans Etudiant : \n");

      Groupe g1 = new Groupe(1);
      System.out.println("Groupe créé avec un ID de 1 : " + g1 + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test constructeur etudiant avec groupe : \n");

      Etudiant e2 = new Etudiant("max",g1);
      System.out.println("Etudiant Max créé avec un groupe d' ID de 1 : " + e2 );

      System.out.println("Groupe de l'étudiant : " + e2.getGroupe());
      System.out.println("Nom de l'etudiant : "+ e2.getNom());
      System.out.println("Etudiants de son groupe : " + g1.getEtudiants());
      System.out.println("Numero de son groupe : " + g1.getNo()+ "\n");

      System.out.println("**************************************\n");

      System.out.println("Test creation de plusieurs etudiants avec le meme groupe : \n");

      Etudiant e3 = new Etudiant("Ginette",g1);
      Etudiant e4 = new Etudiant("Myriam",g1);
      Etudiant e5 = new Etudiant("Josie",g1);

      System.out.println("Etat du groupe d'id 1 apres la création d'etudiants : " + g1 + "\n");

      System.out.println("**************************************\n");

      System.out.println("Creation d'un groupe d'id 2 avec Ginette, Myriam, Josie : \n");

      Groupe g2 = new Groupe(2,e3,e4,e5);

      System.out.println("Etat du groupe : " + g2);

      System.out.println("Etat de leur ancien groupe : " + g1 + "\n");


      System.out.println("**************************************\n");

      System.out.println("Test de la fonction setGroup : \n");

      Etudiant e6 = new Etudiant("Patricia",g1);
      System.out.println("Ajout de l'etudiante Particia dns le groupe 1 : " + e6);
      e6.setGroupe(g2);
      System.out.println("setGroup de patricia vers le groupe d'id 2");
      System.out.println("Etat de son ancien groupe : " + g1);
      System.out.println("Etat de son nouveau groupe : "+ g2 + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test de la fonction viderGroupe\n");

      System.out.println("Etat du groupe d'id 2 " + g2);
      Etudiant etuTest = g2.getEtudiants().getFirst();
      System.out.println("on fait un viderGroupe:");
      g2.viderGroupe();
      System.out.println("Etat du groupe après viderGroupe : " + g2);
      System.out.println("Etat de Ginette : " + etuTest + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test de la fonction tranfererTous\n");
      Groupe g3 = new Groupe(3);
      Etudiant e7 = new Etudiant("Aline");
      Etudiant e8 = new Etudiant("Robert");
      Groupe g4 = new Groupe(4,e7,e8);
      System.out.println("Creation d'un groupe d'id 4 avec 2 etudiants : " + g4);
      System.out.println("Transfert de tous les etudiants du groupe 4 vers un nouveau groupe");
      g4.transfererTous(g3);
      System.out.println("Etat de leur ancien groupe : " + g4);
      System.out.println("Etat de leur nouveau groupe : " + g3 + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test de la fonction tranfererEtudiant\n");
      System.out.println("tranfert de Aline et Robert vers le groupe 4");
      g3.transfererEtudiants(g4,e7,e8);
      System.out.println("Etat de leur ancien groupe : " + g3);
      System.out.println("Etat de leur nouveau groupe : " + g4 + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test de tranfererTous a partir d'un groupe NULL\n");
      Groupe.transfererTous(null,g3);
      System.out.println("Etat du groupe 3 après transfert d'un groupe null : " + g3 + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test de tranfererTous vers le groupe 4 à partir du groupe 4 : \n");
      Groupe.transfererTous(g4,g4);
      System.out.println("Etat du groupe 4 : " + g4 + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test de tranfererTous du groupe 4 vers un groupe Null (set leur groupe a null)\n");

      Etudiant tempEtudiant = g4.getEtudiants().getFirst();
      Groupe.transfererTous(g4,null);
      System.out.println("Etat du groupe 4 : " + g4);
      System.out.println("Etat de Aline après le transfert : " + tempEtudiant + "\n");

      System.out.println("**************************************\n");

      System.out.println("Test de suppression de l'etudiant Robert : \n");
      System.out.println("Ajout de Robert dans le groupe 1 puis suppression de Robert");
      g1.ajouterEtudiants(e8);
      System.out.println("Etat du groupe avant la suppression : " + g1);
      g1.supprimerEtudiants(e8);
      System.out.println("Etat du groupe après la suppression : " + g1);
      System.out.println("Etat de Robert : " + e8);

   }
}
