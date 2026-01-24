/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 * À compléter
 * @author jo
 */
public class Joueur
{    
    private String nom;
    private int power;
    private int grenade;
    private  boolean ganganat;
    public String getNom(){return this.nom;}
    private void setNom(String nom){this.nom = nom;}
    private void setNom()
    {
      setNom(Lire.S("Quel est votre nom"));
    }

    public int getPower(){
        return this.power;
    }

    public void setPower( int min){
        this.power=min;
    }

    public int getGrenade(){
        return this.grenade;
    }

    public int setGrenade(int grenades){
        return this.grenade=grenades;
    }


    
    private Position position;
    /**
     * Position du joueur
     * @return une référence à une position
     */
    public Position getPosition(){return this.position;}    
    /**
     * Salle où se situe le joueur
     * @return une référence à une salle
     */
    public Salle getSalle()
    {
        return this.position.getPlateau().getSalle(this.position);
    }
    public void setPosition(Position position)
    {
        // affectation de la position en déclenchant la méthode d'entrée de la salle
        this.position=position;
        getSalle().entree(this);
    }
        
    /**
     * Avance dans une direction donnée à condition que le mur soit ouvert dans cette direction
     * @param d direction dans laquelle avancer
     */
    public void avance(Direction d)
    {
        /*
            code : il faut gérer la sortie du plateau, le fait qu'un mur soit ou non ouvert et remettre à jour la position du joueur
        */

         // recuper la salle voisine
    Salle sallevoisine = getSalle();
    
   
    if (sallevoisine.isPossible(d)) {
        // recuper la salle a cote de la salle voisine selon la direction
        Salle nextSalle = sallevoisine.getVoisine(d);
        
        
        if (nextSalle != null) {
           
            setPosition(nextSalle.getPosition());
        } else {
            System.out.println("You cannot move in that direction. There is no room.");
        }
    } else {
        System.out.println("You cannot move in that direction. The passage is closed.");
    }
    }
    
    private LesOutils outils;
    public LesOutils getOutils()
    {
        return this.outils;
    }
    private void setOutils(LesOutils outils)
    {
        this.outils = outils;
    }

    /**
     * Récupération d'un outil trouvé dans une salle
     */
    public void recupere()
    {
        //Cette méthode est déclenchée par l'interaction avec l'outil
       // if(this.outils.)
      // System.out.println("allo");
        String rep=Lire.S("vous voulez prendre cette outil repondez par oui ou non");
        if(rep.equals("oui")){
        getOutils().ajoute((Outil) getSalle().getContenu());
        }

    }   
    

    
    private boolean perdant;
    public boolean isPerdant(){return this.perdant;}
    public void setPerdant(boolean perdant){this.perdant = perdant;}

    public boolean isGangnant(){return this.ganganat;}
    public void setGangnant(boolean ganganat){this.ganganat = ganganat;}
    
    public void lanceGrenade(Direction d)
    {
        getSalle().setAcces(d);
        setGrenade(getGrenade()-1);
        /*
            La grenade est perdue si un mur est déjà ouvert dans la direction spécifiée
            Sinon,un accès est ajouté à la salle courante vers la salle contiguë dans la direction d (et réciproquement)
            et le joueur est « aspiré » dans la salle nouvellement ouverte. La réserve de grenades du joueur est décrémentée
        */
    }
 
    public Joueur(String nom,Position position)
    {
        //code
        setNom(nom);
        setPosition(position);
        setPower(20);
        setGrenade(10);
        setPerdant(false);
        setGangnant(false);
        this.outils = new LesOutils(this); 
    }
    public Joueur(Position position)
    {
        //code
        this("Joueur sans nom", position); 
    }

    // Méthode pour ajouter des grenades au joueur
    public void ajouterGrenades(int nombre) {
        if (nombre > 0) {
           setGrenade(nombre); // Ajouter le nombre ajusté de grenades
            System.out.println(nombre + " grenades ont été ajoutées. Vous avez maintenant " + nombre + " grenades.");
        } else {
            System.out.println("Nombre de grenades à ajouter doit être positif.");
        }
    }
}
