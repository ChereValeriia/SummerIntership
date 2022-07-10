package com.company.internshipschedule.screen.room;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Room;

@UiController("Room.edit")
@UiDescriptor("room-edit.xml")
@EditedEntityContainer("roomDc")
public class RoomEdit extends StandardEditor<Room> {
}