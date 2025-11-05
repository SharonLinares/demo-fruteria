package com.sharito.demo.fruteria.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sharito.demo.fruteria.dto.FrutaDto;
import com.sharito.demo.fruteria.entity.FrutaEntity;
import com.sharito.demo.fruteria.repository.FrutaRepository;

@Service
public class FrutaService {

	private FrutaRepository frutaRepository;

	public FrutaService(FrutaRepository frutaRepository) {
		super();
		this.frutaRepository = frutaRepository;
	}

	public FrutaDto crear(FrutaDto frutaDto) {
		FrutaEntity frutaEntity = new FrutaEntity();
		frutaEntity.setNombre(frutaDto.getNombre());
		frutaEntity.setPrecio(frutaDto.getPrecio());
		frutaRepository.save(frutaEntity);
		frutaDto.setId(frutaEntity.getId());
		return frutaDto;
	}

	public FrutaDto modificar(FrutaDto frutaDto, Integer id) {
		FrutaEntity frutaEntity = frutaRepository.findById(id).orElse(null);
		if (frutaEntity != null) {
			frutaEntity.setNombre(frutaDto.getNombre());
			frutaEntity.setPrecio(frutaDto.getPrecio());
			frutaRepository.save(frutaEntity);
			frutaDto.setId(frutaEntity.getId());

		}
		return frutaDto;
	}

	public List<FrutaDto> consultarFrutas() {
		List<FrutaEntity> frutasEntity = frutaRepository.findAll();
		List<FrutaDto> frutasDto = new ArrayList<>();
		for (FrutaEntity frutaEntity : frutasEntity) {
			FrutaDto frutaDto = new FrutaDto();
			frutaDto.setNombre(frutaEntity.getNombre());
			frutaDto.setPrecio(frutaEntity.getPrecio());
			frutaDto.setId(frutaEntity.getId());
			frutasDto.add(frutaDto);

		}

		return frutasDto;
	}

	public FrutaDto consultarFrutaPorId(Integer id) {
		FrutaEntity frutaEntity = frutaRepository.findById(id).orElse(null);
		FrutaDto frutaDto = new FrutaDto();
		frutaDto.setId(frutaEntity.getId());
		frutaDto.setNombre(frutaEntity.getNombre());
		frutaDto.setPrecio(frutaEntity.getPrecio());
		return frutaDto;

	}

	public void eliminar(Integer id) {
		if (frutaRepository.existsById(id)) {
			frutaRepository.deleteById(id);
		}

	}

}
