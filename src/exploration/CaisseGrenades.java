/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 * À compléter
 * @author jo
 */
public class CaisseGrenades extends Objet
{
    private final static int MAX = 9;// nombre maximal dans les caisses de grenades trouvées dans les salles
    private int nombreGrenades;  // Attribut pour stocker le nombre de grenades dans la caisse
    
    
    // Getters et setters pour nombreGrenades peuvent être ajoutés ici si nécessaire
    public int getNombreGrenades() {
        return nombreGrenades;
    }
    
    

    /**
     *
     * @param nombreGrenades
     */
    public final void setNombreGrenades(int nombreGrenades) {
        this.nombreGrenades = Math.max(0, nombreGrenades); 
    }
    
    @Override
    public void interaction(Joueur j)
    {
        
        System.out.println("il ya "+nombreGrenades +" grenades");
        if (nombreGrenades > 0){
            
            int prendre=Lire.i("vous voulez prendre combien");

            if(prendre>nombreGrenades){
               System.out.println("vous ne pouvez pas prendre plus que ce qui ce trouve dans la reserve");
            }else{
                this.nombreGrenades=this.nombreGrenades-prendre;
                j.ajouterGrenades(prendre+j.getGrenade()); // Méthode fictive pour ajouter de l'grenade au joueur
                System.out.println("Vous prenez " + prendre + " grenades. Il reste " + nombreGrenades + "  dans la réserve.");
            }
        } else {
            System.out.println("La caisse de grenades est vide.");
        }
    }

    public CaisseGrenades(int nbGrenades)
    {
        super("G  ","Caisse de grenades");
        //suite code
        setNombreGrenades(nbGrenades);  // Utilise le setter pour initialiser le nombre de grenades, incluant la logique de validation
    }
    
    
    public CaisseGrenades()
    {
        
        this((int)(1 + CaisseGrenades.MAX*Math.random())/*nb de grenades tirées au hasard entre 1 et CaisseGrenades.MAX pour remplacer 0*/);
    }
    
    
}



