class BadReportService {
    public void export(Report report, String format) {
        if (format.equals("TEXT")) {
            System.out.println("Exporting as TEXT: " + report.getTitle());
        } else if (format.equals("JSON")) {
            System.out.println("Exporting as JSON: " + report.getTitle());
        } else if (format.equals("PDF")) {
            System.out.println("Exporting as PDF: " + report.getTitle());
        }
        // Adding XML later => must edit this method (violates OCP) + mixed responsibilities (violates SRP)
    }
}
