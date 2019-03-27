package com.gkalal.simplemvvmdemo.models;

public class NicePlace {

  private String placeName, placeImageUrl;

  public NicePlace(String placeName, String placeImageUrl) {
    this.placeName = placeName;
    this.placeImageUrl = placeImageUrl;
  }

  public String getPlaceName() {
    return placeName;
  }

  public String getPlaceImageUrl() {
    return placeImageUrl;
  }
}
