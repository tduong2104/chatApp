package com.doan.chatapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.doan.chatapp.Models.UserModel;
import com.doan.chatapp.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import android.content.Context;

public class SearchUserRecycleAdapter extends FirestoreRecyclerAdapter<UserModel, SearchUserRecycleAdapter.UserModelViewHolder> {

    Context context;
    public SearchUserRecycleAdapter(@NonNull FirestoreRecyclerOptions<UserModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull UserModelViewHolder holder, int position, @NonNull UserModel model) {
        holder.usernameTxt.setText(model.getUsername());
        holder.phoneTxt.setText(model.getPhone());
    }

    @NonNull
    @Override
    public UserModelViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_user_recycler_row,parent,false);
        return new UserModelViewHolder(view);
    }


    class UserModelViewHolder extends RecyclerView.ViewHolder{
        TextView usernameTxt;
        TextView phoneTxt;
        TextView profilePic;

        public UserModelViewHolder(@NonNull View itemView) {
            super(itemView);
            usernameTxt = itemView.findViewById(R.id.username_txt);
            phoneTxt = itemView.findViewById(R.id.phone_txt);
            profilePic = itemView.findViewById(R.id.profile_pic_image_view);
        }
    }
}
