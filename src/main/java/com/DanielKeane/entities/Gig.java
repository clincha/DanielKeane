package com.DanielKeane.entities;

import javax.swing.text.DateFormatter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Gig {

    private String venue;
    private LocalDateTime date;
    private int price;

    public Gig(String venue, LocalDateTime date, int price) {
        this.venue = venue;
        this.date = date;
        this.price = price;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDate() {
        return date.format(DateTimeFormatter.ISO_DATE);
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Gig{" +
                "venue='" + venue + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
