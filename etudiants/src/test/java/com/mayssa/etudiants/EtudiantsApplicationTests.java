package com.mayssa.etudiants;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mayssa.etudiants.entities.Etudiant;
import com.mayssa.etudiants.entities.Groupe;
import com.mayssa.etudiants.repos.EtudiantRepository;

@SpringBootTest
class EtudiantsApplicationTests {

	@Autowired
	private EtudiantRepository etudiantRepository;
	@Test
	public void testCreateEtudiant() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date dateNaiss = null;
        try {
            dateNaiss = dateFormat.parse("17/055/2003");
        } catch (ParseException e) {
            e.printStackTrace();
        }
	//Etudiant etud = new Etudiant("sellem","Maryem",dateNaiss,"maryem@gmail.com","RSI21");
	//etudiantRepository.save(etud);
	}
	@Test
	public void testFindEtudiant()
	{
	Etudiant e = etudiantRepository.findById(1L).get();
	System.out.println(e);
	}
	@Test
	public void testUpdateEtudiant()
	{
		Etudiant e = etudiantRepository.findById(1L).get();
	   e.setEmail("mayssa.moussa123@gmail.com");
	   etudiantRepository.save(e);
	   System.out.println(e);
	}
	@Test
	public void testDeleteEtudiant()
	{
	etudiantRepository.deleteById(2L);;
	}
	@Test
	public void testListerTousEtudiant()
	{
	List<Etudiant> etuds = etudiantRepository.findAll();
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}
	@Test
	public void testFindByNomEtudiant()
	{
	List<Etudiant> etuds = etudiantRepository.findByNom("moussa");
	for (Etudiant e: etuds)
	{
	System.out.println(e);
	}
	}
	@Test
	public void testFindByNomEtudiantConatains()
	{
	List<Etudiant> etuds = etudiantRepository.findByNomContains("s");
	for (Etudiant e: etuds)
	{
	System.out.println(e);
	}
	}
	@Test
	public void testfindByNomPrenom()
	{
	List<Etudiant> etuds = etudiantRepository.findByNomPrenom("moussa", "mayssa");
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}
	@Test
	public void testfindByGroupe()
	{
	Groupe gp = new Groupe();
	gp.setIdGroupe(1L);
	List<Etudiant> etuds = etudiantRepository.findByGroupe(gp);
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}
	@Test
	public void findByGroupeIdGp()
	{
	List<Etudiant> etuds = etudiantRepository.findByGroupeIdGroupe(1L);
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	 }
	@Test
	public void testfindByOrderByNomAsc()
	{
	List<Etudiant> etuds =
	etudiantRepository.findByOrderByNomAsc();
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}
	@Test
	public void testTrierEtudiantsNomDateNaiss()
	{
	List<Etudiant> etuds = etudiantRepository.trierEtudiantsNomDateNaiss();
	for (Etudiant e : etuds)
	{
	System.out.println(e);
	}
	}

}
