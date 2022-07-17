package com.bhaskor.dynamic_programming;

/**
 * Alphanumeric Abbreviations of a String
 *
 * Difficulty Level : Hard
 * Last Updated : 14 Jul, 2022
 * Given a string of characters of length less than 10. We need to print all the alpha-numeric abbreviation of the string. The alpha-numeric abbreviation is in the form of characters mixed with the digits which is equal to the number of skipped characters of a selected substring.
 *
 * So, whenever a substring of characters is skipped, you have to replace it with the digit denoting the number of characters in the substring. There may be any number of skipped substrings of a string. No two substrings should be adjacent to each other. Hence, no two digits are adjacent in the result. For a clearer idea, see the example.
 *
 * Examples:
 *
 * Input : ANKS
 * Output :
 * ANKS (nothing is replaced)
 * ANK1 (S is replaced)
 * AN1S (K is replaced)
 * AN2  (KS is replaced)
 * A1KS (N is replaced)
 * A1K1 (N and S are replaced)
 * A2S (NK is replaced)
 * A3 (NKS is replaced)
 * 1NKS (A is replaced)
 * 1NK1 (A and S are replaced)
 * 1N1S (A and N is replaced)
 * 1N2 (A and KS are replaced)
 * 2KS (AN is replaced)
 * 2K1 (AN and S is replaced)
 * 3S (ANK is replaced)
 * 4 (ANKS is replaced)
 *
 * Input : ABC
 * Output :
 * ABC
 * AB1
 * A1C
 * A2
 * 1BC
 * 1B1
 * 2C
 * 3
 * Note: 11C is not valid because no two digits should be adjacent,
 * 2C is the correct one because AB is a substring, not A and B individually
 */

public class NumericAbbreviation {



}
