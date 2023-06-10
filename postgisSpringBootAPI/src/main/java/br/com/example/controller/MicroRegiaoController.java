package br.com.example.controller;

import java.util.List;
import br.com.example.repository.MicroRegiaoRepository;
import br.com.example.model.MicroRegiaoVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Projeto Beta WN  API", version = "1.0", description = "Dados de MicroRegiões"))
public class MicroRegiaoController {
    
    @Autowired
    private MicroRegiaoRepository repository;
     
    @GetMapping("/microRegiaoVizinhas/{sigla}")
    public List<MicroRegiaoVO> microRegiaoVizinhas(@PathVariable String sigla){
        List<MicroRegiaoVO> result = repository.listarMicroRegiaoVizinhas(sigla);
        return result;
    }
    
    @GetMapping("/microregiaoPorMesoregiao/{sigla}")
    public List<MicroRegiaoVO> microregiaoPorMesoregiao(@PathVariable String sigla){
        List<MicroRegiaoVO> result = repository.listarMicroRegiaoPorMesoregiao(sigla);
        return result;
    } 
     
 } 