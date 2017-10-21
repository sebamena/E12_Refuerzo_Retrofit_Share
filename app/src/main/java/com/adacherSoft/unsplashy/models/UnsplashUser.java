package com.adacherSoft.unsplashy.models;

/**
 * Created by adacher on 10-07-17.
 */

public class UnsplashUser {

    private String id, updated_at, username, name, first_name, last_name, twitter_username, portfolio_url, bio, location;
    private int total_likes,total_photos,total_collections;

    public UnsplashUser(String id, String updated_at, String username, String name, String first_name, String last_name, String twitter_username, String portfolio_url, String bio, String location, int total_likes, int total_photos, int total_collections) {
        this.id = id;
        this.updated_at = updated_at;
        this.username = username;
        this.name = name;
        this.first_name = first_name;
        this.last_name = last_name;
        this.twitter_username = twitter_username;
        this.portfolio_url = portfolio_url;
        this.bio = bio;
        this.location = location;
        this.total_likes = total_likes;
        this.total_photos = total_photos;
        this.total_collections = total_collections;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getTwitter_username() {
        return twitter_username;
    }

    public void setTwitter_username(String twitter_username) {
        this.twitter_username = twitter_username;
    }

    public String getPortfolio_url() {
        return portfolio_url;
    }

    public void setPortfolio_url(String portfolio_url) {
        this.portfolio_url = portfolio_url;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTotal_likes() {
        return total_likes;
    }

    public void setTotal_likes(int total_likes) {
        this.total_likes = total_likes;
    }

    public int getTotal_photos() {
        return total_photos;
    }

    public void setTotal_photos(int total_photos) {
        this.total_photos = total_photos;
    }

    public int getTotal_collections() {
        return total_collections;
    }

    public void setTotal_collections(int total_collections) {
        this.total_collections = total_collections;
    }
}


