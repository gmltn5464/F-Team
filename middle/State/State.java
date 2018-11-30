package com.example.gmltn.health_care;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import java.util.ArrayList;
import java.util.List;

public class State extends AppCompatActivity{
    private ArrayList<String> arraylist;
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private Adapter adapter;      // 리스트뷰에 연결할 아답터
    private ImageButton searchButton;
    private List<String > sportNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);

        editSearch = (EditText) findViewById(R.id.editSearch);
        listView = (ListView) findViewById(R.id.listView);
        searchButton = (ImageButton)findViewById(R.id.searchButton);
        sportNames = new ArrayList<String>();

        settingList();

        String[] sportTime = {"3h 40m","6h 20m","8h 30m","4h 15m","6h 6m","3h 55m","5h 35m"};

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        arraylist = new ArrayList<String>();
        arraylist.addAll(sportNames);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new Adapter(State.this,sportNames,sportTime);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        editSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    sportNames.clear();
                    if (editSearch.getText().toString().length() == 0) {
                        sportNames.addAll(arraylist);
                    }
                    // 문자 입력
                    else {
                        // 리스트의 모든 데이터를 검색한다.
                        for (int i = 0; i < arraylist.size(); i++) {
                            // arraylist의 모든 데이터에 입력받은 단어가 포함되어 있으면 true를 반환한다.
                            if (arraylist.get(i).toLowerCase().contains(editSearch.getText().toString())) {
                                // 검색된 데이터를 리스트에 추가한다.
                                sportNames.add(arraylist.get(i));
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
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                if (editSearch.getText().toString().length() == 0) {
                    sportNames.clear();
                    sportNames.addAll(arraylist);
                    adapter.notifyDataSetChanged();
                }
           }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            }
        });

        searchButton.setOnClickListener(new Button.OnClickListener() {
           @Override
            public void onClick(View v){
               sportNames.clear();
               if (editSearch.getText().toString().length() == 0) {
                   sportNames.addAll(arraylist);
               }
               // 문자 입력
               else {
                   // 리스트의 모든 데이터를 검색한다.
                   for (int i = 0; i < arraylist.size(); i++) {
                       // arraylist의 모든 데이터에 입력받은 단어가 포함되어 있으면 true를 반환한다.
                       if (arraylist.get(i).toLowerCase().contains(editSearch.getText().toString())) {
                           // 검색된 데이터를 리스트에 추가한다.
                           sportNames.add(arraylist.get(i));
                       }
                   }
               }
               // 리스트 데이터가 변경되었으므로 아답터를 갱신하여 검색된 데이터를 화면에 보여준다.
               adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_state, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void settingList(){
        sportNames.add("경보");
        sportNames.add("체조");
        sportNames.add("볼링");
        sportNames.add("수영");
        sportNames.add("농구");
        sportNames.add("스키");
        sportNames.add("등산");
    }
}