package com.example.vk9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    ImageView userImage;
    TextView name, email, degreeType;


    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        userImage = itemView.findViewById(R.id.imageUser);
        name = itemView.findViewById(R.id.textName);
        email = itemView.findViewById(R.id.textEmail);
        degreeType = itemView.findViewById(R.id.textDegreeType);
    }
}
