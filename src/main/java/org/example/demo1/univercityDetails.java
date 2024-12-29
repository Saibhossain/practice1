package org.example.demo1;
import java.util.ArrayList;
import java.util.List;

public class univercityDetails {
    // Method to get the list of universities
    public static List<University> getUniversities() {
        List<University> universities = new ArrayList<>();
        universities.add(new University("BRAC", 2));
        universities.add(new University(
                "NSU",
                "Dhaka",
                1992,
                List.of("BBA", "CSE", "EDS"),
                "Bangladesh’s first private university, known for its academic excellence and modern campus.",
                "http://www.bubt.edu.bd/",
                1,
                233 // Total Seats
        ));
        universities.add(new University("KU", 3));
        universities.add(new University("UIU", 7));
        universities.add(new University("ULAB", 8));
        universities.add(new University("BUET", 2));
        universities.add(new University("JU", 1));
        //universities.add(new University("SUST", 9));
        return universities;
    }

    // Inner class representing a university
    public static class University {
        private String name;
        private String location;
        private int established;
        private List<String> programs;
        private String keyHighlights;
        private String website;
        private int rank;
        private int totalSeats;

        // Constructor for full details
        public University(String name, String location, int established, List<String> programs,
                          String keyHighlights, String website, int rank, int totalSeats) {
            this.name = name;
            this.location = location;
            this.established = established;
            this.programs = programs;
            this.keyHighlights = keyHighlights;
            this.website = website;
            this.rank = rank;
            this.totalSeats = totalSeats;
        }

        public University(String name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        public String getName() {
            return name;
        }

        public int getRank() {
            return rank;
        }
        // Getters

        public String getLocation() { return location; }
        public int getEstablished() { return established; }
        public List<String> getPrograms() { return programs; }
        public String getKeyHighlights() { return keyHighlights; }
        public String getWebsite() { return website; }

        public int getTotalSeats() { return totalSeats; }
        @Override
        public String toString() {
            return "University{name='" + name + "', location='" + location + "', established=" + established +
                    ", programs=" + programs + ", keyHighlights='" + keyHighlights + "', website='" + website +
                    "', rank=" + rank + ", totalSeats=" + totalSeats + "}";
        }
    }
}
