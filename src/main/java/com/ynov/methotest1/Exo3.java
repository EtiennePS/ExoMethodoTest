package com.ynov.methotest1;

public class Exo3 {
	
	private int usedRight;
	private int usedRightAfter;
	private int credits;
	private int currentYear;
	private int validatedYears;
	private int validatedSemestres; 
	/** Les étudiants passant en année supérieure bénéficient d'un droit à bourse quel que soit le nombre de crédits validés */
	private boolean isSuperiorYear;
	/** 1 droit annuel supplémentaire pour les étudiants
	en situation d’échec consécutive à une période de volontariat ou due à des difficultés
	familiales (décès notamment) ou personnelles (maternité, raisons graves de santé) attestées
	par un avis des services médicaux et sociaux de l’établissement*/
	private boolean hasJustifyFail;
	/** 1 droit annuel supplémentaire dans le cadre d’un parcours linéaire en médecine, odontologie et pharmacie */
	private boolean isMedecine;
	/** 3 droits annuels supplémentaires pour les étudiants souffrant d’un handicap et pour les étudiants sportifs de haut niveau */
	private boolean isSportiv;
	/** 1 droit annuel supplémentaire pour la réalisation d’un stage intégré à la formation d’une durée d’un an */
	private boolean hasTrained;
	
	public Exo3() {
		usedRight = 0;
		usedRightAfter = 0;
		credits = 0;
		currentYear = 1;
		validatedYears = 0;
		validatedSemestres = 0;
		isSuperiorYear = false;
		hasJustifyFail = false;
		isMedecine = false;
		isSportiv = false;
		hasTrained = false;
	}
	
	public boolean hasRight() {
		int bonus = has1MoreRight() ? 1 : 0;
		int limit2 = 2 + bonus;
		int limit3 = 3 + bonus;
		int limit4 = 4 + bonus;
		int limit5 = 5 + bonus;
		int limit7 = 7 + bonus;
		
		boolean ok = usedRight < limit2;
		
		if(currentYear < 4) {
			ok = ok || (usedRight == limit2 && (credits >= 60 || validatedSemestres >= 2 || validatedYears >= 1 || isSuperiorYear));
			ok = ok || ((usedRight == limit3 || usedRight == limit4) && (credits >= 120 || validatedSemestres >= 4 || validatedYears >= 2 || isSuperiorYear));
		}
		else {
			ok = ok || usedRight == limit5 && usedRightAfter < limit2;
			ok = ok || usedRight < limit5 && usedRightAfter < limit3;
		}
		
		ok = ok && (usedRight + usedRightAfter) < limit7;
		
		return ok;
	}
	
	private boolean has1MoreRight() {
		return hasJustifyFail || isMedecine || isSportiv || hasTrained;
	}

	public int getUsedRight() {
		return usedRight;
	}

	public int getUsedRightAfter() {
		return usedRightAfter;
	}

	public int getCredits() {
		return credits;
	}

	public int getCurrentYear() {
		return currentYear;
	}

	public int getValidatedYears() {
		return validatedYears;
	}

	public int getValidatedSemestres() {
		return validatedSemestres;
	}

	public boolean isSuperiorYear() {
		return isSuperiorYear;
	}

	public boolean isHasJustifyFail() {
		return hasJustifyFail;
	}

	public boolean isMedecine() {
		return isMedecine;
	}

	public boolean isSportiv() {
		return isSportiv;
	}

	public boolean isHasTrained() {
		return hasTrained;
	}

	public Exo3 setUsedRight(int usedRight) {
		this.usedRight = usedRight;
		return this;
	}
	
	public Exo3 setUsedRightAfter(int usedRight) {
		this.usedRightAfter = usedRight;
		return this;
	}

	public Exo3 setCredits(int credits) {
		this.credits = credits;
		return this;
	}

	public Exo3 setCurrentYear(int currentYear) {
		this.currentYear = currentYear;
		return this;
	}

	public Exo3 setValidatedYears(int validatedYears) {
		this.validatedYears = validatedYears;
		return this;
	}

	public Exo3 setValidatedSemestres(int validatedSemestres) {
		this.validatedSemestres = validatedSemestres;
		return this;
	}

	public Exo3 setSuperiorYear(boolean isSuperiorYear) {
		this.isSuperiorYear = isSuperiorYear;
		return this;
	}

	public Exo3 setHasJustifyFail(boolean hasJustifyFail) {
		this.hasJustifyFail = hasJustifyFail;
		return this;
	}

	public Exo3 setMedecine(boolean isMedecine) {
		this.isMedecine = isMedecine;
		return this;
	}

	public Exo3 setSportiv(boolean isSportiv) {
		this.isSportiv = isSportiv;
		return this;
	}

	public Exo3 setHasTrained(boolean hasTrained) {
		this.hasTrained = hasTrained;
		return this;
	}
}
