package com.example.setting;

import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

//리사이클러 뷰에 대한 모든 서브 뷰를 보유, 데이터 값에 따라 변경되어 보여질 뷰
public class ViewHolderSetting extends RecyclerView.ViewHolder{
    TextView textView;
    Switch toggle;

    public ViewHolderSetting(View itemView) {
        super(itemView);

        textView = itemView.findViewById(R.id.textView);
        toggle = itemView.findViewById(R.id.toggle);

    }
    public void setItem(Settingmenu item){
        textView.setText(item.getMenu());
    }
}