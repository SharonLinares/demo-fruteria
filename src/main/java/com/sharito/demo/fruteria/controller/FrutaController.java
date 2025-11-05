package com.sharito.demo.fruteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sharito.demo.fruteria.dto.FrutaDto;
import com.sharito.demo.fruteria.service.FrutaService;

@RestController
@RequestMapping("/frutas")
public class FrutaController {

	@Autowired
	private FrutaService frutaService;

	@PostMapping
	public ResponseEntity<FrutaDto> crear(@RequestBody FrutaDto frutaDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(frutaService.crear(frutaDto));
	}

	@PutMapping("/modificar/{id}")
	public ResponseEntity<FrutaDto> modificar(@RequestBody FrutaDto frutaDto, @PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.CREATED).body(frutaService.modificar(frutaDto, id));
	}

	@GetMapping
	public ResponseEntity<List<FrutaDto>> consultarFrutas() {
		return ResponseEntity.ok(frutaService.consultarFrutas());
	}
	
	@GetMapping("/consultarporid/{id}")
	public ResponseEntity<FrutaDto> consultarFrutaPorId(@PathVariable Integer id) {
		return ResponseEntity.ok(frutaService.consultarFrutaPorId(id));
	}

	@DeleteMapping("/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
		frutaService.eliminar(id);
		return ResponseEntity.noContent().build();

	}

}
