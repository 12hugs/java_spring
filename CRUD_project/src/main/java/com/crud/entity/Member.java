package com.crud.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data

@Entity
public class Member {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_seq_gen")
	    @SequenceGenerator(name = "member_seq_gen", sequenceName = "MEMBER_SEQ")
		private Long idx;
		private String email;
		private String pw;
		private LocalDateTime joinDate;
}
