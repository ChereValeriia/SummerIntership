package com.company.internshipschedule.app;

import com.company.internshipschedule.entity.Lesson;
import com.company.internshipschedule.entity.Teacher;
import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class LessonService {
    @Autowired
    private DataManager dataManager;

    public boolean isExisted(Teacher teacher, LocalDateTime time) {
        List<Lesson> data = dataManager.load(Lesson.class)
                .query("select l from Lesson l where l.teacher = :teacher and l.time = :time")
                .parameter("teacher", teacher)
                .parameter("time", time)
                .list();
        if ((data != null) || (!data.isEmpty()))
            return true;
        else return false;
    }
}