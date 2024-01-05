package br.com.mega.virada.controller;

import br.com.mega.virada.model.MegaResult;
import br.com.mega.virada.service.MegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/mega")
public class MegaController {

    @Autowired
    private MegaService service;

    @PostMapping("/upload")
    public ResponseEntity<MegaResult> uploadArquivo(@RequestParam("file") MultipartFile file){
        try{
            service.adicionarResultados(file);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (IOException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
