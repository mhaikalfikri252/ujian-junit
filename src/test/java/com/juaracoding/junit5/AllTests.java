package com.juaracoding.junit5;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestUjian1.class, TestUjian2.class })
public class AllTests {

}
