package com.codingblocks.codingblocks.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codingblocks.codingblocks.R;
import com.codingblocks.codingblocks.interfaces.onItemClickListener;
import com.codingblocks.codingblocks.models.AuthorBooksCB;
import com.codingblocks.codingblocks.models.List;

import java.util.ArrayList;

/**
 * Created by rishabhkhanna on 02/07/17.
 */

public class AllBooksAdapter extends RecyclerView.Adapter<AllBooksAdapter.AllBooksViewHolder>{

    private Context context;
    private ArrayList<List> booksCBArrayList;
    private onItemClickListener clickListener;

    public void setClickListener(onItemClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public AllBooksAdapter(Context context, ArrayList<List> booksCBArrayList) {
        this.context = context;
        this.booksCBArrayList = booksCBArrayList;
    }

    @Override
    public AllBooksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View root = li.inflate(R.layout.all_books_layout,parent,false);

        return new AllBooksViewHolder(root);
    }

    @Override
    public void onBindViewHolder(AllBooksViewHolder holder, int position) {
        final List thisBook = booksCBArrayList.get(position);
        holder.tvBookTitle.setText(thisBook.getTitle());
        holder.tvBookDesc.setText(thisBook.getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null){
                    clickListener.onItemClicklistener(thisBook);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return booksCBArrayList.size();
    }

    public class AllBooksViewHolder extends RecyclerView.ViewHolder{
    TextView tvBookTitle;
    TextView tvBookDesc;
    View itemView;
    public AllBooksViewHolder(View itemView) {
        super(itemView);
        tvBookTitle = (TextView) itemView.findViewById(R.id.tvBookTitle);
        tvBookDesc = (TextView) itemView.findViewById(R.id.tvBookDesc);
        this.itemView = itemView;
    }
}
}
