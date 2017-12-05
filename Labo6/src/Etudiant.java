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

      //si possédait déjà un groupe on le supprime du groupe
      if(getGroupe() != null){
         groupe.supprimerEtudiants(this);
      }

      // on lui attribue le nouveau groupe.
      this.groupe = groupe;

      // on l'ajoute au nouveau groupe.
      groupe.ajouterEtudiants(this);

      /*
      this.groupe = groupe;
      if (getGroupe() == null){
         groupe.ajouterEtudiants(this);
      } 
      else {
         getGroupe().transfererEtudiants(groupe, this);
      }*/
   }

   public String toString() {
      String s = nom;
      if(groupe != null){
         s += "(g" + groupe.getNo() + ")";
      }
      return s;
   }
}