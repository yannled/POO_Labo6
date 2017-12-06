/*
 -----------------------------------------------------------------------------------
 Laboratoire : 06
 Fichier     : Groupe.java
 Auteur(s)   : Loic Frueh et Yann Lederrey
 Date        : 28.11.2017

 But         : Implémente la classe Groupe permettant de construire un objet de
               type Groupe, d'obtenir son numéro, la liste des étudiants le 
               composant, d'ajouter et/ou supprimer un, plusieurs ou tous les 
               étudiants dans le groupe, et de transférer un, plusieurs ou tous
               les étudiants du groupe vers un autre.

 Remarque(s) : La classe Groupe fonctionne avec la classe Etudiant. De plus, ces
               deux classes font partie du même paquetage.

 Compilateur : jdk 1.8.0_144-b01
 -----------------------------------------------------------------------------------
 */

import java.util.LinkedList;

public class Groupe {

   private final int no;
   private LinkedList<Etudiant> etudiants = new LinkedList<>();
   
   public Groupe(int no, Etudiant... etudiants) {
      this.no = no;
      
      if (etudiants.length > 0)
      this.ajouterEtudiants(etudiants);
   }

   public LinkedList<Etudiant> getEtudiants()
   {
      return etudiants;
   }

   public int getNo() {
      return no;
   }
   /* ajouterEtudiants est déclaré final ici afin d'éviter qu'une méthode utilisée
      lors de la construction d'un objet soit redéfinie.
   */
   public final void ajouterEtudiants(Etudiant... etudiants) {

      for (Etudiant etudiant : etudiants){
         etudiant.setGroupe(this);
      }
   }

   public void supprimerEtudiants(Etudiant... etudiants) {

      for (Etudiant etudiant : etudiants){
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

   public static void transfererEtudiants(Groupe groupeSource, Groupe groupeDest, Etudiant... etudiants) {
      if(groupeSource != null && groupeSource != groupeDest){

         for (Etudiant etudiant : etudiants){
            etudiant.setGroupe(groupeDest);
         }
      }
   }

   public void transfererTous(Groupe groupe) {
      transfererTous(this, groupe);
   }

   public static void transfererTous(Groupe groupeSource, Groupe groupeDest) {
      if(groupeSource != null && groupeSource != groupeDest){

         while (!groupeSource.etudiants.isEmpty()){
            transfererEtudiants(groupeSource, groupeDest, groupeSource.etudiants.getFirst());
         }
      }
   }
   
   @Override
   public String toString() {
      String s = "g" + no + " : [";
      for (Etudiant etudiant : etudiants){

         if(etudiant == etudiants.getLast())
            s += etudiant;
         else
            s += etudiant + ", ";
      }
      s += "]";
      return s;
   }

   protected static void sychroniser(Groupe nouveauGroupe, Etudiant etudiant){
      Groupe ancienGroupe = etudiant.getGroupe();
      
      if (ancienGroupe != null){
         ancienGroupe.etudiants.remove(etudiant);
      }
      if(nouveauGroupe != null){
         nouveauGroupe.etudiants.add(etudiant);
      }
   }
}