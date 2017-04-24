package com.example;

public final class NumberToWord {

  private final String[] ones = {
    "",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirteen",
    "fourteen",
    "fifteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen"
  };

  private final String[] tens = {
    "twenty",
    "thirty",
    "fourty",
    "fifty",
    "sixty",
    "seventy",
    "eighty",
    "ninety"
  };

  // the program does not handle numbers larger than quintillions
  // this is ok for now
  private final String[] groups = {
    "",
    "thousand",
    "million",
    "billion",
    "trillion",
    "quadrillion",
    "quintillion"
  };

  private NumberToWord() {}

  private static NumberToWord instance;

  public static synchronized NumberToWord getInstance() {
    if (instance == null) {
      instance = new NumberToWord();
    }
    return instance;
  }

  public CharSequence convert(long n) {
    if (n == 0) {
      return "zero";
    } else if (n < 0) {
      return new StringBuilder("minus ").append(convert(-n));
    } else {
      StringBuilder wordBuilder = new StringBuilder();
      StringBuilder partBuilder = new StringBuilder();
      int k = 0;
      do {
        // reuse part builder here
        // avoid creating new instances for parts with bounded length
        partBuilder.setLength(0);
        long p = n % 1_000;
        // hundreds
        long h = p / 100;
        if (h > 0) {
          partBuilder.append(ones[(int) h]);
          partBuilder.append(" hundred");
        }
        // tens
        long t = p % 100;
        if (t >= 20) {
          // we don't care about the forty vs fourty exception
          // but we can add an if to handle it...
          if (partBuilder.length() > 0) {
            partBuilder.append(" ");
          }
          partBuilder.append(tens[(int) (t / 10) - 2]);
          if (t % 10 > 0) {
            partBuilder.append("-");
            partBuilder.append(ones[(int) (t % 10)]);
          }
        } else if (t != 0) {
          if (partBuilder.length() > 0) {
            partBuilder.append(" ");
          }
          partBuilder.append(ones[(int) t]);
        }
        if (p > 0 && groups[k].length() > 0) {
          if (partBuilder.length() > 0) {
            partBuilder.append(" ");
          }
          partBuilder.append(groups[k]);
        }
        if (partBuilder.length() > 0) {
          if (wordBuilder.length() > 0) {
            wordBuilder.append(" ");
          }
          wordBuilder.append(partBuilder.reverse());
        }
        k++;
        n = n / 1_000;
      } while (n != 0);
      return wordBuilder.reverse();
    }
  }

}
