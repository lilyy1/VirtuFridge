package ui;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.Random;

// does the http request for the recipes api
public class RecipeHttpRequest {

    public final CloseableHttpClient httpClient = HttpClients.createDefault();
    protected String recipeName;
    protected String recipeLink;
    protected String recipeIngredients;

    public String getRecipes(String foodName) throws Exception {
        URIBuilder builder = new URIBuilder("https://api.edamam.com/search");
        builder.setParameter("app_id", "4439eed1")
                .setParameter("app_key", "34503407ac87739aeebe211e1ccafe9b")
                .setParameter("q", foodName)
                .setParameter("to", "5");
        HttpGet request = new HttpGet(builder.build());
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // return it as a String
                String result = EntityUtils.toString(entity);
 //               parseRecipes(result);
//                System.out.println("Here's a recipe called " + recipeName + "!" );
 //               System.out.println("Here's the link." + recipeLink);
            }
        }
        return null;
    }

    //https://stackoverflow.com/questions/45644144/using-json-simple-to-parse-an-array-of-objects-from-a-file
    public void parseRecipes(String s) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(s);
            JSONArray array = (JSONArray) json.get("hits");
            JSONObject getRecipeNum = (JSONObject) array.get(randInt(0, 4));
            JSONObject getRecipe = (JSONObject) getRecipeNum.get("recipe");
            recipeName = getRecipe.get("label").toString();
//      FIX ISSUE SO RECIPE NAME CAN BE STORED AS A GLOBAL VARIABLE OR SOMETHING TO BE CALLED ABOVE!!!!!!!!!
            recipeLink = getRecipe.get("url").toString();
            recipeIngredients = getRecipe.get("ingredientLines").toString();
            System.out.println("Here's a recipe called " + recipeName + "!");
            System.out.println("Here's the recipe link for cooking directions! " + recipeLink);
 //           System.out.println("You will need these ingredients.");
            //System.out.println(recipeIngredients);


    //        String recipe =  ": " + link + " ingredients required: " + ingredients;
//            System.out.println("Here is a recipe! " + name);
//            System.out.println(link);

//            return recipe; if using GUI
//            System.out.println(link);
//
//            JSONObject getRecipeNum1 = (JSONObject) array.get(randInt(0,24));
//            JSONObject getRecipe1 = (JSONObject) getRecipeNum1.get("recipe");
//            String name1 = getRecipe1.get("label").toString();
//            String link1 = getRecipe1.get("url").toString();
//            String recipe = "Here is a recipe that includes it "
//                    + " it is called " + name1 + " and here is a link to the recipe " + link1;
        } catch (ParseException e) {
            e.printStackTrace();
        }
 //       return null;
    }


    // https://stackoverflow.com/questions/363681/how-do-i-generate-random-integers-within-a-specific-range-in-java
    public static int randInt(int min, int max) {
        Random random = new Random();
        int randomNum = random.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
