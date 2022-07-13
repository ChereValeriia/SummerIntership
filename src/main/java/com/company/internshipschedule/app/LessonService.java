package com.company.internshipschedule.app;

import com.company.internshipschedule.entity.Lesson;
import com.company.internshipschedule.entity.Teacher;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LessonService {
    @Autowired
    private DataManager dataManager;

    public void createLesson(UUID id, LocalDate day, LocalDateTime time, Teacher teacher) {
        Lesson lesson = dataManager.create(Lesson.class);
        lesson.setId(id);
        lesson.setDay(day);
        lesson.setTime(time);
        lesson.setTeacher(teacher);
        dataManager.save(lesson);
    }
}