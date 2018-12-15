package com.example.clpagaduan.dlsu_find_a_roomie;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class TenantList extends ArrayAdapter<Tenant>{
        private Activity context;
        private List<Tenant> tenants;

        public TenantList(Activity context, List<Tenant> tenants){
            super(context, R.layout.layout_tenant_list, tenants);
            this.context = context;
            this.tenants = tenants;
        }
        @NonNull
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.layout_tenant_list, null, true);

            TextView textViewName = listViewItem.findViewById(R.id.textViewName);
            TextView textViewSlot = listViewItem.findViewById(R.id.textViewSlot);

            Tenant tenant = tenants.get(position);

            textViewName.setText(tenant.getUid());
            textViewSlot.setText(tenant.getTentantSlot());

            return listViewItem;
        }
}
