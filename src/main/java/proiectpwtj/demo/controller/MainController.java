package proiectpwtj.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import proiectpwtj.demo.model.City;
import proiectpwtj.demo.model.Tourist;
import proiectpwtj.demo.model.TouristicAttraction;
import proiectpwtj.demo.service.MainService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/project")
public class MainController {

    @Autowired
    private MainService mainService;


    @GetMapping("/getTourists")
    public List<Tourist> getAllTourists(){

        return mainService.getAllTourists();
    }

    @GetMapping("/getAttractions")
    public List<TouristicAttraction> getAllAttractions()
    {
        return mainService.getAllAttractions();
    }

    @GetMapping("/getCities")
    public List<City> getAllCities(){

        return mainService.getAllCities();
    }


    @GetMapping("/getAttractionsByCity")
    public List<TouristicAttraction> getAttractionsFromCity(@RequestParam String cityName){
        return  mainService.getAttractionsFromCity(cityName);
    }

    @GetMapping("/getAttractionsByCityId")
    public ResponseEntity<?> getAttractionsFromCityById(@RequestParam int id){

        return ResponseEntity.ok().body(mainService.getAttractionsFromCityById(id));
    }
/*
    @GetMapping("/byCity")
    public List<TouristicAttraction> getAllAttractionsCity(@RequestParam String name){
        return mainService.getAttractionsFromCity(name);
    }
*/
    @PostMapping("/addTourist")
    public ResponseEntity<Tourist> addTourist2(@RequestBody @Valid Tourist tourist) {
        Tourist tourist1 = mainService.addTourist2(tourist);
        return  ResponseEntity.created(URI.create("/project/" + tourist.getFirstName())).body(tourist);

    }

    @PostMapping("addTouristList")
    public List<Tourist> addTourist(@RequestBody @Valid Tourist tourist) {
        return  mainService.addTourist(tourist);
    }

    @PostMapping("/addAttraction")
    public ResponseEntity<TouristicAttraction> addAttraction(@RequestBody @Valid  TouristicAttraction attraction) {
        return  ResponseEntity.ok().body(mainService.addAttraction(attraction));
    }

    @PostMapping("addCity")
    public ResponseEntity<City> addCity(@RequestBody @Valid  City city)
    {
        return ResponseEntity.created(URI.create("/project/" + city.getCityName())).body(city);
    }
/*
    @PostMapping("/updateAttraction")
    public List<TouristicAttraction> modifyAttraction( @RequestBody  TouristicAttraction attraction){
        return  mainService.modifyAttraction(attraction);
    }*/

    @DeleteMapping("/deleteAttraction")
    public List<TouristicAttraction> deleteAttraction(@RequestParam int id)

    {
        return mainService.deleteAttraction(id);
    }


    @DeleteMapping("deleteOneAttraction")
    public ResponseEntity<Integer> deleteOneAttraction(@RequestParam int id){
        return ResponseEntity.ok().body(mainService.deleteOneAttraction(id));
    }

    @DeleteMapping("/deleteAttractionFromCity")
    public List<TouristicAttraction> deleteAttractionFromCity(@RequestParam int id){
        return mainService.deleteAttractionFromCity(id);
    }
}
