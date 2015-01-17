package com.numhero.server.excel;

import com.numhero.client.model.pojoc.ExpenseReceipt;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExportService {

    public static ByteArrayOutputStream expensesExcelReport(List<ExpenseReceipt> expenseReceipts) throws IOException {

        // Stream containing excel data
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//
//        // Create Excel WorkBook and Sheet
//        WritableWorkbook workBook = Workbook.createWorkbook(outputStream);
//        WritableSheet sheet = workBook.createSheet("Expenses", 0);
//
//        // Generates Headers Cells
//        WritableFont headerFont = new WritableFont(WritableFont.TAHOMA, 12, WritableFont.BOLD);
//        WritableCellFormat headerCellFormat = new WritableCellFormat(headerFont);
//        headerCellFormat.setBackground(Colour.PALE_BLUE);
//        sheet.addCell(new Label(1, 1, "Category", headerCellFormat));
//        sheet.addCell(new Label(2, 1, "Client", headerCellFormat));
//
//        // Generates Data Cells
//        WritableFont dataFont = new WritableFont(WritableFont.TAHOMA, 12);
//        WritableCellFormat dataCellFormat = new WritableCellFormat(dataFont);
//        int currentRow = 2;
//        for (ExpenseReceipt expense : expenseReceipts) {
//            sheet.addCell(new Label(1, currentRow, expense.fCategoryName.getValue(), dataCellFormat));
//            sheet.addCell(new Label(2, currentRow, expense.fClientSupplierName.getValue(), dataCellFormat));
//            currentRow++;
//        }
//
//        // Write & Close Excel WorkBook
//        workBook.write();
//        workBook.close();
//
//        return outputStream;
        return null;
    }
}
