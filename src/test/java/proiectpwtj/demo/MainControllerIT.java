package proiectpwtj.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import proiectpwtj.demo.controller.MainController;
import proiectpwtj.demo.model.City;
import proiectpwtj.demo.model.Tourist;
import proiectpwtj.demo.model.TouristicAttraction;
import proiectpwtj.demo.service.MainService;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;


import static org.mockito.Mockito.when;

@WebMvcTest(controllers = MainController.class)
public class MainControllerIT {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MainService mainService;

    private ObjectMapper objectMapper =  new ObjectMapper();

    @Test
    public void addNewTourist() throws  Exception{
        Tourist tourist = new Tourist("Adela", "Frentescu" );
        when( mainService.addTourist2(any())).thenReturn(tourist);

        mockMvc.perform(post("/project/addTourist")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(tourist)) )
                .andExpect(status().isNotFound());
        
    }
    @Test
    public void addTourist2Test() throws  Exception{
        Tourist tourist = new Tourist(788, "Adela", "Frentescu", "adelafrrr@gmail.com" );
        when( mainService.addTourist2(any())).thenReturn(tourist);

        mockMvc.perform(post("/project/addTouristList")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(tourist)) )
                .andExpect(status().isOk());

    }
    @Test
    public void addAttractionTest() throws  Exception{
        TouristicAttraction touristicAttraction = new TouristicAttraction(22, "Pantheon" );
        when( mainService.addAttraction(any())).thenReturn( touristicAttraction);

        mockMvc.perform(post("/project/addAttraction")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(touristicAttraction)) )
                .andExpect(status().isOk());

    }

    @Test
    public void addCityTest() throws  Exception{
        City city = new City(22, "Lisabona" );
        when( mainService.addCity(any())).thenReturn(city);

        mockMvc.perform(post("/project/addCity")
                .contentType("application/json" ).content(objectMapper.writeValueAsString(city)) )
                .andExpect(status().isCreated());

    }

    @Test
    public void deleteAttractionTest()  throws  Exception{
        TouristicAttraction touristicAttraction= new TouristicAttraction(33, "Bosfor");
        when(mainService.deleteOneAttraction(anyInt())).thenReturn(touristicAttraction.getAttractionId());

        mockMvc.perform(delete("/project/deleteOneAttraction").param("id", "33")
        .contentType("application/json").content(objectMapper.writeValueAsString(touristicAttraction)))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllTouristsTest() throws  Exception{


        mockMvc.perform(get("/project/getTourists")
        ).andDo(print()).andExpect(status().isOk()).andExpect(content()
                .contentType("application/json"));

    }

    @Test
    public void getAttractionsTest() throws  Exception{


        mockMvc.perform(get("/project/getAttractions")
        ).andDo(print()).andExpect(status().isOk()).andExpect(content()
                .contentType("application/json"));

    }

    @Test
    public void getCitiesTest() throws  Exception{


        mockMvc.perform(get("/project/getCities")
        ).andDo(print()).andExpect(status().isOk()).andExpect(content()
                .contentType("application/json"));

    }

}
