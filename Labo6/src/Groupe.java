import java.util.LinkedList;

public class Groupe {

   private int no;


   private LinkedList<Etudiant> etudiants;
   
   
   public Groupe(int no, LinkedList<Etudiant> etudiants) {
      this.no = no;
      for (Etudiant etudiant : etudiants){
         this.etudiants.add(etudiant);
         etudiant.setGroupe(this);
      }
   }


   public Groupe(int no) {
      this(no, new LinkedList<Etudiant>());
   }


   public LinkedList<Etudiant> getEtudiants() {
      return etudiants;
   }


   public int getNo() {
      return no;
   }


   public void ajouterEtudiants(Etudiant... etudiants) {
      for (Etudiant etudiant : etudiants){
         this.etudiants.add(etudiant);
         etudiant.setGroupe(this);
      }
   }


   public void supprimerEtudiants(Etudiant... etudiants) {
      for (Etudiant etudiant : etudiants){
         this.etudiants.remove(etudiant);
         etudiant.setGroupe(null);
      }
   }


   public void viderGroupe() {
      etudiants.clear();
   }

   public void transfererEtudiants(Groupe groupe, Etudiant... etudiants) {
      groupe.ajouterEtudiants(etudiants);
      supprimerEtudiants(etudiants);
   }


   public static void transfererEtudiants(Groupe groupeA, Groupe groupeB, Etudiant... etudiants) {
      // TODO implement here
      return null;
   }


   public void transfererTous(Groupe groupe) {
      // TODO implement here
      return null;
   }


   public static void transfererTous(Groupe groupeA, Groupe groupeB) {
      // TODO implement here
      return null;
   }
   
   public String toString() {
      // TODO implement here
      return "";
   }

}