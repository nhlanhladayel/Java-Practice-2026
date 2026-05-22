import java.util.Scanner;

public class LibraryTracker
{
    public static void displayResults(int fictionCount,int nonfictionCount,int mysteryCount,int fantasyCount,int total,String FICTION,String NONFICTION,String MYSTERY,String FANTASY)
    {
        System.out.println("\n===== STATS RESULTS =====");

        double percentage =
                ((double) fictionCount / total) * 100;
        System.out.println(FICTION + ": " + percentage + "%");

        double percentage2 =
                ((double) nonfictionCount / total) * 100;
        System.out.println(NONFICTION + ": " + percentage2 + "%");

        double percentage3 =
                ((double) mysteryCount / total) * 100;
        System.out.println(MYSTERY + ": " + percentage3 + "%");

        double percentage4 =
                ((double) fantasyCount / total) * 100;
        System.out.println(FANTASY + ": " + percentage4 + "%");

        String popular = FICTION;
        int max = fictionCount;

        if(nonfictionCount > max)
        {
            max = nonfictionCount;
            popular = NONFICTION;
        }

        if(mysteryCount > max)
        {
            max = mysteryCount;
            popular = MYSTERY;
        }

        if(fantasyCount > max)
        {
            max = fantasyCount;
            popular = FANTASY;
        }

        System.out.println("Most popular genre: " + popular);
    }

    public static String abbreviateGenre(String genreEntered)
    {
        String upperGenre = genreEntered.toUpperCase();

        if(upperGenre.equals("NONFICTION"))
        {
            return "NF";
        }

        return String.valueOf(upperGenre.charAt(0));
    }

    public static boolean validGenreName(String FICTION,String NONFICTION,String MYSTERY,String FANTASY,String genreEntered)
    {
        if(
                genreEntered.equalsIgnoreCase(FICTION)|| genreEntered.equalsIgnoreCase(NONFICTION)|| genreEntered.equalsIgnoreCase(MYSTERY)|| genreEntered.equalsIgnoreCase(FANTASY)
        )
        {
            return true;
        }

        System.out.println("Invalid genre, please try again");
        return false;
    }

    public static boolean validateCardNumber(long libraryCardNumber)
    {
        String numStr = Long.toString(libraryCardNumber);

        if(numStr.length() == 6)
        {
            return true;
        }

        System.out.println("Invalid card number!");
        return false;
    }

    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        int fictionCount = 0;
        int nonfictionCount = 0;
        int mysteryCount = 0;
        int fantasyCount = 0;
        int total = 0;

        final String FICTION = "FICTION";
        final String NONFICTION = "NONFICTION";
        final String MYSTERY = "MYSTERY";
        final String FANTASY = "FANTASY";

        while(true)
        {
            System.out.print("\nEnter Library card number (6 digits) or -1 to exit: ");

            long libraryCardNumber = kb.nextLong();

            if(libraryCardNumber == -1)
            {
                break;
            }

            if(!validateCardNumber(libraryCardNumber))
            {
                continue;
            }

            System.out.print("Are you an active member? (y/n): ");
            char activeMember = Character.toLowerCase(kb.next().charAt(0));

            kb.nextLine();

            if(activeMember == 'y')
            {
                boolean validGenre = false;

                while(!validGenre)
                {
                    System.out.print("Enter favourite genre "+ "(Fiction, Nonfiction, Mystery, Fantasy): ");

                    String genreEntered =
                            kb.nextLine();

                    if(validGenreName(FICTION,NONFICTION,MYSTERY,FANTASY,genreEntered))
                    {
                        validGenre = true;

                        String abbreviation = abbreviateGenre(genreEntered);

                        System.out.println("Abbreviation: "+ abbreviation);

                        if(genreEntered.equalsIgnoreCase(FICTION))
                        {
                            fictionCount++;
                        }
                        else if(
                                genreEntered.equalsIgnoreCase(NONFICTION))
                        {
                            nonfictionCount++;
                        }
                        else if(
                                genreEntered.equalsIgnoreCase(MYSTERY))
                        {
                            mysteryCount++;
                        }
                        else
                        {
                            fantasyCount++;
                        }

                        total++;
                    }
                }
            }
            else
            {
                System.out.println(
                        "Only active members can select a genre.");
            }
        }

        if(total > 0)
        {
            displayResults(fictionCount,nonfictionCount,mysteryCount,fantasyCount,total,FICTION,NONFICTION,MYSTERY,FANTASY);
        }
        else
        {
            System.out.println("No data to display.");
        }

        kb.close();
    }
}
