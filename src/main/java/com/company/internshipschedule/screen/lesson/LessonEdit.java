package com.company.internshipschedule.screen.lesson;

import io.jmix.core.DataManager;
import io.jmix.core.FluentValuesLoader;
import io.jmix.ui.Notifications;
import io.jmix.ui.action.Action;
import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Lesson;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@UiController("Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
public class LessonEdit extends StandardEditor<Lesson> {

    @Autowired
    private Notifications notifications;
    @Autowired
    private DataManager dataManager;

    @Subscribe
    public void onInitEntity(InitEntityEvent<Lesson> event) {
        List<Lesson> data = dataManager.load(Lesson.class)
                .query("select count(lesson.getTime()), count(lesson.getTeacher()) from Lessons where lesson.time = lesson.getTime() and lesson.teacher = lesson.getTeacher()")
                .list();
        if (data != null)
        {
            notifications.create()
                    .withCaption("The same lesson is already existed")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
        }
        return;
    }

}