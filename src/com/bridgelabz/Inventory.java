package com.bridgelabz;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;



public class Inventory {

    public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {

        JSONPagirser jsonparser = new JSONParser();
        FileReader reader = new FileReader("C:\\Users\\Admin\\IdeaProjects\\Json_Inventory\\src\\details.json");

// Java Object variable
        Object obj = jsonparser.parse(reader); // THis is my Main Object i.e which includes JSONParser, JSONObject, JSONarray

// JSON Object ( after type casting)
        JSONObject inventoryobj = (JSONObject)obj; // FIle Inventory.json it will pasrse the object to JSONObject
        JSONArray array = (JSONArray)inventoryobj.get("inventoryDetails"); // Will now change JSON Object to JSON Array.

        for (int i = 0; i < array.size(); i++ )
        {
            JSONObject inventoryDetails = (JSONObject)array.get(i);

            String name = (String) inventoryDetails.get("name");
            double weight = Double.parseDouble(inventoryDetails.get("weight").toString());
            double pricePerKg = Double.parseDouble(inventoryDetails.get("pricePerKg").toString());
            String type = (String) inventoryDetails.get("type");

            System.out.println("inventoryDetail " +i+ " is ......");

            System.out.println("Name : " + name);
            System.out.println("Weight : " + weight);
            System.out.println("PricePerKg : " + pricePerKg);
            System.out.println("Type : " + type);

            double value = weight * pricePerKg;
            System.out.println("Value for Inventory is : " + value + "\n");
        }
    }
}