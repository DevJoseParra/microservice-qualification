package com.joseparra.qualificationmicroservice.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.joseparra.qualificationmicroservice.dtos.QualificationDto;
import com.joseparra.qualificationmicroservice.entities.Qualification;
import com.joseparra.qualificationmicroservice.repositories.IQualificationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QualificationServiceImpl implements IQualificationService {

	private final IQualificationRepository qualificationRepository;

	private final ModelMapper modelMapper;

	@Override
	public QualificationDto createQualification(QualificationDto qualificationDto) {
		return modelMapper.map(qualificationRepository.save(modelMapper.map(qualificationDto, Qualification.class)),
				QualificationDto.class);
	}

	@Override
	public List<QualificationDto> listAllQualification() {
		List<Qualification> listAllQualification = qualificationRepository.findAll();
		return listAllQualification.stream()
				.map(qualification -> modelMapper.map(qualification, QualificationDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<QualificationDto> listAllQualificationByUser(Long userId) {

		List<Qualification> listAllQualificationUser = qualificationRepository.findByUserId(userId);
		return listAllQualificationUser.stream()
				.map(qualification -> modelMapper.map(qualification, QualificationDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public List<QualificationDto> listAllQualificationByHotel(Long hotelId) {

		List<Qualification> listAllQualificationHotel = qualificationRepository.findByHotelId(hotelId);
		return listAllQualificationHotel.stream()
				.map(qualification -> modelMapper.map(qualification, QualificationDto.class))
				.collect(Collectors.toList());
	}

}
