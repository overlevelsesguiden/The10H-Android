package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.print.PrintHelper;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DocumentActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private ArrayList<Document> documents;

    private int documentIndex;

    private TextView title;


    private TextView h1Title;
    private TextView h1Description;
    private TextView h1;

    private TextView h2Title;
    private TextView h2Description;
    private TextView h2;

    private TextView h3Title;
    private TextView h3Description;
    private TextView h3;

    private TextView h4Title;
    private TextView h4Description;
    private TextView h4;

    private TextView h5Title;
    private TextView h5Description;
    private TextView h5;

    private TextView h6Title;
    private TextView h6Description;
    private TextView h6;

    private TextView h7Title;
    private TextView h7Description;
    private TextView h7;

    private TextView h8Title;
    private TextView h8Description;
    private TextView h8;

    private TextView h9Title;
    private TextView h9Description;
    private TextView h9;

    private TextView h10Title;
    private TextView h10Description;
    private TextView h10;

    private String fileToDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        documentIndex = getIntent().getIntExtra("documentIndex", 0);

        title = (TextView) findViewById(R.id.title);
        title.setText(getIntent().getStringExtra("title"));

        h1Title = (TextView)findViewById(R.id.h1_title);
        h1Description = (TextView)findViewById(R.id.h1_description);
        h1 = (TextView)findViewById(R.id.h1);
        if (getIntent().getStringExtra("h1") == null || getIntent().getStringExtra("h1").length() == 0){
            h1Title.setVisibility(View.GONE);
            h1Description.setVisibility(View.GONE);
            h1.setVisibility(View.GONE);
        }else {
            h1.setText(getIntent().getStringExtra("h1"));
        }

        h2Title = (TextView)findViewById(R.id.h2_title);
        h2Description = (TextView)findViewById(R.id.h2_description);
        h2 = (TextView)findViewById(R.id.h2);
        if (getIntent().getStringExtra("h2") == null || getIntent().getStringExtra("h2").length() == 0){
            h2Title.setVisibility(View.GONE);
            h2Description.setVisibility(View.GONE);
            h2.setVisibility(View.GONE);
        }else {
            h2.setText(getIntent().getStringExtra("h2"));
        }


        h3Title = (TextView)findViewById(R.id.h3_title);
        h3Description = (TextView)findViewById(R.id.h3_description);
        h3 = (TextView)findViewById(R.id.h3);
        if (getIntent().getStringExtra("h3") == null || getIntent().getStringExtra("h3").length() == 0){
            h3Title.setVisibility(View.GONE);
            h3Description.setVisibility(View.GONE);
            h3.setVisibility(View.GONE);
        }else {
            h3.setText(getIntent().getStringExtra("h3"));
        }

        h4Title = (TextView)findViewById(R.id.h4_title);
        h4Description = (TextView)findViewById(R.id.h4_description);
        h4 = (TextView)findViewById(R.id.h4);
        if (getIntent().getStringExtra("h4") == null || getIntent().getStringExtra("h4").length() == 0){
            h4Title.setVisibility(View.GONE);
            h4Description.setVisibility(View.GONE);
            h4.setVisibility(View.GONE);
        }else {
            h4.setText(getIntent().getStringExtra("h4"));
        }

        h5Title = (TextView)findViewById(R.id.h5_title);
        h5Description = (TextView)findViewById(R.id.h5_description);
        h5 = (TextView)findViewById(R.id.h5);
        if (getIntent().getStringExtra("h5") == null || getIntent().getStringExtra("h5").length() == 0){
            h5Title.setVisibility(View.GONE);
            h5Description.setVisibility(View.GONE);
            h5.setVisibility(View.GONE);
        }else {
            h5.setText(getIntent().getStringExtra("h5"));
        }

        h6Title = (TextView)findViewById(R.id.h6_title);
        h6Description = (TextView)findViewById(R.id.h6_description);
        h6 = (TextView)findViewById(R.id.h6);
        if (getIntent().getStringExtra("h6") == null || getIntent().getStringExtra("h6").length() == 0){
            h6Title.setVisibility(View.GONE);
            h6Description.setVisibility(View.GONE);
            h6.setVisibility(View.GONE);
        }else {
            h6.setText(getIntent().getStringExtra("h6"));
        }

        h7Title = (TextView)findViewById(R.id.h7_title);
        h7Description = (TextView)findViewById(R.id.h7_description);
        h7 = (TextView)findViewById(R.id.h7);
        if (getIntent().getStringExtra("h7") == null || getIntent().getStringExtra("h7").length() == 0){
            h7Title.setVisibility(View.GONE);
            h7Description.setVisibility(View.GONE);
            h7.setVisibility(View.GONE);
        }else {
            h7.setText(getIntent().getStringExtra("h7"));
        }

        h8Title = (TextView)findViewById(R.id.h8_title);
        h8Description = (TextView)findViewById(R.id.h8_description);
        h8 = (TextView)findViewById(R.id.h8);
        if (getIntent().getStringExtra("h8") == null || getIntent().getStringExtra("h8").length() == 0){
            h8Title.setVisibility(View.GONE);
            h8Description.setVisibility(View.GONE);
            h8.setVisibility(View.GONE);
        }else {
            h8.setText(getIntent().getStringExtra("h8"));
        }

        h9Title = (TextView)findViewById(R.id.h9_title);
        h9Description = (TextView)findViewById(R.id.h9_description);
        h9 = (TextView)findViewById(R.id.h9);
        if (getIntent().getStringExtra("h9") == null || getIntent().getStringExtra("h9").length() == 0){
            h9Title.setVisibility(View.GONE);
            h9Description.setVisibility(View.GONE);
            h9.setVisibility(View.GONE);
        }else {
            h9.setText(getIntent().getStringExtra("h9"));
        }

        h10Title = (TextView)findViewById(R.id.h10_title);
        h10Description = (TextView)findViewById(R.id.h10_description);
        h10 = (TextView)findViewById(R.id.h10);
        if (getIntent().getStringExtra("h10") == null || getIntent().getStringExtra("h10").length() == 0){
            h10Title.setVisibility(View.GONE);
            h10Description.setVisibility(View.GONE);
            h10.setVisibility(View.GONE);
        }else {
            h10.setText(getIntent().getStringExtra("h10"));
        }

    }


    public void goToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void showOptions(View view){
        PopupMenu menu = new PopupMenu(this, view);
        if (Build.VERSION.SDK_INT >= 29) {
            menu.setForceShowIcon(true);
        }
        menu.setOnMenuItemClickListener(this);
        menu.inflate(R.menu.document_options_menu);
        menu.show();
    }

    private void sharePdfAllHs() throws IOException {
        String subtitleString = title.getText().toString();
        //String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        String fileName = subtitleString+".pdf";
        fileToDelete = fileName;
        //Toast.makeText(this, fileName, Toast.LENGTH_SHORT).show();
        File file = new File(getApplicationContext().getFilesDir(), fileName);

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdf = new PdfDocument(writer);

        com.itextpdf.layout.Document doc = new com.itextpdf.layout.Document(pdf, PageSize.A4, false);
        doc.setMargins(32, 32, 40, 32);

        Paragraph title = new Paragraph(getString(R.string.app_name));
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        title.setFontSize(24);
        doc.add(title);


        Paragraph subtitle = new Paragraph(subtitleString);
        subtitle.setTextAlignment(TextAlignment.CENTER);
        subtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        subtitle.setFontSize(18);
        doc.add(subtitle);

        float [] tableColumnWidths = {150F, 595};
        Table table = new Table(tableColumnWidths);
        table.setMarginTop(2);

        Paragraph H1QuestionTitle = new Paragraph(h1Title.getText().toString());
        H1QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H1QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H1QuestionTitle.setFontSize(14);

        Paragraph H1QuestionSubtitle = new Paragraph(getString(R.string.content));
        H1QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H1QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H1QuestionSubtitle.setFontSize(14);

        Cell cell = new Cell();
        cell.add(H1QuestionTitle);
        cell.add(H1QuestionSubtitle);
        cell.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell);

        Cell cell2 = new Cell();
        if (h1.getText().toString().length() != 0){
            Paragraph H1Answer = new Paragraph(h1.getText().toString());
            H1Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H1Answer.setFontSize(14);
            H1Answer.setMarginRight(5);
            H1Answer.setMarginLeft(5);
            cell2.add(H1Answer);
        }
        cell2.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell2);

        Paragraph H2QuestionTitle = new Paragraph(h2Title.getText().toString());
        H2QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H2QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H2QuestionTitle.setFontSize(14);

        Paragraph H2QuestionSubtitle = new Paragraph(getString(R.string.meaning));
        H2QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H2QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H2QuestionSubtitle.setFontSize(14);

        Cell cell3 = new Cell();
        cell3.add(H2QuestionTitle);
        cell3.add(H2QuestionSubtitle);
        cell3.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell3);

        Cell cell4 = new Cell();
        if (h2.getText().toString().length() != 0){
            Paragraph H2Answer = new Paragraph(h2.getText().toString());
            H2Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H2Answer.setFontSize(14);
            H2Answer.setMarginRight(5);
            H2Answer.setMarginLeft(5);
            cell4.add(H2Answer);
        }
        cell4.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell4);

        Paragraph H3QuestionTitle = new Paragraph(h3Title.getText().toString());
        H3QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H3QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H3QuestionTitle.setFontSize(14);

        Paragraph H3QuestionSubtitle = new Paragraph(getString(R.string.method));
        H3QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H3QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H3QuestionSubtitle.setFontSize(14);

        Cell cell5 = new Cell();
        cell5.add(H3QuestionTitle);
        cell5.add(H3QuestionSubtitle);
        cell5.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell5);

        Cell cell6 = new Cell();
        if (h3.getText().toString().length() != 0){
            Paragraph H3Answer = new Paragraph(h3.getText().toString());
            H3Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H3Answer.setFontSize(14);
            H3Answer.setMarginRight(5);
            H3Answer.setMarginLeft(5);
            cell6.add(H3Answer);
        }
        cell6.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell6);

        Paragraph H4QuestionTitle = new Paragraph(h4Title.getText().toString());
        H4QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H4QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H4QuestionTitle.setFontSize(14);

        Paragraph H4QuestionSubtitle = new Paragraph(getString(R.string.place));
        H4QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H4QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H4QuestionSubtitle.setFontSize(14);

        Cell cell7 = new Cell();
        cell7.add(H4QuestionTitle);
        cell7.add(H4QuestionSubtitle);
        cell7.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell7);

        Cell cell8 = new Cell();
        if (h4.getText().toString().length() != 0){
            Paragraph H4Answer = new Paragraph(h4.getText().toString());
            H4Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H4Answer.setFontSize(14);
            H4Answer.setMarginRight(5);
            H4Answer.setMarginLeft(5);
            cell8.add(H4Answer);
        }
        cell8.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell8);

        Paragraph H5QuestionTitle = new Paragraph(h5Title.getText().toString());
        H5QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H5QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H5QuestionTitle.setFontSize(14);

        Paragraph H5QuestionSubtitle = new Paragraph(getString(R.string.time));
        H5QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H5QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H5QuestionSubtitle.setFontSize(14);

        Cell cell9 = new Cell();
        cell9.add(H5QuestionTitle);
        cell9.add(H5QuestionSubtitle);
        cell9.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell9);

        Cell cell10 = new Cell();
        if (h5.getText().toString().length() != 0){
            Paragraph H5Answer = new Paragraph(h5.getText().toString());
            H5Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H5Answer.setFontSize(14);
            H5Answer.setMarginRight(5);
            H5Answer.setMarginLeft(5);
            cell10.add(H5Answer);
        }
        cell10.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell10);

        Paragraph H6QuestionTitle = new Paragraph(h6Title.getText().toString());
        H6QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H6QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H6QuestionTitle.setFontSize(14);

        Paragraph H6QuestionSubtitle = new Paragraph(getString(R.string.time_horizont));
        H6QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H6QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H6QuestionSubtitle.setFontSize(14);

        Cell cell11 = new Cell();
        cell11.add(H6QuestionTitle);
        cell11.add(H6QuestionSubtitle);
        cell11.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell11);

        Cell cell12 = new Cell();
        if (h6.getText().toString().length() != 0){
            Paragraph H6Answer = new Paragraph(h6.getText().toString());
            H6Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H6Answer.setFontSize(14);
            H6Answer.setMarginRight(5);
            H6Answer.setMarginLeft(5);
            cell12.add(H6Answer);
        }
        cell12.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell12);

        Paragraph H7QuestionTitle = new Paragraph(h7Title.getText().toString());
        H7QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H7QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H7QuestionTitle.setFontSize(14);

        Paragraph H7QuestionSubtitle = new Paragraph(getString(R.string.people));
        H7QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H7QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H7QuestionSubtitle.setFontSize(14);

        Cell cell13 = new Cell();
        cell13.add(H7QuestionTitle);
        cell13.add(H7QuestionSubtitle);
        cell13.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell13);

        Cell cell14 = new Cell();
        if (h7.getText().toString().length() != 0){
            Paragraph H7Answer = new Paragraph(h7.getText().toString());
            H7Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H7Answer.setFontSize(14);
            H7Answer.setMarginRight(5);
            H7Answer.setMarginLeft(5);
            cell14.add(H7Answer);
        }
        cell14.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell14);

        Paragraph H8QuestionTitle = new Paragraph(h8Title.getText().toString());
        H8QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H8QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H8QuestionTitle.setFontSize(14);

        Paragraph H8QuestionSubtitle = new Paragraph(getString(R.string.amount));
        H8QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H8QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H8QuestionSubtitle.setFontSize(14);

        Cell cell15 = new Cell();
        cell15.add(H8QuestionTitle);
        cell15.add(H8QuestionSubtitle);
        cell15.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell15);

        Cell cell16 = new Cell();
        if (h8.getText().toString().length() != 0){
            Paragraph H8Answer = new Paragraph(h8.getText().toString());
            H8Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H8Answer.setFontSize(14);
            H8Answer.setMarginRight(5);
            H8Answer.setMarginLeft(5);
            cell16.add(H8Answer);
        }
        cell16.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell16);

        Paragraph H9QuestionTitle = new Paragraph(h9Title.getText().toString());
        H9QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H9QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H9QuestionTitle.setFontSize(14);

        Paragraph H9QuestionSubtitle = new Paragraph(getString(R.string.person));
        H9QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H9QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H9QuestionSubtitle.setFontSize(14);

        Cell cell17 = new Cell();
        cell17.add(H9QuestionTitle);
        cell17.add(H9QuestionSubtitle);
        cell17.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell17);

        Cell cell18 = new Cell();
        if (h9.getText().toString().length() != 0){
            Paragraph H9Answer = new Paragraph(h9.getText().toString());
            H9Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H9Answer.setFontSize(14);
            H9Answer.setMarginRight(5);
            H9Answer.setMarginLeft(5);
            cell18.add(H9Answer);
        }
        cell18.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell18);

        Paragraph H10QuestionTitle = new Paragraph(h10Title.getText().toString());
        H10QuestionTitle.setTextAlignment(TextAlignment.CENTER);
        H10QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
        H10QuestionTitle.setFontSize(14);

        Paragraph H10QuestionSubtitle = new Paragraph(getString(R.string.content));
        H10QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
        H10QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        H10QuestionSubtitle.setFontSize(14);

        Cell cell19 = new Cell();
        cell19.add(H10QuestionTitle);
        cell19.add(H10QuestionSubtitle);
        cell19.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell19);

        Cell cell20 = new Cell();
        if (h10.getText().toString().length() != 0){
            Paragraph H10Answer = new Paragraph(h10.getText().toString());
            H10Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H10Answer.setFontSize(14);
            H10Answer.setMarginRight(5);
            H10Answer.setMarginLeft(5);
            cell20.add(H10Answer);
        }
        cell20.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

        table.addCell(cell20);

        doc.add(table);

        int numberOfPages = doc.getPdfDocument().getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++){
            if(i > 1) {
                doc.showTextAligned(new Paragraph("Side "+i).setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA)).setFontSize(14),
                        74, 32, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
            }
            doc.showTextAligned(new Paragraph("overlevelsesguiden.dk").setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA)).setFontSize(14),
                    595 - 32, 32, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
        }

        doc.close();

        Uri contentUri = FileProvider.getUriForFile(this, "dk.overlevelsesguiden.de10her.fileprovider", file);

        Intent sharePdfIntent = new Intent(Intent.ACTION_SEND);
        sharePdfIntent.setType("application/pdf");
        sharePdfIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
        sharePdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(sharePdfIntent, "share"));
    }

    private void sharePdfOnlyFilled() throws IOException{
        String subtitleString = title.getText().toString();
        //String pdfPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString();
        String fileName = subtitleString+".pdf";
        fileToDelete = fileName;
        //Toast.makeText(this, fileName, Toast.LENGTH_SHORT).show();
        File file = new File(getApplicationContext().getFilesDir(), fileName);

        PdfWriter writer = new PdfWriter(file);
        PdfDocument pdf = new PdfDocument(writer);

        com.itextpdf.layout.Document doc = new com.itextpdf.layout.Document(pdf, PageSize.A4, false);
        doc.setMargins(32, 32, 40, 32);

        Paragraph title = new Paragraph(getString(R.string.app_name));
        title.setTextAlignment(TextAlignment.CENTER);
        title.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        title.setFontSize(24);
        doc.add(title);


        Paragraph subtitle = new Paragraph(subtitleString);
        subtitle.setTextAlignment(TextAlignment.CENTER);
        subtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
        subtitle.setFontSize(18);
        doc.add(subtitle);

        float [] tableColumnWidths = {150F, 595};
        Table table = new Table(tableColumnWidths);
        table.setMarginTop(2);

        if (h1.getText().toString().length() != 0) {

            Paragraph H1QuestionTitle = new Paragraph(h1Title.getText().toString());
            H1QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H1QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H1QuestionTitle.setFontSize(14);

            Paragraph H1QuestionSubtitle = new Paragraph(getString(R.string.content));
            H1QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H1QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H1QuestionSubtitle.setFontSize(14);

            Cell cell = new Cell();
            cell.add(H1QuestionTitle);
            cell.add(H1QuestionSubtitle);
            cell.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell);

            Cell cell2 = new Cell();

            Paragraph H1Answer = new Paragraph(h1.getText().toString());
            H1Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H1Answer.setFontSize(14);
            H1Answer.setMarginRight(5);
            H1Answer.setMarginLeft(5);
            cell2.add(H1Answer);

            cell2.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell2);
        }

        if (h2.getText().toString().length() != 0) {

            Paragraph H2QuestionTitle = new Paragraph(h2Title.getText().toString());
            H2QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H2QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H2QuestionTitle.setFontSize(14);

            Paragraph H2QuestionSubtitle = new Paragraph(getString(R.string.meaning));
            H2QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H2QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H2QuestionSubtitle.setFontSize(14);

            Cell cell3 = new Cell();
            cell3.add(H2QuestionTitle);
            cell3.add(H2QuestionSubtitle);
            cell3.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell3);

            Cell cell4 = new Cell();

            Paragraph H2Answer = new Paragraph(h2.getText().toString());
            H2Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H2Answer.setFontSize(14);
            H2Answer.setMarginRight(5);
            H2Answer.setMarginLeft(5);
            cell4.add(H2Answer);

            cell4.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell4);

        }

        if (h3.getText().toString().length() != 0) {

            Paragraph H3QuestionTitle = new Paragraph(h3Title.getText().toString());
            H3QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H3QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H3QuestionTitle.setFontSize(14);

            Paragraph H3QuestionSubtitle = new Paragraph(getString(R.string.method));
            H3QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H3QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H3QuestionSubtitle.setFontSize(14);

            Cell cell5 = new Cell();
            cell5.add(H3QuestionTitle);
            cell5.add(H3QuestionSubtitle);
            cell5.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell5);

            Cell cell6 = new Cell();

            Paragraph H3Answer = new Paragraph(h3.getText().toString());
            H3Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H3Answer.setFontSize(14);
            H3Answer.setMarginRight(5);
            H3Answer.setMarginLeft(5);
            cell6.add(H3Answer);

            cell6.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell6);

        }

        if (h4.getText().toString().length() != 0) {

            Paragraph H4QuestionTitle = new Paragraph(h4Title.getText().toString());
            H4QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H4QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H4QuestionTitle.setFontSize(14);

            Paragraph H4QuestionSubtitle = new Paragraph(getString(R.string.place));
            H4QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H4QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H4QuestionSubtitle.setFontSize(14);

            Cell cell7 = new Cell();
            cell7.add(H4QuestionTitle);
            cell7.add(H4QuestionSubtitle);
            cell7.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell7);

            Cell cell8 = new Cell();

            Paragraph H4Answer = new Paragraph(h4.getText().toString());
            H4Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H4Answer.setFontSize(14);
            H4Answer.setMarginRight(5);
            H4Answer.setMarginLeft(5);
            cell8.add(H4Answer);

            cell8.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell8);

        }

        if (h5.getText().toString().length() != 0) {

            Paragraph H5QuestionTitle = new Paragraph(h5Title.getText().toString());
            H5QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H5QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H5QuestionTitle.setFontSize(14);

            Paragraph H5QuestionSubtitle = new Paragraph(getString(R.string.time));
            H5QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H5QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H5QuestionSubtitle.setFontSize(14);

            Cell cell9 = new Cell();
            cell9.add(H5QuestionTitle);
            cell9.add(H5QuestionSubtitle);
            cell9.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell9);

            Cell cell10 = new Cell();

            Paragraph H5Answer = new Paragraph(h5.getText().toString());
            H5Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H5Answer.setFontSize(14);
            H5Answer.setMarginRight(5);
            H5Answer.setMarginLeft(5);
            cell10.add(H5Answer);

            cell10.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell10);

        }

        if (h6.getText().toString().length() != 0) {

            Paragraph H6QuestionTitle = new Paragraph(h6Title.getText().toString());
            H6QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H6QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H6QuestionTitle.setFontSize(14);

            Paragraph H6QuestionSubtitle = new Paragraph(getString(R.string.time_horizont));
            H6QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H6QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H6QuestionSubtitle.setFontSize(14);

            Cell cell11 = new Cell();
            cell11.add(H6QuestionTitle);
            cell11.add(H6QuestionSubtitle);
            cell11.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell11);

            Cell cell12 = new Cell();

            Paragraph H6Answer = new Paragraph(h6.getText().toString());
            H6Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H6Answer.setFontSize(14);
            H6Answer.setMarginRight(5);
            H6Answer.setMarginLeft(5);
            cell12.add(H6Answer);

            cell12.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell12);

        }

        if (h7.getText().toString().length() != 0) {

            Paragraph H7QuestionTitle = new Paragraph(h7Title.getText().toString());
            H7QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H7QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H7QuestionTitle.setFontSize(14);

            Paragraph H7QuestionSubtitle = new Paragraph(getString(R.string.people));
            H7QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H7QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H7QuestionSubtitle.setFontSize(14);

            Cell cell13 = new Cell();
            cell13.add(H7QuestionTitle);
            cell13.add(H7QuestionSubtitle);
            cell13.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell13);

            Cell cell14 = new Cell();

            Paragraph H7Answer = new Paragraph(h7.getText().toString());
            H7Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H7Answer.setFontSize(14);
            H7Answer.setMarginRight(5);
            H7Answer.setMarginLeft(5);
            cell14.add(H7Answer);

            cell14.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell14);

        }

        if (h8.getText().toString().length() != 0) {

            Paragraph H8QuestionTitle = new Paragraph(h8Title.getText().toString());
            H8QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H8QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H8QuestionTitle.setFontSize(14);

            Paragraph H8QuestionSubtitle = new Paragraph(getString(R.string.amount));
            H8QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H8QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H8QuestionSubtitle.setFontSize(14);

            Cell cell15 = new Cell();
            cell15.add(H8QuestionTitle);
            cell15.add(H8QuestionSubtitle);
            cell15.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell15);

            Cell cell16 = new Cell();

            Paragraph H8Answer = new Paragraph(h8.getText().toString());
            H8Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H8Answer.setFontSize(14);
            H8Answer.setMarginRight(5);
            H8Answer.setMarginLeft(5);
            cell16.add(H8Answer);

            cell16.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell16);

        }

        if (h9.getText().toString().length() != 0) {

            Paragraph H9QuestionTitle = new Paragraph(h9Title.getText().toString());
            H9QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H9QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H9QuestionTitle.setFontSize(14);

            Paragraph H9QuestionSubtitle = new Paragraph(getString(R.string.person));
            H9QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H9QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H9QuestionSubtitle.setFontSize(14);

            Cell cell17 = new Cell();
            cell17.add(H9QuestionTitle);
            cell17.add(H9QuestionSubtitle);
            cell17.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell17);

            Cell cell18 = new Cell();

            Paragraph H9Answer = new Paragraph(h9.getText().toString());
            H9Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H9Answer.setFontSize(14);
            H9Answer.setMarginRight(5);
            H9Answer.setMarginLeft(5);
            cell18.add(H9Answer);

            cell18.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell18);

        }

        if (h10.getText().toString().length() != 0) {

            Paragraph H10QuestionTitle = new Paragraph(h10Title.getText().toString());
            H10QuestionTitle.setTextAlignment(TextAlignment.CENTER);
            H10QuestionTitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD));
            H10QuestionTitle.setFontSize(14);

            Paragraph H10QuestionSubtitle = new Paragraph(getString(R.string.content));
            H10QuestionSubtitle.setTextAlignment(TextAlignment.CENTER);
            H10QuestionSubtitle.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H10QuestionSubtitle.setFontSize(14);

            Cell cell19 = new Cell();
            cell19.add(H10QuestionTitle);
            cell19.add(H10QuestionSubtitle);
            cell19.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell19);

            Cell cell20 = new Cell();

            Paragraph H10Answer = new Paragraph(h10.getText().toString());
            H10Answer.setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA));
            H10Answer.setFontSize(14);
            H10Answer.setMarginRight(5);
            H10Answer.setMarginLeft(5);
            cell20.add(H10Answer);

            cell20.setBorder(new SolidBorder(ColorConstants.BLACK, 2));

            table.addCell(cell20);

        }

        doc.add(table);

        int numberOfPages = doc.getPdfDocument().getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++){
            if(i > 1) {
                doc.showTextAligned(new Paragraph("Side "+i).setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA)).setFontSize(14),
                        74, 32, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
            }
            doc.showTextAligned(new Paragraph("overlevelsesguiden.dk").setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA)).setFontSize(14),
                    595 - 32, 32, i, TextAlignment.RIGHT, VerticalAlignment.TOP, 0);
        }

        doc.close();

        Uri contentUri = FileProvider.getUriForFile(this, "dk.overlevelsesguiden.de10her.fileprovider", file);

        Intent sharePdfIntent = new Intent(Intent.ACTION_SEND);
        sharePdfIntent.setType("application/pdf");
        sharePdfIntent.putExtra(Intent.EXTRA_STREAM, contentUri);
        sharePdfIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(sharePdfIntent, "share"));


    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.shareAllHs){
            try {
                sharePdfAllHs();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (item.getItemId() == R.id.shareOnlyFilled){
            try {
                sharePdfOnlyFilled();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if (item.getItemId() == R.id.delete){

            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage(getString(R.string.deleteNotice)).setPositiveButton(getString(R.string.ok), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);
                    Gson gson = new Gson();
                    String loadJson = preferences.getString("document_array", null);
                    Type type = new TypeToken<ArrayList<Document>>() {}.getType();
                    documents = gson.fromJson(loadJson, type);

                    documents.remove(documentIndex);

                    SharedPreferences.Editor editor = preferences.edit();
                    String saveJson = gson.toJson(documents);
                    editor.putString("document_array", saveJson);
                    editor.apply();

                    Intent intent = new Intent(DocumentActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }).setNegativeButton(getString(R.string.cancel), null);
            AlertDialog alert = builder.create();
            alert.show();

            return true;
        }
        if (item.getItemId() == R.id.edit){
            Intent editIntent = new Intent(this, EditOrDuplicateDocumentActivity.class);
            editIntent.putExtra("document_index", documentIndex);
            editIntent.putExtra("is_duplicating", false);
            editIntent.putExtra("title_to_edit", title.getText().toString());
            editIntent.putExtra("h1_to_edit", h1.getText().toString());
            editIntent.putExtra("h2_to_edit", h2.getText().toString());
            editIntent.putExtra("h3_to_edit", h3.getText().toString());
            editIntent.putExtra("h4_to_edit", h4.getText().toString());
            editIntent.putExtra("h5_to_edit", h5.getText().toString());
            editIntent.putExtra("h6_to_edit", h6.getText().toString());
            editIntent.putExtra("h7_to_edit", h7.getText().toString());
            editIntent.putExtra("h8_to_edit", h8.getText().toString());
            editIntent.putExtra("h9_to_edit", h9.getText().toString());
            editIntent.putExtra("h10_to_edit", h10.getText().toString());
            startActivity(editIntent);
            return true;
        }
        if (item.getItemId() == R.id.duplicate){
            Intent duplicateIntent = new Intent(this, EditOrDuplicateDocumentActivity.class);
            duplicateIntent.putExtra("document_index", documentIndex);
            duplicateIntent.putExtra("is_duplicating", true);
            duplicateIntent.putExtra("title_to_edit", title.getText().toString()+" "+getString(R.string.copy));
            duplicateIntent.putExtra("h1_to_edit", h1.getText().toString());
            duplicateIntent.putExtra("h2_to_edit", h2.getText().toString());
            duplicateIntent.putExtra("h3_to_edit", h3.getText().toString());
            duplicateIntent.putExtra("h4_to_edit", h4.getText().toString());
            duplicateIntent.putExtra("h5_to_edit", h5.getText().toString());
            duplicateIntent.putExtra("h6_to_edit", h6.getText().toString());
            duplicateIntent.putExtra("h7_to_edit", h7.getText().toString());
            duplicateIntent.putExtra("h8_to_edit", h8.getText().toString());
            duplicateIntent.putExtra("h9_to_edit", h9.getText().toString());
            duplicateIntent.putExtra("h10_to_edit", h10.getText().toString());
            startActivity(duplicateIntent);
        }else {
            return false;
        }
        /*
        switch (item.getItemId()){
            case R.id.delete:
                SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);
                Gson gson = new Gson();
                String loadJson = preferences.getString("document_array", null);
                Type type = new TypeToken<ArrayList<Document>>() {}.getType();
                documents = gson.fromJson(loadJson, type);

                documents.remove(documentIndex);

                SharedPreferences.Editor editor = preferences.edit();
                String saveJson = gson.toJson(documents);
                editor.putString("document_array", saveJson);
                editor.apply();

                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.edit:
                Intent editIntent = new Intent(this, EditOrDuplicateDocumentActivity.class);
                editIntent.putExtra("document_index", documentIndex);
                editIntent.putExtra("is_duplicating", false);
                editIntent.putExtra("title_to_edit", title.getText().toString());
                editIntent.putExtra("h1_to_edit", h1.getText().toString());
                editIntent.putExtra("h2_to_edit", h2.getText().toString());
                editIntent.putExtra("h3_to_edit", h3.getText().toString());
                editIntent.putExtra("h4_to_edit", h4.getText().toString());
                editIntent.putExtra("h5_to_edit", h5.getText().toString());
                editIntent.putExtra("h6_to_edit", h6.getText().toString());
                editIntent.putExtra("h7_to_edit", h7.getText().toString());
                editIntent.putExtra("h8_to_edit", h8.getText().toString());
                editIntent.putExtra("h9_to_edit", h9.getText().toString());
                editIntent.putExtra("h10_to_edit", h10.getText().toString());
                startActivity(editIntent);
                return true;
            case R.id.duplicate:
                Intent duplicateIntent = new Intent(this, EditOrDuplicateDocumentActivity.class);
                duplicateIntent.putExtra("document_index", documentIndex);
                duplicateIntent.putExtra("is_duplicating", true);
                duplicateIntent.putExtra("title_to_edit", title.getText().toString()+" "+getString(R.string.copy));
                duplicateIntent.putExtra("h1_to_edit", h1.getText().toString());
                duplicateIntent.putExtra("h2_to_edit", h2.getText().toString());
                duplicateIntent.putExtra("h3_to_edit", h3.getText().toString());
                duplicateIntent.putExtra("h4_to_edit", h4.getText().toString());
                duplicateIntent.putExtra("h5_to_edit", h5.getText().toString());
                duplicateIntent.putExtra("h6_to_edit", h6.getText().toString());
                duplicateIntent.putExtra("h7_to_edit", h7.getText().toString());
                duplicateIntent.putExtra("h8_to_edit", h8.getText().toString());
                duplicateIntent.putExtra("h9_to_edit", h9.getText().toString());
                duplicateIntent.putExtra("h10_to_edit", h10.getText().toString());
                startActivity(duplicateIntent);
            default:
                return false;
        }
         */
        return false;
    }
}