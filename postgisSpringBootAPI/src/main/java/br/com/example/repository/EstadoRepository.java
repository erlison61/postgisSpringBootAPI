package br.com.example.repository;

import br.com.example.model.Estado;
import br.com.example.model.EstadoVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface EstadoRepository extends JpaRepository<Estado, Integer>{
    
 
    @Query(value ="select distance(geometry(ea.geometria), geometry(eb.geometria)) from Estado ea, Estado eb where ea.nome = :estadoA  and   eb.nome = :estadoB")
    public Double distanciaEntreEstados(String estadoA, String estadoB);
    
    @Query(value = "select new br.com.example.model.EstadoVO(eb.codigo,eb.nome) from Estado ea, Estado eb where touches(ea.geometria, eb.geometria) = true and ea.nome = :nome")
    List<EstadoVO> listarEstadosVizinhos(String nome);
     
    @Query(value = "select new br.com.example.model.EstadoVO(eb.codigo,eb.nome) from Estado ea, Estado eb where within(ea.geometria, eb.geometria) = true and ea.regiao = :regiao")
    List<EstadoVO> listarEstadosPorRegiao(String regiao);
    
 
}
