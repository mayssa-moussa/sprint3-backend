package com.mayssa.etudiants.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Image;
import com.mayssa.etudiants.services.EtudiantService;
import com.mayssa.etudiants.services.ImageService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	
	@Autowired
	EtudiantService etudiantService;

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Image uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}

	@PostMapping(value = "/uplaodImageEtud/{idEtud}")
	public Image uploadMultiImages(@RequestParam("image") MultipartFile file, @PathVariable("idEtud") Long idEtud)
			throws IOException {
		return imageService.uplaodImageEtud(file, idEtud);
	}

	@RequestMapping(value = "/getImagesEtud/{idEtud}", method = RequestMethod.GET)
	public List<Image> getImagesEtud(@PathVariable("idEtud") Long idEtud) throws IOException {
		return imageService.getImagesParEtud(idEtud);
	}

	@RequestMapping(value = "/uploadFS/{id}", method = RequestMethod.POST)
	public void uploadImageFS(@RequestParam("image") MultipartFile file, @PathVariable("id") Long id)
			throws IOException {
		Etudiant e = etudiantService.getEtudiant(id);
		e.setImagePath(id + ".jpg");

		Files.write(Paths.get(System.getProperty("user.home") + "/images/" + e.getImagePath()), file.getBytes());
		etudiantService.saveEtudiant(e);

	}

	@RequestMapping(value = "/loadfromFS/{id}", method = RequestMethod.GET,
			produces = MediaType.IMAGE_JPEG_VALUE)
	public byte[] getImageFS(@PathVariable("id") Long id) throws IOException {

		Etudiant e = etudiantService.getEtudiant(id);
		return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "/images/" + e.getImagePath()));
	}
}
