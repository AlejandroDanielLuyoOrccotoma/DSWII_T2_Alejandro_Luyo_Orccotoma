package pe.cibertec.examen.T2_Alejandro_Luyo.service;

import pe.cibertec.examen.T2_Alejandro_Luyo.model.dto.ProgramaTvDto;

import java.util.List;
import java.util.Optional;

public interface IProgramaTvService {
    List<ProgramaTvDto> listarProgramas();
    Optional<ProgramaTvDto> buscarProgramaPorId(Integer id);
    ProgramaTvDto registrarPrograma(ProgramaTvDto programaTvDTO);
    ProgramaTvDto modificarPrograma(Integer id, ProgramaTvDto programaTvDTO);
    void eliminarProgramaPorId(Integer id);
}
