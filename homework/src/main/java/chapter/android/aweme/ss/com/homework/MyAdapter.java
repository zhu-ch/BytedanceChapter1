package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import chapter.android.aweme.ss.com.homework.model.Message;
import chapter.android.aweme.ss.com.homework.widget.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Message> myData;
    public MyAdapter(List<Message> data){
        myData = data;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();
        int layoutIdForListItem = R.layout.my_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, viewGroup, shouldAttachToParentImmediately);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, int i) {
        Message message = myData.get(i);
        myViewHolder.upgradeUI(message);
    }

    @Override
    public int getItemCount() {
        return myData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private final TextView itemName;
        private final TextView itemDescription;
        private final TextView itemTime;
        private chapter.android.aweme.ss.com.homework.widget.CircleImageView itemIcon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            itemName = (TextView)itemView.findViewById(R.id.item_name);
//            itemDescription = (TextView)itemView.findViewById(R.id.item_description);
//            itemTime = (TextView)itemView.findViewById(R.id.item_time);
//            itemIcon = (CircleImageView)itemView.findViewById(R.id.item_icon);
            itemName = (TextView)itemView.findViewById(R.id.tv_title);
            itemDescription = (TextView)itemView.findViewById(R.id.tv_description);
            itemTime = (TextView)itemView.findViewById(R.id.tv_time);
            itemIcon = (CircleImageView)itemView.findViewById(R.id.iv_avatar);
        }

        public void upgradeUI(Message message){
            itemName.setText(message.getTitle());
            itemDescription.setText(message.getDescription());
            itemTime.setText(message.getTime());
            itemIcon.setImageResource(message.getIcon());
            }
     }
}
