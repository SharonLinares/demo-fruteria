package com.sharito.demo.fruteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public FrutaDto crear(@RequestBody FrutaDto frutaDto) {
		return frutaService.crear(frutaDto);
	}

	@PutMapping("/modificar/{id}")
	public FrutaDto modificar(@RequestBody FrutaDto frutaDto, @PathVariable Integer id) {
		return frutaService.modificar(frutaDto, id);
	}

	@GetMapping
	public List<FrutaDto> consultarFrutas() {
		return frutaService.consultarFrutas();
	}

	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable Integer id) {
		frutaService.eliminar(id);
	}

}
