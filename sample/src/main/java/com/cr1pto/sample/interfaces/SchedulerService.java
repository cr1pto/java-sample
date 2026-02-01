package com.cr1pto.sample.interfaces;

import com.cr1pto.sample.requests.AssociateScheduleRequest;
import com.cr1pto.sample.responses.ScheduleResponse;

public interface SchedulerService {
    void addAssociateToSchedule(AssociateScheduleRequest request);
    void removeAssociateFromSchedule(AssociateScheduleRequest request);
    ScheduleResponse getSchedule();
}
