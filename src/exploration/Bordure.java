/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exploration;

/**
 *
 * @author jo
 */
public class Bordure extends Objet
{
    @Override
    public void interaction(Joueur j)
    {
      
        System.out.println("vous etes arrivez a la limite");
    }

    public Bordure(){super("░  ","Bordure");}
}                                
