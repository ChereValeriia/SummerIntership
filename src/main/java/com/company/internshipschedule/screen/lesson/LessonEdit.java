package com.company.internshipschedule.screen.lesson;

import com.company.internshipschedule.app.LessonService;
import io.jmix.ui.Notifications;
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

    @Subscribe
    public void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        Lesson l = getEditedEntity();
        if (lessonService.isExisted(l.getTeacher(), l.getTime())) {
            event.preventCommit();
            notifications.create()
                    .withCaption("The same lesson is already existed")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
        }
    }


/*
    @Subscribe
    public void onInitEntity(InitEntityEvent<Lesson> event, Teacher teacher, LocalDateTime time) {

        List<Lesson> data = dataManager.load(Lesson.class)
                .query("select l from Lesson l where l.teacher = :teacher and l.time = :time")
                .parameter("teacher", teacher)
                .parameter("time", time)
                .list();

        if ((data != null) || (!data.isEmpty()))
        {
            notifications.create()
                    .withCaption("The same lesson is already existed")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
        }
        return;
    }*/
}