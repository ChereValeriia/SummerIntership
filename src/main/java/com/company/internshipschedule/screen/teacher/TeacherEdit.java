package com.company.internshipschedule.screen.teacher;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Teacher;

@UiController("Teacher.edit")
@UiDescriptor("teacher-edit.xml")
@EditedEntityContainer("teacherDc")
public class TeacherEdit extends StandardEditor<Teacher> {
}