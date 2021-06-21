package com.example.task1.service;

import com.example.task1.entity.Hotel;
import com.example.task1.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;

    public String add(Hotel hotel) {
        Hotel newHotel=new Hotel();
        newHotel.setName(hotel.getName());
        hotelRepository.save(newHotel);
        return "Added";
    }

    public List<Hotel> allGet() {
        return hotelRepository.findAll();
    }

    public Hotel getById(Integer hotelId) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(hotelId);
        Hotel  hotel1=new Hotel();
        if (hotelOptional.isPresent()){
            Hotel hotel = hotelOptional.get();
            hotel1.setName(hotel.getName());
            return hotel1;
        }
        return null;
    }

    public String edit(Hotel hotel, Integer id) {
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isEmpty()){
            return "Not Found";
        }
        Hotel hotel1 = hotelOptional.get();
        hotel1.setName(hotel.getName());
        hotelRepository.save(hotel1);
        return "Edited";
    }
}
