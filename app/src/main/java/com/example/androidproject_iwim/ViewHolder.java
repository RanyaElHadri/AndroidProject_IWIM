package com.example.androidproject_iwim;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder
{
    TextView mnom, memail, mnumtel,mmatiere, mnbreheures;
    View mView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);


        mView= itemView;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());
            }
        });
        //item long click listner
        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mClickListener.OnItemLongClick(v, getAdapterPosition());
                return true;
            }
        });

        //initialiser view with model_layout.xml
        mnom = itemView.findViewById(R.id.rnom);
        memail = itemView.findViewById(R.id.remail);
        mmatiere = itemView.findViewById(R.id.rmatiere);
        mnumtel = itemView.findViewById(R.id.rnumtel);

        mnbreheures = itemView.findViewById(R.id.rnbreheures);


    }

    private  ViewHolder.ClickListener mClickListener;

        //interface for click listner
    public interface ClickListener{
        void onItemClick(View view, int position);
        void OnItemLongClick(View view, int position);

        }

        public void setOnClickLinstener(ViewHolder.ClickListener clickLinstener){
mClickListener = clickLinstener;
mClickListener = clickLinstener;
        }



}
