package proiectpwtj.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
public class Tourist {

    private int touristId;

    @NotNull(message = "Please add the First Name of the tourist")
    private String firstName;
    @NotNull(message = "Please add the Last Name of the tourist")

    private String lastName;
    @NotNull(message = "Please add the email of the tourist")
    private String email;
   // private int attractionId;

    public Tourist(){

    }
    public Tourist(int touristId, String firstName, String lastName, String email) {
        this.touristId = touristId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }
    public Tourist(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

   /* public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }*/

    public int getTouristId() {
        return touristId;
    }

    public void setTouristId(int touristId) {
        this.touristId = touristId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
