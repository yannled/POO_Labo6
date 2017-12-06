import java.util.LinkedList;

public class Groupe {

   private final int no;


   private LinkedList<Etudiant> etudiants = new LinkedList<>();
   
   
   public Groupe(int no, Etudiant... etudiants) {
      //TODO: utiliser ajouterEtudiant dans le constructeur ce qui settera automatiquement le groupe
      this.no = no;

      if (etudiants.length > 0)
      this.ajouterEtudiants(etudiants);
   }


   public LinkedList<Etudiant> getEtudiants() {
      return etudiants;
   }


   public int getNo() {
      return no;
   }


   public void ajouterEtudiants(Etudiant... etudiants) {

      for (Etudiant etudiant : etudiants){
         //AddInGroup(etudiant);
         //this.etudiants.add(etudiant);

         etudiant.setGroupe(this);
      }
   }


   public void supprimerEtudiants(Etudiant... etudiants) {

      for (Etudiant etudiant : etudiants){
         //suppInGroup(etudiant);
         //this.etudiants.remove(etudiant);
         etudiant.setGroupe(null);
      }
   }


   public void viderGroupe() {
      while (!etudiants.isEmpty()){
         etudiants.getFirst().setGroupe(null);
      }
   }

   public void transfererEtudiants(Groupe groupe, Etudiant... etudiants) {
      transfererEtudiants(this, groupe, etudiants);
   }


   public static void transfererEtudiants(Groupe groupeA, Groupe groupeB, Etudiant... etudiants) {
      groupeB.ajouterEtudiants(etudiants);
      groupeA.supprimerEtudiants(etudiants);
   }


   public void transfererTous(Groupe groupe) {
      transfererTous(this, groupe);
   }


   public static void transfererTous(Groupe groupeA, Groupe groupeB) {
      for (Etudiant etudiant : groupeA.etudiants) {
         transfererEtudiants(groupeA,groupeB,etudiant);
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

   protected static void sychronisation(Groupe newGroupe, Etudiant etudiant){
      Groupe oldGroupe = etudiant.getGroupe();
      if (oldGroupe != null){
         //oldGroupe.suppInGroup(etudiant);
         oldGroupe.etudiants.remove(etudiant);
      }
      if(newGroupe != null){
         //newGroupe.AddInGroup(etudiant);
         newGroupe.etudiants.add(etudiant);
      }
   }

   private void AddInGroup(Etudiant etudiant){
      etudiants.add(etudiant);
   }

   private void suppInGroup(Etudiant etudiant){
      etudiants.remove(etudiant);
   }

}