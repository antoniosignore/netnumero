package com.numhero.server.command;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.numhero.client.model.datacargo.staff.ReimbursableStaffListRequest;
import com.numhero.client.model.datacargo.staff.StaffListResponse;
import com.numhero.client.model.pojoc.BusinessAccount;
import com.numhero.client.model.pojoc.ExpenseReceipt;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.server.model.daolite.ExpenseReceiptDao;
import com.numhero.server.model.daolite.StaffDao;
import com.numhero.server.service.MockedGuiceModule;
import com.numhero.server.utils.PojoTestUtils;
import com.numhero.shared.datacargo.PaginatedArrayList;
import com.numhero.shared.datacargo.PaginatedList;
import com.numhero.shared.enums.ReceiptStatusEnum;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.List;

import static com.numhero.server.utils.PojoTestUtils.createBusinessAccount;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CommandGetReimbursableStaffMembersTest {

    private CommandGetReimbursableStaffMembers commandGetReimbursable;

    private StaffDao staffDao;

    private ExpenseReceiptDao expenseReceiptDao;
    private BusinessAccount ba;

    @Before
    public void setUp() throws Exception {
        ba = createBusinessAccount();

        Injector injector = Guice.createInjector(new MockedGuiceModule());
        staffDao = injector.getInstance(StaffDao.class);

        expenseReceiptDao = injector.getInstance(ExpenseReceiptDao.class);

        commandGetReimbursable = new CommandGetReimbursableStaffMembers();
        commandGetReimbursable.setBusinessAccount(ba);

        injector.injectMembers(commandGetReimbursable);

    }

    @Test
    public void testExecute() throws Exception {
        final Staff staff = PojoTestUtils.createStaff();

        when(staffDao.findAllPaginated("ba1", 1000, null, null)).thenAnswer(new Answer<PaginatedList<Staff>>() {

            @Override
            public PaginatedList<Staff> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<Staff> l = new ArrayList<Staff>();
                l.add(staff);
                return new PaginatedArrayList<Staff>(l, true, true);
            }
        });

        when(expenseReceiptDao.findReceipts("ba1", null, staff.getId(), null, null, null, ReceiptStatusEnum.Presented)
        ).thenAnswer(new Answer<List<ExpenseReceipt>>() {


            @Override
            public List<ExpenseReceipt> answer(InvocationOnMock invocationOnMock) throws Throwable {
                List<ExpenseReceipt> l = new ArrayList<ExpenseReceipt>();
                l.add(PojoTestUtils.createExpenseReceipt());
                return l;
            }
        });

        ReimbursableStaffListRequest request = new ReimbursableStaffListRequest();
        request.setBusinessAccountId("ba1");
        request.setMaxResults(10);
        request.setBusinessAccountId(ba.fBusinessAccountUri.getValue());
        StaffListResponse response = commandGetReimbursable.execute(request);

        assertThat(response.getEntityList().size(), is(1));
        assertThat(response.isFirstPage(), is(Boolean.TRUE));
        assertThat(response.isLastPage(), is(Boolean.TRUE));

        verify(staffDao).findAllPaginated("ba1", 1000, null, null);
        verify(expenseReceiptDao).findReceipts("ba1", null, staff.getId(), null, null, null, ReceiptStatusEnum.Presented);

    }
}
