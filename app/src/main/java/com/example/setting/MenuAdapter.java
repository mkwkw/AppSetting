//데이터와 아이템에 대한 뷰를 생성해주는 기능

package com.example.setting;

import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//어댑터
public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder>{
    ArrayList<Settingmenu> items = new ArrayList<Settingmenu>(); //메뉴 이름 저장

    //알림설정 on off 상태 저장할 array 객체
    private SparseBooleanArray selected = new SparseBooleanArray();
    private int prePosition = -1;

   public void addItem(Settingmenu item){
       items.add(item);
   }

   public void setItems(ArrayList<Settingmenu> items){
       this.items = items;
   }

   public Settingmenu getItem(int position){
       return items.get(position);
   }

   public void setItem(int position, Settingmenu item){
       items.set(position, item);
   }


   @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.menu_item, viewGroup, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Settingmenu item = items.get(position);
        viewHolder.setItem(item);

        ViewHolder viewholdersetting = (ViewHolder) viewHolder;
        viewholdersetting.setItem(items.get(position));
        viewholdersetting.setOnViewHolderItemClickListener(new OnViewHolderItemClickListener() {
            @Override
            public void onViewHolderItemClick() {
                if(selected.get(position)){
                    //펼쳐진 Item을 클릭 시
                    selected.delete(position);
                }

            }
        });



    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //리사이클러 뷰에 대한 모든 서브 뷰를 보유, 데이터 값에 따라 변경되어 보여질 뷰
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        Switch toggle;

        OnViewHolderItemClickListener onViewHolderItemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textView);
            toggle = itemView.findViewById(R.id.toggle);

        }
        public void setItem(Settingmenu item){
            textView.setText(item.getMenu());
        }

        public void setOnViewHolderItemClickListener(OnViewHolderItemClickListener onViewHolderItemClickListener){
            this.onViewHolderItemClickListener =  onViewHolderItemClickListener;
        }
    }




}
