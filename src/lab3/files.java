package lab3;

import java.io.File;

public class files {
	public static void find(String path, String filename) {
        File file = new File(path);
        
        if (!file.exists()) {
            System.out.println("Path does not exist: " + path);
            return;
        }
        if (file.isFile()) {
            if (file.getName().equals(filename)) {
                System.out.println("Found: " + file.getAbsolutePath());
            }
        }
        else if (file.isDirectory()) {
            File[] files = file.listFiles();

            if (files != null) {
                for (File f : files) {
                    find(f.getAbsolutePath(), filename); // Recursive call
                }
             }
        }
	}
public static void main(String[] args) {

    String searchPath = "/Users/uday/Desktop/Downloads:Desktop/Techno";
   
    String fileName = "GTG Premiere | Klint - Quad [MR039].mp3";

    find(searchPath, fileName);
  }
}
