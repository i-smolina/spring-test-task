package ru.smolina.domain;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class VashMock {

	public static BufferedImage createImage() {
		File file = new File(
				"/home/iren/java_prog/spring-test-task/SpringTestTask/src/main/resources/static/images/orange.png");
		BufferedImage image = null;

		try {
			image = ImageIO.read(file);
			System.out.println(image.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		// save the image to the file
		File output = new File(
				"/home/iren/java_prog/spring-test-task/SpringTestTask/src/main/resources/static/images/output.png");
		if (output.exists()) {

			try {
				ImageIO.write(image, "png", output);
				System.out.println("rewrite output");
			} catch (IOException e) {

				e.printStackTrace();
			}
		} else {
			try {
				output.createNewFile();
				System.out.println("create new file");

				ImageIO.write(image, "png", output);
				System.out.println("write to output");

			} catch (IOException e) {

				e.printStackTrace();
			}
		}

		return image;

	}

}
