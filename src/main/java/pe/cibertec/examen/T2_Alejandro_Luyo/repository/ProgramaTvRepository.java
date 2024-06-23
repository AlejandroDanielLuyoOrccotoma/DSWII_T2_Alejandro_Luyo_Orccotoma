package pe.cibertec.examen.T2_Alejandro_Luyo.repository;

import pe.cibertec.examen.T2_Alejandro_Luyo.model.bd.ProgramaTv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramaTvRepository extends JpaRepository<ProgramaTv, Integer> {
}
