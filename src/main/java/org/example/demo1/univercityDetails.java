package org.example.demo1;
import java.util.ArrayList;
import java.util.List;

public class univercityDetails {
    // Method to get the list of universities
    public static List<University> getUniversities() {
        List<University> universities = new ArrayList<>();
        universities.add(new University("American International University-Bangladesh","Dhaka",1995,List.of("BBA", "CSE", "EDS","Architecture"),"Renowned for its strong focus on technical education and industry collaboration.","http://www.aust.edu/",3,2370));
        universities.add(new University("Independent University, Bangladesh","Dhaka",1993,List.of("BBA", "CSE", "Economics","Law","Environmental Science"),"Strong emphasis on research and sustainability initiatives","http://www.iub.edu.bd/",5,2433));
        universities.add(new University("North South University","Dhaka",1992,List.of("BBA", "CSE", "EDS"),"Bangladesh’s first private university, known for its academic excellence and modern campus.","http://www.bubt.edu.bd/",1,2330));
        universities.add(new University("BRAC","Dhaka",2001,List.of("BBA", "CSE", "Economics","Law"),"Focuses on social impact and global partnerships for research and development","http://www.bracu.ac.bd/",2,3433));
        //universities.add(new University("KU", 3));
        universities.add(new University("UIU","Dhaka",2003,List.of("BBA", "CSE", "Economics","MDS"),"Known for its scholarships and advanced campus facilities","http://www.ulab.edu.bd/",4,3000));
        universities.add(new University("ULAB", "Dhaka", 2004,List.of("Media Studies", "CSE", "Environmental Science"), "Focuses on liberal arts education and research excellence.", "http://www.ulab.edu.bd/", 8, 2000));
        universities.add(new University("BUET", "Dhaka", 1962,List.of("Engineering", "Architecture", "Urban Planning"),"The premier engineering institution in Bangladesh, known for its rigorous academics.","http://www.buet.ac.bd/", 10, 5000));
        universities.add(new University("JU", "Savar", 1970, List.of("Physics", "Chemistry", "Mathematics", "Biological Sciences"), "Renowned for its research contributions and beautiful natural campus.", "http://www.juniv.edu/", 11, 4000));
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
