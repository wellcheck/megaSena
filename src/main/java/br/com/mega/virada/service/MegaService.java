package br.com.mega.virada.service;

import br.com.mega.virada.model.MegaResult;
import br.com.mega.virada.repository.MegaResultRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class MegaService {

    @Autowired
    private MegaResultRepository repository;


    public List<MegaResult> adicionarResultados(MultipartFile file) throws IOException {
        List<MegaResult> megaResults = new ArrayList<>();
        try (InputStream excelArquivo = file.getInputStream()) {
            XSSFWorkbook workbook = new XSSFWorkbook(excelArquivo);
            XSSFSheet planilha = workbook.getSheetAt(0);

            Iterator<Row> linhaItarator = planilha.iterator();
            linhaItarator.next();

            while(linhaItarator.hasNext()){
                Row linha = linhaItarator.next();
                Iterator<Cell> cellIterator = linha.iterator();

                while(cellIterator.hasNext()){
                    Cell celula = cellIterator.next();

                    switch (celula.getColumnIndex()){
                        case 0:
                            System.out.println("Concurso: " + celula.getNumericCellValue());
                            var con = celula.getNumericCellValue();
                            MegaResult res = MegaResult.
                                    builder()
                                    .concurso((int) con)
                                    .build();
                            repository.save(res);
                            break;
                        case 1:
                            System.out.println("Data: " + celula.getStringCellValue());
                            break;
                        case 2:
                            System.out.println("Bola 1: " + celula.getNumericCellValue());
                            break;
                        case 3:
                            System.out.println("Bola 2: " + celula.getNumericCellValue());
                            break;
                        case 4:
                            System.out.println("Bola 3: " + celula.getNumericCellValue());
                            break;
                        case 5:
                            System.out.println("Bola 4: " + celula.getNumericCellValue());
                            break;
                        case 6:
                            System.out.println("Bola 5: " + celula.getNumericCellValue());
                            break;
                        case 7:
                            System.out.println("Bola 6: " + celula.getNumericCellValue());
                            break;
                        default:
                    }

                    }
                }
        }

        catch (FileNotFoundException e){
            System.out.println("Arquivo não encontrado!" + e );
        }catch (IOException e2){
            System.out.println("Erro ao processar o arquivo!" + e2);
        }
        return megaResults;
    }

}