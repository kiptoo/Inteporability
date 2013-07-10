/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp;

/**
 *
 * @author kip
 */
public class Villager {
    private Animals animal;

    public Animals getAnimal() {
        return animal;
    }

    public void setAnimal(Animals animal) {
        this.animal = animal;
    }
    
    public void village(){
     getAnimal().MakeNoise();
    }
    
}
