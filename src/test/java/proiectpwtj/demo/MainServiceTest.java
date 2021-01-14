package proiectpwtj.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import proiectpwtj.demo.model.Tourist;
import proiectpwtj.demo.model.TouristicAttraction;
import proiectpwtj.demo.repository.MainRepository;
import proiectpwtj.demo.service.MainService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class MainServiceTest {

    @InjectMocks
    private MainService mainService;

    @Mock
    private MainRepository mainRepository;

    @Test
    @DisplayName("Get all attractions")
    public void getAllAttractionsTest(){

        Mockito.when(mainRepository.getAllAttractions()).thenReturn(Arrays.asList(new TouristicAttraction("name1", "address1", 5.0)));
        List<TouristicAttraction>  attractionList = mainService.getAllAttractions();
        assertEquals ( attractionList.size(), 1);
    }



    public void getAllTourists(){

    }


}
