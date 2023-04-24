package com.joseparra.qualificationmicroservice.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "ratings")
public class Qualification extends AbstractEntityPersistentObject {
	@NotNull(message = "userId can't be null")
	private Long userId;
	@NotNull(message = "hotelId can't be null")
	private Long hotelId;
	@Size(min = 0, max = 10, message = "Score should be between 0 and 10")
	private int score;
	private String observation;

}
