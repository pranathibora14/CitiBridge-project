package com.example.demo.Sanctions;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;



public class Country {
//	public String iso;
//	public String code;
	public String name;
//String iso, String code,
    public Country( String name) {
//        this.iso = iso;
//        this.code = code;
        this.name = name;
    }

    public String toString() {
        return name;
    }
    public List<String> liistofCountries() {
    	List<String> countries = new ArrayList<String>();
    	String[] isoCountries = Locale.getISOCountries();
        for (String country : isoCountries) {
            Locale locale = new Locale("en", country);
//            String iso = locale.getISO3Country();
//            String code = locale.getCountry();
            String name = locale.getDisplayCountry();

            if (!"".equals(name)) {
                countries.add(name);
            }
        }
        
//        Collections.sort(countries, new CountryComparator());
//      for(Country s:countries) {
//    	System.out.println(s);
//    }        
        return countries;
    }
}
class CountryComparator implements Comparator<Country> {
    private Comparator<Object> comparator;

    CountryComparator() {
        comparator = Collator.getInstance();
    }

    public int compare(Country c1, Country c2) {
        return comparator.compare(c1.name, c2.name);
    }
}
