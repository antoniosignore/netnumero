package com.numhero.client.model.datacargo.report.chartofaccounts;

import com.numhero.shared.datacargo.CommandRequest;
import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.CountryEnum;
import com.numhero.shared.service.ApplicationCommandEnum;

import java.util.Date;

public class AccountBalanceRequest extends CommandRequest {

    Long ledgerAccountId;
    private Date from;
    private Date to;
    private AccountClassEnum ledgerAccountClass;
    private CountryEnum country;

    public AccountBalanceRequest() {
        setCommand(ApplicationCommandEnum.CommandGetAccountBalance);
    }

    public Long getLedgerAccountId() {
        return ledgerAccountId;
    }

    public void setLedgerAccountId(Long ledgerAccountId) {
        this.ledgerAccountId = ledgerAccountId;
    }

    public Date getFrom() {
        return from;
    }

    public Date getTo() {
        return to;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public void setLedgerAccountClass(AccountClassEnum ledgerAccountClass) {
        this.ledgerAccountClass = ledgerAccountClass;
    }

    public AccountClassEnum getLedgerAccountClass() {
        return ledgerAccountClass;
    }

    public void setCountry(CountryEnum country) {
        this.country = country;
    }

    public CountryEnum getCountry() {
        return country;
    }
}
