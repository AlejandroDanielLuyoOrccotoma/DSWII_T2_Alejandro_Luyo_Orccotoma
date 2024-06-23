package pe.cibertec.examen.T2_Alejandro_Luyo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.dto.PersonajeDto;
import pe.cibertec.examen.T2_Alejandro_Luyo.service.IPersonajeService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/personaje")
public class PersonajeController {

    private IPersonajeService personajeService;

    @GetMapping("")
    public ResponseEntity<List<PersonajeDto>> listarPersonajes() {
        List<PersonajeDto> personajeList = new ArrayList<>(personajeService.listarPersonajes());
        if(personajeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personajeList,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonajeDto> buscarPersonajePorId(@PathVariable Integer id) {
        Optional<PersonajeDto> personaje = personajeService.buscarPersonajePorId(id);
        return personaje.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<PersonajeDto> registrarPersonaje(@RequestBody PersonajeDto personajeDTO) {
        PersonajeDto nuevoPersonaje = personajeService.registrarPersonaje(personajeDTO);
        return new ResponseEntity<>(nuevoPersonaje, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonajeDto> modificarPersonaje(@PathVariable Integer id, @RequestBody PersonajeDto personajeDTO) {
        PersonajeDto updatedPersonaje = personajeService.modificarPersonaje(id, personajeDTO);
        if (updatedPersonaje != null) {
            return new ResponseEntity<>(updatedPersonaje, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPersonajePorId(@PathVariable Integer id) {
        personajeService.eliminarPersonajePorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
