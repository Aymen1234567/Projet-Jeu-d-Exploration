/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;


/**
 *
 * @author jo
 */
public class ScannerUnidirectionnel extends Outil
{
    private static final int MARGE_ERREUR = 20;
    private int getMarge(){return ScannerUnidirectionnel.MARGE_ERREUR;}
    
    private Direction directionCourante;
    public Direction getDirectionCourante()
    {
        return this.directionCourante;
    }
    protected void setDirectionCourante()
    {
        do
        {
            this.directionCourante = new Direction(Lire.S("Entrez une direction en combinant 'h','b','g','d' ou 'haut','bas','gauche','droite'"));
        }while(!directionCourante.isValide());
    }
    public ScannerUnidirectionnel()
    {
        super
        (
                "S  ",
                "Scanner unidrectionnel",
                "<Descriptif de la fonctionnalité de l'outil>",
                2//coût énergétique de l'utilisation du scanner
        );
    }    

    @Override
    public void activation(Joueur j)
    {
        /* recherche dans une direction demandée au joueur jusqu'à tomber sur une position null (en dehors de l'enceinte)
            ou une salle contenant un objet. Le nombre de salles parcourues est affiché à 20% près
        */
        //System.out.println("f;egsml,s");
        if(isUtilisablePar(j)){

        setDirectionCourante();
        // Search in the specified direction until encountering an object or reaching null position
        int salleTraverser = chercherDansDir(j);

        j.setPower(j.getPower()-getConsommationEnergetique());

        // Display the result with approximate accuracy
        int adjustedsalleTraverser = adjustAccuracy(salleTraverser);
        System.out.println("Nombre de salles traversées dans la direction " + this.directionCourante + ": " + salleTraverser);
    }else{
        System.out.println("vous n avais pas assez d'energie");
    }
}
    
    private int chercherDansDir(Joueur j) {
        int salleTraverser = 0;
        Salle salleCourant = j.getSalle();

        while (true) {
            // avancer a la salle suivant selon la direction
            salleCourant = salleCourant.getVoisine(directionCourante);

            
            if (salleCourant.getContenu().getNature() != "vide") {
                break;
            }

            salleTraverser++;
        }

        return salleTraverser;
    }

    private int adjustAccuracy(int value) {
        
        double erreur = Math.random() * (MARGE_ERREUR * 2) - MARGE_ERREUR;
        double laValeur = value * (1 + erreur / 100);
        return (int) Math.round(laValeur);
    }

@Override
public int getEnergyCost() {
    return 2; // Energy cost for using the mine detector tool
}

}
