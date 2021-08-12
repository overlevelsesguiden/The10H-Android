package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class EditOrDuplicateDocumentActivity extends AppCompatActivity {

    private ArrayList<Document> documents;
    private int documentIndex;

    private boolean isDuplicating;

    private Document editedDocument;

    private EditText titleToEdit;

    private EditText h1ToEdit;
    private EditText h2ToEdit;
    private EditText h3ToEdit;
    private EditText h4ToEdit;
    private EditText h5ToEdit;
    private EditText h6ToEdit;
    private EditText h7ToEdit;
    private EditText h8ToEdit;
    private EditText h9ToEdit;
    private EditText h10ToEdit;

    private Button saveEditedDocumentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_or_duplicate_document);

        documentIndex = getIntent().getIntExtra("document_index", 0);

        isDuplicating = getIntent().getBooleanExtra("is_duplicating", false);

        editedDocument = new Document();

        titleToEdit = (EditText) findViewById(R.id.document_id_to_edit);
        titleToEdit.setText(getIntent().getStringExtra("title_to_edit"));

        h1ToEdit = (EditText) findViewById(R.id.h1_text_to_edit);
        if (getIntent().getStringExtra("h1_to_edit") == null){
            h1ToEdit.setText("");
        }else{
            h1ToEdit.setText(getIntent().getStringExtra("h1_to_edit"));
        }

        h2ToEdit = (EditText) findViewById(R.id.h2_text_to_edit);
        if (getIntent().getStringExtra("h2_to_edit") == null){
            h2ToEdit.setText("");
        }else{
            h2ToEdit.setText(getIntent().getStringExtra("h2_to_edit"));
        }

        h3ToEdit = (EditText) findViewById(R.id.h3_text_to_edit);
        if (getIntent().getStringExtra("h3_to_edit") == null){
            h3ToEdit.setText("");
        }else{
            h3ToEdit.setText(getIntent().getStringExtra("h3_to_edit"));
        }

        h4ToEdit = (EditText) findViewById(R.id.h4_text_to_edit);
        if (getIntent().getStringExtra("h4_to_edit") == null){
            h4ToEdit.setText("");
        }else{
            h4ToEdit.setText(getIntent().getStringExtra("h4_to_edit"));
        }

        h5ToEdit = (EditText) findViewById(R.id.h5_text_to_edit);
        if (getIntent().getStringExtra("h5_to_edit") == null){
            h5ToEdit.setText("");
        }else{
            h5ToEdit.setText(getIntent().getStringExtra("h5_to_edit"));
        }

        h6ToEdit = (EditText) findViewById(R.id.h6_text_to_edit);
        if (getIntent().getStringExtra("h6_to_edit") == null){
            h6ToEdit.setText("");
        }else{
            h6ToEdit.setText(getIntent().getStringExtra("h6_to_edit"));
        }

        h7ToEdit = (EditText) findViewById(R.id.h7_text_to_edit);
        if (getIntent().getStringExtra("h7_to_edit") == null){
            h7ToEdit.setText("");
        }else{
            h7ToEdit.setText(getIntent().getStringExtra("h7_to_edit"));
        }

        h8ToEdit = (EditText) findViewById(R.id.h8_text_to_edit);
        if (getIntent().getStringExtra("h8_to_edit") == null){
            h8ToEdit.setText("");
        }else{
            h8ToEdit.setText(getIntent().getStringExtra("h8_to_edit"));
        }

        h9ToEdit = (EditText) findViewById(R.id.h9_text_to_edit);
        if (getIntent().getStringExtra("h9_to_edit") == null){
            h9ToEdit.setText("");
        }else{
            h9ToEdit.setText(getIntent().getStringExtra("h9_to_edit"));
        }

        h10ToEdit = (EditText) findViewById(R.id.h10_text_to_edit);
        if (getIntent().getStringExtra("h10_to_edit") == null){
            h10ToEdit.setText("");
        }else{
            h10ToEdit.setText(getIntent().getStringExtra("h10_to_edit"));
        }

        titleToEdit.addTextChangedListener(buttonStateControl);

        h1ToEdit.addTextChangedListener(buttonStateControl);
        h2ToEdit.addTextChangedListener(buttonStateControl);
        h3ToEdit.addTextChangedListener(buttonStateControl);
        h4ToEdit.addTextChangedListener(buttonStateControl);
        h5ToEdit.addTextChangedListener(buttonStateControl);
        h6ToEdit.addTextChangedListener(buttonStateControl);
        h7ToEdit.addTextChangedListener(buttonStateControl);
        h8ToEdit.addTextChangedListener(buttonStateControl);
        h9ToEdit.addTextChangedListener(buttonStateControl);
        h10ToEdit.addTextChangedListener(buttonStateControl);

        saveEditedDocumentButton = (Button) findViewById(R.id.saveEditedDocument);
        saveEditedDocumentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isDuplicating){
                    editedDocument.setTitle(titleToEdit.getText().toString());
                    editedDocument.setH1(h1ToEdit.getText().toString());
                    editedDocument.setH2(h2ToEdit.getText().toString());
                    editedDocument.setH3(h3ToEdit.getText().toString());
                    editedDocument.setH4(h4ToEdit.getText().toString());
                    editedDocument.setH5(h5ToEdit.getText().toString());
                    editedDocument.setH6(h6ToEdit.getText().toString());
                    editedDocument.setH7(h7ToEdit.getText().toString());
                    editedDocument.setH8(h8ToEdit.getText().toString());
                    editedDocument.setH9(h9ToEdit.getText().toString());
                    editedDocument.setH10(h10ToEdit.getText().toString());

                    Calendar date = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
                    String dateString = dateFormat.format(date.getTime());
                    editedDocument.setDate(dateString);

                    Calendar time = Calendar.getInstance();
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    String timeString = timeFormat.format(time.getTime());
                    editedDocument.setTime(timeString);

                    SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);
                    Gson gson = new Gson();
                    String loadJson = preferences.getString("document_array", null);
                    Type type = new TypeToken<ArrayList<Document>>() {}.getType();
                    documents = gson.fromJson(loadJson, type);

                    documents.add(editedDocument);

                    SharedPreferences.Editor editor = preferences.edit();
                    String saveJson = gson.toJson(documents);
                    editor.putString("document_array", saveJson);
                    editor.apply();

                    Intent editDocumentIntent = new Intent(EditOrDuplicateDocumentActivity.this, MainActivity.class);
                    editDocumentIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(editDocumentIntent);
                }else {
                    editedDocument.setTitle(titleToEdit.getText().toString());
                    editedDocument.setH1(h1ToEdit.getText().toString());
                    editedDocument.setH2(h2ToEdit.getText().toString());
                    editedDocument.setH3(h3ToEdit.getText().toString());
                    editedDocument.setH4(h4ToEdit.getText().toString());
                    editedDocument.setH5(h5ToEdit.getText().toString());
                    editedDocument.setH6(h6ToEdit.getText().toString());
                    editedDocument.setH7(h7ToEdit.getText().toString());
                    editedDocument.setH8(h8ToEdit.getText().toString());
                    editedDocument.setH9(h9ToEdit.getText().toString());
                    editedDocument.setH10(h10ToEdit.getText().toString());

                    Calendar date = Calendar.getInstance();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy");
                    String dateString = dateFormat.format(date.getTime());
                    editedDocument.setDate(dateString);

                    Calendar time = Calendar.getInstance();
                    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                    String timeString = timeFormat.format(time.getTime());
                    editedDocument.setTime(timeString);

                    SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);
                    Gson gson = new Gson();
                    String loadJson = preferences.getString("document_array", null);
                    Type type = new TypeToken<ArrayList<Document>>() {}.getType();
                    documents = gson.fromJson(loadJson, type);

                    documents.set(documentIndex, editedDocument);

                    SharedPreferences.Editor editor = preferences.edit();
                    String saveJson = gson.toJson(documents);
                    editor.putString("document_array", saveJson);
                    editor.apply();

                    Intent editDocumentIntent = new Intent(EditOrDuplicateDocumentActivity.this, MainActivity.class);
                    editDocumentIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(editDocumentIntent);
                }
            }
        });
    }

    public void goToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private TextWatcher buttonStateControl = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String titleInput = titleToEdit.getText().toString().trim();
            saveEditedDocumentButton.setEnabled(!titleInput.isEmpty() && (!h1ToEdit.getText().toString().trim().isEmpty() ||
                    !h2ToEdit.getText().toString().trim().isEmpty() || !h3ToEdit.getText().toString().trim().isEmpty() ||
                    !h4ToEdit.getText().toString().trim().isEmpty() || !h5ToEdit.getText().toString().trim().isEmpty() ||
                    !h6ToEdit.getText().toString().trim().isEmpty() || !h7ToEdit.getText().toString().trim().isEmpty() ||
                    !h8ToEdit.getText().toString().trim().isEmpty() || !h9ToEdit.getText().toString().trim().isEmpty() ||
                    !h10ToEdit.getText().toString().trim().isEmpty()));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}