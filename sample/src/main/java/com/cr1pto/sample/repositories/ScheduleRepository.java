package com.cr1pto.sample.repositories;

import org.springframework.data.repository.CrudRepository;

import com.cr1pto.sample.entities.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {

}
