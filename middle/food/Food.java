package com.example.user.health_care_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class Food extends AppCompatActivity {

    private ArrayList<String> foodcopy;
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editText;        // 검색어를 입력할 Input 창
    private Adapter adapter;      // 리스트뷰에 연결할 아답터
    private ImageButton button;
    private List<String > food;

    int Total_kcal =0;
    private void foodList(){
        food.add("쌀밥");
        food.add("김치찌개");
        food.add("치킨");
        food.add("햄치즈샌드위치");
        food.add("아메리카노");
        food.add("오렌지주스");
        food.add("치킨마요(한솥)");
        food.add("불고기피자");
        food.add("족발");
        food.add("새우");
        food.add("귤");
        food.add("깔라만시");
        food.add("멸치볶음");
        food.add("삼겹살");
        food.add("닭발");
        food.add("사이다(200ml)");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        editText = (EditText) findViewById(R.id.search);
        listView = (ListView) findViewById(R.id.listview);
        button = (ImageButton)findViewById(R.id.searchButton);
        food = new ArrayList<String>();

        foodList();

        final int[] foodKcal = {300, 121, 249, 352, 4, 112, 453, 480, 458, 66, 42, 15, 69, 661, 203, 85};

        // 리스트의 모든 데이터를 arraylist에 복사한다.// list 복사본을 만든다.
        foodcopy = new ArrayList<String>();
        foodcopy.addAll(food);

        // 리스트에 연동될 아답터를 생성한다.
        adapter = new Adapter(Food.this,food);

        // 리스트뷰에 아답터를 연결한다.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CheckBox check = (CheckBox)view.findViewById(R.id.checkbox);
                if(check.isChecked()) {
                    check.setChecked(false);
                    Total_kcal-=foodKcal[position];
                }
                else {
                    check.setChecked(true);
                    Total_kcal+=foodKcal[position];
                }
                Toast.makeText(Food.this, ""+Total_kcal, Toast.LENGTH_SHORT).show();
            }
        });

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                //Enter key Action
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    food.clear();
                    if (editText.getText().toString().length() == 0) {
                        food.addAll(foodcopy);
                    }
                    // 문자 입력
                    else {
                        // 리스트의 모든 데이터를 검색한다.
                        for (int i = 0; i < foodcopy.size(); i++) {
                            // arraylist의 모든 데이터에 입력받은 단어가 포함되어 있으면 true를 반환한다.
                            if (foodcopy.get(i).toLowerCase().contains(editText.getText().toString())) {
                                // 검색된 데이터를 리스트에 추가한다.
                                food.add(foodcopy.get(i));
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
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable arg0) {
                if (editText.getText().toString().length() == 0) {
                    food.clear();
                    food.addAll(foodcopy);
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

        button.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v){
                food.clear();
                if (editText.getText().toString().length() == 0) {
                    food.addAll(foodcopy);
                }
                // 문자 입력
                else {
                    // 리스트의 모든 데이터를 검색한다.
                    for (int i = 0; i < foodcopy.size(); i++) {
                        // arraylist의 모든 데이터에 입력받은 단어가 포함되어 있으면 true를 반환한다.
                        if (foodcopy.get(i).toLowerCase().contains(editText.getText().toString())) {
                            // 검색된 데이터를 리스트에 추가한다.
                            food.add(foodcopy.get(i));
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
        getMenuInflater().inflate(R.menu.menu_food, menu);
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
}