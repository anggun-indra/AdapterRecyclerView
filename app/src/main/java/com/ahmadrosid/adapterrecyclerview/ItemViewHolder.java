package com.ahmadrosid.adapterrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ocittwo on 22/08/16.
 */
public class ItemViewHolder extends RecyclerView.ViewHolder {

    private TextView text;

    public ItemViewHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.text);
    }

    public void bind(String model) {
        text.setText(model);
    }
}
