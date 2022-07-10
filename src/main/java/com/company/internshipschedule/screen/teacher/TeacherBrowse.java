package com.company.internshipschedule.screen.teacher;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Teacher;

@UiController("Teacher.browse")
@UiDescriptor("teacher-browse.xml")
@LookupComponent("teachersTable")
public class TeacherBrowse extends StandardLookup<Teacher> {
}