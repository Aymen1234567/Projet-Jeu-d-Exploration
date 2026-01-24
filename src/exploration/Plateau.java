/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;
import java.util.ArrayList;

/**
 *
 * @author jo
 */
public class Plateau
{
    private static final String BORD = "░";
    public static boolean VISIBLE = true; // mode déboggage : si true, toutes les salles doivent afficher leur contenu
    private Jeu jeu;
    public Jeu getJeu(){return this.jeu;}
    private void setJeu(Jeu jeu){this.jeu = jeu;}

    private boolean visible;
    public boolean isVisible(){return this.visible||Plateau.VISIBLE;}
    public void setVisible(boolean visible){this.visible = visible;}
    public int  nbLig;
    public int  nbCol;
    private Salle[][] grille;
    public int getNbLig(){return this.grille.length;}
    public int getNbCol(){return this.nbCol;}
    public int getNbSalles(){return this.getNbCol()*this.getNbLig();}
    public Salle getSalle(Position p)
    {
        if(p.isValide()) return this.grille[p.getLig()-1][p.getCol()-1];
        else return null;
    }
    public Salle getSalle(int lig, int col){return this.getSalle(new Position(lig,col,this));}

    /**
     * Place une salle à une position donnée (Les positions en Lig et Col commencent à 1)
     * @param s Une salle
     */

     

     public void  setnbLig(int nb){
        this.nbLig=nb;
       }

       
  
       public void  setnbCol(int nb){
          this.nbCol=nb;
         }
    public void placeSalle(Salle s)
    {
        Position p = s.getPosition();
        if(!p.isValide()) throw new RuntimeException("Affectation de la salle à une position non valide");
        this.grille[p.getLig()-1][p.getCol()-1] = s;       
    }

    /**
     * Crée une salle contenant un objet référencé par o (vide si o = null) et l'affecte au plateau
     * @param p la position dans le plateau
     * @param o l'objet que la salle doit contenir
     */
    public void setNouvelleSalle(Position p, Objet o)
    {
        placeSalle(new Salle(p,this,o));       
    }
    public void setNouvelleSalle(Position p){setNouvelleSalle(p, null);}
    
    private Joueur joueur;
    public Joueur getJoueur(){return this.joueur;}
    public void setJoueur(Joueur joueur){this.joueur = joueur;}
    public Position getPosJoueur(){return this.getJoueur().getPosition();}

    @Override
    public String toString()
   
    {
        String dessin="";
        // Parcourez toutes les salles et concaténez leur représentation dans la chaîne
    for (int i = 1; i < getNbLig()+1; i++) {
        for(int j=1; j<getNbCol()+1; j++){
            dessin+=getSalle(i,j).toString();
          // Assurez-vous que chaque salle ait une méthode toString() définie
         // Ajoutez une nouvelle ligne pour séparer les salles
    }
    dessin+= "\n";
}
return dessin;

    // restitue la chaîne qui représente l'ensemble du plateau en combinant les toString des salles (voir exemple dans le sujet)
    }

    public Plateau(int nbLig, int nbCol, Jeu jeu)
    {
        int centreLigne = ((nbLig+1) / 2) ;
            int centreColonne = ((nbCol+1) / 2);
        // Crée un joueur et initialise le plateau selon les spécifications du jeu (Gros boulot)
        
        this.setnbLig(nbLig);
        this.setnbCol(nbCol);
        this.setJeu(jeu);
        this.grille = new Salle[nbLig][nbCol];
       
    }
}
