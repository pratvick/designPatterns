package com.directi.training.designpatterns_refactored.adapter.clazz;

import com.directi.training.designpatterns_refactored.adapter.LeaveRecord;
import com.directi.training.designpatterns_refactored.adapter.thirdparty.Employee;
import com.directi.training.designpatterns_refactored.adapter.thirdparty.ThirdPartyLeaveRecord;

public class LeaveRecordAdapter extends ThirdPartyLeaveRecord implements LeaveRecord
{
    @Override
    public String getMostAbsentEmployeeName()
    {
        String[] nameParts = getMostAbsentEmployee().getName().split(",");
        return nameParts[1].trim() + " " + nameParts[0].trim();
    }

    @Override
    public int getEmployeeAbsences(String employeeName)
    {
        int lastIndex = employeeName.lastIndexOf(" ");
        String firstPart = employeeName.substring(lastIndex + 1);
        String secondPart = employeeName.substring(0, lastIndex);
        return getEmployeeAbsences(new Employee(firstPart + ", " + secondPart));
    }
}
