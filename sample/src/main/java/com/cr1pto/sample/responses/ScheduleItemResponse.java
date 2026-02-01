package com.cr1pto.sample.responses;

import java.util.Date;

public class ScheduleItemResponse {
    private AssociateResponse associate;
    private Date workDay;

    public AssociateResponse getAssociate() {
        return associate;
    }

    public void setAssociate(AssociateResponse associate) {
        this.associate = associate;
    }

    public Date getWorkDay() {
        return workDay;
    }

    public void setWorkDay(Date workDay) {
        this.workDay = workDay;
    }
}
