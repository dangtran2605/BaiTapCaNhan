package com.lab.TranVanDang.service;

import com.lab.TranVanDang.entity.room;
import com.lab.TranVanDang.repository.roomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class roomService {
    @Autowired
    private roomRepository room_Repository;
    public List<room> getAll(){
        return room_Repository.findAll();
    }
    public room getRoomByID(String roomID)
    {
        Optional<room> optionalPB = room_Repository.findById(roomID);
        if(optionalPB.isPresent()){
            return optionalPB.get();
        }else{
            throw new RuntimeException("Room not found");
        }
    }
    public room saveRoom(room r){ return room_Repository.save(r);}
    public room createRoom(room r){ return room_Repository.save(r);}
    public  void  updateRoom(room r) { room_Repository.save(r);}
    public void deleteRoom(String roomID) { room_Repository.deleteById(roomID);}
}
