/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.evidencepojistenych;

/**
 *
 * @author Jan Trnka
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

/**
 *
 * @author Jan Trnka
 */
public class Evidence {

  private LinkedList<Polozka> polozky = new LinkedList<>();
  private Polozka aktualniPolozka;
  private Scanner sc = new Scanner(System.in);
/**
 * Hlavní program ovládání
 */
  public void Program() {

      String akce = "";

      while (!akce.equals("5")) {
          ZobrazMenu();

          if (aktualniPolozka != null) {
              try {
                  aktualniPolozka = polozky.getLast();
                  VytiskniPosledniPolozku();
              } catch (Exception e) {
                    System.out.println("*** EVIDENCE JE PRÁZDNÁ ***");
              }
          }

          System.out.print("VYBERTE AKCI: ");
          akce = sc.nextLine();

          switch (akce) {
              case "1":
                  VytvorNovouPolozku();
                  break;

              case "2":
                  UkazVsechnyPolozky();
                  break;
                  
              case "3":
                  VyhledejPolozku();
                  break;

              case "4":
                  if (polozky.size() != 0) {
                      SmazPolozku();
                  } else {
                      System.out.println("\n *** EVIDENCE JE PRÁZDNÁ *** \n");
                  }
                  break;

              case "5":
                  System.out.println("ZAVÍRÁM PROGRAM EVIDENCE POJIŠTĚNÝCH.");
                  break;
                  
              default: System.out.println("*** VYBERTE AKCI V ROZMEZÍ 1 - 5 ***");
          }
      }

  }
/**
 * Metoda k tištění položek
 */
  void VytiskniPocetPolozek() {
      System.out.println("------------------------------------------");
      System.out.println("POČET POLOŽEK: " + polozky.size());
      System.out.println("------------------------------------------");
  }
/**
 * Metoda ke zobrazení menu
 */
  void ZobrazMenu() {
      System.out.println("------------------------------------------");
      System.out.println("          EVIDENCE POJIŠTĚNÝCH            ");
      System.out.println("------------------------------------------");
      System.out.println("    VYBERTE AKCI:");
      System.out.println("1 - PŘIDAT NOVÉHO POJIŠTĚNÉHO");
      System.out.println("2 - VYPSAT VŠECHNY POJIŠTĚNÉ");
      System.out.println("3 - VYHLEDAT POLOŽKU POJIŠTĚNÉHO");
      System.out.println("4 - ODSTRANIT POLOŽKU POJIŠTĚNÉHO");
      System.out.println("5 - UKONČENÍ PROGRAMU EVIDENCE POJIŠTĚNÝCH");
      System.out.println("------------------------------------------");
      VytiskniPocetPolozek();
  }
/**
 * Metoda k vytvoření nové položky
 */
  void VytvorNovouPolozku() {
      System.out.println("------------------------------------------");
      
      System.out.println("Zadejte jméno pojištěného:");
      String jmeno = sc.nextLine();
      
      System.out.println("Zadejte příjmení pojištěného:");
      String prijmeni = sc.nextLine();
      
      System.out.println("Zadejte telefonní číslo pojištěného:");
      String telcislo = sc.nextLine();
      
      System.out.println("Zadejte věk pojištěného:");
      String vek = sc.nextLine();
      
      System.out.println("Poznámka:");
      LocalDate datumVytvoreniPolozky = LocalDate.now();
      String text = sc.nextLine();

      Polozka polozka = new Polozka(datumVytvoreniPolozky, text, jmeno, prijmeni, telcislo, vek);
      polozky.add(polozka);

      aktualniPolozka = polozka;

      System.out.println("POLOŽKA BYLA VYTVOŘENA");
      System.out.println("------------------------------------------");
  }
/**
 * Metoda ke zobrazení všech položek
 */
  void UkazVsechnyPolozky() {
      VytiskniPocetPolozek();

      System.out.println("------------------------------------------");
      for (int i = 0; i < polozky.size(); i++) {
          System.out.println("ID [" + i + "] VYTVOŘENO " + polozky.get(i).getDatum() + ":");
          System.out.println(polozky.get(i).getJmeno() + "  " +
                 polozky.get(i).getPrijmeni()+ "  " + polozky.get(i).getTelCislo() + "  " + 
                 polozky.get(i).getVek() + "  " + polozky.get(i).getText() + "\n");

      }
      System.out.println("------------------------------------------");
  }
  
/**
 * Metoda ke zobrazení poslední položky
 */
  void VytiskniPosledniPolozku() {
      System.out.println("------------------------------------------");
      System.out.println("POSLEDNÍ POLOŽKA:");
      
      System.out.println(aktualniPolozka.getJmeno() + "  " +
                 aktualniPolozka.getPrijmeni()+ "  " + aktualniPolozka.getTelCislo() + "  " + 
                 aktualniPolozka.getVek() + "  " + aktualniPolozka.getText() + "\n");
      
      
      System.out.println("VYTVOŘEN: " + aktualniPolozka.getDatum());
      System.out.println("------------------------------------------");
  }
/**
 * Metoda ke smazání položky
 */
  void SmazPolozku() {

      UkazVsechnyPolozky();

      boolean jeSpravne = false;
      /* Kontolní boolean, který slouží k potvrzení zadání správného vstupu, 
       * v případě nesprávného zadání se vypíše varovná zpráva a cyklus while pokračuje,
       * dokud uživatel nezadá platný index
       */
      while (!jeSpravne) {
          try {
              System.out.println("JAKÁ POLOŽKA BUDE VYMAZÁNA?");
              System.out.println("PRO VYMAZÁNÍ POLOŽKY ZADEJTE JEJÍ ID.");
              System.out.print("POLOŽKA K VYMAZÁNÍ: ");
              int id = Integer.parseInt(sc.nextLine()); // Přetypování (Parsování) vstupu uživatele do proměnné id, provádí se překlad ze String do Integer
                          
                    System.out.println("ID [" + (id) + "] SMAZÁNO " + polozky.get(id).getDatum() + ":");
                    System.out.println(polozky.get(id).getJmeno() + "  " +
                    polozky.get(id).getPrijmeni()+ "  " + polozky.get(id).getTelCislo() + "  " + 
                    polozky.get(id).getVek() + "  " + polozky.get(id).getText() + "\n");
                             
                    polozky.remove(id); // Vymazání položky
              
                    
              jeSpravne = true; // Boolean jeSpravne na true, ukončí cyklus while

          } catch (Exception e) {
              System.out.println(
                      "*** EVIDENCE NEOBSAHUJE TUTO POLOŽKU ***");
          }
      }
  }
  /**
   * Metoda k vyhledání položky
   */
  void VyhledejPolozku() {
      System.out.println("------------------------------------------");
      
      System.out.println("Zadejte jméno pojištěného:");
      String VyhledejJmeno = sc.nextLine();
      
      System.out.println("Zadejte příjmení pojištěného:");
      String VyhledejPrijmeni = sc.nextLine();
      
      
      for (int i = 0; i < polozky.size(); i++) {
          
              if (((polozky.get(i).getJmeno().equals(VyhledejJmeno))) && 
                      ((polozky.get(i).getPrijmeni().equals(VyhledejPrijmeni))))
                {
                    System.out.println("ID [" + i + "] VYTVOŘENO " + polozky.get(i).getDatum() + ":");
                    System.out.println(polozky.get(i).getJmeno() + "  " +
                    polozky.get(i).getPrijmeni()+ "  " + polozky.get(i).getTelCislo() + "  " + 
                    polozky.get(i).getVek() + "  " + polozky.get(i).getText() + "\n");
                }
              else {
                  System.out.println("*** EVIDENCE NEOBSAHUJE TUTO POLOŽKU ***");
              }
        }
      System.out.println("------------------------------------------");
    }
}
      
          
          
