package com.example.fyp.Company;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyp.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class ProgressingOrders extends Fragment {

    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progressing_orders, container, false);

        recyclerView=view.findViewById(R.id.customerCompletedOrderRecycler);
        final FragmentActivity c = getActivity();

        LinearLayoutManager ll=new LinearLayoutManager(c);
        ll.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(ll);




        final ArrayList<ProgressingOrdersModel> list = new ArrayList<>();

        DatabaseReference gotoCompletedOrders = FirebaseDatabase.getInstance().getReference().child("WorkingRequests");

        gotoCompletedOrders.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (isAdded()) {
                    if (dataSnapshot.exists()) {

                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            String requestId = data.getKey();
                            String dname = data.child("driverName").getValue(String.class);
                            String orderName = data.child("orderId").getValue(String.class);
                            String cName = data.child("customerName").getValue(String.class);
                            list.add(new ProgressingOrdersModel(dname, requestId, cName, orderName));
                            ProgressingOrdersAdapter adapter = new ProgressingOrdersAdapter(getActivity(), list);
                            recyclerView.setAdapter(adapter);
                        }

                    }
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

}
