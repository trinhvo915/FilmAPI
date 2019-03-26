package enclave.com.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import enclave.com.exception.MyFileNotFoundException;
import enclave.com.property.FileStorageProperties;

@Service
public class FileStorageService {
	
	private final Path fileStrongeLocation;
	
	@Autowired
	public FileStorageService(FileStorageProperties fileStorageProperties) {
		this.fileStrongeLocation = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStrongeLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String storeFile(MultipartFile file) {
		//Get file name
		String fileName = file.getOriginalFilename();
		
		//Replace existing file with the same name
		Path targetLocation = this.fileStrongeLocation.resolve(fileName);
		
		try {
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	public Resource loadFileAsResource (String fileName) {
		
		try {
			Path filePath = this.fileStrongeLocation.resolve(fileName);
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException e) {
			throw new MyFileNotFoundException("File not found " + fileName);
		}
	}
	
	
	
}
