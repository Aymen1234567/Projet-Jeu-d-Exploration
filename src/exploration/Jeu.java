/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

import java.util.ArrayList;
import java.util.Collections;

/**
 * À compléter
 * @author jo
 */
public class Jeu
{
    private Plateau plateau;
    public Plateau getPlateau(){return this.plateau;}
    public void setPlateau(Plateau plateau){ this.plateau = plateau;}  

    private Categorie[] listeCategories;
    public void setListeCategories(Categorie[] listeCategories){this.listeCategories = listeCategories;}
    public Categorie[] getListeCategories(){return this.listeCategories;}

    private int proportionVides;

    /**
     * Proportion de salles vides par rapport à l'ensemble des salles : 50 signifie que 50% des salles du plateau sont vides
     * @return
     */
    public int getProportionVides(){return this.proportionVides;}
    private void setProportionVides(int proportionVides){this.proportionVides = proportionVides;}
    
    public boolean isFini(){return true;}

    /**
     * Restitue le joueur qui a été créé dans le plateau (Le joueur pourrait aussi être référencé dans une instance de jeu)
     * @return
     */
    public Joueur getJoueur(){return this.getPlateau().getJoueur();}
    
    public void initJeu(){

        // array de chaque objet
        ArrayList<String> mine = new ArrayList<>();
    ArrayList<String> caisse = new ArrayList<>();
    ArrayList<String> reserve = new ArrayList<>();
    ArrayList<String> detecteur = new ArrayList<>();
    ArrayList<String> scanner = new ArrayList<>();
    ArrayList<String> vide = new ArrayList<>();
    for(var i=0; i<27;i++){
        vide.add("vide");
    }
    //sort d'une fonction qui melange les arrayliste de facon aleatoire pour les places dans la grille
for (Categorie categorie : listeCategories) {
                    //System.out.println(categorie.getClasse());
                    if(categorie.getClasse().equals(Mine.class)){
                        int mine_n=categorie.getProportion();
                        
                        for(var i=0; i<mine_n;i++){
                            mine.add("mine");
                        }
                       
                    }else{
                        if(categorie.getClasse().equals(CaisseGrenades.class)){
                            int caisse_n=categorie.getProportion();
                            
                            for(var i=0; i<caisse_n;i++){
                                caisse.add("caisse");
                            }
                           
                        }else{
                            if(categorie.getClasse().equals(ReserveEnergie.class)){
                                int reserve_n=categorie.getProportion();
                               
                                for(var i=0; i<reserve_n;i++){
                                    reserve.add("reserve");
                                }
                               
                            }else{
                                if(categorie.getClasse().equals(DetecteurMines.class)){
                                    int detecteur_n=categorie.getProportion();
                                    
                                    for(var i=0; i<detecteur_n;i++){
                                        detecteur.add("detecteur");
                                    }
                                   
                                }else{
                                    if(categorie.getClasse().equals(ScannerUnidirectionnel.class)){
                                        int scanner_n=categorie.getProportion();
                                        
                                        for(var i=0; i<scanner_n;i++){
                                            scanner.add("scanner");
                                        }
                                       
                                    }
                                }
                            }
                        }
                    }

                }

                 // methode Combine the four ArrayLists
        ArrayList<String> combinedList = combineAndMix(mine, reserve, caisse, detecteur,scanner,vide);
       
        //remplir la grille
         int centreLigne = (plateau.getNbLig() / 2) + 1;
        int centreColonne = (plateau.getNbCol() / 2) +1;
        for (int i = 1; i < plateau.getNbLig()+1; i++) {
            for(int j=1; j<plateau.getNbCol()+1; j++){
                if(i==1|| i==plateau.getNbLig()){
                    Objet o=new Bordure();
                    plateau.setNouvelleSalle(new Position(i,j ,this.plateau), o);
                    plateau.getSalle(new Position(i,j,this.plateau)).setVisible(true);
                }else{
                   if( (j==1 || j==plateau.getNbCol())){
                   Objet o=new Bordure();
                   plateau.setNouvelleSalle(new Position(i,j ,this.plateau), o);
                   plateau.getSalle(new Position(i,j,this.plateau)).setVisible(true);
                   }else{
                  
                   Objet o=new SalleVide();
                   plateau.setNouvelleSalle(new Position(i,j ,this.plateau), o);
                   plateau.getSalle(new Position(i,j,this.plateau)).setVisible(false);
                   
                   }
                }
               
               
        }
        
    }

    //place la sortie dans l un des coté
    int s=(int) (Math.random() * (4)) + 1;
    switch (s) {
        case 1:
            Sortie sor1=new Sortie();
            this.plateau.setNouvelleSalle(new Position(2, 2, this.plateau),sor1);
            this.plateau.getSalle(new Position(2,2,this.plateau)).setVisible(false);
            break;
        case 2:
            Sortie sor2=new Sortie();
            this.plateau.setNouvelleSalle(new Position((this.plateau.getNbLig()-1), 2, this.plateau),sor2);
            this.plateau.getSalle(new Position((this.plateau.getNbLig()-1),2,this.plateau)).setVisible(false);
            break;   
            
        case 3:
            Sortie sor3=new Sortie();
            this.plateau.setNouvelleSalle(new Position(2, (this.plateau.getNbCol()-1), this.plateau),sor3);
            break;
        case 4:
            Sortie sor4=new Sortie();
            this.plateau.setNouvelleSalle(new Position((this.plateau.getNbLig()-1), (this.plateau.getNbCol()-1), this.plateau),sor4);
            break;        
    
        default:
            Sortie sor5=new Sortie();
            this.plateau.setNouvelleSalle(new Position(2, 2, this.plateau),sor5);
            break;
    }
    plateau.setJoueur(new Joueur("aymen",plateau.getSalle(centreLigne,centreColonne).getPosition()));
    

    //remplie les sale vide par des opjet
    int counter=0;
    for (int i = 1; i < plateau.getNbLig()+1; i++) {
        for(int j=1; j<plateau.getNbCol()+1; j++){

           
            if( (i!=centreLigne || j!=centreColonne) && (plateau.getSalle(new Position(i,j,this.plateau)).getContenu().getNature()=="vide")){
                
                
                
                Objet o;
                if(combinedList.get(counter)=="mine"){
                     o=new Mine();
                }else{
                    if(combinedList.get(counter)=="caisse"){
                         o=new CaisseGrenades();
                    }else{
                        if(combinedList.get(counter)=="reserve"){
                             o=new ReserveEnergie();
                        }else{
                            if(combinedList.get(counter)=="detecteur"){
                                 o=new Categorie(10, DetecteurMines.class).getNouveau();
                            } else{
                                if(combinedList.get(counter)=="vide"){
                                    o=new SalleVide();
                                }else{
                                    o=new Categorie(10, ScannerUnidirectionnel.class).getNouveau();
                                }
                               
                            }
                        }
                    }
                }
                counter=counter+1;
                plateau.setNouvelleSalle(new Position(i,j ,this.plateau), o);
                   plateau.getSalle(new Position(i,j,this.plateau)).setVisible(false);
                
            }else{
             
            }

        }
    }

    

        plateau.toString();
        System.out.println(plateau.toString());
    }

    public static <T> ArrayList<T> combineAndMix(ArrayList<T>... lists) {
        
        ArrayList<T> combinedList = new ArrayList<>();

        
        for (ArrayList<T> list : lists) {
            combinedList.addAll(list);
        }

        Collections.shuffle(combinedList);

        return combinedList;
    }
    
    public void joue()
    {
        // Déroulement du jeu
        boolean gg=true;
        initJeu();
        while(!(this.plateau.getJoueur().isPerdant()) && (this.plateau.getJoueur().getGrenade()>0) && !(this.plateau.getJoueur().isGangnant())){
            System.out.println("1- pour avancer");
            System.out.println("2- pour utiliser un outil");

            String menu=Lire.S("chosisez votre action");
            Joueur j=this.plateau.getJoueur();
            //avancer
            if(menu.equals("1")){

            String direction=Lire.S("Donnez votre direction");
           Direction d= new Direction(direction);
           Salle courrent= this.plateau.getSalle(this.plateau.getJoueur().getPosition());
           Salle voisine=courrent.getVoisine(d);
           Position p=voisine.getPosition();
           String lancer="";
           Position pjj=this.plateau.getPosJoueur();
             Joueur jjj=this.plateau.getJoueur();
             System.out.println("vous aves " + jjj.getGrenade() + " grenade");
             System.out.println("vous aves "+jjj.getPower()+" energie");
             
          
           if(voisine.getContenu().getNature()=="Borde"){
             Position pj=this.plateau.getPosJoueur();
             Joueur jj=this.plateau.getJoueur();
             voisine.entree(jj);
             int centreLigne = pj.getLig();
             int centreColonne = pj.getCol();

             jj.setPosition(new Position(centreLigne, centreColonne, this.plateau));   
        //plateau.setJoueur(new Joueur("aymen",plateau.getSalle(centreLigne,centreColonne).getPosition()));
             

           }else{
            if(voisine.getContenu().getNature()=="Sortie"){
                if(courrent.isPossible(d)){
                Position pj=this.plateau.getPosJoueur();
             Joueur jj=this.plateau.getJoueur();
            // voisine.entree(jj);
             int centreLigne = p.getLig();
             int centreColonne = p.getCol();
             j.setGangnant(true);

             jj.setPosition(new Position(centreLigne, centreColonne, this.plateau)); 
                }else{

                    System.out.println("vous na ves pas acces");
                    lancer=Lire.S("lancer une grenade pour acces a la salle ecrire oui ou non");
                    if(lancer.equals("oui")  ){
                        //courrent.setAcces(d);
                        j.setGangnant(true);
                        voisine.setVisible(true);
                        Position pj=this.plateau.getPosJoueur();
             Joueur jj=this.plateau.getJoueur();
             jj.lanceGrenade(d);
            // voisine.entree(jj);
             int centreLigne = p.getLig();
             int centreColonne = p.getCol();

             jj.setPosition(new Position(centreLigne, centreColonne, this.plateau)); 
                    }
                }  
       
            }else{
                if(courrent.isPossible(d)){
           int centreLigne = p.getLig();
           int centreColonne = p.getCol();
           Joueur jj=this.plateau.getJoueur();
           jj.setPosition(new Position(centreLigne, centreColonne, this.plateau));   
                }else{
                    System.out.println("vous na ves pas acces");
                    lancer=Lire.S("lancer une grenade pour acces a la salle ecrire oui ou non");
                    if(lancer.equals("oui")  ){
                        //courrent.setAcces(d);
                        voisine.setVisible(true);
                        Position pj=this.plateau.getPosJoueur();
             int centreLigne = p.getLig();
             int centreColonne = p.getCol();
             Joueur jj=this.plateau.getJoueur();

             jj.lanceGrenade(d);
             jj.setPosition(new Position(centreLigne, centreColonne, this.plateau));  
                    }
                }
       
            }
    }
}else{
    //menu 2
    if(menu.equals("2")){
         if(j.getOutils().equals(null)){
            System.out.println("vous n'avez aucun outil");
         }else{
            System.out.println("1- ScannerUnidirectionnel");
            System.out.println("2- detecteur de mine");
            String outil=Lire.S("vous ai choisir l outile que vous voulez utilisez");
            if(outil.equals("1")){
                //System.out.println("kkakakk");
                j.getOutils().get(0).activation(j);
            }else{
                if(outil.equals("2")){
                    j.getOutils().get(1).activation(j);
                }
            }
         }
    }else{

    }
}
       plateau.toString();
        System.out.println(plateau.toString());
           
        }
       // System.out.println("sfq");
       if((this.plateau.getJoueur().isPerdant()) || (this.plateau.getJoueur().getGrenade()==0) || (this.plateau.getJoueur().isGangnant())){
        if((this.plateau.getJoueur().isPerdant())){
        System.out.println("match perdue vous avez tomber sur une mine");
        for (int i = 1; i < plateau.getNbLig()+1; i++) {
            for(int j=1; j<plateau.getNbCol()+1; j++){
                plateau.getSalle(new Position(i,j,this.plateau)).setVisible(true);
            }
        }
        System.out.println(plateau.toString());
        
    }else{
        if((this.plateau.getJoueur().getGrenade()==0)){
        System.out.println("match perdue il reste plus de grenade");
        for (int i = 1; i < plateau.getNbLig()+1; i++) {
            for(int j=1; j<plateau.getNbCol()+1; j++){
                plateau.getSalle(new Position(i,j,this.plateau)).setVisible(true);
            }
        }
        System.out.println(plateau.toString());
        }else{
            System.out.println("match gagné");
            for (int i = 1; i < plateau.getNbLig()+1; i++) {
                for(int j=1; j<plateau.getNbCol()+1; j++){
                    plateau.getSalle(new Position(i,j,this.plateau)).setVisible(true);
                }
            }
            System.out.println(plateau.toString());
        }
    }
       }

    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
    public Jeu(int nbLig, int nbCol, int proportionVides, Categorie... listeCategories)
    {
        /*  initialisations du jeu : création d'un plateau et exécution de joue()
            nbLig et nbCol sont les tailles du plateau (Elles peuvent être fixes au moins au début)
        */
        
        setListeCategories(listeCategories);
        setProportionVides(proportionVides);
        this.plateau=new Plateau(nbLig, nbCol, this);
        //setPlateau(plateau);

        //joue();
    }
}