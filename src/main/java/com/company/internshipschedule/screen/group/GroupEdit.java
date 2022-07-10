package com.company.internshipschedule.screen.group;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Group;

@UiController("Group_.edit")
@UiDescriptor("group-edit.xml")
@EditedEntityContainer("groupDc")
public class GroupEdit extends StandardEditor<Group> {
}