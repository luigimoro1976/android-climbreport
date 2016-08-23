package com.luigimoro.climbingreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.luigimoro.climbingreport.pojo.climb.Pitch;
import com.luigimoro.climbingreport.utils.Constants;

public class AddPitchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pitch);

        fillRouteDifficultySpinners();
    }


    public void savePitchInfo(View view) {

        Pitch pitch = new Pitch();

        EditText pitchDescription = (EditText) findViewById(R.id.pitch_form_description_id);
        EditText pitchBelayDescription = (EditText) findViewById(R.id.pitch_form_belay_id);
        EditText pitchHours = (EditText) findViewById(R.id.pitch_form_hours_id);
        EditText pitchMinutes = (EditText) findViewById(R.id.pitch_form_minutes_id);
        EditText pitchPitons = (EditText) findViewById(R.id.pitch_form_pitons_id);
        EditText pitchSpits = (EditText) findViewById(R.id.pitch_form_spits_id);
        Spinner pitchDifficulty = (Spinner) findViewById(R.id.pitch_form_difficulty_id);
        Spinner pitchRockQuality = (Spinner) findViewById(R.id.pitch_form_rock_quality_id);
        EditText pitchLength= (EditText) findViewById(R.id.pitch_form_lentgh_id);

        pitch.setPitchDescription(pitchDescription.getText().toString());
        pitch.setBelayDescription(pitchBelayDescription.getText().toString());
        pitch.setHours(pitchHours.getText().toString());
        pitch.setMinutes(pitchMinutes.getText().toString());
        pitch.setPythonsNumber(pitchPitons.getText().toString());
        pitch.setSpitsNumber(pitchSpits.getText().toString());
        pitch.setDifficulty(pitchDifficulty.getSelectedItem().toString());
        pitch.setRockQuality(pitchRockQuality.getSelectedItem().toString());
        pitch.setPitchLength(pitchLength.getText().toString());

        Intent pitchIntent = new Intent(this, AddRouteActivity.class);

        pitchIntent.putExtra(Constants.PITCH_NEW_EXTRA, pitch);

//        startActivity(pitchIntent);

        setResult(RESULT_OK, pitchIntent);

        finish();


    }

    private void fillRouteDifficultySpinners() {

        Intent intent = getIntent();

        String routeTypeSelected = intent.getStringExtra(Constants.ROUTE_TYPE_EXTRA);

        Spinner routeDifficultySpinner = (Spinner) findViewById(R.id.pitch_form_difficulty_id);

        ArrayAdapter<String> routeDifficultySpinnerAdapter;

        if ("Classica".equals(routeTypeSelected)) {

            routeDifficultySpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Constants.getClassicRouteGradeList());
        } else {
            routeDifficultySpinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Constants.getSportRouteGradeList());

        }

        routeDifficultySpinner.setAdapter(routeDifficultySpinnerAdapter);
    }
}
