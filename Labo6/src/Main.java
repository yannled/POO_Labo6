public class Main {
   public static void main (String[] args) {

      // TEST D'AJOUT ETUDIANT AVEC GROUPE NULL
      System.out.println("TEST AJOUT ETUDIANT AVEC GROUPE NULL");

      Etudiant e1 = new Etudiant("licorne");
      System.out.println(e1);
      System.out.println("Son groupe est : " + e1.getGroupe());

      System.out.println();

      // TEST GROUPE ETUDIANT

      System.out.println("TEST GROUPE / ETUDIANT ET GETTERS");

      Groupe g1 = new Groupe(1);
      Etudiant e2 = new Etudiant("max",g1);

      System.out.println(e2.getGroupe());

      System.out.println(e2.getNom());
      System.out.println(g1.getEtudiants());
      System.out.println(g1.getNo());

      System.out.println();

      // TEST ELIPSE GROUPE ET CHANGEMENT DE GROUPE VIA CONSTRUCTEUR

      System.out.println("TEST CONSTRUCTEUR GROUPE AVEC ELIPSE ET TRANSFERT DE GROUPE VIA CONSTRUCTEUR");
      System.out.println("\033[0;91m" + "ERREUR DIPLICATION" + "\033[0m");
      Etudiant e3 = new Etudiant("Ginette",g1);
      Etudiant e4 = new Etudiant("Myriam",g1);
      Etudiant e5 = new Etudiant("Josie",g1);

      System.out.println(g1);

      Groupe g2 = new Groupe(2,e3,e4,e5);

      System.out.println(g2);

      System.out.println(g1);

      System.out.println();

      // TEST SET GROUPE

      System.out.println("TEST setGroupe");

      Etudiant e6 = new Etudiant("Patricia",g1);
      System.out.println(e6);
      System.out.println(g1);
      System.out.println("on fait un setGroupe:");
      e6.setGroupe(g2);
      System.out.println(g1);
      System.out.println(g2);

      System.out.println();

      // TEST VIDER GROUPE

      System.out.println("TEST viderGroupe");

      System.out.println(g2);
      Etudiant etuTest = g2.getEtudiants().getFirst();
      System.out.println("on fait un viderGroupe:");
      g2.viderGroupe();
      System.out.println(g2);
      System.out.println(etuTest);

      // TEST VIDER GROUPE
      System.out.println("TEST tranfererTous");
      Groupe g3 = new Groupe(3);
      Etudiant e7 = new Etudiant("aline");
      Etudiant e8 = new Etudiant("Oh OUIII");
      Groupe g4 = new Groupe(4,e7,e8);

      System.out.println(g4);
      g4.transfererTous(g3);
      System.out.println(g4);
      System.out.println(g3);

      System.out.println("TEST tranferer un certain nombre d'étudiants");
      g3.transfererEtudiants(g4,e7);
      System.out.println(g3);
      System.out.println(g4);

      System.out.println("TEST tranfererTous  a partir de vide");
      Groupe.transfererTous(null,g4);
      System.out.println(g4);

      System.out.println("TEST tranfertous vers meme groupe");
      Groupe.transfererTous(g4,g4);
      System.out.println(g4);

      System.out.println("TEST tranfererTous vers vide");

      Etudiant tempEtudiant = g3.getEtudiants().getFirst();
      Groupe.transfererTous(g3,null);
      System.out.println(g3);
      System.out.println(tempEtudiant);




   }
   // TODOLIST
   //TODO : fct static éviter de doubler le code.
}
