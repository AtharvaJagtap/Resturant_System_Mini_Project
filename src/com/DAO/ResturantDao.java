package com.DAO;

import com.Bean.RS_Database;

public interface ResturantDao {

	public RS_Database getResturantName();

	void insert();

	void UpdateResturantDetails();

	void deleteResturantDetails();

	void DisplayNoOfRetsurants();

	void sort();

}
