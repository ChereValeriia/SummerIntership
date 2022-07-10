package com.company.internshipschedule.screen.group;

import io.jmix.ui.screen.*;
import com.company.internshipschedule.entity.Group;

@UiController("Group_.browse")
@UiDescriptor("group-browse.xml")
@LookupComponent("groupsTable")
public class GroupBrowse extends StandardLookup<Group> {
}