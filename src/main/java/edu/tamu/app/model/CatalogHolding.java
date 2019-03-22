package edu.tamu.app.model;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a (somewhat) generalize holding from a catalog
 *
 * @author Jason Savell <jsavell@library.tamu.edu>
 *
 */

public class CatalogHolding {
    private String marcRecordLeader;
    private String mfhd;
    private String issn;
    private String isbn;
    private String title;
    private String author;
    private String publisher;
    private String place;
    private String year;
    private String genre;
    private String fallbackLocationCode;

    private Map<String, Map<String, String>> catalogItems = new HashMap<String, Map<String, String>>();

    public CatalogHolding(String marcRecordLeader, String mfhd, String issn, String isbn, String title, String author,
            String publisher, String place, String year, String genre, String fallBackLocationCode,
            Map<String, Map<String, String>> catalogItems) {
        this.setMarcRecordLeader(marcRecordLeader);
        this.setMfhd(mfhd);
        this.setCatalogItems(catalogItems);
        this.setIssn(issn);
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublisher(publisher);
        this.setPlace(place);
        this.setYear(year);
        this.setGenre(genre);
        this.setFallbackLocationCode(fallBackLocationCode);
    }

    public String getMarcRecordLeader() {
        return marcRecordLeader;
    }

    public void setMarcRecordLeader(String marcRecordLeader) {
        this.marcRecordLeader = marcRecordLeader;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getMfhd() {
        return mfhd;
    }

    public void setMfhd(String mfhd) {
        this.mfhd = mfhd;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getFallbackLocationCode() {
        return fallbackLocationCode;
    }

    public void setFallbackLocationCode(String fallbackLocationCode) {
        this.fallbackLocationCode = fallbackLocationCode;
    }

    public Map<String, Map<String, String>> getCatalogItems() {
        return catalogItems;
    }

    public void setCatalogItems(Map<String, Map<String, String>> catalogItems) {
        this.catalogItems = catalogItems;
    }

    public boolean isMultiVolume() {
        return (this.getCatalogItems().size() > 1);
    }

    /**
     * A helper method to allow outside callers to access getters when all they know
     * is the name of the parameter
     *
     * @param String propertyName
     * @return String
     * @throws Exception
     */
    public String getValueByPropertyName(String propertyName) throws Exception {
        Class<?> c = Class.forName(this.getClass().getCanonicalName());
        Method m = null;
        m = c.getDeclaredMethod("get" + StringUtils.capitalize(propertyName));
        return (String) m.invoke(this);
    }
}
