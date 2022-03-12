package com.juaracoding.junit5;

import static java.lang.invoke.MethodHandles.lookup;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.slf4j.LoggerFactory.getLogger;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(JUnitParamsRunner.class)
public class TestUjian1 {

	static final Logger log = getLogger(lookup().lookupClass());

	Ujian1 ujian1;

	@Before
	public void setUp() throws Exception {
		ujian1 = new Ujian1();

	}

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void succeeded(Description description) {
			log.debug("Pesan Sukses: {}", description.getMethodName());
		}

		@Override
		protected void failed(Throwable e, Description description) {
			log.debug("Pesan Failed: {}", description.getMethodName());
		}

	};

	@Test
	@FileParameters("src/test/resources/kelilingKolam.csv")
	public void testkelilingKolam(double p, double l, double t, double expect) {

		log.debug("Testing 5");
		System.out.println("Test Keliling Kolam");

		double actual = ujian1.kelilingKolam(p, l, t);

		assertEquals(expect, actual, 0.0);

	}

	@Test
	public void testkelilingKolamBukanAngka() {

		log.debug("Testing 8");
		System.out.println("Test Keliling Kolam Bukan Angka");

		String pBukanAngka = "A";
		String lBukanAngka = "B";
		String tBukanAngka = "C";

		double convertP = Double.parseDouble(pBukanAngka);
		double convertL = Double.parseDouble(lBukanAngka);
		double convertT = Double.parseDouble(tBukanAngka);

		double actual = ujian1.kelilingKolam(convertP, convertL, convertT);

		String expect = "A";

		assertEquals(Double.parseDouble(expect), actual, 0.0);

	}

	@Test
	public void testkelilingKolamAngkaNegatif() {

		log.debug("Testing 6");
		System.out.println("Test Keliling Kolam Angka Negatif");

		double p = -1;
		double l = -2;
		double t = -3;

		double actual = ujian1.kelilingKolam(p, l, t);

		assertEquals(-24, actual, 0.0);

	}

	@Test
	public void testkelilingKolamAngkaNull() {

		log.debug("Testing 7");
		System.out.println("Test Keliling Kolam Angka Null");

		double p = 0;
		double l = 0;
		double t = 0;
		Double panjangNull = null;
		Double lebarNull = null;
		Double tinggiNull = null;

		double actual = ujian1.kelilingKolam(p, l, t);

		assertNull(panjangNull);

		assertEquals(p, actual, 0.0);

	}

	@Test
	@FileParameters("src/test/resources/volumeAirKolam.csv")
	public void testVolumeKolam(double p, double l, double t, double expect) {

		log.debug("Testing 1");
		System.out.println("Test Volume Kolam");

		double actual = ujian1.volumeKolam(p, l, t);

		assertEquals(expect, actual, 0.0);

	}

	@Test
	public void testVolumeKolamBukanAngka() {

		log.debug("Testing 4");
		System.out.println("Test Volume Kolam Bukan Angka");

		String pBukanAngka = "A";
		String lBukanAngka = "B";
		String tBukanAngka = "C";

		double convertP = Double.parseDouble(pBukanAngka);
		double convertL = Double.parseDouble(lBukanAngka);
		double convertT = Double.parseDouble(tBukanAngka);

		double actual = ujian1.volumeKolam(convertP, convertL, convertT);

		String expect = "A";

		assertEquals(Double.parseDouble(expect), actual, 0.0);

	}

	@Test
	public void testVolumeKolamAngkaNegatif() {

		log.debug("Testing 2");
		System.out.println("Test Volume Kolam Angka Negatif");

		double p = -1;
		double l = -2;
		double t = -3;

		double actual = ujian1.volumeKolam(p, l, t);

		assertEquals(-6, actual, 0.0);

	}

	@Test
	public void testVolumeKolamAngkaNull() {

		log.debug("Testing 3");
		System.out.println("Test Volume Kolam Angka Null");

		double p = 0;
		double l = 0;
		double t = 0;
		Double panjangNull = null;
		Double lebarNull = null;
		Double tinggiNull = null;

		double actual = ujian1.volumeKolam(p, l, t);

		assertNull(panjangNull);

		assertEquals(p, actual, 0.0);

	}
}
