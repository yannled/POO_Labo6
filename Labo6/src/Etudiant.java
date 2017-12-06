/*
 -----------------------------------------------------------------------------------
 Laboratoire : 06
 Fichier     : Etudiant.java
 Auteur(s)   : Loic Frueh et Yann Lederrey
 Date        : 28.11.2017

 But         : Implémente la classe étudiant permettants de construire un objet
               de type Etudiant, d'obtenir son nom, le groupe auquel il appartient
               et de lui attibuer un groupe si nécessaire.

 Remarque(s) : La classe Etudiant fonctionne avec la classe Groupe. De plus, ces
               deux classes font partie du même paquetage.

 Compilateur : jdk 1.8.0_144-b01
 -----------------------------------------------------------------------------------
 */

public class Etudiant {

   private String nom;
   private Groupe groupe;

   public Etudiant(String nom, Groupe groupe) {
      this.nom = nom;
      setGroupe(groupe);
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
   /* setGroupe est déclaré final ici afin d'éviter qu'une méthode aussi centrale pour le 
      fonctionnement de la classe et utilisée lors de la construction d'un objet
      soit redéfinie.
   */
   public final void setGroupe(Groupe nouveauGroupe) {
      Groupe.sychroniser(nouveauGroupe, this);
      groupe = nouveauGroupe;

   }

   @Override
   public String toString() {
      String s = nom;
      if(groupe != null){
         s += "(g" + groupe.getNo() + ")";
      }
      return s;
   }
}