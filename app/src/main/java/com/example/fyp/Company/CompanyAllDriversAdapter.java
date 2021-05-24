package com.example.fyp.Company;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fyp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CompanyAllDriversAdapter extends RecyclerView.Adapter<CompanyAllDriversAdapter.viewHolder> {

    ArrayList<CompanyAllCustomersModel> mdata;
    private LayoutInflater mlayoutinflater;
    Context context;
    private ItemClickListener mylistener;
    int x;
    private String driverId;

    public CompanyAllDriversAdapter(Context context,ArrayList<CompanyAllCustomersModel> mdata){
        mlayoutinflater=LayoutInflater.from(context);
        this.mdata=mdata;
        this.context=context;

    }


    @NonNull
    @Override
    public CompanyAllDriversAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = mlayoutinflater.inflate(R.layout.single_company_all_customers, viewGroup, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyAllDriversAdapter.viewHolder viewHolder, int i) {
        viewHolder.text1.setText(mdata.get(i).getName());
        viewHolder.text2.setText(mdata.get(i).getMobile());
        String image=mdata.get(i).getImage();
        driverId=mdata.get(i).getcId();
        if (!image.equals("default")) {
            Picasso.get().load(image).into(viewHolder.imageView);
        }

    }

    @Override
    public int getItemCount() {
        return mdata.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView text1,text2;

        CircleImageView imageView;
        public viewHolder(View itemView) {
            super(itemView);
            text1 = (TextView) itemView.findViewById(R.id.companycustomerName);
            text2 = (TextView) itemView.findViewById(R.id.companycustomerMobile);
            imageView= (CircleImageView) itemView.findViewById(R.id.customerPic);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "gooood", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(context, ShowCompanyAllDriversDetails.class);
                    intent.putExtra("idofDriver",driverId);
                    context.startActivity(intent);
                }
            });
        }

        @Override
        public void onClick(View v) {
            mylistener.onItemClick(getAdapterPosition());
        }
    }

    void setClickListener(CompanyAllDriversAdapter.ItemClickListener itemClickListener) {
        this.mylistener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(int position);
    }
}
