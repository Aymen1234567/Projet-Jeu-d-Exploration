/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;


/**
 * À compléter
 * @author jo
 */
public class DetecteurMines extends Outil {
    public DetecteurMines() {
        super(
            "D  ",  // Symbole du détecteur de mines
            "Détecteur de mines",
            "Utilisé pour détecter la présence de mines dans les salles adjacentes.",
            3  // Coût énergétique de la détection des mines
        );
    }

   /*  @Override
    public void interaction(Joueur j) {
        if (isUtilisablePar(j)) {
            activation(j);  // Active l'outil si le joueur a assez d'énergie
        } else {
            System.out.println("Pas assez d'énergie pour utiliser le détecteur de mines.");
        }
    }*/

    @Override
    public void activation(Joueur j) {
        
        // Compte les mines et affiche le résultat
        if (isUtilisablePar(j)) {
        int nombreDeMines = compterMinesAutour(j); 
        System.out.println("Nombre de mines détectées autour de vous : " + nombreDeMines);
        j.setPower(j.getPower()-getConsommationEnergetique()); // Réduit l'énergie du joueur après utilisation
        }else{
            System.out.println("Pas assez d'énergie pour utiliser le détecteur de mines.");
        }
    }

 
    private int compterMinesAutour(Joueur j) {
        int nbrdemine = 0;
        String[] array = {"bas", "haut", "gauche", "droite","haut gauche","haut droite","bas gauche","bas droite"};
        Salle currentRoom = j.getSalle();
        
        for (int i = 0; i < array.length; i++) {
           Salle currentRoom1 = currentRoom.getVoisine(new Direction(array[i]));

            
            // Increment the counter for traversed rooms
            
                if(currentRoom1.getContenu().getNature().equals("Mine")){
                    nbrdemine++;
                  
                }
            
           
        }

        

        return nbrdemine;
    }

    @Override
    public int getEnergyCost() {
        return getConsommationEnergetique();
    }
}

