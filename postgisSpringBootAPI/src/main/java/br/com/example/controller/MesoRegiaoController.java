package br.com.example.controller;

import java.util.List;
import br.com.example.repository.MesoRegiaoRepository;
import br.com.example.model.MesoRegiaoVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Projeto Beta WN  API", version = "1.0", description = "Dados de MesoRegiões"))
public class MesoRegiaoController {
    
   
    
    @Autowired
    private MesoRegiaoRepository repository;
    
    
    @GetMapping("/mesoRegiaoVizinhas/{sigla}")
    public List<MesoRegiaoVO> mesoRegiaoVizinhas(@PathVariable String sigla){
        List<MesoRegiaoVO> result = repository.listarMesoRegiaoVizinhas(sigla);
        return result;
    }
}


    
   
   