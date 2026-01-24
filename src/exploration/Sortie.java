package exploration;

/**
 *
 * @author jo
 */
public class Sortie extends Objet
{
    @Override
    public void interaction(Joueur j)
    {
        //j.setPerdant(fa);
        System.out.println("match gangnéé");
    }

    public Sortie(){super("<< ","Sortie");}
}
