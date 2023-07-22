package com.user.service;

import com.user.entity.Laptop;
import com.user.repo.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LaptopService {
    private final LaptopRepository laptopRepository;

    @Autowired
    public LaptopService(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    public List<Laptop> getAllLaptops() {
        return laptopRepository.findAll();
    }

    public Laptop getLaptopById(Integer laptopId) {
        return laptopRepository.findById(laptopId).orElse(null);
    }

    public Laptop saveLaptop(Laptop laptop) {
        return laptopRepository.save(laptop);
    }

    public void deleteLaptop(Integer laptopId) {
        laptopRepository.deleteById(laptopId);
    }
}