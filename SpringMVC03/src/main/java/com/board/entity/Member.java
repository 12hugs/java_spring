package com.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {
	private int memIdx;
	private String memId;
	private String memPw;
	private String memName;
	private int memAge;
	private String memGender;
	private String memEmail;
	private String memProfile;
}
