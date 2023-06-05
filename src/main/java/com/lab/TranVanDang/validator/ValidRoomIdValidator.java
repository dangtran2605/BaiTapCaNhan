package com.lab.TranVanDang.validator;

import com.lab.TranVanDang.entity.room;
import com.lab.TranVanDang.validator.annotation.ValidRoomID;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidRoomIdValidator implements ConstraintValidator<ValidRoomID, room> {
    @Override
    public boolean isValid(room Room, ConstraintValidatorContext context){
        return Room!=null&& Room.getRoomID()!=null;
    }
}
