package com.numhero.client.model.pojoc;

import com.numhero.shared.enums.AccountClassEnum;
import com.numhero.shared.enums.AccountingGroupEnum;

import java.util.Date;

public interface LedgerAccountIF {

    public AccountingGroupEnum getAccountingGroup();

    public Long getId();

    AccountClassEnum getAccountClass();

    public String getName();

    public Boolean isPersonalLedger();

    public String getDescription();

    public Double getBalance();

    public Date getBalanceDate();

    public String getCode();

}
