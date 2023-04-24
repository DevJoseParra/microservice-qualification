package com.joseparra.qualificationmicroservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.joseparra.qualificationmicroservice.entities.Qualification;

@Repository
public interface IQualificationRepository extends JpaRepository<Qualification, Long> {

	public List<Qualification> findByUserId(Long userId);

	public List<Qualification> findByHotelId(Long hotelId);

}
