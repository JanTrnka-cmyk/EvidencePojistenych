/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistenych;

import java.time.LocalDate;

/**
 *
 * @author Jan Trnka
 */
public class Polozka {
    private final LocalDate datumCas;
    private final String text;
    private final String jmeno;
    private final String prijmeni;
    private final String telcislo;
    private final String vek;
/**
 * 
 * @param datumCas
 * @param text
 * @param jmeno
 * @param prijmeni
 * @param telcislo
 * @param vek 
 */
  public Polozka(LocalDate datumCas, String text, String jmeno, String prijmeni, String telcislo, String vek) {
    this.datumCas = datumCas;
    this.text = text;
    this.jmeno = jmeno;
    this.prijmeni = prijmeni;
    this.telcislo = telcislo;
    this.vek = vek;
  }
/**
 * Vrací datum a čas
 * @return datumCas
 */
  public LocalDate getDatum() {
    return datumCas;
  }
/**
 * Vrací text
 * @return text
 */
  public String getText() {
    return text;
  }
  /**
   * Vrací jméno
   * @return Jméno
   */
  public String getJmeno() {
      return jmeno;
  }
  /**
   * Vrací příjmení
   * @return Příjmení
   */
  public String getPrijmeni() {
      return prijmeni;
  }
  /**
   * Vrací telefonní číslo
   * @return telcislo
   */
  public String getTelCislo() {
      return telcislo;
  }
  /**
   * Vrací věk
   * @return Věk
   */
  public String getVek() {
      return vek;
  }
}
