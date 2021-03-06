package br.com.sassotabacco.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;

@Service
public class S3Service {

	@Autowired
	private AmazonS3 s3Client;
	private Logger LOG = LoggerFactory.getLogger(S3Service.class);

	@Value("${bucketpictureuser}")
	private String bucketpictureuser;
	
	@Value("${bucketcontaspagar}")
	private String bucketcontaspagar;
	
	@Value("${bucketcontasreceber}")
	private String bucketcontasreceber;
	

	public URI uploadFilePictureUser(MultipartFile multipartFile) {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadFilePictureUser(is, fileName, contentType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro IO: " + e.getMessage());
		}

	}

	public URI uploadFilePictureUser(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Iniciando Upload");
			s3Client.putObject(bucketpictureuser, fileName, is, meta);
			LOG.info("Upload Finalizado");
			return s3Client.getUrl(bucketpictureuser, fileName).toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro converter URI");
		}
	}
	
	public URI uploadFileCP(MultipartFile multipartFile) {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadFileCP(is, fileName, contentType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro IO: " + e.getMessage());
		}

	}

	public URI uploadFileCP(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Iniciando Upload");
			s3Client.putObject(bucketcontaspagar, fileName, is, meta);
			LOG.info("Upload Finalizado");
			return s3Client.getUrl(bucketcontaspagar, fileName).toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro converter URI");
		}
	}
	
	public URI uploadFileCR(MultipartFile multipartFile) {
		try {
			String fileName = multipartFile.getOriginalFilename();
			InputStream is = multipartFile.getInputStream();
			String contentType = multipartFile.getContentType();
			return uploadFileCR(is, fileName, contentType);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro IO: " + e.getMessage());
		}

	}

	public URI uploadFileCR(InputStream is, String fileName, String contentType) {
		try {
			ObjectMetadata meta = new ObjectMetadata();
			meta.setContentType(contentType);
			LOG.info("Iniciando Upload");
			s3Client.putObject(bucketcontasreceber, fileName, is, meta);
			LOG.info("Upload Finalizado");
			return s3Client.getUrl(bucketcontasreceber, fileName).toURI();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("Erro converter URI");
		}
	}

}
