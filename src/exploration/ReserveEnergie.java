/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class ReserveEnergie extends Objet {
    private final static int MAX = 9; // Maximum d'unités d'énergie initialement dans les réserves
    private int dispo; // Unités d'énergie disponibles dans cette réserve
   
    // Getter pour les unités d'énergie disponibles
    public int getDispo() {
        return dispo;
    }
    
    

    // Setter pour les unités d'énergie disponibles
    public final void setDispo(int dispo) {
        this.dispo = Math.max(0, dispo); // Assure que les unités d'énergie ne sont pas négatives
    }

    // Méthode pour interagir avec le joueur
    @Override
    public void interaction(Joueur j) {
        System.out.println("il ya "+dispo +" energie");
        if (dispo > 0) {
            int prendre=Lire.i("vous voulez prendre combien");

            if(prendre>dispo){
               System.out.println("vous ne pouvez pas prendre plus que ce qui ce trouve dans la reserve");
            }else{
                this.dispo=this.dispo-prendre;
                j.setPower(j.getPower()+dispo); // Méthode fictive pour ajouter de l'énergie au joueur
                System.out.println("Vous prenez " + prendre + " unités d'énergie. Il reste " + dispo + " unités dans la réserve.");
            }
        } else {
            System.out.println("La réserve d'énergie est vide.");
        }
    }
    
    // Constructeur avec une quantité spécifique d'énergie
    public ReserveEnergie(int disponible) {
        super("R  ", "Réserve d'énergie"); // Appelle le constructeur de la classe parent Objet
        setDispo(disponible); // Utilise le setter pour initialiser le nombre d'unités d'énergie disponibles
    }
    
    // Constructeur par défaut qui initialise avec un nombre aléatoire d'unités d'énergie
    public ReserveEnergie() 
    {
        this((int)(1 + ReserveEnergie.MAX * Math.random()));
    }
    
    
}

