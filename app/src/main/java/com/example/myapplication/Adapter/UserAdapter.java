package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Class.user;
import com.example.myapplication.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<user> userList;

    public UserAdapter(List<user> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        user user = userList.get(position);
        holder.userName.setText(user.getName());
        holder.userEmail.setText(user.getEmail());
        // Set user image placeholder or actual image
        holder.userImage.setImageResource(R.drawable.people); // Replace with actual image if available
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        ImageView userImage;
        TextView userName;
        TextView userEmail;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userImage = itemView.findViewById(R.id.UserImage);
            userName = itemView.findViewById(R.id.username);
            userEmail = itemView.findViewById(R.id.email);
        }
    }
}
