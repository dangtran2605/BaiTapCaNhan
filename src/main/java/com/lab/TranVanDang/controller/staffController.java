package com.lab.TranVanDang.controller;

import com.lab.TranVanDang.entity.staff;
import com.lab.TranVanDang.service.roomService;
import com.lab.TranVanDang.service.staffService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/staff")
public class staffController {
    @Autowired
    private staffService staff_Service;
    @Autowired
    private roomService room_Service;

    @GetMapping
    public String showAllStaff(Model model)
    {
        List<staff> st = staff_Service.getAll();
        model.addAttribute("staff",st);
        return "staff/list";
    }


    @GetMapping("/add")
    public String addStaffForm(Model model){
        model.addAttribute("staff",new staff());
        model.addAttribute("room",room_Service.getAll());
        return "staff/add";
    }


    @PostMapping("/add")
    public String addStaff(@Valid @ModelAttribute("staff") staff st , BindingResult bindingResult , Model model){
        if(bindingResult.hasErrors())
        {
            model.addAttribute("room",room_Service.getAll());
            return "staff/add";
        }
        staff_Service.addStaff(st);
        return "redirect:/staff";
    }
    private String idStaff="";
    @GetMapping("/edit/{staffID}")
    public String editStaffForm(@PathVariable("staffID") String staffID, Model model){
        staff editSt = staff_Service.getStaffByID(staffID);
        if(editSt != null){
            model.addAttribute("staff", editSt);
            model.addAttribute("room", room_Service.getAll());
            idStaff=staffID;
            return "staff/edit";
        }else {
            return "not-found";
        }
    }
    @PostMapping("/edit")
    public String editStaff(@Valid @ModelAttribute("staff")staff updateStaff, BindingResult bindingResult, Model model ){
        if (bindingResult.hasErrors()){
            model.addAttribute("room", room_Service.getAll());
            return "staff/edit";
        }
        staff_Service.deleteStaff(idStaff);
        idStaff="";
        staff_Service.updateStaff(updateStaff);
        return "redirect:/staff";
    }
    @PostMapping("/delete/{staffID}")
    public String deleteStaff(@PathVariable("staffID") String staffID){
        staff_Service.deleteStaff(staffID);
        return "redirect:/staff";
    }
}
