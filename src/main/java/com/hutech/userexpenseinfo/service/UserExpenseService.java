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
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.hutech.userexpenseinfo.model.UserExpense;

@Service
public class UserExpenseService {
	private static final String COLLECTION_NAME = "expense";

	public String saveUser(UserExpense user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		String id= dbFirestore.collection(COLLECTION_NAME).document().getId();
		user.setExpenseId(id);
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(id)
				.set(user);
		return collectionApiFuture.get().getUpdateTime().toString();
	}

//	public User getUserData(String userId) throws InterruptedException, ExecutionException {
//		Firestore dbFirestore = FirestoreClient.getFirestore();
//		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document();
//		ApiFuture<DocumentSnapshot> future = documentReference.get();
//		DocumentSnapshot document = future.get();
//		if (document.exists()) {
//			User user = document.toObject(User.class);
//			return user;
//		} else {
//			return null;
//		}
//
//	}

	public List<UserExpense> findAll() throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		Iterable<DocumentReference> documentReference = dbFirestore.collection(COLLECTION_NAME).listDocuments();
		Iterator<DocumentReference> iterator = documentReference.iterator();
		List<UserExpense> userList = new ArrayList<>();
		UserExpense user = null;
		while (iterator.hasNext()) {
			DocumentReference documentReference2 = iterator.next();
			ApiFuture<DocumentSnapshot> future = documentReference2.get();
			DocumentSnapshot document = future.get();
			user = document.toObject(UserExpense.class);
			userList.add(user);

		}

		return userList;
	}

	public String updateUser(String expenseId,UserExpense user) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(expenseId)
				.set(user);

		return "user updated";
	}

	public String deleteUser(String expenseId) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(expenseId).delete();
		return "User Deleted" + " with name " + " " + expenseId;
	}

	public UserExpense getUserData(int expenseId) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document();
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		if (document.exists()) {
			UserExpense user = document.toObject(UserExpense.class);
			return user;
		} else {
			return null;
		}

	}

}
