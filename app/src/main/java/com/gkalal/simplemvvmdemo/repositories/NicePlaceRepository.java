package com.gkalal.simplemvvmdemo.repositories;

import androidx.lifecycle.MutableLiveData;
import com.gkalal.simplemvvmdemo.models.NicePlace;
import java.util.ArrayList;
import java.util.List;

public class NicePlaceRepository {

  private static NicePlaceRepository instance;
  private ArrayList<NicePlace> dataset = new ArrayList<>();

  public static NicePlaceRepository getInstance() {
    if (instance == null) {
      instance = new NicePlaceRepository();
    }
    return instance;
  }

  public MutableLiveData<List<NicePlace>> getNicePlaces() {
    setNicePlaces();
    MutableLiveData<List<NicePlace>> data = new MutableLiveData<>();
    data.setValue(dataset);
    return data;
  }

  private void setNicePlaces() {
    try {
      dataset.add(new NicePlace("St. Lucia",
          "https://www.usnews.com/dims4/USNEWS/fb70b9f/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F50%2F51%2F7aaf5357446eb09cacd79a3e28fb%2F160111-stluciatwinpitons-stock.jpg"));
      dataset.add(new NicePlace("Jackson Hole, Wyoming",
          "https://www.usnews.com/dims4/USNEWS/2f8409d/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F87%2F36%2F282224ce4ea2b03469bfaf1d62fb%2F150821-jacksonhole-stock.jpg"));
      dataset.add(new NicePlace("Banff, Alberta",
          "https://www.usnews.com/dims4/USNEWS/2e3209e/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F48%2F89%2Fb13c45394aeda4456ced12b7ab0a%2F160511-banffnationalpark-stock.jpg"));
      dataset.add(new NicePlace("Machu Picchu",
          "https://www.usnews.com/dims4/USNEWS/b32d9e5/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2Ffe%2F3d%2F5c0e07984bc2b8460de68fb8add8%2F160203-machupicchu-stock.jpg"));
      dataset.add(new NicePlace("Great Barrier Reef",
          "https://www.usnews.com/dims4/USNEWS/4eeb968/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F40%2Fc3%2F84e57c45448db612f326c23b8dcd%2F160420-greatbarrierreef-stock.jpg"));
      dataset.add(new NicePlace("Park City, Utah",
          "https://www.usnews.com/dims4/USNEWS/6867a50/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F3f%2F7e%2F3bfb23b5445e84753fd7f5170940%2Fparkcityutah.jpg"));
      dataset.add(new NicePlace("The British Virgin Islands",
          "https://www.usnews.com/dims4/USNEWS/de0a44f/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F6f%2F3b%2F335740f14c2da6bb03a1867aa402%2F160111-britishvirginislands-stock.jpg"));
      dataset.add(new NicePlace("Costa Rica",
          "https://www.usnews.com/dims4/USNEWS/b623a7e/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F46%2F69%2Feaa5c1b0452695f940e122855156%2F160421-costaricawaterfall-stock.jpg"));
      dataset.add(new NicePlace("Yosemite National Park",
          "https://www.usnews.com/dims4/USNEWS/e3a6f33/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F64%2Fb3%2Feab4d9e044fb811ec21ee12b0e7e%2F140519-yosemite-stock.jpg"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
