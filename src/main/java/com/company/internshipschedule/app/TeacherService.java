package com.company.internshipschedule.app;

import com.company.internshipschedule.entity.Teacher;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    private DataManager dataManager;


}