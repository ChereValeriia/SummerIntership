package com.company.internshipschedule.screen.lesson;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Lesson;

@UiController("Lesson.edit")
@UiDescriptor("lesson-edit.xml")
@EditedEntityContainer("lessonDc")
public class LessonEdit extends StandardEditor<Lesson> {
}