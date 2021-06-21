package com.example.task1.service;

import com.example.task1.entity.Hotel;
import com.example.task1.entity.Room;
import com.example.task1.payload.RoomDto;
import com.example.task1.repository.HotelRepository;
import com.example.task1.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    HotelRepository hotelRepository;

    public String add(RoomDto roomDto) {
        Room room=new Room();
        room.setNumber(roomDto.getNumber());
        room.setFloor(roomDto.getFloor());
        room.setSize(roomDto.getSize());
        Optional<Hotel> hotelOptional = hotelRepository.findById(roomDto.getHotelId());
        if (hotelOptional.isEmpty()){
            return "Not found";
        }
        Hotel hotel = hotelOptional.get();
        room.setHotel(hotel);
        roomRepository.save(room);
        return "Added";
    }

    public List<Room> allRoom() {
        return roomRepository.findAll();
    }

    public Page<Room> byHotelId(Integer hotelId, int page) {
        Pageable pageable= PageRequest.of(page,10);
        return roomRepository.findAllByHotelId(hotelId, pageable);

    }

    public String edit(Integer id, RoomDto roomDto) {
        Optional<Room> optional = roomRepository.findById(id);
        if (optional.isEmpty()){
            return "Room Not found";
        }
        Optional<Hotel> hotelOptional = hotelRepository.findById(roomDto.getHotelId());
        if (hotelOptional.isEmpty()){
            return "Hotel not found";
        }
        Room room = optional.get();
        room.setSize(roomDto.getSize());
        room.setFloor(roomDto.getFloor());
        room.setNumber(roomDto.getNumber());
        Hotel hotel = hotelOptional.get();
        room.setHotel(hotel);
        roomRepository.save(room);
        return "Edited Room";

    }
}
