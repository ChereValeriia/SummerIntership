package com.company.internshipschedule.screen.lesson;

import com.company.internshipschedule.app.TeacherService;
import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Lesson;

@UiController("Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
public class LessonEdit extends StandardEditor<Lesson> {

}