package pe.cibertec.examen.T2_Alejandro_Luyo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.bd.Personaje;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.bd.ProgramaTv;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.dto.PersonajeDto;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.dto.ProgramaTvDto;
import pe.cibertec.examen.T2_Alejandro_Luyo.repository.ProgramaTvRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProgramaTvService implements IProgramaTvService {

    private final ProgramaTvRepository programaTvRepository;
    private final IPersonajeService personajeService;

    @Override
    public List<ProgramaTvDto> listarProgramas() {
        return programaTvRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProgramaTvDto> buscarProgramaPorId(Integer id) {
        return programaTvRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public ProgramaTvDto registrarPrograma(ProgramaTvDto programaTvDto) {
        ProgramaTv programaTv = convertToEntity(programaTvDto);
        return convertToDTO(programaTvRepository.save(programaTv));
    }

    @Override
    public ProgramaTvDto modificarPrograma(Integer id, ProgramaTvDto programaTvDto) {
        if (programaTvRepository.existsById(id)) {
            ProgramaTv programaTv = convertToEntity(programaTvDto);
            programaTv.setIdProgramaTv(id);
            return convertToDTO(programaTvRepository.save(programaTv));
        }
        return null;
    }

    @Override
    public void eliminarProgramaPorId(Integer id) {
        programaTvRepository.deleteById(id);
    }

    private ProgramaTvDto convertToDTO(ProgramaTv programaTv) {
        ProgramaTvDto dto = new ProgramaTvDto();
        dto.setIdProgramaTv(programaTv.getIdProgramaTv());
        dto.setTitulo(programaTv.getTitulo());
        dto.setResumen(programaTv.getResumen());
        dto.setFechaInicio(programaTv.getFechaInicio());
        dto.setIdPersonaje(programaTv.getPersonaje().getIdPersonaje());
        return dto;
    }

    private ProgramaTv convertToEntity(ProgramaTvDto dto) {
        ProgramaTv programaTv = new ProgramaTv();
        programaTv.setIdProgramaTv(dto.getIdProgramaTv());
        programaTv.setTitulo(dto.getTitulo());
        programaTv.setResumen(dto.getResumen());
        programaTv.setFechaInicio(dto.getFechaInicio());
        PersonajeDto personajeDTO = personajeService.buscarPersonajePorId(dto.getIdPersonaje()).orElse(null);
        if (personajeDTO != null) {
            Personaje personaje = convertDtoToEntity(personajeDTO);
            programaTv.setPersonaje(personaje);
        }
        return programaTv;
    }

    private Personaje convertDtoToEntity(PersonajeDto dto) {
        Personaje personaje = new Personaje();
        personaje.setIdPersonaje(dto.getIdPersonaje());
        personaje.setNomPersonaje(dto.getNomPersonaje());
        personaje.setApePersonaje(dto.getApePersonaje());
        personaje.setFechNacPersonaje(dto.getFechNacPersonaje());
        return personaje;
    }
}
