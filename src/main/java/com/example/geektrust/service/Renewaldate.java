package com.example.geektrust.service;

import java.time.LocalDate;

public class Renewaldate {
    private static final int BEFORE_REMINDER = 10;

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

    public RenewalDates calculateRenewalDates(Subscription sub) {
        LocalDate startDate = sub.getStartDate();

        int musicRenewalMonths = Plan.valueOf(sub.getMusicPlan()).getRenewalMonths();
        int videoRenewalMonths = Plan.valueOf(sub.getVideoPlan()).getRenewalMonths();
        int podcastRenewalMonths = Plan.valueOf(sub.getPodcastPlan()).getRenewalMonths();

        LocalDate musicRenewalDate = startDate.plusMonths(musicRenewalMonths).minusDays(BEFORE_REMINDER);
        LocalDate videoRenewalDate = startDate.plusMonths(videoRenewalMonths).minusDays(BEFORE_REMINDER);
        LocalDate podcastRenewalDate = startDate.plusMonths(podcastRenewalMonths).minusDays(BEFORE_REMINDER);

        return new RenewalDates(musicRenewalDate, videoRenewalDate, podcastRenewalDate);
    }
}
