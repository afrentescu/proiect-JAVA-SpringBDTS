package proiectpwtj.demo.queries;

public class Queries {

    public final static String GET_TOURISTS_SQL = "select * from tourist";

    public final static String GET_ALL_ATTRACTIONS_SQL = "select * from TouristicAttraction";
    public final static String GET_ALL_CITIES = "select * from City";
    public final static String GET_CITY_ATTRACTIONS_BY_NAME = "select * from TouristicAttraction inner join City on TouristicAttraction.cityId = city.cityId where city.cityName = ? ";
    public final static String GET_ATTRACTIONS_FROM_CITY_By_ID = "select * from TouristicAttraction where cityId = ? ";
    public final static String GET_ATTRACTIONS_FROM_CATEGORY = "select * from touristicAttraction where categoryId = ? ";


    public final static String DELETE_ATTRACTION_SQL = "delete from TouristicAttraction where attractionId = ? ";
    //sterge attractiile dintr-un anumit oras
    public final static String DETELE_ATTRACTIONS_FROM_CITY = "delete from TouristicAttraction where cityId = ? ";

    public final static String ADD_TOURIST = "INSERT INTO tourist (touristId, firstName, lastName, email) VALUES (null, ?, ?, ?)";
    public final static String ADD_ATTRACTION = "INSERT INTO touristicAttraction (attractionId, attractionName, address, ticketPrice, programme, cityId) VALUES (null, ?, ?, ?, ?, ?)";
    public final static String ADD_CITY = "INSERT INTO city (cityId, cityName) VALUES (null, ?)";
  //  public final static String UPDATE_ATTRACTION = " update TouristicAttraction set attractionName = ?  where attractionId = ? ";

}
