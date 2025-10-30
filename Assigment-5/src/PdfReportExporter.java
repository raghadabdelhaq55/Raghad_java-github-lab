public class PdfReportExporter implements ReportExporter {
    @Override
    public void export(Report report) {
        System.out.println("Exporting report as PDF...");
        System.out.println("[PDF] Title: " + report.getTitle());
        System.out.println("[PDF] Content: " + report.getContent());
    }
}

