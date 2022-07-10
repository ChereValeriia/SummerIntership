package com.company.internshipschedule.screen.room;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Room;

@UiController("Room.browse")
@UiDescriptor("room-browse.xml")
@LookupComponent("roomsTable")
public class RoomBrowse extends StandardLookup<Room> {
}