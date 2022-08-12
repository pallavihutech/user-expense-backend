package com.hutech.userexpenseinfo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.hutech.userexpenseinfo.model.Category;

@Service
public class CategoryService {
	private static final String COLLECTION_NAME = "category";

	public Category findByCategory(String categoryId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(categoryId);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		if (document.exists()) {
			Category category = document.toObject(Category.class);
			return category;
		} else {
			return null;
		}

	}

	public List<Category> findAll() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
		Iterator<DocumentReference> iterator = documentReference.iterator();
		List<Category> cateList = new ArrayList<>();
		Category category = null;
		while (iterator.hasNext()) {
			DocumentReference documentReference2 = iterator.next();
			ApiFuture<DocumentSnapshot> future = documentReference2.get();
			DocumentSnapshot document = future.get();
			category = document.toObject(Category.class);
			cateList.add(category);

		}

		return cateList;

	}

}
