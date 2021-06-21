package com.example.task1.controller;

import com.example.task1.entity.Hotel;
import com.example.task1.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Hotel")
public class HotelController {
    @Autowired
    HotelService hotelService;

    @PostMapping
public String add(@RequestBody Hotel hotel){
    return hotelService.add(hotel);
    }
    @GetMapping("/get")
    public List<Hotel> allHotel(){
        return hotelService.allGet();
    }

    @GetMapping("/getById/{hotelId}")
    public Hotel getById(@PathVariable Integer hotelId){
        return hotelService.getById(hotelId);
    }
    @PutMapping("/edit/{id}")
    public String edit(@RequestBody Hotel hotel,@PathVariable Integer id){
        return hotelService.edit(hotel,id);
    }
}
