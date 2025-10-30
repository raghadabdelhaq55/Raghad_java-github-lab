public class Main {
    public static void main(String[] args) {
        Report report = new Report("Monthly Sales", "Sales increased by 15% in October.");
        ReportService service = new ReportService();

        ReportExporter textExporter = new TextReportExporter();
        ReportExporter jsonExporter = new JsonReportExporter();
        ReportExporter pdfExporter  = new PdfReportExporter(); //New exporter part 8

        service.generateReport(report, textExporter);
        service.generateReport(report, jsonExporter);
        service.generateReport(report, pdfExporter); // New exporter part 8
    }
}

