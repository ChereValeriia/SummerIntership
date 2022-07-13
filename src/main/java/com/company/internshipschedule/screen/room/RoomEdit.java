package com.company.internshipschedule.screen.room;

import com.company.internshipschedule.app.RoomService;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Room.edit")
@UiDescriptor("room-edit.xml")
@EditedEntityContainer("roomDc")
public class RoomEdit extends StandardEditor<Room> {
    @Autowired
    private RoomService roomService;
    @Autowired
    Notifications notifications;

    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        Room r = getEditedEntity();
        if (roomService.labCapacity(r))
        {
            notifications.create()
                    .withCaption("This type of room can't include more than 1")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
        }
        else this.closeWithCommit();
    }
}