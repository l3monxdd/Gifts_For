package com.gifts.parser;

import com.gifts.entity.Commodity;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 01.06.17.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Document document = Jsoup.connect("https://www.gifts.com/").get();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");

        EntityManager manager = factory.createEntityManager();

        manager.getTransaction().begin();


        for (Commodity commodity : parse(document)) {
//            System.out.println("commodity = " + commodity);

            manager.persist(commodity);
        }

        manager.getTransaction().commit();



    }


    public static List<Commodity> parse(Document document){

        ArrayList<Commodity> commodities = new ArrayList<>();

        Elements elementNames = document.select("div.name");
        Elements elementPrices = document.select("span.prices  ");


        for (Element element : elementNames) {
            Commodity commodity = new Commodity();
            commodity.setName_of_commodity(element.text());
            commodities.add(commodity);
        }

        int counter = 0;
        for (Element elementPrice : elementPrices) {
            String price = elementPrice.text().replace("$","");
            if(price.contains(" ")){
                price = price.substring(0, price.indexOf(" ")+1);
               commodities.get(counter).setPrice_id_uan(Double.parseDouble(price));
            }else{
                commodities.get(counter).setPrice_id_uan(Double.parseDouble(price));
            }
            counter++;
        }


        return commodities;
    }

}
