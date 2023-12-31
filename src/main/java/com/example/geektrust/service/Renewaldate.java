package com.example.geektrust.service;

import java.time.LocalDate;

/**
 * The Renewaldate class calculates renewal dates for different subscription plans.
 */
public class Renewaldate {
    private static final int BEFORE_REMINDER = 10;

    /**
     * Enumeration of subscription plans with their corresponding renewal months.
     */
    public enum Plan {
        FREE(1),
        PERSONAL(1),
        PREMIUM(3);

        private final int renewalMonths;

        Plan(int renewalMonths) {
            this.renewalMonths = renewalMonths;
        }

        public int getRenewalMonths() {
            return renewalMonths;
        }
    }

    /**
     * Container class for renewal dates of different subscription plans.
     */
    public class RenewalDates {
        private LocalDate musicRenewalDate;
        private LocalDate videoRenewalDate;
        private LocalDate podcastRenewalDate;

        public RenewalDates(LocalDate musicRenewalDate, LocalDate videoRenewalDate, LocalDate podcastRenewalDate) {
            this.musicRenewalDate = musicRenewalDate;
            this.videoRenewalDate = videoRenewalDate;
            this.podcastRenewalDate = podcastRenewalDate;
        }

        public LocalDate getMusicRenewalDate() {
            return musicRenewalDate;
        }

        public LocalDate getVideoRenewalDate() {
            return videoRenewalDate;
        }

        public LocalDate getPodcastRenewalDate() {
            return podcastRenewalDate;
        }
    }

    /**
     * Calculates renewal dates for the given subscription.
     *
     * @param sub The subscription for which to calculate renewal dates.
     * @return An instance of RenewalDates containing the calculated renewal dates.
     */
    public RenewalDates calculateRenewalDates(Subscription sub) {
        LocalDate startDate = sub.getStartDate();

        LocalDate musicRenewalDate = null;
        LocalDate videoRenewalDate = null;
        LocalDate podcastRenewalDate = null;

        if (sub.getMusicPlan() != null) {
            int musicRenewalMonths = Plan.valueOf(sub.getMusicPlan()).getRenewalMonths();
            musicRenewalDate = startDate.plusMonths(musicRenewalMonths).minusDays(BEFORE_REMINDER);
        }

        if (sub.getVideoPlan() != null) {
            int videoRenewalMonths = Plan.valueOf(sub.getVideoPlan()).getRenewalMonths();
            videoRenewalDate = startDate.plusMonths(videoRenewalMonths).minusDays(BEFORE_REMINDER);
        }

        if (sub.getPodcastPlan() != null) {
            int podcastRenewalMonths = Plan.valueOf(sub.getPodcastPlan()).getRenewalMonths();
            podcastRenewalDate = startDate.plusMonths(podcastRenewalMonths).minusDays(BEFORE_REMINDER);
        }

        return new RenewalDates(musicRenewalDate, videoRenewalDate, podcastRenewalDate);
    }
}
