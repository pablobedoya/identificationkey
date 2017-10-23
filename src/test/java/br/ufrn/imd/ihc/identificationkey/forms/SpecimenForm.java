package br.ufrn.imd.ihc.identificationkey.forms;

import java.util.Random;

public class SpecimenForm {
	private String projectName;
	private int quantity;
	private String name;
	private String description;
	private String collectionDate;
	private String taxonType;
	private String taxon;
	
	public static SpecimenForm getDefaultForm() {
		SpecimenForm form = new SpecimenForm();
		
		form.setProjectName(Long.toHexString(new Random().nextLong())); // Gera nome aleatório
		form.setQuantity(1);
		form.setName(Long.toHexString(new Random().nextLong())); // Gera nome aleatório
		form.setDescription("test_default_specimen_description");
		form.setCollectionDate("01012017");
		form.setTaxonType("Reino");
		form.setTaxon("Animalia");
		
		return form;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public String getCollectionDate() {
		return collectionDate;
	}

	public void setCollectionDate(String collectionDate) {
		this.collectionDate = collectionDate;
	}

	public String getTaxonType() {
		return taxonType;
	}

	public void setTaxonType(String taxonType) {
		this.taxonType = taxonType;
	}

	public String getTaxon() {
		return taxon;
	}

	public void setTaxon(String taxon) {
		this.taxon = taxon;
	}
}
