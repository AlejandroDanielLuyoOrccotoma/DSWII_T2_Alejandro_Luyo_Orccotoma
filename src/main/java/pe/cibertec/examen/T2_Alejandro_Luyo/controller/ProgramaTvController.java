package pe.cibertec.examen.T2_Alejandro_Luyo.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.cibertec.examen.T2_Alejandro_Luyo.model.dto.ProgramaTvDto;
import pe.cibertec.examen.T2_Alejandro_Luyo.service.IProgramaTvService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/programatv")
public class ProgramaTvController {

    private IProgramaTvService programaTvService;

    @GetMapping("")
    public ResponseEntity<List<ProgramaTvDto>> listarProgramas() {
        List<ProgramaTvDto> programaList = new ArrayList<>(programaTvService.listarProgramas());
        if (programaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(programaList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProgramaTvDto> buscarProgramaPorId(@PathVariable Integer id) {
        Optional<ProgramaTvDto> programaTv = programaTvService.buscarProgramaPorId(id);
        return programaTv.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ResponseEntity<ProgramaTvDto> registrarPrograma(@RequestBody ProgramaTvDto programaTvDTO) {
        ProgramaTvDto nuevoProgramaTv = programaTvService.registrarPrograma(programaTvDTO);
        return new ResponseEntity<>(nuevoProgramaTv, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProgramaTvDto> modificarPrograma(@PathVariable Integer id, @RequestBody ProgramaTvDto programaTvDTO) {
        ProgramaTvDto updatedProgramaTv = programaTvService.modificarPrograma(id, programaTvDTO);
        if (updatedProgramaTv != null) {
            return new ResponseEntity<>(updatedProgramaTv, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProgramaPorId(@PathVariable Integer id) {
        programaTvService.eliminarProgramaPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
