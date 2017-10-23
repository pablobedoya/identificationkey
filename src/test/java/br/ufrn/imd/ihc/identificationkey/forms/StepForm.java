package br.ufrn.imd.ihc.identificationkey.forms;

import java.util.ArrayList;
import java.util.List;

public class StepForm {
	private String characteristicA;
	private String initialTaxonTypeA;
	private String initialTaxonA;
	private String characteristicB;
	private String initialTaxonTypeB;
	private String initialTaxonB;

	public static List<StepForm> getDefaultSteps(int quantity) {
		List<StepForm> steps = new ArrayList<>();
		
		for (int i = 0; i < quantity; i++) {
			StepForm form = new StepForm();
			form.setCharacteristicA("step_" + (i + 1) + "_characteristic_a");
			form.setInitialTaxonTypeA("Reino");
			form.setInitialTaxonA("Animalia");
			form.setCharacteristicB("step_" + (i + 1) + "_characteristic_b");
			form.setInitialTaxonTypeB("Reino");
			form.setInitialTaxonB("Animalia");
			steps.add(form);
		}

		return steps;
	}

	public String getCharacteristicA() {
		return characteristicA;
	}

	public void setCharacteristicA(String characteristic) {
		this.characteristicA = characteristic;
	}

	public String getInitialTaxonTypeA() {
		return initialTaxonTypeA;
	}

	public void setInitialTaxonTypeA(String initialTaxonType) {
		this.initialTaxonTypeA = initialTaxonType;
	}

	public String getInitialTaxonA() {
		return initialTaxonA;
	}

	public void setInitialTaxonA(String initialTaxon) {
		this.initialTaxonA = initialTaxon;
	}

	public String getCharacteristicB() {
		return characteristicB;
	}

	public void setCharacteristicB(String characteristic) {
		this.characteristicB = characteristic;
	}

	public String getInitialTaxonTypeB() {
		return initialTaxonTypeB;
	}

	public void setInitialTaxonTypeB(String initialTaxonType) {
		this.initialTaxonTypeB = initialTaxonType;
	}

	public String getInitialTaxonB() {
		return initialTaxonB;
	}

	public void setInitialTaxonB(String initialTaxon) {
		this.initialTaxonB = initialTaxon;
	}
}
