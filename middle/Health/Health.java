package com.example.leegyounghoon.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.*;
import android.view.View;
import android.text.Editable;
import android.text.TextWatcher;
import java.util.*;

public class Health extends AppCompatActivity {

    private ArrayList<String> sportcopy;
    private ListView listview;          // 검색을 보여줄 리스트변수
    private Adapter adapter;      // 리스트뷰에 연결할 아답터
    private ImageButton searchButton;
    private List<String> sportdata;
    private EditText edittext;

    private void sportList(){
        sportdata.add("경보");
        sportdata.add("체조");
        sportdata.add("볼링");
        sportdata.add("수영");
        sportdata.add("농구");
        sportdata.add("스키");
        sportdata.add("등산");
    }

    int[] sportIcons = {R.drawable.walking,
            R.drawable.yoga,
            R.drawable.swimming,
            R.drawable.bowlin,
            R.drawable.basketball,
            R.drawable.skiing,
            R.drawable.trekking,
    };

    String[] calorie = {"560kcal/h", "350kcal/h", "500kcal/h", "410kcal/h", "420kcal/h", "440kcal/h", "490kcal/h"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health);

        searchButton = (ImageButton)findViewById(R.id.searchButton);
        edittext=(EditText)findViewById(R.id.search);
        listview = (ListView) findViewById(R.id.listview);
        sportdata = new ArrayList<String>();

        sportList();

        sportcopy = new ArrayList<String>();
        sportcopy.addAll(sportdata);

        adapter = new Adapter(Health.this, sportdata, calorie, sportIcons);
        listview.setAdapter(adapter);

        edittext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    sportdata.clear();
                    if (edittext.getText().toString().length() == 0) {
                        sportdata.addAll(sportcopy);
                    }
                    // 문자 입력
                    else {
                        // 리스트의 모든 데이터를 검색한다.
                        for (int i = 0; i < sportcopy.size(); i++) {
                            // arraylist의 모든 데이터에 입력받은 단어가 포함되어 있으면 true를 반환한다.
                            if (sportcopy.get(i).toLowerCase().contains(edittext.getText().toString())) {
                                // 검색된 데이터를 리스트에 추가한다.
                                sportdata.add(sportcopy.get(i));
                            }
                        }
                    }
                    // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                    adapter.notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });

        edittext.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                if (edittext.getText().toString().length() == 0) {
                    sportdata.clear();
                    sportdata.addAll(sportcopy);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });

        edittext.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    sportdata.clear();
                    if (edittext.getText().toString().length() == 0) {
                        sportdata.addAll(sportcopy);
                    }
                    // 문자 입력
                    else {
                        // 리스트의 모든 데이터를 검색한다.
                        for (int i = 0; i < sportcopy.size(); i++) {
                            // arraylist의 모든 데이터에 입력받은 단어가 포함되어 있으면 true를 반환한다.
                            if (sportcopy.get(i).toLowerCase().contains(edittext.getText().toString())) {
                                // 검색된 데이터를 리스트에 추가한다.
                                sportdata.add(sportcopy.get(i));
                            }
                        }
                    }
                    // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                    adapter.notifyDataSetChanged();
                    return true;
                }
                return false;
            }
        });
        searchButton.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                sportdata.clear();
                if (edittext.getText().toString().length() == 0) {
                    sportdata.addAll(sportcopy);
                }
                // 문자 입력
                else {
                    // 리스트의 모든 데이터를 검색한다.
                    for (int i = 0; i < sportcopy.size(); i++) {
                        // arraylist의 모든 데이터에 입력받은 단어가 포함되어 있으면 true를 반환한다.
                        if (sportcopy.get(i).toLowerCase().contains(edittext.getText().toString())) {
                            // 검색된 데이터를 리스트에 추가한다.
                            sportdata.add(sportcopy.get(i));
                        }
                    }
                }
                // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
                adapter.notifyDataSetChanged();
            }
        });

    }
    public void mOnClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.button1:
                intent = new Intent(this, SubActivity.class);
                startActivity(intent);
                break;
        }
    }
}
