package com.example.ssattampd.ui.fragments.locations;

////////////////////////////////////////////////////////////////////////////////
// Name                 Saif Sattar
// Student ID           S1313176
////////////////////////////////////////////////////////////////////////////////

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ssattampd.data.models.Location;
import com.example.ssattampd.databinding.CellLocationBinding;

import java.util.ArrayList;

public class LocationsAdapter extends RecyclerView.Adapter<LocationsAdapter.LocationsViewHolder> {

    private ArrayList<Location> locations = new ArrayList<>();
    private LocationsFragment.OnLocationClickListener onLocationClickListener;

    public LocationsAdapter(LocationsFragment.OnLocationClickListener onLocationClickListener) {
        this.onLocationClickListener = onLocationClickListener;
    }

    public void setData(ArrayList<Location> locations) {
        this.locations.clear();
        this.locations.addAll(locations);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LocationsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LocationsViewHolder(
                CellLocationBinding.inflate(
                        LayoutInflater.from(parent.getContext()),
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull LocationsViewHolder holder, int position) {

        Location location = locations.get(position);
        holder.binding.setLocation(location);
        holder.binding.setOnClickListener(onLocationClickListener);
        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return locations.size();
    }

    class LocationsViewHolder extends RecyclerView.ViewHolder {

        private CellLocationBinding binding;

        public LocationsViewHolder(@NonNull CellLocationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
