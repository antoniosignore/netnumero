package com.numhero.server.accounting;

import com.numhero.client.model.pojoc.NominalLedgerAccount;
import com.numhero.server.model.daolite.NominalLedgerAccountDao;
import com.numhero.shared.enums.AccountingGroupEnum;

import java.util.List;

public class AccountingEquation {

    // assets = liabilities + equity
    public static boolean isValid(String baId, NominalLedgerAccountDao nominalLedgerAccountDao) {
        if (getAssetsValue(baId, nominalLedgerAccountDao) == getLiabilitiesValue(baId, nominalLedgerAccountDao) + equityValues(baId, nominalLedgerAccountDao))
            return true;
        else
            return false;
    }

    private static Double equityValues(String baId, NominalLedgerAccountDao nominalLedgerAccountDao) {

        List<NominalLedgerAccount> list = nominalLedgerAccountDao.findAllByGroup(baId, AccountingGroupEnum.Capital);

        //todo

        return null;
    }

    private static Double getLiabilitiesValue(String baId, NominalLedgerAccountDao nominalLedgerAccountDao) {

        List<NominalLedgerAccount> list = nominalLedgerAccountDao.findAllByGroup(baId, AccountingGroupEnum.Liability);

        //todo

        return null;

    }

    private static Double getAssetsValue(String baId, NominalLedgerAccountDao nominalLedgerAccountDao) {

        List<NominalLedgerAccount> list = nominalLedgerAccountDao.findAllByGroup(baId, AccountingGroupEnum.Asset);

        //todo

        return null;

    }

}
