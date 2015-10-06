package com.example.ken.pcn;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class NoteListActivity extends AppCompatActivity {
    ListView listView;
    String [] titles={"Title11","Title2","Title3","Title4"};
    String [] texts={"haha","hehe","qwer","asdf"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_node_list);
        this.setTitle("My notes");
        listView=(ListView)this.findViewById(R.id.MyListView);
        listView.setAdapter(new ListViewAdapter(titles, texts));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent =new Intent(NoteListActivity.this,EditNoteActivity.class);
                startActivity(intent);
            }
        });
    }
    public class ListViewAdapter extends BaseAdapter {
        View[] itemViews;

        public ListViewAdapter(String[] itemTitles, String[] itemTexts  ) {
            itemViews = new View[itemTitles.length];

            for (int i = 0; i < itemViews.length; i++) {
                itemViews[i] = makeItemView(itemTitles[i], itemTexts[i]);
            }
        }

        @Override
        public int getCount() {
            return itemViews.length;
        }

        @Override
        public Object getItem(int i) {
            return itemViews[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }
        private View makeItemView(String strTitle, String strText) {
            LayoutInflater inflater = (LayoutInflater)NoteListActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // 使用View的对象itemView与R.layout.item关联
            View itemView = inflater.inflate(R.layout.note_list_item, null);

            // 通过findViewById()方法实例R.layout.item内各组件
            TextView title = (TextView)itemView.findViewById(R.id.itemTitle);
            title.setText(strTitle);
            TextView text = (TextView)itemView.findViewById(R.id.itemText);
            text.setText(strText);
            return itemView;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                return itemViews[position];
            return convertView;
        }
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_node_list, menu);
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
    }*/
}
