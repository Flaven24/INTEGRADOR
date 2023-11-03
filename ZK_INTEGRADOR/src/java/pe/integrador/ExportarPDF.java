package pe.integrador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.zkoss.util.media.AMedia;
import org.zkoss.zul.Filedownload;

/**
 *
 * @author Acer
 */
public class ExportarPDF {

    public static void exportJasperToPdf(String nombre, JRBeanCollectionDataSource data, HashMap parametro, String ruta) {
//        try {
//            ExportarPDF exportarPdf = new ExportarPDF();
//            parametro.put(JRParameter.REPORT_LOCALE, new Locale("es", "US"));
//            InputStream is = exportarPdf.getClass().getClassLoader().getResourceAsStream(ruta);
//            JasperPrint jasperprint = JasperFillManager.fillReport(is, parametro, data);
//            //JasperExportManager.exportReportToPdfStream(jasperprint, out);
//            JasperExportManager.exportReportToPdfFile(jasperprint, "D:/"+nombre+".pdf");
////            ByteArrayOutputStream out = new ByteArrayOutputStream();
////            ExportarPDF exportarPdf = new ExportarPDF();
////            parametro.put(JRParameter.REPORT_LOCALE, new Locale("es", "US"));
////            InputStream is = exportarPdf.getClass().getClassLoader().getResourceAsStream(ruta);
////            JasperPrint jasperprint = JasperFillManager.fillReport(is, parametro, data);
////            JasperExportManager.exportReportToPdfStream(jasperprint, out);
////            AMedia amedia = new AMedia(nombre + ".pdf", "pdf", ruta, out.toByteArray());
////            Filedownload.save(amedia);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException(e.getMessage());
//        }
    }

    public static void reporte(String nombre, JRBeanCollectionDataSource data, HashMap parametro, String ruta) {
        try {
            JasperReport jr = JasperCompileManager.compileReport(ruta);
            JasperPrint jp = JasperFillManager.fillReport(jr, parametro, data);
            byte[] pdfBytes = JasperExportManager.exportReportToPdf(jp);
            AMedia amedia = new AMedia(nombre + ".pdf", "pdf", ruta, pdfBytes);
            Filedownload.save(amedia);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
