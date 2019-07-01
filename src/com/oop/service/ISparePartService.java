package com.oop.service;

import java.util.List;

import com.oop.exception.DatabaseErrorException;
import com.oop.model.Search;
import com.oop.model.SparePart;

public interface ISparePartService {
	void insertSparePart(SparePart sparePart) throws DatabaseErrorException;
	void deleteSparePart(int partIdForDelete) throws DatabaseErrorException;
	void updateSparePart(SparePart sparePart)  throws DatabaseErrorException;
	
	List<SparePart> searchitem(Search search) throws DatabaseErrorException;
}
