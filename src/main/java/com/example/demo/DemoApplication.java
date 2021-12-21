package com.example.demo;

import com.example.demo.dataprocessing.FindStudiosByName;
import com.example.demo.db.Market;
import com.example.demo.db.Studios;
import com.example.demo.repositories.MarketRepository;
import com.example.demo.repositories.StudiosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping(value = "", produces = "application/json")
public class DemoApplication {

    private String adminPassword = "admin";
    @Autowired
    private StudiosRepository studiosRepository;
    @Autowired
    private MarketRepository marketRepository;
    @Autowired
    private FindStudiosByName findStudiosByName;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @PostMapping(value="create-studio/{password}", consumes = "application/json")
    public Studios createStudio(@PathVariable ("password") String password, @RequestBody Studios studio)
    {
        if(adminPassword.equals(password)) {
            return studiosRepository.save(studio);
        }
        return null;
    }

    @PostMapping(value="create-market-product", consumes = "application/json")
    public Market createMarketProduct(@RequestBody Market market)
    {
        return marketRepository.save(market);
    }

    @DeleteMapping(value="delete-studio/{password}/{id}", consumes = "application/json")
    public void deleteStudio(@PathVariable ("password") String password, @PathVariable ("id") Long id, @RequestBody Studios studio)
    {
        if (adminPassword.equals(password)) {
            if (id.equals(studio.getId())) {
                studiosRepository.deleteById(id);
            }
        }
    }

    @DeleteMapping(value="delete-market-product/{id}", consumes = "application/json")
    public void deleteMarketProduct(@PathVariable ("id") Long id, @RequestBody Market market)
    {
        if(id.equals(market.getId()))
        {
            marketRepository.deleteById(id);
        }
    }

    @PutMapping(value="update-studio/{password}/{id}", consumes = "application/json")
    public void updateStudio (@PathVariable ("password") String password, @PathVariable ("id") Long id, @RequestBody Studios studio)
    {
        if (adminPassword.equals(password)) {
            if (id.equals(studio.getId())) {
                studiosRepository.save(studio);
            }
        }
    }

    @PutMapping(value="update-market-product/{id}", consumes = "application/json")
    public void updateMarket (@PathVariable ("id") Long id, @RequestBody Market market)
    {
        if(id.equals(market.getId()))
        {
            marketRepository.save(market);
        }
    }

    @GetMapping(value="get-studio-by-name", consumes = "application/json")
    public ArrayList<Studios> getStudioByName(@RequestBody Studios studio)
    {
        List <Studios> studiosList = (List<Studios>) studiosRepository.findAll();
        //ArrayList<String> nameList = new ArrayList<>();
        ArrayList <Studios> foundStudio = new ArrayList<>();
        for (int i = 0; i<studiosList.size(); i++)
        {
            if(findStudiosByName.NameEquals(studio.getName(),studiosList.get(i).getName()))
            {
                foundStudio.add(studiosList.get(i));
                //return foundStudio.get(i);
            }
        }
        return foundStudio;
    }

    @GetMapping(value="get-product-by-name", consumes = "application/json")
    public ArrayList<Market> getProductByName(@RequestBody Market market)
    {
        List <Market> marketList = (List<Market>) marketRepository.findAll();
        //ArrayList<String> nameList = new ArrayList<>();
        ArrayList <Market> foundProduct = new ArrayList<>();
        for (int i = 0; i<marketList.size(); i++)
        {
            if(findStudiosByName.NameEquals(market.getName(),marketList.get(i).getName()))
            {
                foundProduct.add(marketList.get(i));
                //return foundStudio.get(i);
            }
        }
        return foundProduct;
    }


}
