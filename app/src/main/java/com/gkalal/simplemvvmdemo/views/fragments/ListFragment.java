package com.gkalal.simplemvvmdemo.views.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.gkalal.simplemvvmdemo.ListFragmentBinder;
import com.gkalal.simplemvvmdemo.R;
import com.gkalal.simplemvvmdemo.adapters.ListAdapter;
import com.gkalal.simplemvvmdemo.models.NicePlace;
import com.gkalal.simplemvvmdemo.viewmodels.ListViewModel;
import java.util.List;

public class ListFragment extends Fragment implements View.OnClickListener {

  private ListFragmentBinder mBinder;
  private ListAdapter listAdapter;
  private ListViewModel listViewModel;

  public ListFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    mBinder = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false);
    return mBinder.getRoot();
  }

  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    mBinder.fabAddNewPlace.setOnClickListener(this);

    listViewModel = ViewModelProviders.of(getActivity()).get(ListViewModel.class);

    listViewModel.init();

    listViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
      @Override public void onChanged(List<NicePlace> nicePlaces) {
        listAdapter.notifyDataSetChanged();
      }
    });

    listViewModel.checkIfUpdating().observe(this, new Observer<Boolean>() {
      @Override public void onChanged(Boolean isUpdating) {
        if (isUpdating) {
          showProgressBar();
        } else {
          hideProgressBar();
          mBinder.recyclerView.smoothScrollToPosition(
              listViewModel.getNicePlaces().getValue().size() - 1);
        }
      }
    });

    initRecyclerView();
  }

  private void initRecyclerView() {
    try {
      listAdapter = new ListAdapter(listViewModel.getNicePlaces().getValue(), getActivity());
      RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
      mBinder.recyclerView.setLayoutManager(layoutManager);
      mBinder.recyclerView.setHasFixedSize(true);
      mBinder.recyclerView.setAdapter(listAdapter);
    } catch (NullPointerException e) {
      e.printStackTrace();
    }
  }

  private void showProgressBar() {
    mBinder.progressBar.setVisibility(View.VISIBLE);
  }

  private void hideProgressBar() {
    mBinder.progressBar.setVisibility(View.GONE);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.fabAddNewPlace:
        listViewModel.addNewPlace(new NicePlace("Tahiti, French Polynesia",
            "https://www.usnews.com/dims4/USNEWS/f4aa438/2147483647/resize/1200x%3E/quality/85/?url=http%3A%2F%2Fmedia.beam.usnews.com%2F71%2F49%2Fe488592b45c1b91969dfb422af75%2F5-tahiti.jpg"));
        break;
    }
  }
}
