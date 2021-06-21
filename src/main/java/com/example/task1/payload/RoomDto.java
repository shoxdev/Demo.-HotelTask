package com.example.task1.payload;

import com.example.task1.entity.Hotel;
import lombok.Data;

import javax.persistence.ManyToOne;

@Data
public class RoomDto {

    private String number;
    private Integer floor;
    private double size;
    private Integer hotelId;
}
