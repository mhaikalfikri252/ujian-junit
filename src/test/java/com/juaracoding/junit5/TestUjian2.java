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
public class TestUjian2 {

	static final Logger log = getLogger(lookup().lookupClass());

	Ujian2 ujian2;

	@Before
	public void setUp() throws Exception {
		ujian2 = new Ujian2();

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
	@FileParameters("src/test/resources/konversiSuhu.csv")
	public void testkonversiSuhu(double f, double expect) {

		log.debug("Testing 1");
		System.out.println("Test Konversi Suhu");

		double actual = ujian2.konversiSuhu(f);

		assertEquals(expect, actual, 0.4);

	}

	@Test
	public void testkonversiSuhuBukanAngka() {

		log.debug("Testing 4");
		System.out.println("Test Konversi Suhu Bukan Angka");

		String fBukanAngka = "A";

		double convert = Double.parseDouble(fBukanAngka);

		double actual = ujian2.konversiSuhu(convert);

		String expect = "A";

		assertEquals(Double.parseDouble(expect), actual, 0.0);

	}

	@Test
	public void testkonversiSuhuAngkaNegatif() {

		log.debug("Testing 2");
		System.out.println("Test Konversi Suhu Angka Negatif");

		double f = -2;

		double actual = ujian2.konversiSuhu(f);

		assertEquals(-18, actual, 0.9);

	}

	@Test
	public void testkonversiSuhuAngkaNull() {

		log.debug("Testing 3");
		System.out.println("Test Konversi Suhu Angka Null");

		double f = 0;
		double fNull = 32;
		Double fahrenheitNull = null;

		double actual = ujian2.konversiSuhu(fNull);

		assertNull(fahrenheitNull);

		assertEquals(f, actual, 0.0);

	}
}
