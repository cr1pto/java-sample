package com.cr1pto.sample.services;

import org.springframework.stereotype.Service;

import com.cr1pto.sample.interfaces.SchedulerService;
import com.cr1pto.sample.repositories.AssociateRepository;
import com.cr1pto.sample.repositories.ManagerRepository;
import com.cr1pto.sample.repositories.ScheduleRepository;
import com.cr1pto.sample.requests.AssociateScheduleRequest;
import com.cr1pto.sample.responses.ScheduleResponse;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    public SchedulerServiceImpl(AssociateRepository associateRepository, ManagerRepository managerRepository,
            ScheduleRepository scheduleRepository) {
        super();
    }

    @Override
    public void addAssociateToSchedule(AssociateScheduleRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAssociateToSchedule'");
    }

    @Override
    public void removeAssociateFromSchedule(AssociateScheduleRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAssociateFromSchedule'");
    }

    @Override
    public ScheduleResponse getSchedule() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSchedule'");
    }

}
