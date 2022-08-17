package com.hutech.userexpenseinfo.service;

import java.io.IOException;
import java.io.InputStream;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FireBaseInitialize {
	@PostConstruct
	public void initialize() throws IOException {
		InputStream serviceAccount = this.getClass().getClassLoader().getResourceAsStream("./serviceAccountKey.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount)).build();

		FirebaseApp.initializeApp(options);

	}

}
