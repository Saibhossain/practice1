package org.example.demo1;

import org.example.demo1.chat.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class univercityDetails {

    public static List<University> getUniversities() {
        List<University> universities = new ArrayList<>();
        String query = "SELECT UniversityID, Name, Name, Established, Programs, KeyHighlights, Website, Rank, TotalSeats,Type,colour,shortName,application_deadline, Detailes_information,Contact_information,image FROM universities";

        try (Connection connection = databaseConnection.connect();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String location = resultSet.getString("Name");
                int established = resultSet.getInt("Established");
                String programsString = resultSet.getString("Programs");
                List<String> programs = List.of(programsString.split(","));
                String keyHighlights = resultSet.getString("KeyHighlights");
                String website = resultSet.getString("Website");
                int rank = resultSet.getInt("Rank");
                int totalSeats = resultSet.getInt("TotalSeats");
                String image = resultSet.getString("image");

                universities.add(new University(name, location, established, programs, keyHighlights, website, rank, totalSeats,image));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return universities;
    }

    public static class University {
        private String name;
        private String location;
        private int established;
        private List<String> programs;
        private String keyHighlights;
        private String website;
        private int rank;
        private int totalSeats;
        private String image;

        public University(String name, String location, int established, List<String> programs,
                          String keyHighlights, String website, int rank, int totalSeats,String image) {
            this.name = name;
            this.location = location;
            this.established = established;
            this.programs = programs;
            this.keyHighlights = keyHighlights;
            this.website = website;
            this.rank = rank;
            this.totalSeats = totalSeats;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getLocation() {
            return location;
        }

        public int getEstablished() {
            return established;
        }

        public List<String> getPrograms() {
            return programs;
        }

        public String getKeyHighlights() {
            return keyHighlights;
        }

        public String getWebsite() {
            return website;
        }

        public int getRank() {
            return rank;
        }

        public int getTotalSeats() {
            return totalSeats;
        }
        public String getimage() {
            return image;
        }

        @Override
        public String toString() {
            return "University{name='" + name + '\'' +
                    ", location='" + location + '\'' +
                    ", established=" + established +
                    ", programs=" + programs +
                    ", keyHighlights='" + keyHighlights + '\'' +
                    ", website='" + website + '\'' +
                    ", rank=" + rank +
                    ", totalSeats=" + totalSeats +
                    '}';
        }
    }
}
