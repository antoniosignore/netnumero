package com.numhero.server.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.*;
import com.numhero.client.model.pojoc.*;
import com.numhero.server.utils.StringUtils;
import com.numhero.shared.enums.InvoiceStatusEnum;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Logger;

public class InvoicePdf {
    private static final Font INVOICE_TYPE_FONT = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
    private static final Font HELVETICA_8_REGULAR_WHITE = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL, BaseColor.WHITE);
    private static final Font HELVETICA_8_REGULAR = new Font(Font.FontFamily.HELVETICA, 8, Font.NORMAL);
    private static final Font HELVETICA_8_BOLD = new Font(Font.FontFamily.HELVETICA, 8, Font.BOLD);
    private static final Font HELVETICA_10_REGULAR = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
    private static final Font HELVETICA_10_BOLD = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);

    private static final Logger log = Logger.getLogger(InvoicePdf.class.getName());

    private static PdfPTable getHeaderTable(Document document, BusinessAccount ba, Invoice invoice) throws DocumentException, MalformedURLException, IOException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.30f, 0.35f, 0.35f});

        Image img = null;
        byte[] aBafCompanyLogoValue = ba.fCompanyLogo.getValue();
        if (aBafCompanyLogoValue != null && aBafCompanyLogoValue.length > 0) {
            img = Image.getInstance(aBafCompanyLogoValue);
        }

        PdfPCell logoCell = new PdfPCell(img, true);
        logoCell.setBorder(Rectangle.NO_BORDER);
        logoCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        table.addCell(logoCell);

        PdfPCell cellBa = new PdfPCell();
        cellBa.setPaddingLeft(35);
        cellBa.setBorder(Rectangle.NO_BORDER);
        cellBa.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellBa.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cellBa.addElement(new Phrase(ba.fName.getValue(), HELVETICA_10_REGULAR));
        cellBa.addElement(new Phrase(ba.fVat.getValue(), HELVETICA_10_REGULAR));
        cellBa.addElement(new Phrase(ba.fAddress.getValue(), HELVETICA_10_REGULAR));
        cellBa.addElement(new Phrase(StringUtils.emptyIfNullStr(ba.fCity.getValue()) + ", " +
                StringUtils.emptyIfNullStr(ba.fZipCode.getValue()), HELVETICA_10_REGULAR));
        cellBa.addElement(new Phrase(StringUtils.emptyIfNullStr(ba.fRegion.getValue()), HELVETICA_10_REGULAR));
        cellBa.addElement(new Phrase(StringUtils.emptyIfNullStr(ba.fCountry.getValue().toString()), HELVETICA_10_REGULAR));

        //TODO: display the phone number
        if (ba.fPhone.getValue() != null && !ba.fPhone.getValue().isEmpty()) {
            try {
                PdfPTable phoneTable = new PdfPTable(2);
                phoneTable.setHorizontalAlignment(Element.ALIGN_LEFT);
                phoneTable.setWidths(new int[]{30, 200});
                phoneTable.setSpacingBefore(5f);
                phoneTable.setSpacingAfter(0f);
                PdfPCell c1 = new PdfPCell(Image.getInstance(InvoicePdf.class.getResource("/phone.png")), false);
                c1.setBorder(Rectangle.NO_BORDER);
                phoneTable.addCell(c1);
                PdfPCell c2 = new PdfPCell(new Phrase(ba.fPhone.getValue(), HELVETICA_10_REGULAR));
                c2.setBorder(Rectangle.NO_BORDER);
                phoneTable.addCell(c2);
                cellBa.addElement(phoneTable);
            }
            catch (Exception ex) {
                log.throwing(InvoicePdf.class.getSimpleName(), "getHeaderTable", ex);
            }
        }
        if (ba.fWeb.getValue() != null && !ba.fWeb.getValue().isEmpty()) {
            cellBa.addElement(new Paragraph(new Chunk(ba.fWeb.getValue(), HELVETICA_10_REGULAR).setAnchor(ba.fWeb.getValue())));
        }
        table.addCell(cellBa);

        PdfPCell cellTitle = new PdfPCell();
        cellTitle.setBorder(Rectangle.NO_BORDER);
        cellTitle.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cellTitle.setVerticalAlignment(Element.ALIGN_BOTTOM);
        cellTitle.addElement(new Phrase(invoice.getInvoiceType().name().toUpperCase() + " " + invoice.fName.getValue(), INVOICE_TYPE_FONT));
        table.addCell(cellTitle);

        return table;
    }

    private static PdfPTable getClientTable(ClientSupplier cs) throws DocumentException {
        PdfPTable table = new PdfPTable(1);
        table.setSpacingBefore(5f);
        table.setSpacingAfter(20f);
        table.setWidthPercentage(100);
        table.getDefaultCell().setPadding(0);
        table.getDefaultCell().setBorderWidth(0);
        table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
        table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);

        PdfPTable destTable = new PdfPTable(1);
        destTable.getDefaultCell().setPaddingTop(4);
        destTable.getDefaultCell().setBorderWidth(0);
        destTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);

        destTable.addCell(new Phrase("Bill To:", HELVETICA_10_BOLD));

        destTable.addCell(new Phrase(cs.fName.getValue(), HELVETICA_10_REGULAR));
        destTable.addCell(new Phrase(cs.fVat.getValue(), HELVETICA_10_REGULAR));
        destTable.addCell(new Phrase(cs.fAddress.getValue(), HELVETICA_10_REGULAR));
        destTable.addCell(new Phrase(StringUtils.emptyIfNullStr(cs.fCity.getValue()) + ", " +
                StringUtils.emptyIfNullStr(cs.fZipCode.getValue()), HELVETICA_10_REGULAR));
        destTable.addCell(new Phrase(cs.fRegion.getValue(), HELVETICA_10_REGULAR));
        destTable.addCell(new Phrase(cs.fCountry.getValue().toString(), HELVETICA_10_REGULAR));

        table.addCell(destTable);

        return table;
    }

    public static ByteArrayOutputStream getPdf(Rectangle size, BusinessAccount ba, ClientSupplier cs, Invoice invoice, Map<Long, TaxInfo> taxes) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(size);
        BaseColor invoiceColorScheme = new BaseColor(ba.fInvoiceColor.getValue().intColor());

        try {
            PdfWriter writer = PdfWriter.getInstance(document, baos);
            document.setMargins(20, 20, 25, 25);
            document.open();

            PdfPTable mainTable = new PdfPTable(1);
            mainTable.setWidthPercentage(100);
            mainTable.getDefaultCell().setPadding(3);
            mainTable.getDefaultCell().setHorizontalAlignment(Element.ALIGN_LEFT);
            mainTable.getDefaultCell().setBorderWidth(0.0f);

            mainTable.addCell(getHeaderTable(document, ba, invoice));
            mainTable.addCell("");
            mainTable.addCell(createClientAndInvoiceSummaryTable(invoice, cs, invoiceColorScheme));
            mainTable.addCell("");
            mainTable.addCell(getInvoiceDetailsTable(invoice, taxes, invoiceColorScheme));

            for (int i = 35; i > invoice.getDetails().size(); i--) {
                mainTable.addCell("");
            }
            mainTable.addCell(createFooterNotes(ba, invoice));

            document.add(mainTable);

            if (invoice.getInvoiceStatus() == InvoiceStatusEnum.Draft) {
                try {
                    BaseFont bf = BaseFont.createFont("Helvetica", "UTF-8", false);
                    float height = 102f;
                    float width = bf.getWidthPoint("DRAFT", height);
                    PdfTemplate template = PdfTemplate.createTemplate(writer, width, height);
                    template.beginText();
                    template.setFontAndSize(bf, height);
                    template.setColorFill(new BaseColor(0xE9E9E9));
                    template.setTextMatrix(0, 2);
                    template.showText("DRAFT");
                    template.endText();
                    template.setWidth(width);
                    template.setHeight(height + 2);
                    Image watermark = Image.getInstance(template);
                    watermark.setRotationDegrees(35);
                    watermark.setAbsolutePosition(120, 350);
                    document.add(watermark);
                }
                catch (IOException e) {
                    log.throwing(InvoicePdf.class.getSimpleName(), "getPdf", e);
                }
            }
        }
        catch (DocumentException e) {
            log.throwing("InvoicePdf", "getPdf", e);
            throw new RuntimeException(e);
            // baos.write("There was an error generating the document. Please try again later.".getBytes("UTF-8"));
        }
        catch (IOException e) {
            log.throwing("InvoicePdf", "getPdf", e);
            throw new RuntimeException(e);
        }
        document.close();
        return baos;
    }

    private static PdfPTable createFooterNotes(BusinessAccount ba, Invoice invoice) throws DocumentException, IOException {
        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.33f, 0.33f, 0.33f});
        table.getDefaultCell().setPadding(4);

        String colorHexCode = ba.fInvoiceColor.getValue().hexCode();
        PdfPCell termsCell = createCellFromHtml("<span style=\"color:#" + colorHexCode + "; font-size: 8px;\">TERMS&nbsp;</span> <span style=\"font-size: 8px;\">" + invoice.fTermsConditions.getValue() + "</span>");
        PdfPCell notesCell = createCellFromHtml("<span style=\"color:#" + colorHexCode + "; font-size: 8px;\">NOTES&nbsp;</span> <span style=\"font-size: 8px;\">" + invoice.fNotes.getValue() + "</span>");
        PdfPCell thanksCell = createCellFromHtml("<span style=\"color:#" + colorHexCode + "; font-size: 8px;\">Thank you for choosing " + ba.fName.getValue() + "</span>");
        thanksCell.setVerticalAlignment(Element.ALIGN_MIDDLE);

        table.addCell(termsCell);
        table.addCell(notesCell);
        table.addCell(thanksCell);

        return table;
    }

    private static PdfPCell createCellFromHtml(String html) throws IOException {
        PdfPCell termsCell = new PdfPCell();
        termsCell.setBorder(Rectangle.NO_BORDER);
        StringReader reader = new StringReader(html);
        ArrayList<Element> elements = HTMLWorker.parseToList(reader, null);
        for (Element element : elements) {
            termsCell.addElement(element);
        }

        return termsCell;
    }

    private static PdfPTable createClientAndInvoiceSummaryTable(Invoice invoice, ClientSupplier cs, BaseColor invoiceColorScheme) throws DocumentException {
        float borderWidth = 0.3f;
        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.45f, 0.55f});
        table.getDefaultCell().setPadding(0);

        PdfPCell client = new PdfPCell();
        client.setBorderWidth(borderWidth);
        client.setBorder(Rectangle.TOP);
        client.addElement(getClientTable(cs));
        table.addCell(client);

        PdfPTable invoiceDetailsTable = new PdfPTable(3);
        invoiceDetailsTable.setWidthPercentage(100);
        invoiceDetailsTable.setWidths(new float[]{0.33f, 0.33f, 0.33f});
        invoiceDetailsTable.getDefaultCell().setPadding(0);

        PdfPCell issueDate = new PdfPCell();
        issueDate.setBorderWidth(borderWidth);
        issueDate.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);
        PdfPTable _table = new PdfPTable(1);
        _table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        _table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        _table.getDefaultCell().setPadding(0);

        _table.addCell(new Phrase("INVOICE DATE\n\n\n", new Font(FontFamily.HELVETICA, 7, Font.NORMAL, invoiceColorScheme)));
        _table.addCell(new Phrase(StringUtils.dateToStr(invoice.getDateRaised()) + "\n\n\n", new Font(FontFamily.HELVETICA, 10)));
        issueDate.addElement(_table);

        PdfPCell amount = new PdfPCell();
        amount.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        amount.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);
        amount.setBorderWidth(borderWidth);
        amount.setBackgroundColor(invoiceColorScheme);
        _table = new PdfPTable(1);
        _table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        _table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        _table.getDefaultCell().setPadding(0);
        _table.addCell(new Phrase("PLEASE PAY\n\n\n", new Font(FontFamily.HELVETICA, 7, Font.NORMAL, BaseColor.WHITE)));
        _table.addCell(new Phrase(StringUtils.numToStr(invoice.fValue.getValue()) + " " + invoice.fCurrency.getValueAsString() + "\n\n\n", new Font(FontFamily.HELVETICA, 10, Font.NORMAL, BaseColor.WHITE)));
        amount.addElement(_table);

        PdfPCell dueDate = new PdfPCell();
        dueDate.setBorder(Rectangle.BOTTOM | Rectangle.LEFT | Rectangle.RIGHT);
        dueDate.setBorderWidth(borderWidth);
        _table = new PdfPTable(1);
        _table.getDefaultCell().setBorder(Rectangle.NO_BORDER);
        _table.getDefaultCell().setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        _table.getDefaultCell().setPadding(0);
        _table.addCell(new Phrase("DUE DATE\n\n\n", new Font(FontFamily.HELVETICA, 7, Font.NORMAL, invoiceColorScheme)));
        _table.addCell(new Phrase(StringUtils.dateToStr(invoice.getDateDue()) + "\n\n\n", new Font(FontFamily.HELVETICA, 10)));
        dueDate.addElement(_table);

        invoiceDetailsTable.addCell(issueDate);
        invoiceDetailsTable.addCell(amount);
        invoiceDetailsTable.addCell(dueDate);

        PdfPCell invoiceDetails = new PdfPCell();
        invoiceDetails.setPadding(0);
        invoiceDetails.addElement(invoiceDetailsTable);
        invoiceDetails.setBorderWidth(borderWidth);
        invoiceDetails.setBorder(Rectangle.TOP);
        invoiceDetails.setVerticalAlignment(PdfPCell.ALIGN_TOP);

        table.addCell(invoiceDetails);

        return table;
    }

    private static PdfPTable getInvoiceDetailsTable(final Invoice invoice, Map<Long, TaxInfo> taxes, BaseColor colorScheme) throws DocumentException {
        PdfPTable table = new PdfPTable(7);

        table.setWidthPercentage(100);
        table.setWidths(new float[]{0.32f, 0.08f, 0.12f, 0.15f, 0.08f, 0.12f, 0.15f});

        table.addCell(getHeaderCell("Item", Element.ALIGN_CENTER, colorScheme));
        table.addCell(getHeaderCell("Quantity", Element.ALIGN_CENTER, colorScheme));
        table.addCell(getHeaderCell("Unit Price", Element.ALIGN_RIGHT, colorScheme));
        table.addCell(getHeaderCell("Price", Element.ALIGN_RIGHT, colorScheme));
        table.addCell(getHeaderCell("VAT %", Element.ALIGN_CENTER, colorScheme));
        table.addCell(getHeaderCell("VAT", Element.ALIGN_RIGHT, colorScheme));
        table.addCell(getHeaderCell("Total", Element.ALIGN_RIGHT, colorScheme));

        Map<String, Double> difTaxes = invoice.calculateTaxes(taxes);

        String currency = invoice.fCurrency.getValueAsString();
        for (int i = 0; i < invoice.getDetails().size(); i++) {
            InvoiceDetail idc = invoice.getDetails().get(i);
            table.addCell(getDescriptionCell(idc.fDescription.getValue()));
            table.addCell(getNumericCell(idc.fQuantity.getValue(), null));
            table.addCell(getNumericCell(idc.fPrice.getValue(), currency));
            double totalWithoutVat = idc.fQuantity.getValue() * idc.fPrice.getValue();
            table.addCell(getNumericCell(totalWithoutVat, currency));

            double vatValue = 0d;
            boolean hasVat = false;
            for (TaxInfo taxInfo : taxes.values()) {
                if (taxInfo.fIsVAT.getValue()) {
                    vatValue = idc.getTaxValue(taxInfo);
                    vatValue = invoice.calculateDiscounted(vatValue);
                    table.addCell(getNumericCell(taxInfo.getPercent(), "%"));
                    table.addCell(getNumericCell(vatValue, currency));
                    hasVat = true;
                    break;
                }
            }

            if (!hasVat) {
                table.addCell(getNumericCell(0d, "%"));
                table.addCell(getNumericCell(0d, currency));
            }

            table.addCell(getNumericCell(totalWithoutVat + vatValue, currency));
        }

        table.addCell(getFooterInvoiceLabelCell("Discount"));
        table.addCell(getNumericCell(invoice.fDiscount.getValue(), "%"));

        for (String taxName : difTaxes.keySet()) {
            double taxSum = difTaxes.get(taxName);
            table.addCell(getFooterInvoiceLabelCell(taxName));
            table.addCell(getNumericCell(taxSum, currency));
        }

        table.addCell(getFooterInvoiceLabelCell("TOTAL"));
        table.addCell(getNumericCell(invoice.fValue.getValue(), currency));

        table.setTableEvent(new PdfPTableEvent() {
            @Override
            public void tableLayout(PdfPTable table, float[][] widths, float[] heights, int headerRows, int rowStart, PdfContentByte[] canvases) {
                int columns;
                Rectangle rect;
                for (int row = 2; row <= invoice.getDetails().size(); row += 2) {
                    columns = widths[row].length - 1;
                    rect = new Rectangle(widths[row][0], heights[row], widths[row][columns], heights[row + 1]);
                    rect.setBackgroundColor(new BaseColor(0xEEEEEE));
                    rect.setBorder(Rectangle.NO_BORDER);
                    canvases[PdfPTable.BASECANVAS].rectangle(rect);
                }
            }
        });

        return table;
    }

    private static PdfPCell getFooterInvoiceLabelCell(String string) {
        PdfPCell testColspan = new PdfPCell();
        testColspan.setColspan(6);
        testColspan.setBorderWidth(0.0f);
        testColspan.setHorizontalAlignment(Element.ALIGN_RIGHT);
        testColspan.setVerticalAlignment(Element.ALIGN_MIDDLE);
        testColspan.setPhrase(new Phrase(string, HELVETICA_8_BOLD));
        return testColspan;
    }

    private static PdfPCell getNumericCell(Double value, String suffix) {
        PdfPCell cell = new PdfPCell();
        cell.setBorderWidth(0.1f);
        cell.setPadding(5f);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
        cell.setPhrase(new Phrase(StringUtils.numToStr(value) + " " + StringUtils.emptyIfNullStr(suffix), HELVETICA_8_REGULAR));
        return cell;
    }

    private static PdfPCell getDescriptionCell(String desc) {
        PdfPCell cell = new PdfPCell();
        cell.setBorderWidth(0.1f);
        cell.setPadding(5f);
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        cell.setPhrase(new Phrase(desc, HELVETICA_8_REGULAR));
        return cell;
    }

    private static PdfPCell getHeaderCell(String string, int align, BaseColor colorScheme) {
        PdfPCell cell = new PdfPCell();
        if (Element.ALIGN_RIGHT == align) {
            cell.setPaddingRight(5f);
        }
        cell.setBackgroundColor(colorScheme);
        cell.setBorderWidth(0.1f);
        cell.setHorizontalAlignment(align);
        cell.setVerticalAlignment(Element.ALIGN_TOP);
        Phrase phrase = new Phrase(string, HELVETICA_8_REGULAR_WHITE);
        cell.setPhrase(phrase);
        return cell;
    }

    @SuppressWarnings("unused")
    private static PdfPTable getSeparator() {
        PdfPTable table = new PdfPTable(1);
        table.addCell(getEmptyCell());
        PdfPCell cell = new PdfPCell();
        cell.setBorderWidth(2f);
        cell.setBorderColorBottom(BaseColor.WHITE); // FIXME
        cell.setBorderColorRight(BaseColor.WHITE);
        cell.setBorderColorLeft(BaseColor.WHITE);
        table.addCell(cell);
        table.addCell(getEmptyCell());
        return table;
    }

    private static PdfPCell getEmptyCell() {
        PdfPCell cell = new PdfPCell();
        cell.setBorder(Rectangle.NO_BORDER);
        cell.addElement(new Phrase(""));
        return cell;
    }
}
