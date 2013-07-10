/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp;

/**
 *
 * @author kip
 */
public class patient{
  private String complaint;
  private String  diagnosis;

  public static void main(String args[]){
      Person pers =new  Person();
      
      pers.setAge("89");
      pers.setFname("Evans Kiptoo");
      pers.setId("23");
      patient pat = new patient();
      
     
      pat.setDiagnosis("Malaria");
      pat.setComplaint("Headache");
      
      System.out.println("Patient Name is"+" "+pers.getFname());
  
  } 
    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
 
  
}
