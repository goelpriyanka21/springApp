import helperclasses.UnlockPropertyData;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UnlockEntryJson {
	static FileWriter writer;

	public static void main(String[] args) throws IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		writer = new FileWriter(
				"/Users/priyanka/git/grabhouse//UnlockEntryJson.json");

		writer.append(gson.toJson(new UnlockPropertyData(
				"SriSaiKormanagalaattimesatmp10:23", "Building")));

		writer.close();
	}

}
