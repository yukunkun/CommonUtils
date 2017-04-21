package com.cxria.livetest.activity.photo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;
import com.cxria.livetest.R;

import java.util.ArrayList;

public class ListDetailActivity extends Activity {

    private ArrayList<ImageDetail> lists=new ArrayList<>();
    private GridView gridView;
    private GlideViewAdapter glideViewAdapter;
    ArrayList<String> mCheckNumber=new ArrayList<>();
    private TextView mTextView;
    private TextView mMTextViewAll;
    private final int MAXNUMBER=5;

    private void init() {
        gridView = (GridView) findViewById(R.id.grideview);
        mTextView = (TextView) findViewById(R.id.tv_over);
        mMTextViewAll = (TextView) findViewById(R.id.tv_all);

        if(lists.size()==0){

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list);
        ArrayList<String> photo = getIntent().getStringArrayListExtra("photo");
        for (int i = 0; i < photo.size(); i++) {
            ImageDetail imageDetail=new ImageDetail();
            imageDetail.setImagePath(photo.get(i));
            imageDetail.setChecked(false);
            lists.add(imageDetail);
        }
        init();
        setAdapter();
        setListener();
    }

    private void setAdapter() {
        glideViewAdapter = new GlideViewAdapter(getApplicationContext(),lists);
        gridView.setAdapter(glideViewAdapter);
        //點擊的回調
        glideViewAdapter.setCheckCheckbox(new GlideViewAdapter.CheckCheckbox() {
            @Override
            public void checkCheckboxCallBacks(int position, boolean isChecked) {
                if(mCheckNumber.size()>=MAXNUMBER){
                    glideViewAdapter.notifyDataSetChanged();
                    if(!isChecked){
                        for (int i = 0; i < mCheckNumber.size(); i++) {
                            if(mCheckNumber.get(i).equals(lists.get(position).getImagePath())){
                                mCheckNumber.remove(i);
                                lists.get(position).setChecked(false);
                            }
                        }
                    }
                    return;
                }
                if(isChecked){
                    mCheckNumber.add(lists.get(position).getImagePath());
                    lists.get(position).setChecked(true);
                }else {
                    for (int i = 0; i < mCheckNumber.size(); i++) {
                        if(mCheckNumber.get(i).equals(lists.get(position).getImagePath())){
                            mCheckNumber.remove(i);
                            lists.get(position).setChecked(false);
                        }
                    }
                }
                glideViewAdapter.notifyDataSetChanged();

            }
        });
    }

    private void setListener() {
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (lists.size() != 0) {
                    final String detail = lists.get(position).getImagePath();
                    int nameCount = detail.lastIndexOf("/");
                    final String name = detail.substring(nameCount + 1, detail.length());
                }
            }
        });

        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //傳值出去
                if(mCheckNumber.size()<1){
                    Toast.makeText(ListDetailActivity.this, "选择失败!", Toast.LENGTH_SHORT).show();
                }else
                Toast.makeText(ListDetailActivity.this, mCheckNumber.toString()+"", Toast.LENGTH_SHORT).show();
            }
        });

        mMTextViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(MAXNUMBER>lists.size()){
                    for (int i = 0; i < lists.size(); i++) {
                        lists.get(i).setChecked(true);
                        mCheckNumber.add(lists.get(i).getImagePath());
                    }
//                }else {
//                    for (int i = 0; i < MAXNUMBER; i++) {
//                        lists.get(i).setChecked(true);
//                        mCheckNumber.add(lists.get(i).getImagePath());
//                    }
//                }
                glideViewAdapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    public void ListBack(View view) {
        finish();
//        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.left_in,R.anim.right_out);
    }
}
