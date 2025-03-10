package org.example.exameninterfaces.services;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.example.exameninterfaces.model.Item;
import org.example.exameninterfaces.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ReportService {

    private final ItemRepository itemRepository;

    @Autowired
    public ReportService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    public byte[] generarInforme() {
        try {
            List<Item> listaItems = itemRepository.findAll();

            // si fuera archivo jrxml se le pasaría y luego se compila
            /*
            Me he liado, no he caido que csv era nativo de Jaspersoft pensé que era parecido a hacerlo con MongoDB
             */
            InputStream report = getClass().getResourceAsStream("/reports/store_data.csv");

            JasperReport reportJasper = JasperCompileManager.compileReport(report);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaItems);

            JasperPrint jp = JasperFillManager.fillReport(reportJasper, null,dataSource);

            return JasperExportManager.exportReportToPdf(jp);

        } catch (JRException e) {
            throw new RuntimeException(e);
        }
    }
}
