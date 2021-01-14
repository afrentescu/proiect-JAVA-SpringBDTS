package proiectpwtj.demo.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import proiectpwtj.demo.Exceptions.ObjectNotFoundException;
import proiectpwtj.demo.model.City;
import proiectpwtj.demo.model.Tourist;
import proiectpwtj.demo.model.TouristicAttraction;
import proiectpwtj.demo.queries.Queries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.ToolBarUI;
import java.util.List;


@Repository
public class MainRepository {

     @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final Logger logger = LoggerFactory.getLogger(MainRepository.class);

     public List<Tourist> getAllTourists(){
         logger.info("Se preiau din repository toti turistii.");
        List<Tourist> allTourists = jdbcTemplate.query(Queries.GET_TOURISTS_SQL, new BeanPropertyRowMapper<>(Tourist.class));
         return allTourists;
     }

     public List<TouristicAttraction> getAllAttractions(){
         logger.info("Se preiau din repository toate atractiile turistice");
         List<TouristicAttraction> attractions = jdbcTemplate.query(Queries.GET_ALL_ATTRACTIONS_SQL, new BeanPropertyRowMapper<>(TouristicAttraction.class));
         return attractions;
     }

     public List<City> getAllCities(){
         logger.info("Se preiau din repository toate orasele");
         List<City> cities = jdbcTemplate.query(Queries.GET_ALL_CITIES, new BeanPropertyRowMapper<>(City.class));
         return cities;
     }

     public List<TouristicAttraction> getAttractionsFromCity(String cityName){
         logger.info("Se preiau din repository toate atractiile turistice dintr-un anumit oras");

             List<TouristicAttraction> attractionListByCity = jdbcTemplate.query(Queries.GET_CITY_ATTRACTIONS_BY_NAME, new BeanPropertyRowMapper<>(TouristicAttraction.class));
             return attractionListByCity;

     }


     public List<TouristicAttraction> getAttractionsFromCityById( int id) {
         logger.info("Se preiau din repository toate atractiile turistice dintr-un anumit oras dupa id-ul acestuia");
           try {
               List<TouristicAttraction> attractionListByCity = jdbcTemplate.query(Queries.GET_ATTRACTIONS_FROM_CITY_By_ID, new BeanPropertyRowMapper<>(TouristicAttraction.class));
               return attractionListByCity;
           }catch (ObjectNotFoundException exception){
               throw  new ObjectNotFoundException("Could not identify attractions from this city");
           }

     }

    public List<Tourist> addTourist(Tourist tourist) {
        logger.info("Se preiau din repository datele pentru noul turist introdus");

        jdbcTemplate.update(Queries.ADD_TOURIST, tourist.getFirstName(), tourist.getLastName(), tourist.getEmail());
        return jdbcTemplate.query(Queries.GET_TOURISTS_SQL, new BeanPropertyRowMapper<>(Tourist.class));
    }

    public Tourist addTourist2( Tourist tourist){
        logger.info("Se preiau din repository datele pentru noul turist introdus");

        jdbcTemplate.update(Queries.ADD_TOURIST, tourist.getFirstName(), tourist.getLastName(), tourist.getEmail());
        return tourist;
    }

    public TouristicAttraction addAttraction(TouristicAttraction attraction) {
        logger.info("Se preiau din repository datele pentru noua atractie introdus");

        jdbcTemplate.update(Queries.ADD_ATTRACTION, attraction.getAttractionName(), attraction.getAddress(), attraction.getTicketPrice(), attraction.getProgramme(), attraction.getCityId());
        return attraction;
    }

    public City addCity(City city) {
        logger.info("Se preiau din repository datele pentru noul oras introdus");

        jdbcTemplate.update(Queries.ADD_CITY, city.getCityName());
        return city;
    }
/*
   public List<TouristicAttraction> modifyAttraction(TouristicAttraction attraction){
         jdbcTemplate.update(Queries.UPDATE_ATTRACTION,attraction.getAttractionName(), attraction.getAddress(), attraction.getTicketPrice(), attraction.getProgramme());
         return jdbcTemplate.query(Queries.GET_ALL_ATTRACTIONS_SQL, new BeanPropertyRowMapper<>(TouristicAttraction.class));
   }
*/

    public List<TouristicAttraction> deleteAttraction(int id){
        logger.info("Se preiau din repository datele pentru atractia care urmeaza sa fie stearsa");

        jdbcTemplate.update(Queries.DELETE_ATTRACTION_SQL, id);
         return jdbcTemplate.query(Queries.GET_ALL_ATTRACTIONS_SQL, new BeanPropertyRowMapper<>(TouristicAttraction.class));

     }

     public int deleteOneAttraction(int id){
         jdbcTemplate.update(Queries.DELETE_ATTRACTION_SQL, id);
         return id;
     }

    public List<TouristicAttraction> deleteAttractionFromCity(int id){
        logger.info("Se preiau din repository datele pentru atractiile care urmeaza sa fie stearse dintr-un anumit oras");

        jdbcTemplate.update(Queries.DETELE_ATTRACTIONS_FROM_CITY, id);
        return jdbcTemplate.query(Queries.GET_ALL_ATTRACTIONS_SQL, new BeanPropertyRowMapper<>(TouristicAttraction.class));

    }

}
