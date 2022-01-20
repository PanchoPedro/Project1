package Project1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Timestamp;
import java.time.Instant;
//import java.util.Arrays; // possibilit to use for array sorting 

public class fileHandling {

	
	public static Path updatePath(String FileName){
		Path currentPath = Paths.get(System.getProperty("user.dir"));;
		Path finalPath = Paths.get(currentPath.toString(),FileName);
		return finalPath;
	}
	
	
	public static void readFile(Path filePath) {
		try {
			System.out.println(Files.readAllLines(filePath)); /* if file is updated with more lines read all lines will show it */
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteFile(Path filePath) {
		File f = new File(filePath.toString());
		String realPath = " ";
		String inputPath = filePath.toString();
		try {
			realPath = f.getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (Files.exists(filePath) && (inputPath.equals(realPath))) {
			if (Files.isDirectory(filePath)){System.out.println(filePath.toString()+" is a directory. Please recheck options");}
			else {
		try {
			Files.delete(filePath);
			System.out.println("File deleted");
		}  catch (IOException e) {
			e.printStackTrace();
		}}
		} else {
			System.out.println(filePath.toString()+" doesn't exist");
		}
	}

	public static void diplaySortedDir(String filePath) {
			File f = new File(filePath);
			String[] dirContent = f.list(); 
			sortDir(dirContent);
			//Arrays.sort(dirContent); does the same as the sortDir above
			for (String currentContent : dirContent) {
				System.out.println(currentContent);
			}

	}
	
	public static String[] sortDir(String[] dirContent) { // bubbleSort
		int n = dirContent.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (dirContent[j].compareTo(dirContent[j+1])>0)
                {
                    String temp = dirContent[j];
                    dirContent[j] = dirContent[j+1];
                    dirContent[j+1] = temp;
                }
		return dirContent;

	}


	public static void writeFile(Path filePath) {
		Timestamp ts = Timestamp.from(Instant.now());
		String content =ts.toString();
		try {
			Files.write(filePath, content.getBytes(), StandardOpenOption.CREATE,StandardOpenOption.WRITE);
			System.out.println("File created with current timestamp as key");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void searchFile(Path filePath) {
		File f = new File(filePath.toString());
		String realPath = " ";
		String inputPath = filePath.toString();
		try {
			realPath = f.getCanonicalPath();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (Files.exists(filePath) && (inputPath.equals(realPath))) {			
			System.out.println(filePath.toString()+" exists");
			if (Files.isDirectory(filePath)){System.out.println(filePath.toString()+" is a directory");}
			else {
			try {
				System.out.println("Size "+ Files.size(filePath)+" bytes.");
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Content:");
			fileHandling.readFile(filePath);}
			
		} else {
			System.out.println(filePath.toString()+" doesn't exist");
			}

}

}
