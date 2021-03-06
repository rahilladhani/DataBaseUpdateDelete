package com.offlinedata;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.offlinedata.Resonse.ListResoponse;
import com.offlinedata.application.ApiDemo;

import java.util.List;

/**
 * Created by abc on 19-06-17.
 */
public class ListAdapter extends BaseAdapter {
    private LayoutInflater mLayoutInflater;
    Context context;
    List<ListResoponse> data;
    ImageLoader imageLoader;
    public ListAdapter(Context context, List<ListResoponse> data)
    {
        this.context = context;
        this.data = data;
        mLayoutInflater = LayoutInflater.from(context);
        imageLoader = ImageLoader.getInstance();
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View vi = view;             //trying to reuse a recycled view
        ViewHolder holder = null;
        if (vi == null) {
            //The view is not a recycled one: we have to inflate
            vi = mLayoutInflater.inflate(R.layout.row_list, parent, false);
            holder = new ViewHolder();
            holder.txt_name = (TextView) vi.findViewById(R.id.txt_name);
            holder.homework = (TextView) vi.findViewById(R.id.homework);
            holder.iv_image = (ImageView) vi.findViewById(R.id.iv_image);
            holder.subject = (TextView) vi.findViewById(R.id.subject);
            holder.client_id = (TextView) vi.findViewById(R.id.client_id);
            vi.setTag(holder);
        } else {
            // View recycled !
            // no need to inflate
            // no need to findViews by id
            holder = (ViewHolder) vi.getTag();
        }

        holder.txt_name.setText(data.get(position).getFirstName());
        holder.client_id.setText(data.get(position).getClientId());
        holder.subject.setText(data.get(position).getSubject());
        holder.homework.setText(data.get(position).getHomework());

        imageLoader.displayImage(data.get(position).getProfilePic(),holder.iv_image, ApiDemo.getFoodPicture(context));
        return vi;
    }


    static class ViewHolder{
        TextView txt_name,client_id,subject,homework;
        ImageView iv_image;
    }
}
