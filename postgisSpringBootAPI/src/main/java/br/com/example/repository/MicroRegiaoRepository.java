package br.com.example.repository;

import br.com.example.model.MicroRegiao;
import br.com.example.model.MicroRegiaoVO;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MicroRegiaoRepository extends JpaRepository<MicroRegiao, Integer>{
    
    @Query(value = "select new br.com.example.model.MicroRegiaoVO(mb.codigo,mb.sigla) from MicroRegiao ma, MicroRegiao mb where touches(ma.geometria, mb.geometria) = true and ma.sigla = :sigla")
    List<MicroRegiaoVO> listarMicroRegiaoVizinhas(String sigla);
  
    @Query(value = "select new br.com.example.model.MicroRegiaoVO(ab.codigo,ab.sigla) from MicroRegiao aa, MesoRegiao ab where within(aa.geometria, ab.geometria) = true and aa.sigla = :sigla")
    List<MicroRegiaoVO> listarMicroRegiaoPorMesoregiao(String sigla);
    
    
}