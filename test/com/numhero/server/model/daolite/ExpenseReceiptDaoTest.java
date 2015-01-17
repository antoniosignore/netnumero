package com.numhero.server.model.daolite;

import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.server.NumheroUtils;
import com.numhero.shared.enums.ReceiptStatusEnum;
import org.junit.Test;

import java.util.List;

import static com.numhero.server.utils.PojoTestUtils.createExpenseReceipt;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class ExpenseReceiptDaoTest extends BaseDaoTest {

	ExpenseReceiptDao receiptDao;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		receiptDao = NumheroUtils.injector.getInstance(ExpenseReceiptDao.class);

	}


	@Test
	public void testSaveReceipts() {
		ExpenseReceipt rec = createExpenseReceipt();
        receiptDao.save(rec);
		assertThat(rec.getId(), is(notNullValue()));

		ExpenseReceipt rec2 = receiptDao.get(rec.getId());
		assertThat(rec, is(rec2));

	}


	@Test
	public void testFindReceipts() {
		ExpenseReceipt rec = createExpenseReceipt();
        receiptDao.save(rec);

		List<ExpenseReceipt> lr = receiptDao.findReceipts("ba1", null, null, null, null, null, ReceiptStatusEnum.Presented);

		assertThat(lr.size(), is(1));


		lr = receiptDao.findReceipts("ba1", null, null, null, null, null, ReceiptStatusEnum.Paid);

		assertThat(lr.size(), is(0));
	}




}
