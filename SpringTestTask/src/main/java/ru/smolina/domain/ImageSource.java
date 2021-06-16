package ru.smolina.domain;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.imageio.ImageIO;

import lombok.Data;
import vash.Vash;

@Data
public class ImageSource {
	// The width and height are the dimensions of the output image
	int width = 250;
	int height = 250;

	public String getImageFromVash(String data) {

		String algorithm = "1.1";
		BufferedImage img1 = null;
		
		try {
			img1 = Vash.createImage(algorithm, data, width, height);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return getBase64Image(img1);
	}

	public String getImageFromResourses() {

		File img = new File("/images/apple.png");

		BufferedImage buffImg = new BufferedImage(1000, 1000, BufferedImage.TYPE_3BYTE_BGR);

		try {
			buffImg = ImageIO.read(img);
		} catch (IOException e) {
		}

		File outputfile = new File("/home/iren/java_prog/spring-test-task/SpringTestTask/app.png");
		try {
			boolean b = outputfile.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			ImageIO.write(buffImg, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return getBase64Image(buffImg);

	}

	private String getBase64Image(BufferedImage img) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(img, "png", baos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] bytes = baos.toByteArray();

		return Base64.getEncoder().encodeToString(bytes);
	}

}
