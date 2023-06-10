package br.com.example.controller;

import java.util.List;
import br.com.example.repository.EstadoRepository;
import br.com.example.model.EstadoVO;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@OpenAPIDefinition(info = @Info(title = "Projeto Beta WN  API", version = "1.0", description = "Dados por Estados e Região"))
public class EstadoController {
    
    @Autowired
    private EstadoRepository repository;
    
    
    
    
     @GetMapping("/distanciaEntreEstados/{estadoA}/{estadoB}")
     public Double distanciaEntreEstados(@PathVariable String estadoA, @PathVariable String estadoB){
        double result = repository.distanciaEntreEstados(estadoA, estadoB);
        return result;
    }    
   
    @GetMapping("/estadosVizinhos/{nome}")
    public List<EstadoVO> estadosVizinhos(@PathVariable String nome){
        List<EstadoVO> result = repository.listarEstadosVizinhos(nome);
        return result;
    }
    
     @GetMapping("/estadosPorRegiao/{regiao}")
    public List<EstadoVO> estados_Por_Regiao(@PathVariable String regiao){
        List<EstadoVO> result = repository.listarEstadosPorRegiao(regiao);
        return result;
    }
}