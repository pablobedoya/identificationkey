package br.ufrn.imd.ihc.identificationkey.form;

import java.util.List;

public class KeyForm {

	private String initialTaxonType;
	private String initialTaxon;
	private String name;
	private String description;
	private String author;
	private String biography;
	private List<VerificationStepForm> steps;

	public static KeyForm getDefaultForm() {
		KeyForm form = new KeyForm();
		
		form.setInitialTaxonType("Reino");
		form.setInitialTaxon("Animalia");
		form.setName("test_default_key_name");
		form.setDescription("test_default_key_description");
		form.setAuthor("test_default_key_author");
		form.setBiography("test_default_key_biography");
		
		return form;
	}
	
	public String getInitialTaxonType() {
		return initialTaxonType;
	}

	public void setInitialTaxonType(String initialTaxonType) {
		this.initialTaxonType = initialTaxonType;
	}

	public String getInitialTaxon() {
		return initialTaxon;
	}

	public void setInitialTaxon(String initialTaxon) {
		this.initialTaxon = initialTaxon;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<VerificationStepForm> getSteps() {
		return steps;
	}

	public void setSteps(List<VerificationStepForm> steps) {
		this.steps = steps;
	}

}