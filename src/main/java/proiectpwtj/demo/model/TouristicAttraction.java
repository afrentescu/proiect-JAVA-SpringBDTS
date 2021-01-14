package proiectpwtj.demo.model;

import javax.validation.constraints.NotNull;

public class TouristicAttraction {

    private int attractionId;

    @NotNull(message = "The name of the touristic attraction cannot be null!!!")
    private String attractionName;
    @NotNull(message =  " Enter the address of the attraction!")
    private String address;
    @NotNull(message = "Enter a price for the ticket!!")
    private Double ticketPrice;

    @NotNull(message = "Specify the programmme in which the tourists can visit the place or specify if it is open 24/7!")
    private String programme;
     private int cityId;

    public TouristicAttraction(){

    }
    public TouristicAttraction(String name, String address, Double price){
        this.attractionName = name;
        this.address = address;
        this.ticketPrice = price;
    }
    public TouristicAttraction(int attractionId, String name){
        this.attractionId = attractionId;
        this.attractionName = name;
    }
    public TouristicAttraction(int attractionId, String attractionName, String address, Double ticketPrice, String programme, int cityId) {
        this.attractionId = attractionId;
        this.attractionName = attractionName;
        this.address = address;
        this.ticketPrice = ticketPrice;
        this.programme = programme;
        this.cityId = cityId;
    }

    public int getAttractionId() {
        return attractionId;
    }

    public void setAttractionId(int attractionId) {
        this.attractionId = attractionId;
    }

    public String getAttractionName() {
        return attractionName;
    }

    public void setAttractionName(String attractionName) {
        this.attractionName = attractionName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "TouristicAttraction{" +
                "attractionId=" + attractionId +
                ", attractionName='" + attractionName + '\'' +
                ", address='" + address + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", programme='" + programme + '\'' +
                '}';
    }
}
