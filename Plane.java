import java.util.*;


public class Plane {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, String> seats = new HashMap<>();
		String seatLetters = "ABCDE";
		for (char ch: seatLetters.toCharArray()) {
			for (int i = 1;i<5;i++) {
				seats.put(String.valueOf(ch) + String.valueOf(i), null);	
			}	
		}
		// Credit Carl seats 
		
		String[] names = {"Foughtsson", "Thysellsson", "Wilsonsson", "Carlevågsson", "Holthsson", "Hagemann-Jensensson", "Gazicsson", "Carsbrantsson", "Åslundsson", "Loosedsson", "Bauersson", "Stolpesson", "Svensson", "Kortisson", "Kahrimanovicsson", "Hansson", "Konoerbisson", "Tinosson", "Amongsson", "Moyaisson"};
		
			
		
		
		
		while(true) {
			System.out.println("Välj en operation:"
					+ "\n1. Skriv ut platserna"
					+ "\n2. Fill i platserna slumpat"
					+ "\n3  Lägg till passagerare" 
					+ "\n4. Kolla platser"
					+ "\n5. Sök på plats med passagerare"
					+ "\n6. Plannet avtar"); 
			
			String choice = sc.nextLine();
			
			
            switch (choice) {
            //Skriv ut platserna 
            case "1": {printSeats(seatLetters, seats);
            
            	break;
            }
            //Fill i platserna slumpat
            case "2": {
            	Random random = new Random();
                
                for (String lastName : names) {
                    String seatName;
                    boolean seatAssigned = false;
                    
                    while (!seatAssigned) {
                        // Slumpmässigt generera rad och plats.
                        char row = seatLetters.charAt(random.nextInt(seatLetters.length()));
                        int col = random.nextInt(4) + 1;
                        seatName = String.valueOf(row) + col;
                        
                        // Kontrollera om platsen är ledig.
                        if (seats.get(seatName) == null) {
                            seats.put(seatName, lastName);
                            seatAssigned = true;
                        }
                    }
                }

                printSeats(seatLetters, seats); // Skriv ut uppdaterade platser.
                break;
            		
            }
            //Lägg till passagerare
            case "3": {
            	
            	System.out.println("Ange passagerarens efternamn:");
                String lastName = sc.nextLine();
                System.out.println("Ange plats (t.ex., A1):");
                String seatName = sc.nextLine();
                
                // Välja plats och kontrollera åldersregler vid nödutgången.
                // Uppdatera HashMap 'seats' med den valda platsen och passagerarens efternamn.
                
                
                if (seats.get(seatName) == null) {
                    seats.put(seatName, lastName);} //Temp lösning som inte ska vara så här
                
                printSeats(seatLetters, seats); // Skriv ut uppdaterade platser.
                break;
            	
   	
            }
            //Kolla platser
            case "4": {
            	
            	System.out.println("Ange plats (t.ex., A1) för att kontrollera om den är ledig eller upptagen:");
                String seatToCheck = sc.nextLine();

                if (seats.containsKey(seatToCheck)) {
                    if (seats.get(seatToCheck) == null) {
                        System.out.println("Plats " + seatToCheck + " är ledig.");
                    } else {
                        System.out.println("Plats " + seatToCheck + " är upptagen av " + seats.get(seatToCheck));
                    }
                } else {
                    System.out.println("Ogiltig platsangivelse.");
                }

            	break;	
            }
            //Sök på plats med passagerare
            case "5": {
            	
            	System.out.println("Ange passagerarens efternamn för att söka:");
                String searchLastName = sc.nextLine();
                boolean passengerFound = false;

                // Loopa igenom platserna och eftersök efternamnet
                for (String seat : seats.keySet()) {
                    String lastName = seats.get(seat);

                    if (lastName != null && lastName.equals(searchLastName)) {
                        System.out.println(searchLastName + " sitter på plats " + seat);
                        passengerFound = true;
                    }
                }

                if (!passengerFound) {
                    System.out.println(searchLastName + " hittades inte ombord på planet.");
                }

            	break;
            }
            //Plannet avtar
            case "6": {
            	
            	System.out.println("                                                                               \r\n"
            			+ "                ██▓▓▓▓                                                                  \r\n"
            			+ "                ██░░  ▒▒                                                                \r\n"
            			+ "                ██    ████                                                              \r\n"
            			+ "                ██      ██                                                              \r\n"
            			+ "                ██      ██                                                              \r\n"
            			+ "                ██      ██                                                              \r\n"
            			+ "                ██      ██                                                              \r\n"
            			+ "                ██      ██                                                              \r\n"
            			+ "                ██        ██                                                            \r\n"
            			+ "                ██        ░░██                                                          \r\n"
            			+ "                ██          ░░██▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓██▓▓██        \r\n"
            			+ "  ▓▓▓▓▓▓▓▓▓▓▓▓▓▓██                                                              ██      \r\n"
            			+ "    ██░░░░░░░░                                                                ████████  \r\n"
            			+ "      ████████████          ████    ████      ████    ████      ████          ██████████\r\n"
            			+ "      ░░░░░░░░░░██          ████    ████      ████    ████      ████          ██████████\r\n"
            			+ "                ▓▓▒▒        ░░▓▓    ▒▒▒▒      ▓▓▒▒    ▒▒▒▒      ░░░░          ░░▒▒▒▒▒▒██\r\n"
            			+ "                  ██                                                                  ██\r\n"
            			+ "                    ██                            ████████                        ▓▓▓▓  \r\n"
            			+ "                      ██████████████████████████████      ████████████████████████      \r\n"
            			+ "                        ░░░░░░░░░░░░░░░░░░░░░░░░░░██      ▓▓░░░░░░░░░░░░░░░░░░░░░░      \r\n"
            			+ "                                                  ▓▓██▒▒▒▒░░                            \r\n"
            			+ "																							   ");
            	sc.close();
	        	System.exit(0);
            	break;
            	
            }
            
            default: {System.out.println("Ogitligt val. Försök igen."); break;}
           
            }
		
		
		
		}
		
	}
	
	public static void printSeats (String seatLetters, HashMap<String, String> seats) {
		
		for (char x : seatLetters.toCharArray()) {
    		for(int i = 1; i<5; i++) {
    			String seatName = String.valueOf(x) + String.valueOf(i);
    	
    			System.out.println(seatName + " : " + seats.get(seatName)); // Carl 
    			}
    		}
	}
	
	
	
}
