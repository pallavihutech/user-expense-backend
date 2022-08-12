package com.hutech.userexpenseinfo.service;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.Query;
import com.hutech.userexpenseinfo.model.Login;

@Service
public class LoginService {
	private static final String COLLECTION_NAME = "loginUsers";

	public String createLogin(Login login) throws InterruptedException, ExecutionException {
		Firestore dbFirestore =FirestoreClient.getFirestore();
		ApiFuture<WriteResult> collectionApiFuture = dbFirestore.collection(COLLECTION_NAME).document(login.getID())
				.set(login);
		return collectionApiFuture.get().getUpdateTime().toString();
	}


	public String getLoginData(Login login) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = FirestoreClient.getFirestore();
		CollectionReference loginData = dbFirestore.collection(COLLECTION_NAME);
		ApiFuture<QuerySnapshot> future = dbFirestore.collection(COLLECTION_NAME).whereEqualTo("email", login.getEmail()).get();
		List<QueryDocumentSnapshot> documents = future.get().getDocuments();
		for (DocumentSnapshot document : documents) {
			String pwd = document.toObject(Login.class).getPassword();
			if(pwd.equals(login.getPassword()))
				return "(" +document.getId() + ") "+ document.toObject(Login.class).getName();
			else
				return "Incorrect Password!!";
		}
		return "This user does not exist!!";
		
	}



}
