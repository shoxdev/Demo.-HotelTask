package com.example.task1.controller;

import com.example.task1.entity.Room;
import com.example.task1.payload.RoomDto;
import com.example.task1.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    RoomService roomService;

    @PostMapping("/add")
    public String add(@RequestBody RoomDto roomDto){
        return roomService.add(roomDto);
    }

    @GetMapping("/allRoom")
    public List<Room> allRoom(){
        return roomService.allRoom();
    }

    @GetMapping("/byHotelId/{hotelId}")
    public Page<Room> byHotelId(@PathVariable Integer hotelId,@RequestParam int page){
        return roomService.byHotelId(hotelId,page);
    }

    @PutMapping("/edit/{id}")
    public String edit(@PathVariable Integer id,@RequestBody RoomDto roomDto){
        return roomService.edit(id,roomDto);
    }
}
