package com.lab.TranVanDang.entity;

import com.lab.TranVanDang.validator.annotation.ValidRoomID;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="staff")
public class staff {
    @Id
    @NotEmpty(message = "Staff's ID must not be empty")
    @Size(max=3, min = 1, message = "Staff's ID must be less than 3 characters")
    private String staffID;
    @Column
    @NotEmpty(message = "Staff's name must not be empty")
    @Size(max=100, min = 1, message = "Staff's name must be less than 100 characters")
    private String staffName;
    @Column
    @Size(max=3, min = 0, message = "Staff's gender must be less than 3 characters")
    private String sex;
    @Column
    @Size(max=200, min = 0, message = "Staff's birth place  must be less than 200 characters")
    private String birthPlace;

    @Column(insertable=false, updatable=false)
    @Size(max=2, min = 0,message = "")
    private String idRoom;
    @Column
    @NotNull(message = "Salary is required")
    private Integer salary;
    @ManyToOne
    @JoinColumn(name = "idRoom")
    @ValidRoomID
    private room rooms;
    public String  getStaffID() {
        return staffID;
    }
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }
    public String  getStaffName() {
        return staffName;
    }
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
    public String  getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String  getBirthPlace() {
        return birthPlace;
    }
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }
    public String  getIdRoom() {
        return idRoom;
    }
    public void setIdRoom(String idRoom) {
        this.idRoom = idRoom;
    }
    public Integer  getSalary() {
        return salary;
    }
    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
