package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CategoryRepository;
import com.app.entities.Category;

@Service
@Transactional
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	CategoryRepository catRepo;

	public Category addCategory(Category cat) {

		return catRepo.save(cat);
	}

	public List<Category> getAllMenuTypes() {
		return catRepo.findAllAcending();
	}
}
