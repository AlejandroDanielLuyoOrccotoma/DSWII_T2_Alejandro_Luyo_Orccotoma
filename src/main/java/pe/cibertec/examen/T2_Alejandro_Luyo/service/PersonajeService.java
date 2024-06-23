package pe.cibertec.examen.T2_Alejandro_Luyo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.bd.Personaje;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.dto.PersonajeDto;
import pe.cibertec.examen.T2_Alejandro_Luyo.repository.PersonajeRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonajeService implements IPersonajeService {

    private final PersonajeRepository personajeRepository;

    @Override
    public List<PersonajeDto> listarPersonajes() {
        return personajeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PersonajeDto> buscarPersonajePorId(Integer id) {
        return personajeRepository.findById(id)
                .map(this::convertToDTO);
    }

    @Override
    public PersonajeDto registrarPersonaje(PersonajeDto PersonajeDto) {
        Personaje personaje = convertDtoToEntity(PersonajeDto);
        return convertToDTO(personajeRepository.save(personaje));
    }

    @Override
    public PersonajeDto modificarPersonaje(Integer id, PersonajeDto PersonajeDto) {
        if (personajeRepository.existsById(id)) {
            Personaje personaje = convertDtoToEntity(PersonajeDto);
            personaje.setIdPersonaje(id);
            return convertToDTO(personajeRepository.save(personaje));
        }
        return null;
    }

    @Override
    public void eliminarPersonajePorId(Integer id) {
        personajeRepository.deleteById(id);
    }

    private PersonajeDto convertToDTO(Personaje personaje) {
        PersonajeDto dto = new PersonajeDto();
        dto.setIdPersonaje(personaje.getIdPersonaje());
        dto.setNomPersonaje(personaje.getNomPersonaje());
        dto.setApePersonaje(personaje.getApePersonaje());
        dto.setFechNacPersonaje(personaje.getFechNacPersonaje());
        return dto;
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
