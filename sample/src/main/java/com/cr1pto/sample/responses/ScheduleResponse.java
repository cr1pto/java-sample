package com.cr1pto.sample.responses;

import java.util.List;

public class ScheduleResponse {
    private List<ScheduleItemResponse> items;

    public List<ScheduleItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ScheduleItemResponse> items) {
        this.items = items;
    }
}
