/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp;

/**
 *
 * @author kip
 */
public class Dog implements  Animals{

    @Override
    public String getname() {
       return "Dog";
    }

    @Override
    public void MakeNoise() {
        System.out.println("Bark");
    }
    
}
