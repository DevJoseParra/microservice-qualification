package com.joseparra.qualificationmicroservice.services;

import java.util.List;

import com.joseparra.qualificationmicroservice.dtos.QualificationDto;

public interface IQualificationService {

	public QualificationDto createQualification(QualificationDto qualificationDto);

	public List<QualificationDto> listAllQualification();

	public List<QualificationDto> listAllQualificationByUser(Long userId);

	public List<QualificationDto> listAllQualificationByHotel(Long hotelId);

}
