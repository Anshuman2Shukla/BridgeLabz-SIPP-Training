
interface Exporter {
    void export();
    default void exportToJSON() {
        System.out.println("Default JSON export");
    }
}

class CSVExporter implements Exporter {
    public void export() { System.out.println("Exported CSV"); }
}

class PDFExporter implements Exporter {
    public void export() { System.out.println("Exported PDF"); }
}

public class Problem11_DataExport {
    public static void main(String[] args) {
        Exporter csv = new CSVExporter();
        csv.export();
        csv.exportToJSON();
    }
}
