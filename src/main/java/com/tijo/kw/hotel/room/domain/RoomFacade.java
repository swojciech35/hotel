package com.tijo.kw.hotel.room.domain;

import com.tijo.kw.hotel.room.dto.RoomDto;
import com.tijo.kw.hotel.room.dto.TypeOfRoomDto;
import com.tijo.kw.hotel.room.repository.RoomRepository;
import com.tijo.kw.hotel.room.repository.TypeOfRoomRepository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class RoomFacade {

    RoomRepository roomRepository;
    TypeOfRoomRepository typeOfRoomRepository;

    public RoomFacade(RoomRepository roomRepository, TypeOfRoomRepository typeOfRoomRepository) {
        this.roomRepository = roomRepository;
        this.typeOfRoomRepository = typeOfRoomRepository;
    }

    public RoomDto addRoom(RoomDto newRoom){
        return RoomDto.builder().build();
    }

    public boolean deleteRoom(UUID roomId){
        return true;
    }

    public TypeOfRoomDto addTypeOfRoom(TypeOfRoomDto newTypeOfRoom){
        return TypeOfRoomDto.builder().build();
    }

    public boolean deleteTypeOfRoom(UUID typeOfRoomId){
        return true;
    }

    public List<TypeOfRoomDto> getTypesOfRoom() {
        return Collections.emptyList();
    }
    public TypeOfRoomDto getTypeOfRoom(UUID typeOfRoomId){
        return TypeOfRoomDto.builder().build();
    }
}
