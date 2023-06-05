package com.lab.TranVanDang.controller;

import com.lab.TranVanDang.entity.room;
import com.lab.TranVanDang.service.roomService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/room")
public class roomController {
    @Autowired
    private roomService room_Service;

    @GetMapping
    public String showAllRoom(Model model)
    {
        List<room> rooms = room_Service.getAll();
        model.addAttribute("room",rooms);

        return "room/list";
    }

    @GetMapping("/add")
    public String addRoomForm(Model model){
        model.addAttribute("room",new room());
        return "room/add";
    }


    @PostMapping("/add")
    public String addRoom(@Valid @ModelAttribute("room") room Room , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors())
        {
            return "room/add";
        }
        room_Service.createRoom(Room);
        return "redirect:/room";
    }
    String id_Room="";
    @GetMapping("/edit/{roomID}")
    public String editRoomForm(@PathVariable("roomID") String roomID, Model model){
        room editRoom = room_Service.getRoomByID(roomID);
        if(editRoom != null){
            id_Room=roomID;
            model.addAttribute("room", editRoom);
            return "room/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editRoom(@Valid @ModelAttribute("room")room updateRoom, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("room", room_Service.getAll());
            return "room/edit";
        }
        room_Service.deleteRoom(id_Room);
        id_Room="";
        room_Service.updateRoom(updateRoom);
        return "redirect:/room";
    }
    @PostMapping("/delete/{roomID}")
    public String deleteRoom(@PathVariable("roomID") String roomID){
        room_Service.deleteRoom(roomID);
        return "redirect:/room";
    }
}
