package com.ashwin.examples.dynamicretrofitresponse;

import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ashwin on 26/09/18.
 */

public class Profile {
    @SerializedName("id") String id;
    @SerializedName("firstname") String firstname;
    @SerializedName("lastname") String lastname;
    @SerializedName("gender") String gender;
    @SerializedName("age") int age;
    @SerializedName("company") String company;
    @SerializedName("profession") String profession;
    @SerializedName("address") JsonElement address;
    @SerializedName("phone") String phone;
    @SerializedName("points") double points;

    public JSONObject getAddress() {
        try {
            return new JSONObject(address.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return new StringBuilder("{")
                .append("id: ").append(id)
                .append(", firstname: ").append(firstname)
                .append(", lastname: ").append(lastname)
                .append(", gender: ").append(gender)
                .append(", address: ").append(String.valueOf(address))
                .append("}")
                .toString();
    }
}
