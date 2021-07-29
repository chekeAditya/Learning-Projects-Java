package com.example.student;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {

    private ImageView mTvStudentImg;
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvDob;
    private RelativeLayout mRelativeLayout;
    private TextView mTvAddress;
    private ItemClickListener itemClickListener;

    //don't have any inbuild constructor
    public StudentViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        this.itemClickListener = itemClickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        mTvStudentImg = itemView.findViewById(R.id.ivImage);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        mTvName = itemView.findViewById(R.id.tvname);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvDob = itemView.findViewById(R.id.tvDob);
        mRelativeLayout = itemView.findViewById(R.id.relativeLayout);
    }

    public void setData(Student student) {
        mTvStudentImg.setImageResource(student.getImageId());
        mTvName.setText(student.getName());
        mTvAge.setText(student.getAge() + " ");
        mTvDob.setText(student.getDob());
        mTvAddress.setText(student.getAddress());
        mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get adapter position is nothing but then we click on the first view it will show 0 and on second it will show 1 goes on.
                itemClickListener.onItemClicked(student, getAdapterPosition());
            }
        });
    }
}
