package pe.cibertec.examen.T2_Alejandro_Luyo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.bd.Personaje;

@Repository
public interface PersonajeRepository extends JpaRepository<Personaje, Integer> {
}