package com.iu.point;

import java.util.ArrayList;

public class PointService {

	private PointDAO pointDAO;

	public PointService() {
		this.pointDAO = new PointDAO();
	}

	// 1.List
	public ArrayList<PointDTO> pointList() throws Exception {
		return pointDAO.pointList();
	}

	// 2.Select
	public PointDTO pointSelect(int num) throws Exception {
		return pointDAO.pointSelect(num);
	}

	// 3.Delete
	public int pointDelete(int num) throws Exception {
		return pointDAO.pointDelete(num);
	}

	// 4.Add / Insert
	public int pointAdd(PointDTO pointDTO) throws Exception {
		return pointDAO.pointAdd(pointDTO);
	}

	// 5.Update
	public int pointMod(PointDTO pointDTO) throws Exception {
		return pointDAO.pointMod(pointDTO);
	}

}
