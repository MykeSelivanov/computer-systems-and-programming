package oop.creationaldesignpatterns.factory;

public class Main {
    public static void main(String[] args) {
        DocumentFactory docFactory = new DocFactory();
        Document doc = docFactory.createDocument();
        doc.open();

        DocumentFactory pdfFactory = new PdfFactory();
        Document pdf = pdfFactory.createDocument();
        pdf.open();
    }
}
