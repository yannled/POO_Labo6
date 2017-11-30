import java.util.LinkedList;

public class Groupe {

   private int no;


   private LinkedList<Etudiant> etudiants = new LinkedList<>();
   
   
   public Groupe(int no, Etudiant... etudiants) {
      this.no = no;
      for (Etudiant etudiant : etudiants){
         this.etudiants.add(etudiant);
         etudiant.setGroupe(this);
      }
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
   }


   public void transfererTous(Groupe groupe) {
      for (Etudiant etudiant : etudiants) {
         etudiant.setGroupe(groupe);
         groupe.ajouterEtudiants(etudiant);
      }
   }


   public static void transfererTous(Groupe groupeA, Groupe groupeB) {
      for (Etudiant etudiant : groupeA.etudiants) {
         etudiant.setGroupe(groupeB);
         groupeB.ajouterEtudiants(etudiant);
      }
   }
   
   public String toString() {
      String s = "g" + no + " : [";
      for (Etudiant etudiant : etudiants){

         if(etudiant == etudiants.getLast())
            s += etudiant + " ";
         else
            s += etudiant + ", ";
      }
      s += "]";
      return s;
   }

}