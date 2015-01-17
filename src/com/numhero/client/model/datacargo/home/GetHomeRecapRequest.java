package com.numhero.client.model.datacargo.home;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.service.ApplicationCommandEnum;

public class GetHomeRecapRequest extends CommandRequest {
    private Integer year;

    public GetHomeRecapRequest() {
        setCommand(ApplicationCommandEnum.CommandHomeRecap);
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
