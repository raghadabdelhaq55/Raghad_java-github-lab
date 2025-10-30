public class JsonReportExporter implements ReportExporter {
    @Override
    public void export(Report report) {
        System.out.println("Exporting report as JSON...");
        System.out.println("{ \"title\": \"" + report.getTitle() + "\", \"content\": \"" + report.getContent() + "\" }");
    }
}
