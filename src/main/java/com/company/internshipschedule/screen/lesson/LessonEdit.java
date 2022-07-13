package com.company.internshipschedule.screen.lesson;

import com.company.internshipschedule.app.LessonService;
import com.company.internshipschedule.entity.Teacher;
import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

@UiController("Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
public class LessonEdit extends StandardEditor<Lesson> {

    @Autowired
    private Notifications notifications;
    @Autowired
    private DataManager dataManager;
    @Autowired
    private LessonService lessonService;

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
    }
}