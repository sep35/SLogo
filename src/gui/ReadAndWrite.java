package gui;
//This entire file is part of my masterpiece.
//Steven Pierre
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class ReadAndWrite {
    private FileChooser fileChooser;

    public ReadAndWrite() {
	fileChooser = new FileChooser();
	fileChooser.getExtensionFilters().add(
		new FileChooser.ExtensionFilter(".txt", "*.txt"));
	fileChooser
		.setInitialDirectory(new File(System.getProperty("user.dir")));
    }

    public void write(String... args) {
	try {
	    fileChooser.setTitle("Save Data");
	    File newTextFile = fileChooser.showSaveDialog(new Stage());
	    FileWriter fw = new FileWriter(newTextFile);
	    for (String str : args) {
		fw.write(str);
	    }
	    fw.close();
	} catch (IOException iox) {
	    // do stuff with exception
	    iox.printStackTrace();
	}
    }

    public List<String> read() throws IOException {
	fileChooser.setTitle("Read data");
	File dataText = fileChooser.showOpenDialog(new Stage());
	Path path = Paths.get(dataText.getPath());
	return Files.readAllLines(path);
    }
}