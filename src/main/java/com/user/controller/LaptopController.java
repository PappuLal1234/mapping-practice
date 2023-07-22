package com.user.controller;
import com.user.entity.Laptop;
import com.user.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/laptops")
public class LaptopController {
    private final LaptopService laptopService;

    @Autowired
    public LaptopController(LaptopService laptopService) {
        this.laptopService = laptopService;
    }

    @GetMapping
    public List<Laptop> getAllLaptops() {
        return laptopService.getAllLaptops();
    }

    @GetMapping("/{laptopId}")
    public Laptop getLaptopById(@PathVariable Integer laptopId) {
        return laptopService.getLaptopById(laptopId);
    }

    @PostMapping
    public Laptop createLaptop(@RequestBody Laptop laptop) {
        return laptopService.saveLaptop(laptop);
    }

    @PutMapping("/{laptopId}")
    public Laptop updateLaptop(@PathVariable Integer laptopId, @RequestBody Laptop updatedLaptop) {
        Laptop laptop = laptopService.getLaptopById(laptopId);
        if (laptop != null) {
            laptop.setName(updatedLaptop.getName());
            // Update other fields as needed
            return laptopService.saveLaptop(laptop);
        }
        return null;
    }

    @DeleteMapping("/{laptopId}")
    public void deleteLaptop(@PathVariable Integer laptopId) {
        laptopService.deleteLaptop(laptopId);
    }
}
