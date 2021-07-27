package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Document> documents;
    private LinearLayout savedDocumentsContainer;
    private View savedDocumentsView;

    /*
    View v;
    int[] someList;
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (File file : getApplicationContext().getFilesDir().listFiles()){
            if (file.exists()){
                //Toast.makeText(this, file.getName(), Toast.LENGTH_SHORT).show();
                file.delete();
            }
        }

        SharedPreferences loadPreferences = getSharedPreferences("preference", MODE_PRIVATE);
        Gson loadGson = new Gson();
        String loadJson = loadPreferences.getString("document_array", null);
        Type type = new TypeToken<ArrayList<Document>>() {}.getType();
        documents = loadGson.fromJson(loadJson, type);
        if (documents == null){
            documents = new ArrayList<Document>();
        }






        if (getIntent().getStringExtra("document")!= null){
            Gson gson = new Gson();
            documents.add(gson.fromJson(getIntent().getStringExtra("document"), Document.class));
            SharedPreferences savePreferences = getSharedPreferences("preference", MODE_PRIVATE);
            SharedPreferences.Editor editor = savePreferences.edit();
            Gson saveGson = new Gson();
            String saveJson = saveGson.toJson(documents);
            editor.putString("document_array",saveJson);
            editor.apply();
        }


        savedDocumentsContainer = (LinearLayout)findViewById(R.id.document_button_container);
        /*
        for (Document document : documents){
            savedDocumentsView = getLayoutInflater().inflate(R.layout.saved_documents_view, null, false);

            TextView titleView = (TextView) savedDocumentsView.findViewById(R.id.document_title);
            titleView.setText(document.getTitle());

            TextView dateView = (TextView) savedDocumentsView.findViewById(R.id.document_date);
            dateView.setText(document.getDate());

            TextView timeView = (TextView) savedDocumentsView.findViewById(R.id.document_time);
            timeView.setText(document.getTime());

            savedDocumentsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DocumentActivity.class);

                    intent.putExtra("documentIndex", documents.indexOf(document));
                    intent.putExtra("title", document.getTitle());
                    intent.putExtra("h1", document.getH1());
                    intent.putExtra("h2", document.getH2());
                    intent.putExtra("h3", document.getH3());
                    intent.putExtra("h4", document.getH4());
                    intent.putExtra("h5", document.getH5());
                    intent.putExtra("h6", document.getH6());
                    intent.putExtra("h7", document.getH7());
                    intent.putExtra("h8", document.getH8());
                    intent.putExtra("h9", document.getH9());
                    intent.putExtra("h10", document.getH10());

                    startActivity(intent);
                }
            });


            savedDocumentsContainer.addView(savedDocumentsView);

        }*/

        for (int i = documents.size() - 1; i >= 0; i--){
            savedDocumentsView = getLayoutInflater().inflate(R.layout.saved_documents_view, null, false);

            TextView titleView = (TextView) savedDocumentsView.findViewById(R.id.document_title);
            titleView.setText(documents.get(i).getTitle());

            TextView dateView = (TextView) savedDocumentsView.findViewById(R.id.document_date);
            dateView.setText(documents.get(i).getDate());

            TextView timeView = (TextView) savedDocumentsView.findViewById(R.id.document_time);
            timeView.setText(documents.get(i).getTime());

            int index = i;
            savedDocumentsView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, DocumentActivity.class);

                    intent.putExtra("documentIndex", documents.indexOf(documents.get(index)));
                    intent.putExtra("title", documents.get(index).getTitle());
                    intent.putExtra("h1", documents.get(index).getH1());
                    intent.putExtra("h2", documents.get(index).getH2());
                    intent.putExtra("h3", documents.get(index).getH3());
                    intent.putExtra("h4", documents.get(index).getH4());
                    intent.putExtra("h5", documents.get(index).getH5());
                    intent.putExtra("h6", documents.get(index).getH6());
                    intent.putExtra("h7", documents.get(index).getH7());
                    intent.putExtra("h8", documents.get(index).getH8());
                    intent.putExtra("h9", documents.get(index).getH9());
                    intent.putExtra("h10", documents.get(index).getH10());

                    startActivity(intent);
                }
            });
            savedDocumentsContainer.addView(savedDocumentsView);
        }
        /*
        someList = new int[]{1, 2, 3, 4, 5};

        for (int number : someList) {

            v = getLayoutInflater().inflate(R.layout.saved_documents_view, null, false);
            TextView placeholderView = (TextView) v.findViewById(R.id.placeholder);
            placeholderView.setText("no longer placeholder");
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"index is: "+number, Toast.LENGTH_SHORT).show();

                }
            });
            savedDocumentsContainer.addView(v);
        }

         */
    }

    public void goToInfoActivity(View view){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    public void goToMakeDocumentActivity(View view){
        Intent intent = new Intent(this, MakeDocumentActivity.class);
        startActivity(intent);
    }
}