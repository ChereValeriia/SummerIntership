package com.company.internshipschedule.app;

import com.company.internshipschedule.entity.Teacher;
import io.jmix.core.DataManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    @Autowired
    private DataManager dataManager;

    public Teacher findLeastBusyTeacher() {
        Teacher leastBusyTeacher = dataManager.loadValues("select t, count(f.name) " +
                "from Teacher t left outer join Lesson f" +
                "on t = f.name " +
                "group by t ").properties("teacher", "lesson")
                .list().stream().map(e -> e.<Teacher>getValue("teacher"))
                .findFirst()
                .orElseThrow(IllegalStateException::new);
        return leastBusyTeacher;
    }
}