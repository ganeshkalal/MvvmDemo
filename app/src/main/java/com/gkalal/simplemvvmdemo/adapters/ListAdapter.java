package com.gkalal.simplemvvmdemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.gkalal.simplemvvmdemo.ItemListBinder;
import com.gkalal.simplemvvmdemo.R;
import com.gkalal.simplemvvmdemo.models.NicePlace;
import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

  private List<NicePlace> nicePlaceList = new ArrayList<>();
  private Context context;
  private ItemListBinder mBinder;

  public ListAdapter(List<NicePlace> nicePlaceList, Context context) {
    this.nicePlaceList = nicePlaceList;
    this.context = context;
  }

  @NonNull @Override
  public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    mBinder =
        DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.layout_item_list,
            parent, false);
    return new ListAdapter.ViewHolder(mBinder);
  }

  @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    try {
      NicePlace nicePlace = nicePlaceList.get(position);
      if (nicePlace != null) {
        mBinder.textViewPlaceName.setText(nicePlace.getPlaceName());

        Glide.with(context)
            .load(nicePlace.getPlaceImageUrl())
            .into(mBinder.imageViewPlacePhoto);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override public long getItemId(int position) {
    return position;
  }

  @Override public int getItemViewType(int position) {
    return position;
  }

  @Override public int getItemCount() {
    return nicePlaceList.size();
  }

  class ViewHolder extends RecyclerView.ViewHolder {
    ItemListBinder mBinder;

    ViewHolder(ItemListBinder binder) {
      super(binder.getRoot());
      this.mBinder = binder;
    }
  }
}
