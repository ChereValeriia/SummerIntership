package com.company.internshipschedule.app;

import com.company.internshipschedule.entity.Room;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private DataManager dataManager;

    public boolean labCapacity() {
        List<Room> rooms = dataManager.load(Room.class)
                .query("select r from Room r where r.typeOfRoom = :typeOfRoom and r.capacity > :capacity")
                .parameter("typeOfRoom", 2)
                .parameter("capacity", 1)
                .list();
        if ((!rooms.isEmpty()))
            return true;
        else return false;
    }
}