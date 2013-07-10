/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp;

/**
 *
 * @author kip
 */
public class Human  implements  Animals {

    @Override
    public String getname() {
      
        return "Huaman";
    }

    @Override
    public void MakeNoise() {
         
        System.out.println("Riot");
    }
    
    
}
