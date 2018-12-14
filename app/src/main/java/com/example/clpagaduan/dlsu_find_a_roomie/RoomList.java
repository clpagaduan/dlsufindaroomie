package com.example.clpagaduan.dlsu_find_a_roomie;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class RoomList extends ArrayAdapter<Room> {
    private Activity context;
    private List<Room> roomList;

    public RoomList(Activity context, List<Room> roomList){
        super(context, R.layout.list_layout, roomList);
        this.context = context;
        this.roomList = roomList;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewRent = listViewItem.findViewById(R.id.textViewRent);

        Room room = roomList.get(position);

        textViewName.setText(room.getRoomName());
        textViewRent.setText(room.getRoomRent());

        return listViewItem;
    }
}
