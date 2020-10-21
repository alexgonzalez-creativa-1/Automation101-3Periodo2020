package DataProviders;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.testng.annotations.DataProvider;
import pojo.productData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class productsDataProvider {
    @DataProvider(name = "getProductsFromJson")
    public Object[] getProductsFromJson() throws FileNotFoundException {
        JsonElement jsonData = new JsonParser().parse(new FileReader("src/test/java/DataFiles/productData.json"));
        JsonElement productsDataSet = jsonData.getAsJsonObject().get("dataset");

        List<productData> usersData = new Gson().fromJson(productsDataSet, new TypeToken<List<productData>>(){}.getType());

        Object[][] returnValue = new Object[usersData.size()][1];

        int index = 0;

        for (Object[] each: returnValue) {
            each[0] = usersData.get(index++);
        }

        return returnValue;
    }
}
