package com.conclave.transcription;

import com.ibm.watson.developer_cloud.speech_to_text.v1.SpeechToText;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.developer_cloud.speech_to_text.v1.model.SpeechResults;

import java.io.File;

public class Application
{
	public static void main(String[] args)
	{
		SpeechToText transcriber = new SpeechToText();
		//TODO: hide credentials
		transcriber.setUsernameAndPassword("e0fd4c2d-8b12-488e-8298-46b0a9c55e91", "DK1XsTijmdye");

		RecognizeOptions options = new RecognizeOptions.Builder()
				.contentType("audio/wav") //TODO: probably don't need this
				.model("en-US_NarrowbandModel") //TODO: figure out how to determine model
				.build();

		File audio = new File(args[0]);

		SpeechResults results = transcriber.recognize(audio, options).execute();
		System.out.println(results.toString());
	}
}
