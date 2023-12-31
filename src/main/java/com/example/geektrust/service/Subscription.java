package com.example.geektrust.service;

import java.time.LocalDate;

/**
 * The Subscription class represents a subscription data structure.
 */
public class Subscription {
    private LocalDate startDate;
    private String musicPlan;
    private String videoPlan;
    private String podcastPlan;
    private Topup topup;

    /**
     * Initializes a new Subscription instance with default values.
     */
    public Subscription() {
        this(LocalDate.of(1998, 3, 20), null, null, null, new Topup());
    }

    /**
     * Initializes a new Subscription instance with specified values.
     *
     * @param startDate The start date of the subscription.
     * @param musicPlan The music plan of the subscription.
     * @param videoPlan The video plan of the subscription.
     * @param podcastPlan The podcast plan of the subscription.
     * @param topup The top-up associated with the subscription.
     */
    public Subscription(LocalDate startDate, String musicPlan, String videoPlan, String podcastPlan, Topup topup) {
        this.startDate = startDate;
        this.musicPlan = musicPlan;
        this.videoPlan = videoPlan;
        this.podcastPlan = podcastPlan;
        this.topup = topup;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getMusicPlan() {
        return musicPlan;
    }

    public void setMusicPlan(String musicPlan) {
        this.musicPlan = musicPlan;
    }

    public String getVideoPlan() {
        return videoPlan;
    }

    public void setVideoPlan(String videoPlan) {
        this.videoPlan = videoPlan;
    }

    public String getPodcastPlan() {
        return podcastPlan;
    }

    public void setPodcastPlan(String podcastPlan) {
        this.podcastPlan = podcastPlan;
    }

    public Topup getTopup() {
        return topup;
    }

    public void setTopup(Topup topup) {
        this.topup = topup;
    }

    /**
     * Returns a string representation of the Subscription instance.
     *
     * @return A string representing the subscription details.
     */
    @Override
    public String toString() {
        return "Subscription [startDate=" + startDate + ", MusicPlan=" + musicPlan + ", VideoPlan=" + videoPlan
                + ", PodcastPlan=" + podcastPlan + ", Topup=" + topup + "]";
    }
}
