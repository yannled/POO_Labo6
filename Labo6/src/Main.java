public class Main {
   public static void main (String[] args) {

      Etudiant e1 = new Etudiant("prout");
      Etudiant e2 = new Etudiant("coucou");
      Etudiant e3 = new Etudiant("hypocampe");
      Etudiant e4 = new Etudiant("licorne");
      Groupe g1 = new Groupe(1, e1, e2, e3, e4);
      Groupe g2 = new Groupe(2, e2); //TESTER SI DEJA DANS GROUPE
      Groupe g3 = new Groupe(3);
   }


   // TODOLIST
   //TODO : fct static éviter de doubler le code.
}
