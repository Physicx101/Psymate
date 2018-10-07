package com.example.bogi.psymate.data;

import android.content.Context;
import android.content.res.TypedArray;

import com.example.bogi.psymate.model.Clinic;
import com.example.bogi.psymate.model.People;
import com.example.bogi.psymate.R;
import com.example.bogi.psymate.utils.Tools;



import java.util.ArrayList;


import java.util.List;

import java.util.Random;

@SuppressWarnings("ResourceType")
public class DataGenerator {

    private static Random r = new Random();

    public static int randInt(int max) {
        int min = 0;
        return r.nextInt((max - min) + 1) + min;
    }

    /**
     * Generate dummy data clinics
     *
     * @param ctx android context
     * @return list of object
     */
    public static List<Clinic> getClinicData(Context ctx) {
        List<Clinic> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.clinic_images);
        String name_arr[] = ctx.getResources().getStringArray(R.array.clinic_names);
        String rating_arr[] = ctx.getResources().getStringArray(R.array.clinic_ratings);
        String address_arr[] = ctx.getResources().getStringArray(R.array.clinic_address);

        for (int i = 0; i < drw_arr.length(); i++) {
            Clinic obj = new Clinic();
            obj.imgRef = drw_arr.getResourceId(i, -1);
            obj.clinicName = name_arr[i];
            obj.address = address_arr[i];
            obj.rating = rating_arr[i];
            obj.distance = Tools.getDistance(obj.rating);
            obj.clinicImage= ctx.getResources().getDrawable(obj.imgRef);
            items.add(obj);
        }
        //Collections.shuffle(items);
        return items;
    }
    /**
     * Generate dummy data psychologists
     *
     * @param ctx android context
     * @return list of object
     */

    public static List<People> getPeopleData(Context ctx) {
        List<People> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.people_images);
        String name_ar[] = ctx.getResources().getStringArray(R.array.people_names);

        for (int i = 0; i < drw_arr.length(); i++) {
            People obj = new People();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.name = name_ar[i];
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        return items;
    }


    private static int getRandomIndex(int max) {
        return r.nextInt(max - 1);
    }
}
