package com.thym.dto;

public class PositionDTO {
	private int positionNo;
	private String positionName;

	public PositionDTO() {
	}

	public PositionDTO(int positionNo, String positionName) {
		this.positionNo = positionNo;
		this.positionName = positionName;
	}

	public int getPositionNo() {
		return positionNo;
	}

	public void setPositionNo(int positionNo) {
		this.positionNo = positionNo;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	@Override
	public String toString() {
		return "PositionDTO [positionNo=" + positionNo + ", positionName=" + positionName + "]";
	}
	
}
