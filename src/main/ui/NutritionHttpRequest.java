package ui;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ui.FridgeApp;

// does the http request for the nutrition api
public class NutritionHttpRequest {

    FridgeApp fridge = new FridgeApp();
    public final CloseableHttpClient httpClient = HttpClients.createDefault();

    public String getNutrition(String foodName) throws Exception {
        URIBuilder builder = new URIBuilder("https://api.edamam.com/api/nutrition-data");
        builder.setParameter("app_id", "b08d9bae")
                .setParameter("app_key", "65f1f862ee3bb66d6a67297139a546b4")
                .setParameter("ingr", foodName);
        HttpGet request = new HttpGet(builder.build());
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
                return parseNutrition(result);
            }

        }
        return null;
    }

    //https://mkyong.com/java/json-simple-example-read-and-write-json/
    public String parseNutrition(String s) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(s);
            String calories = json.get("calories").toString();

            JSONObject healthNutrients = (JSONObject) json.get("totalNutrients");
            JSONObject fat = (JSONObject) healthNutrients.get("FAT");
            //String fatAmount = fat.get("quantity").toString().substring(0,5);
            double fatAmount = Double.parseDouble(fat.get("quantity").toString().substring(0,5));
            String fatUnit = fat.get("unit").toString();

            JSONObject saturatedFat = (JSONObject) healthNutrients.get("FASAT");
            double saturatedFatAmount = Double.parseDouble(saturatedFat.get("quantity").toString().substring(0,5));
            String saturatedFatUnit = saturatedFat.get("unit").toString();

            JSONObject monoUnsaturatedFat = (JSONObject) healthNutrients.get("FAMS");
            String monoUnsaturatedFatAmount = monoUnsaturatedFat.get("quantity").toString().substring(0,5);
            String monoUnsaturatedFatUnit = monoUnsaturatedFat.get("unit").toString();

            JSONObject polyUnsaturatedFat = (JSONObject) healthNutrients.get("FAMS");
            String polyUnsaturatedFatAmount = polyUnsaturatedFat.get("quantity").toString().substring(0,5);
            String polyUnsaturatedFatUnit = polyUnsaturatedFat.get("unit").toString();

            JSONObject protein = (JSONObject) healthNutrients.get("PROCNT");
            String sugarAmount = protein.get("quantity").toString().substring(0,5);
            String sugarUnit = protein.get("unit").toString();

            JSONObject carbs = (JSONObject) healthNutrients.get("CARBS");
            double carbAmount = Double.parseDouble(carbs.get("quantity").toString().substring(0,3000));
            String carbUnit = carbs.get("unit").toString();

            JSONObject calorie = (JSONObject) healthNutrients.get("ENERC_KCAL");
            double calorieAmount = Double.parseDouble(calorie.get("quantity").toString().substring(0,3000));
            String calorieUnit = calorie.get("unit").toString();

            double calorieForXObjects = calorieAmount * fridge.amount;

            String nutrition = "Calories: " + calorieForXObjects + " "
                    + "Fat: " + fatAmount + fatUnit + " "
                    + "Sugar: " + sugarAmount + sugarUnit + " ";
            return nutrition;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

//    public String parse
}
