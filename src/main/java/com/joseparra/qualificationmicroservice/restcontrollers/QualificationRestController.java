package com.joseparra.qualificationmicroservice.restcontrollers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joseparra.qualificationmicroservice.dtos.QualificationDto;
import com.joseparra.qualificationmicroservice.services.IQualificationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "/api/qualification/v1")
@Slf4j
public class QualificationRestController {

	@Autowired
	private IQualificationService qualificationService;

	@PostMapping(value = "/create")
	public ResponseEntity<?> createQualification(@Valid @RequestBody QualificationDto qualificationDto,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			StringBuilder messageErrors = this.messageErrors(bindingResult);
			log.error(messageErrors.toString());
			return new ResponseEntity<>(messageErrors, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(qualificationService.createQualification(qualificationDto));
	}

	@GetMapping(value = "/all")
	public ResponseEntity<?> getAllQualification() {
		log.info("--LISTING QUALIFICATION--");
		List<QualificationDto> listQualification = qualificationService.listAllQualification();
		if (listQualification.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There are't qualification.");
		}
		return ResponseEntity.ok(listQualification);
	}

	@GetMapping(value = "/all_by_user/{id}")
	public ResponseEntity<?> getAllQualificationByUser(@PathVariable("id") Long idUser) {
		log.info("--LISTING QUALIFICATION BY USER--");
		List<QualificationDto> listQualificationByUser = qualificationService.listAllQualificationByUser(idUser);
		if (listQualificationByUser.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There are't qualification by the user.");
		}
		return ResponseEntity.ok(listQualificationByUser);
	}

	@GetMapping(value = "/all_by_hotel/{id}")
	public ResponseEntity<?> getAllQualificationByHotel(@PathVariable("id") Long idHotel) {
		log.info("--LISTING QUALIFICATION BY HOTEL--");
		List<QualificationDto> listQualificationByHotel = qualificationService.listAllQualificationByHotel(idHotel);
		if (listQualificationByHotel.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("There are't qualification for the hotel.");
		}
		return ResponseEntity.ok(listQualificationByHotel);
	}

	private StringBuilder messageErrors(BindingResult bindingResult) {
		StringBuilder messageErrors = new StringBuilder(
				"It can't register/update the qualification. The qualification has "
						+ bindingResult.getFieldErrorCount() + " errors. ");
		List<ObjectError> listErrors = bindingResult.getAllErrors();
		int numberMessage = 1;
		for (ObjectError objectError : listErrors) {
			if (numberMessage < bindingResult.getFieldErrorCount()) {
				messageErrors.append(objectError.getDefaultMessage() + ", ");
			} else {
				messageErrors.append(objectError.getDefaultMessage() + ".");
			}
			numberMessage += 1;
		}
		return messageErrors;
	}

}
