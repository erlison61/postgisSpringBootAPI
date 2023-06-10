package br.com.example.repository;

import br.com.example.model.MesoRegiao;
import br.com.example.model.MesoRegiaoVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface MesoRegiaoRepository extends JpaRepository<MesoRegiao, Integer>{
    
@Query(value = "select new br.com.example.model.MesoRegiaoVO(mb.codigo,mb.nome,mb.sigla) from MesoRegiao ma, Estado mb where touches(ma.geometria, mb.geometria) = true and ma.sigla = :sigla")
    List<MesoRegiaoVO> listarMesoRegiaoVizinhas(String sigla);
}