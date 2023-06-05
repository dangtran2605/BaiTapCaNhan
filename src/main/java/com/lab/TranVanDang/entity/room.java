package com.lab.TranVanDang.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Data
@Entity
@Table(name="room")
public class room {
    @Id
    @NotEmpty(message = "Room's ID must not be empty")
    @Size(max=2, min = 1, message = "Room's ID must be less than 2 characters")
    private String roomID;
    @Column
    @NotEmpty(message = "Room's name must not be empty")
    @Size(max=30, min = 1, message = "Room's name must be less than 30 characters")
    private String roomName;

    public String  getRoomID() {
        return roomID;
    }
    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }
    public String  getRoomName() {
        return roomName;
    }
    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
