package com.company.internshipschedule.screen.student;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Student;

@UiController("Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
public class StudentEdit extends StandardEditor<Student> {
}