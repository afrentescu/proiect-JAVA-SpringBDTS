package proiectpwtj.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;
import proiectpwtj.demo.model.City;
import proiectpwtj.demo.model.Tourist;
import proiectpwtj.demo.model.TouristicAttraction;
import proiectpwtj.demo.queries.Queries;
import proiectpwtj.demo.repository.MainRepository;

import java.util.List;

@Service
public class MainService {

    @Autowired
    private MainRepository mainRepository;

    public List<Tourist> getAllTourists(){

        return mainRepository.getAllTourists();
    }

    public List<TouristicAttraction> getAllAttractions()
    {
        return mainRepository.getAllAttractions();
    }
    public List<City> getAllCities(){

        return mainRepository.getAllCities();
    }

    public List<TouristicAttraction> getAttractionsFromCity(String cityName){

        return mainRepository.getAttractionsFromCity(cityName);
    }


    public List<TouristicAttraction> getAttractionsFromCityById(int id){

        return mainRepository.getAttractionsFromCityById(id);
    }
    public List<Tourist> addTourist(Tourist tourist) {
        return  mainRepository.addTourist(tourist);
    }

    public Tourist addTourist2(Tourist tourist) {
        return  mainRepository.addTourist2(tourist);
    }

    public TouristicAttraction addAttraction(TouristicAttraction attraction) {
        return mainRepository.addAttraction(attraction);
    }

    public City addCity(City city) {
        return mainRepository.addCity(city);
    }
/*
    public List<TouristicAttraction> modifyAttraction(TouristicAttraction attraction){
        return  mainRepository.modifyAttraction(attraction);
    }
*/
    public List<TouristicAttraction> deleteAttraction(int id){
        return mainRepository.deleteAttraction(id);
    }

    public int deleteOneAttraction(int id){
        return mainRepository.deleteOneAttraction(id);
    }

    public List<TouristicAttraction> deleteAttractionFromCity(int id){
        return mainRepository.deleteAttractionFromCity(id);
    }
}
