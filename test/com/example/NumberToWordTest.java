package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.currentThread;

public class NumberToWordTest {

  @DataProvider(name = "expectedResults")
  public static Object[][] providesExpectedResults() {
    List<Object[]> expectedResults = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(
          new InputStreamReader(currentThread().getContextClassLoader()
              .getResourceAsStream("NumberToWords-ExpectedResults.txt")))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] split = line.split(" = ", -1);
        expectedResults.add(new Object[] {Long.parseLong(split[0]), split[1]});
      }
    } catch (IOException ignore) {}
    return expectedResults.toArray(new Object[][] {});
  }

  @Test(dataProvider = "expectedResults")
  public void shouldTransformNumberToWordsAsExpected(Long number, String expectedWords) {
      Assert.assertEquals(NumberToWord.getInstance().convert(number).toString(), expectedWords);
  }

}
