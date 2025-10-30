public class ReportService {
    public void generateReport(Report report, ReportExporter exporter) {
        System.out.println("Generating report: " + report.getTitle());
        exporter.export(report);
        System.out.println("----");
    }
}
