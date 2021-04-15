package com.ynov.methotest1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class Exo3Test {
	
	@Test
	public void testHas0UsedRight() {
		assertEquals(true, new Exo3().hasRight());
	}
	
	@Test
	public void testHas0UsedRightAndIsSuperiorYear() {
		assertEquals(true, new Exo3().setSuperiorYear(true).hasRight());
	}
	
	@Test
	public void testHas1UsedRight() {
		assertEquals(true, new Exo3().setUsedRight(1).hasRight());
	}
	
	@Test
	public void testHas1UsedRightAndIsSuperiorYear() {
		assertEquals(true, new Exo3().setUsedRight(1).setSuperiorYear(true).hasRight());
	}
	
	@Test
	public void testHas2UsedRights() {
		assertEquals(false, new Exo3().setUsedRight(2).hasRight());
	}
	
	@Test
	public void testHas2UsedRightAndIsSuperiorYear() {
		assertEquals(true, new Exo3().setUsedRight(2).setSuperiorYear(true).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAndNegativCredits() {
		assertEquals(false, new Exo3().setUsedRight(2).setCredits(-60).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAnd60Credits() {
		assertEquals(true, new Exo3().setUsedRight(2).setCredits(60).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAndNegativSemestre() {
		assertEquals(false, new Exo3().setUsedRight(2).setValidatedSemestres(-1).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAnd1Semestre() {
		assertEquals(false, new Exo3().setUsedRight(2).setValidatedSemestres(1).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAnd2Semestre() {
		assertEquals(true, new Exo3().setUsedRight(2).setValidatedSemestres(2).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAndNegativYear() {
		assertEquals(false, new Exo3().setUsedRight(2).setValidatedYears(-1).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAnd1Year() {
		assertEquals(true, new Exo3().setUsedRight(2).setValidatedYears(1).hasRight());
	}
	
	@Test
	public void testHas3UsedRights() {
		assertEquals(false, new Exo3().setUsedRight(3).hasRight());
	}
	
	@Test
	public void testHas3UsedRightAndIsSuperiorYear() {
		assertEquals(true, new Exo3().setUsedRight(3).setSuperiorYear(true).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAnd60Credits() {
		assertEquals(false, new Exo3().setUsedRight(3).setCredits(60).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAnd120Credits() {
		assertEquals(true, new Exo3().setUsedRight(3).setCredits(120).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAnd2Semestre() {
		assertEquals(false, new Exo3().setUsedRight(3).setValidatedSemestres(2).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAnd4Semestre() {
		assertEquals(true, new Exo3().setUsedRight(3).setValidatedSemestres(4).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAnd1Year() {
		assertEquals(false, new Exo3().setUsedRight(3).setValidatedYears(1).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAnd2Year() {
		assertEquals(true, new Exo3().setUsedRight(3).setValidatedYears(2).hasRight());
	}
	
	@Test
	public void testHas4UsedRights() {
		assertEquals(false, new Exo3().setUsedRight(4).hasRight());
	}
	
	@Test
	public void testHas4UsedRightAndIsSuperiorYear() {
		assertEquals(true, new Exo3().setUsedRight(4).setSuperiorYear(true).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAnd60Credits() {
		assertEquals(false, new Exo3().setUsedRight(4).setCredits(60).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAnd120Credits() {
		assertEquals(true, new Exo3().setUsedRight(4).setCredits(120).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAnd2Semestre() {
		assertEquals(false, new Exo3().setUsedRight(4).setValidatedSemestres(2).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAnd4Semestre() {
		assertEquals(true, new Exo3().setUsedRight(4).setValidatedSemestres(4).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAnd1Year() {
		assertEquals(false, new Exo3().setUsedRight(4).setValidatedYears(1).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAnd2Year() {
		assertEquals(true, new Exo3().setUsedRight(4).setValidatedYears(2).hasRight());
	}
	
	@Test
	public void testHas5UsedRights() {
		assertEquals(false, new Exo3().setUsedRight(5).hasRight());
	}
	
	@Test
	public void testHas5UsedRightAndIsSuperiorYear() {
		assertEquals(false, new Exo3().setUsedRight(5).setSuperiorYear(true).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAnd120Credits() {
		assertEquals(false, new Exo3().setUsedRight(5).setCredits(120).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAnd4Semestre() {
		assertEquals(false, new Exo3().setUsedRight(5).setValidatedSemestres(4).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAnd2Year() {
		assertEquals(false, new Exo3().setUsedRight(5).setValidatedYears(2).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAndCurrentYear3() {
		assertEquals(false, new Exo3().setUsedRight(5).setCurrentYear(3).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAndCurrentYear4() {
		assertEquals(true, new Exo3().setUsedRight(5).setCurrentYear(4).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAndCurrentYear4AndHasUsed2RightAfter() {
		assertEquals(false, new Exo3().setUsedRight(5).setCurrentYear(4).setUsedRightAfter(2).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAndCurrentYear4AndHasUsed2RightAfter() {
		assertEquals(true, new Exo3().setUsedRight(4).setCurrentYear(4).setUsedRightAfter(2).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAndCurrentYear4AndHasUsed3RightAfter() {
		assertEquals(false, new Exo3().setUsedRight(4).setCurrentYear(4).setUsedRightAfter(3).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAndSportiv() {
		assertEquals(true, new Exo3().setUsedRight(2).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAndMedecine() {
		assertEquals(true, new Exo3().setUsedRight(2).setMedecine(true).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAndTrained() {
		assertEquals(true, new Exo3().setUsedRight(2).setHasTrained(true).hasRight());
	}
	
	@Test
	public void testHas2UsedRightsAndJustifyFail() {
		assertEquals(true, new Exo3().setUsedRight(2).setHasJustifyFail(true).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAndSportiv() {
		assertEquals(false, new Exo3().setUsedRight(3).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAndMedecine() {
		assertEquals(false, new Exo3().setUsedRight(3).setMedecine(true).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAndTrained() {
		assertEquals(false, new Exo3().setUsedRight(3).setHasTrained(true).hasRight());
	}
	
	@Test
	public void testHas3UsedRightsAndJustifyFail() {
		assertEquals(false, new Exo3().setUsedRight(3).setHasJustifyFail(true).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAndSportiv() {
		assertEquals(false, new Exo3().setUsedRight(4).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAndSportiv() {
		assertEquals(false, new Exo3().setUsedRight(5).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas5UsedRightAndIsSuperiorYearAndMedecine() {
		assertEquals(true, new Exo3().setUsedRight(5).setSuperiorYear(true).setMedecine(true).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAnd120CreditsAndJustifyFail() {
		assertEquals(true, new Exo3().setUsedRight(5).setCredits(120).setHasJustifyFail(true).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAnd4SemestreAndTrained() {
		assertEquals(true, new Exo3().setUsedRight(5).setValidatedSemestres(4).setHasTrained(true).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAnd2YearAndSportiv() {
		assertEquals(true, new Exo3().setUsedRight(5).setValidatedYears(2).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas5UsedRightsAndCurrentYear4AndHasUsed2RightAfterAndSportiv() {
		assertEquals(true, new Exo3().setUsedRight(5).setCurrentYear(4).setUsedRightAfter(2).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAndCurrentYear4AndHasUsed3RightAfterAndMedecine() {
		assertEquals(true, new Exo3().setUsedRight(4).setCurrentYear(4).setUsedRightAfter(3).setMedecine(true).hasRight());
	}
	
	@Test
	public void testHas6UsedRightAndIsSuperiorYearAndMedecine() {
		assertEquals(false, new Exo3().setUsedRight(6).setSuperiorYear(true).setMedecine(true).hasRight());
	}
	
	@Test
	public void testHas6UsedRightsAnd120CreditsAndJustifyFail() {
		assertEquals(false, new Exo3().setUsedRight(6).setCredits(120).setHasJustifyFail(true).hasRight());
	}
	
	@Test
	public void testHas6UsedRightsAnd4SemestreAndTrained() {
		assertEquals(false, new Exo3().setUsedRight(6).setValidatedSemestres(4).setHasTrained(true).hasRight());
	}
	
	@Test
	public void testHas6UsedRightsAnd2YearAndSportiv() {
		assertEquals(false, new Exo3().setUsedRight(6).setValidatedYears(2).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas6UsedRightsAndCurrentYear4AndHasUsed2RightAfterAndSportiv() {
		assertEquals(false, new Exo3().setUsedRight(6).setCurrentYear(4).setUsedRightAfter(2).setSportiv(true).hasRight());
	}
	
	@Test
	public void testHas4UsedRightsAndCurrentYear4AndHasUsed4RightAfterAndMedecine() {
		assertEquals(false, new Exo3().setUsedRight(4).setCurrentYear(4).setUsedRightAfter(4).setMedecine(true).hasRight());
	}
}
