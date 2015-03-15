package br.com.joocebox.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.mortennobel.imagescaling.AdvancedResizeOp.UnsharpenMask;
import com.mortennobel.imagescaling.ResampleOp;

public class ImageUtils {


	public byte[] resizeImageToPng(byte[] imageInByte, int width, int height) throws IOException{
		
		InputStream in = new ByteArrayInputStream(imageInByte);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		
		ResampleOp  resampleOp = new ResampleOp (width, height);
		resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
		BufferedImage resizedImage = resampleOp.filter(bImageFromConvert, null);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(resizedImage, "png", baos);
		baos.flush();
		imageInByte = baos.toByteArray();
		baos.close();
		
		return imageInByte;
	}
	
	public byte[] resizeImageToJpg(byte[] imageInByte, int width, int height) throws IOException{
		
		InputStream in = new ByteArrayInputStream(imageInByte);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		
		ResampleOp  resampleOp = new ResampleOp (width, height);
		resampleOp.setUnsharpenMask(UnsharpenMask.Normal);
		BufferedImage resizedImage = resampleOp.filter(bImageFromConvert, null);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(resizedImage, "jpg", baos);
		baos.flush();
		imageInByte = baos.toByteArray();
		baos.close();
		return imageInByte;
	}
}