package com.company.internshipschedule.screen.lesson;

import com.company.internshipschedule.app.LessonService;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
public class LessonEdit extends StandardEditor<Lesson> {
    @Autowired
    private LessonService lessonService;
    @Autowired
    Notifications notifications;



    @Subscribe("commitAndCloseBtn")
    public void onCommitAndCloseBtnClick(Button.ClickEvent event) {
        Lesson l = getEditedEntity();
        if (lessonService.isExisted(l.getTeacher(), l.getTime())) {
            notifications.create()
                    .withCaption("The same lesson is already existed")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
        }
        else this.closeWithCommit();
    }
}