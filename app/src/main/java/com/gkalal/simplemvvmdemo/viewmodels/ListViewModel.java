package com.gkalal.simplemvvmdemo.viewmodels;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.gkalal.simplemvvmdemo.models.NicePlace;
import com.gkalal.simplemvvmdemo.repositories.NicePlaceRepository;
import java.util.List;

public class ListViewModel extends ViewModel {

  private MutableLiveData<List<NicePlace>> nicePlaces;
  private NicePlaceRepository nicePlaceRepository;
  private MutableLiveData<Boolean> isUpdating = new MutableLiveData<>();

  public void init() {
    if (nicePlaces != null) {
      return;
    }
    nicePlaceRepository = NicePlaceRepository.getInstance();
    nicePlaces = nicePlaceRepository.getNicePlaces();
  }

  public LiveData<List<NicePlace>> getNicePlaces() {
    return nicePlaces;
  }

  @SuppressLint("StaticFieldLeak") public void addNewPlace(final NicePlace place) {
    isUpdating.setValue(true);

    new AsyncTask<Void, Void, Void>() {

      @Override protected Void doInBackground(Void... voids) {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        return null;
      }

      @Override protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        List<NicePlace> newPlace = nicePlaces.getValue();
        newPlace.add(place);
        nicePlaces.postValue(newPlace);
        isUpdating.postValue(false);
      }
    }.execute();
  }

  public LiveData<Boolean> checkIfUpdating() {
    return isUpdating;
  }
}
