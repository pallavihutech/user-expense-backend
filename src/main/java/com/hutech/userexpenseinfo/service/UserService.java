package com.hutech.userexpenseinfo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.hutech.userexpenseinfo.model.User;

@Service
public class UserService {
	private static final String COLLECTION_NAME = "user";

	public String saveUser(User user) throws InterruptedException, ExecutionException {
		Firestore dbFirestore =FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(user.getPaid_by())
				.set(user);
		return collectionApiFuture.get().getUpdateTime().toString();
	}

	public User getUserData(String paid_by) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		DocumentReference documentReference = dbFirestore.collection(COLLECTION_NAME).document(paid_by);
		ApiFuture<DocumentSnapshot> future = documentReference.get();
		DocumentSnapshot document = future.get();
		//User user = null;
		if (document.exists()) {
			 User user = document.toObject(User.class);
			return user;
		} else {
			return null;
		}

	}

	public String updateUser(User user) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(user.getPaid_by())
				.set(user);
				
		return "user updated";
	}

	public String deleteUser(String paid_by) {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(paid_by).delete();
		return "User Deleted" +" with name "+" "+paid_by;
	}

}
