//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//
//import models.PhotoModel;
//
//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;
//
//public class PhotoModelJson {
//	static FileWriter writer;
//
//	public static void main(String[] args) throws IOException {
//
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//
//		writer = new FileWriter(
//				"/Users/priyanka/git/grabhouse//PhotoModelJson.json");
//
//		writer.append(gson.toJson(new PhotoModel("pg3", "Building", "Building", "srisaimanasabuilding", new File("/Users/priyanka/srisaimanasabuilding.JPG"))));
//
//		writer.close();
//	}
//
//}
