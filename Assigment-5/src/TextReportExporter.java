public class TextReportExporter implements ReportExporter {
    @Override
    public void export(Report report) {
        System.out.println("Exporting report as TEXT...");
        System.out.println("Title: " + report.getTitle());
        System.out.println("Content: " + report.getContent());
    }
}

