package com.joseparra.qualificationmicroservice.dtos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QualificationDto {
	private Long id;
	@NotNull(message = "userId can't be null")
	private Long userId;
	@NotNull(message = "hotelId can't be null")
	private Long hotelId;
	@Size(min = 0, max = 10, message = "Score should be between 0 and 10")
	private int score;
	private String observation;
}
