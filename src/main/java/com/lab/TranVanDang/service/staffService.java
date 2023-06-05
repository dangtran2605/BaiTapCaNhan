package com.lab.TranVanDang.service;

import com.lab.TranVanDang.entity.staff;
import com.lab.TranVanDang.repository.staffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class staffService {
    @Autowired
    private staffRepository st_Repository;
    public List<staff> getAll(){
        return st_Repository.findAll();
    }
    public staff getStaffByID (String staffID){
        Optional<staff> optional=st_Repository.findById(staffID);
        return optional.orElse(null);
    }
    public void addStaff(staff st){
        st_Repository.save(st);
    }
    public void updateStaff(staff st){
        st_Repository.save(st);
    }
    public void deleteStaff(String staffID){
        st_Repository.deleteById(staffID);
    }
}
