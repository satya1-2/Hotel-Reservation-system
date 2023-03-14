package com.hotelReservationSystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HotelReservation {
    public static class HotelRoomReservation {
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

        public String minCostHotel(String input) {
            // Regular: 16Mar2009(mon), 17Mar2009(tue), 18Mar2009(wed)
            String[] arr = input.split(",");
            String customerType = "";
            if (arr.length > 0) {
                String tempArr[] = arr[0].split(":");
                customerType = tempArr[0];
                arr[0] = tempArr[1];
            }
            String hotel = minCostHotel(customerType, arr);
            return hotel;
        }

        private String minCostHotel(String customerType, String[] arr) {
            int numOfWeekdays = 0;
            int numOfWeekends = 0;
            int lakeWoodCost = 0;
            int bridgeWoodCost = 0;
            int ridgeWoodCost = 0;
            for (int i = 0; i < arr.length; i++) {
                String day = arr[i];
                System.out.println(day);
                if (day.contains("mon") || day.contains("tue") || day.contains("wed") || day.contains("thu")
                        || day.contains("fri")) {
                    numOfWeekdays++;
                } else {
                    numOfWeekends++;
                }
            }
            List<Integer> valuesForLakewood = lakeWood.get(customerType); // 0 - weekday, 1- weekend
            List<Integer> valuesForBridgeWood = bridgeWood.get(customerType);
            List<Integer> valuesForRidgeWood = ridgeWood.get(customerType);
            lakeWoodCost = numOfWeekdays * valuesForLakewood.get(0) + numOfWeekends * valuesForLakewood.get(1);
            bridgeWoodCost = numOfWeekdays * valuesForBridgeWood.get(0) + numOfWeekends * valuesForBridgeWood.get(1);
            ridgeWoodCost = numOfWeekdays * valuesForRidgeWood.get(0) + numOfWeekends * valuesForRidgeWood.get(1);
            String hotel = minCost(lakeWoodCost, bridgeWoodCost, ridgeWoodCost);
            System.out.println(lakeWoodCost + " " + bridgeWoodCost + " " + ridgeWoodCost);
            return hotel;
        }

        private String minCost(int lakeWoodCost, int bridgeWoodCost, int ridgeWoodCost) {
            int minCost = Math.min(lakeWoodCost, Math.min(bridgeWoodCost, ridgeWoodCost));
            if (minCost == lakeWoodCost && minCost == bridgeWoodCost) {
                return bridgeWoodRating > lakeWoodRating ? "BridgeWood" : "LakeWood";
            } else if (minCost == bridgeWoodCost && minCost == ridgeWoodCost) {
                return bridgeWoodRating > ridgeWoodCost ? "BridgeWood" : "RidgeWood";
            } else if (minCost == lakeWoodCost && minCost == ridgeWoodCost) {
                return lakeWoodCost > ridgeWoodCost ? "LakeWood" : "RidgeWood";
            } else {
                if (minCost == lakeWoodCost) {
                    return "LakeWood";
                } else if (minCost == bridgeWoodCost) {
                    return "BridgeWood";
                } else {
                    return "RidgeWood";
                }
            }
        }

        public static void main(String[] args) {
            //String input = "Regular: 16Mar2009(mon), 17Mar2009(tue), 18Mar2009(wed)"; //-> LakeWood
            String input = "Rewards: 26Mar2009(thu), 27Mar2009(fri), 28Mar2009(sat)"; // -> RidgeWood
            HotelRoomReservation hotelRoom = new HotelRoomReservation();
            String hotel = hotelRoom.minCostHotel(input);
            System.out.println(hotel);
        }

    }
}