package com.tijo.kw.hotel.room;

import com.tijo.kw.hotel.room.domain.RoomFacade;
import com.tijo.kw.hotel.room.dto.RoomDto;
import com.tijo.kw.hotel.room.dto.TypeOfRoomDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value="/api/room")
public class RoomController {
    RoomFacade roomFacade;
    public RoomController(RoomFacade roomFacade) {
        this.roomFacade = roomFacade;
    }

    @PostMapping(value ="")
    @Operation(summary = "Adds room and returns it")
    public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto room){
        return ResponseEntity.ok(roomFacade.addRoom(room));
    }

    @PostMapping(value ="/type")
    @Operation(summary = "Adds type of room and returns it")
    public ResponseEntity<TypeOfRoomDto> addTypeOfRoom(@RequestBody TypeOfRoomDto typeOfRoom){
        return ResponseEntity.ok(roomFacade.addTypeOfRoom(typeOfRoom));
    }

    @DeleteMapping(value ="/{roomId}")
    @Operation(summary = "Deletes room with given id and returns false/true")
    public ResponseEntity<Boolean> deleteRoom(@PathVariable UUID roomId){
        return ResponseEntity.ok(roomFacade.deleteRoom(roomId));
    }

    @DeleteMapping(value ="/type/{typeOfRoomId}")
    @Operation(summary = "Deletes room with given id and returns false/true")
    public ResponseEntity<Boolean> deleteTypeOfRoom(@PathVariable UUID typeOfRoomId){
        return ResponseEntity.ok(roomFacade.deleteTypeOfRoom(typeOfRoomId));
    }

    @GetMapping(value="/type")
    @Operation(summary = "Returns list of all types of room")
    public ResponseEntity<List<TypeOfRoomDto>> getTypesOfRoom(){
        return ResponseEntity.ok(roomFacade.getTypesOfRoom());
    }

    @GetMapping(value="")
    @Operation(summary = "Returns list of all rooms")
    public ResponseEntity<List<RoomDto>> getRooms(){
        return ResponseEntity.ok(roomFacade.getRooms());
    }

    @GetMapping(value="/{typeOfRoomId}")
    @Operation(summary = "Returns type of room with given id")
    public ResponseEntity<TypeOfRoomDto> getTypeOfRoom(@PathVariable UUID typeOfRoomId){
        return ResponseEntity.ok(roomFacade.getTypeOfRoom(typeOfRoomId));
    }

}