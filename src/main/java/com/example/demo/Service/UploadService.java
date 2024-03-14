package com.ejemplo.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ejemplo.backend.model.UploadResponse;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;

@Service
public class UploadService {

    @Autowired
    private YourRepository yourRepository; // Reemplaza YourRepository por tu repositorio de Spring Data JPA

    // Método para procesar la carga de archivos
    public UploadResponse processUpload(MultipartFile file) throws IOException {
        try (InputStream inputStream = file.getInputStream()) {
            // Leemos el archivo Excel
            Workbook workbook = new XSSFWorkbook(inputStream);

            // Recorremos las hojas del archivo Excel
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);

                // Leemos las filas de la hoja
                for (Row row : sheet) {
                    // Ignoramos la primera fila que generalmente contiene los nombres de las columnas
                    if (row.getRowNum() == 0) {
                        continue;
                    }

                    // Aquí debes adaptar la lógica para leer los datos de cada fila y
                    // realizar las inserciones en la base de datos utilizando tu repositorio

                    // Ejemplo:
                    // String columna1 = row.getCell(0).getStringCellValue();
                    // int columna2 = (int) row.getCell(1).getNumericCellValue();
                    // YourEntity entidad = new YourEntity(columna1, columna2);
                    // yourRepository.save(entidad);
                }
            }
            return new UploadResponse("Archivo cargado exitosamente.");
        } catch (IOException e) {
            throw new IOException("Error al procesar el archivo.");
        }
    }
}
