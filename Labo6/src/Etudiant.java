public class Etudiant {

   private String nom;


   private Groupe groupe;

   

   public Etudiant(String nom, Groupe groupe) {
      this.nom = nom;
      this.groupe = groupe;
      if (groupe != null){
         groupe.ajouterEtudiants(this);
      }
   }


   public Etudiant(String nom) {
      this(nom, null);
   }


   public String getNom() {
      return nom;
   }


   public Groupe getGroupe() {
      return groupe;
   }


   public void setGroupe(Groupe groupe) {
      this.groupe = groupe;
      groupe.ajouterEtudiants(this);
   }

   public String toString() {
      String s = nom;
      if(groupe != null){
         s += "(g" + groupe.getNo() + ")";
      }
      return s;
   }
}