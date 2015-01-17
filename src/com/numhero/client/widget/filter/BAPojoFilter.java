package com.numhero.client.widget.filter;

import com.numhero.client.model.pojoc.ClientSupplier;
import com.numhero.client.model.pojoc.Project;
import com.numhero.client.model.pojoc.Staff;
import com.numhero.client.model.pojoc.Task;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

public class BAPojoFilter extends HashMap<String, Long> implements Serializable {

    private Date from;
    private Date to;
    private static final String CLIENT_SUPPLIER_ID = "clientSupplierId";
    private static final String STAFF_ID = "staffId";
    private static final String PROJECT_ID = "projectId";
    private static final String TASK_ID = "taskId";
    private Boolean billed = false;

    public BAPojoFilter() {
    }

    public void putClientSupplier(ClientSupplier staff) {
        put(CLIENT_SUPPLIER_ID, staff.getId());
    }

    public void setStaff(Staff staff) {
        put(STAFF_ID, staff.getId());
    }

    public void setProject(Project project) {
        put(PROJECT_ID, project.getId());
    }

    public void setTask(Task task) {
        put(TASK_ID, task.getId());
    }

    public Long getClientSupplierId() {
        return get(CLIENT_SUPPLIER_ID);
    }

    public Long getStaffId() {
        return get(STAFF_ID);
    }

    public Long getProjectId() {
        return get(PROJECT_ID);
    }

    public Long getTaskId() {
        return get(TASK_ID);
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public Boolean getBilled() {
        return billed;
    }

    public void setBilled(Boolean billed) {
        this.billed = billed;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n\ndate from         : " + from + "\n");
        sb.append("date   to         : " + to + "\n");
        sb.append("staffId           : " + get(STAFF_ID) + "\n");
        sb.append("projectId         : " + get(PROJECT_ID) + "\n");
        sb.append("taskId            : " + get(TASK_ID) + "\n");
        sb.append("clientSupplierId  : " + get(CLIENT_SUPPLIER_ID) + "\n");
        sb.append("isBillable        : " + billed + "\n");
        return sb.toString();
    }


}
