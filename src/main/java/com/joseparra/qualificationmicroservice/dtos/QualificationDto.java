package com.joseparra.qualificationmicroservice.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

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
	@Min(value = 0)
	@Max(value = 10)
	private int score;
	private String observation;
}
