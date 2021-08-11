package com.profinal.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SupportCaseDto {
	
	private Long clientId;
	private String clientName;
	private LocalDateTime date;
	private String description;
	
	
	
}
