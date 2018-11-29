package optionb.task1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Listing {
    private static String listing;

    public Listing() {
    }

    public static String getListing() {
        return listing;
    }

    public static void setListing(String listing) {
        Listing.listing = listing;
    }

    public static String [] divideListings (File source ){
        String [] listings = null;
        try ( FileReader sourceText = new FileReader(source) ){
            BufferedReader reader = new BufferedReader(sourceText);
            String text = reader.readLine();
            listings = text.split("\\/* \\s*");

            for ( String element : listings ){
                listing = element;
            }
        }
        catch ( IOException e ){
            e.getMessage();
        }
        return listings;
    }
}
