package com.hotelReservationSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public  class HotelReservation {
    public static  class HotelRoomReservation {
        private HashMap<String, List<Integer>> lakeWood = new HashMap<>();
        private HashMap<String, List<Integer>> bridgeWood = new HashMap<>();
        private HashMap<String, List<Integer>> ridgeWood = new HashMap<>();
        private static int lakeWoodRating;
        private static int bridgeWoodRating;
        private static int rigdeWoodRating;

        public HotelRoomReservation() {
            setLakeWood();
            setBridgeWood();
            setRidgeWood();
        }

        private void setLakeWood() {
            List<Integer> lakeWoodRewards = new ArrayList<>();
            lakeWoodRewards.add(80);
            lakeWoodRewards.add(80);

            List<Integer> lakeWoodRegular = new ArrayList<>();
            lakeWoodRegular.add(110);
            lakeWoodRegular.add(90);

            lakeWood.put("Rewards", lakeWoodRewards);
            lakeWood.put("Regular", lakeWoodRegular);
            lakeWoodRating = 3;
        }

        private void setBridgeWood() {
            List<Integer> bridgeWoodRewards = new ArrayList<>();
            bridgeWoodRewards.add(110);
            bridgeWoodRewards.add(50);

            List<Integer> bridgeWoodRegular = new ArrayList<>();
            bridgeWoodRegular.add(160);
            bridgeWoodRegular.add(60);

            bridgeWood.put("Rewards", bridgeWoodRewards);
            bridgeWood.put("Regular", bridgeWoodRegular);
            bridgeWoodRating = 4;
        }

        private void setRidgeWood() {
            List<Integer> ridgeWoodRewards = new ArrayList<>();
            ridgeWoodRewards.add(100);
            ridgeWoodRewards.add(40);

            List<Integer> ridgeWoodRegular = new ArrayList<>();
            ridgeWoodRegular.add(220);
            ridgeWoodRegular.add(150);

            ridgeWood.put("Rewards", ridgeWoodRewards);
            ridgeWood.put("Regular", ridgeWoodRegular);
            rigdeWoodRating = 5;
        }

        public static void main(String[] args) {
            HotelRoomReservation hotelRoomReservation = new HotelRoomReservation();
        }

    }}