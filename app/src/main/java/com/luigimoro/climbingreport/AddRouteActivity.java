package com.luigimoro.climbingreport;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.luigimoro.climbingreport.pojo.climb.Pitch;
import com.luigimoro.climbingreport.pojo.climb.Route;
import com.luigimoro.climbingreport.utils.Constants;

public class AddRouteActivity extends AppCompatActivity {

    private Route route;
    private Bundle currentInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_route);

        System.out.println("onCreate::method called");

        configureGradeType();

        if (savedInstanceState != null) {
            this.currentInstanceState = savedInstanceState;
            route = loadRouteStatus(savedInstanceState);
        } else {
            route = new Route();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        System.out.println("onActivityResult::begin");

        if (requestCode == Constants.ACTIVITY_CODE_ADD_PITCH &&
                resultCode == RESULT_OK
                && intent != null) {

            Pitch pitch = (Pitch) intent.getSerializableExtra(Constants.PITCH_NEW_EXTRA);

            if (pitch != null) {

                int pitchNumber = route.getPitchList().size();
                pitch.setPitchNumber(pitchNumber + 1);
                route.addPitch(pitch);
            }

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("onPause::begin");
    }

    @Override
    public void onResume() {
        super.onResume();

//        this.populateRouteViews();

    }


    private void checkPitchIntent() {
        Intent intent = getIntent();

        Pitch pitch = (Pitch) intent.getSerializableExtra(Constants.PITCH_NEW_EXTRA);

        if (pitch != null) {

            int pitchNumber = route.getPitchList().size();
            pitch.setPitchNumber(pitchNumber);
            route.addPitch(pitch);
        }
    }

    private void populateRouteFields() {

        EditText routeName = (EditText) findViewById(R.id.route_form_name_id);
        EditText mountainArea = (EditText) findViewById(R.id.route_form_mountain_area_id);
        EditText closestVillage = (EditText) findViewById(R.id.route_form_closest_village_id);
        EditText closestRefugee = (EditText) findViewById(R.id.route_form_closest_refugee_id);
        EditText routeStart = (EditText) findViewById(R.id.route_form_route_start_id);

        Spinner routeType = (Spinner) findViewById(R.id.route_form_route_type_id);
        Spinner difficulty = (Spinner) findViewById(R.id.route_form_route_difficulty_id);
        Spinner mandatoryDifficulty = (Spinner) findViewById(R.id.route_form_route_mand_difficulty_id);

        route.setRouteName(routeName.getText().toString());
        route.setMountainChain(mountainArea.getText().toString());
        route.setClosestVillage(closestVillage.getText().toString());
        route.setClosestRefugee(closestRefugee.getText().toString());
        route.setRouteStart(routeStart.getText().toString());

        route.setRouteType(routeType.getSelectedItemPosition());
        route.setMaxDifficulty(difficulty.getSelectedItemPosition());
        route.setMandatotyDifficulty(mandatoryDifficulty.getSelectedItemPosition());
    }

    private void populateRouteViews() {

        if (route != null) {

            EditText routeName = (EditText) findViewById(R.id.route_form_name_id);
            Spinner routeType = (Spinner) findViewById(R.id.route_form_route_type_id);
            EditText mountainArea = (EditText) findViewById(R.id.route_form_mountain_area_id);
            EditText closestVillage = (EditText) findViewById(R.id.route_form_closest_village_id);
            EditText closestRefugee = (EditText) findViewById(R.id.route_form_closest_refugee_id);
            Spinner difficulty = (Spinner) findViewById(R.id.route_form_route_difficulty_id);
            Spinner mandatoryDifficulty = (Spinner) findViewById(R.id.route_form_route_mand_difficulty_id);
            EditText routeStart = (EditText) findViewById(R.id.route_form_route_start_id);
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.route_form_pitch_layout_id);


            routeType.setSelection(this.route.getRouteType());
            difficulty.setSelection(this.route.getMaxDifficulty());
            mandatoryDifficulty.setSelection(this.route.getMandatotyDifficulty());

            routeName.setText(this.route.getRouteName());
            mountainArea.setText(this.route.getMountainChain());
            closestVillage.setText(this.route.getClosestVillage());
            closestRefugee.setText(this.route.getClesestRefugee());
            routeStart.setText(this.route.getRouteStart());


            linearLayout.removeAllViews();

            for (Pitch pitch : route.getPitchList()) {
                EditText pitchView = new EditText(this);

                pitchView.setText(pitch.getPitchNumber() + "° Tiro - " + pitch.getPitchLength() + " - " + pitch.getDifficulty());

                linearLayout.addView(pitchView);
            }
        }
    }

    public void addPitch(View view) {

        Intent addPitchIntent = new Intent(this, AddPitchActivity.class);

        addPitchIntent.putExtra(Constants.ROUTE_TYPE_EXTRA, getSelectedRouteValue());

        startActivityForResult(addPitchIntent, Constants.ACTIVITY_CODE_ADD_PITCH);


    }

    /**
     * Depending on the customer's choice, the Spinner selectors concerning route grade and route mandatory grade
     * will be set with UIAA or French grading system.
     */
    private void configureGradeType() {
        final Spinner routeTypeSpinner = (Spinner) findViewById(R.id.route_form_route_type_id);

        routeTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                fillRouteDifficultySpinners();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });
    }

    /**
     * Fills the Spinners View allowing the choice of route grade and route mandatory grade.
     */
    private void fillRouteDifficultySpinners() {

        Spinner routeTypeSpinner = (Spinner) findViewById(R.id.route_form_route_type_id);
        String routeTypeSelected = (String) routeTypeSpinner.getSelectedItem();

        Spinner routeDifficultySpinner = (Spinner) findViewById(R.id.route_form_route_difficulty_id);
        Spinner routeMandDifficultySpinner = (Spinner) findViewById(R.id.route_form_route_mand_difficulty_id);

        ArrayAdapter<String> routeDifficultySpinnerAdapter;
        ArrayAdapter<String> routeMandDifficultySpinnerAdapter;

        Constants constants = new Constants();

        if (Constants.ROUTE_CLASSIC_TYPE.equals(routeTypeSelected)) {

            routeDifficultySpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Constants.getClassicRouteGradeList());
            routeMandDifficultySpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Constants.getClassicRouteGradeList());

        } else {
            routeDifficultySpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Constants.getSportRouteGradeList());
            routeMandDifficultySpinnerAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Constants.getSportRouteGradeList());

        }
        routeDifficultySpinner.setAdapter(routeDifficultySpinnerAdapter);
        routeDifficultySpinner.setSelection(5);
        routeMandDifficultySpinner.setAdapter(routeMandDifficultySpinnerAdapter);
        routeMandDifficultySpinner.setSelection(5);
    }


    /**
     * Check for the route type selected by customer.
     *
     * @return a string representing the route type (classic or sport)
     */
    private String getSelectedRouteValue() {

        Spinner routeTypeSpinner = (Spinner) findViewById(R.id.route_form_route_type_id);

        return (String) routeTypeSpinner.getSelectedItem();


    }

//    private void saveRouteStatus(Bundle currentInstanceState, Route route) {
//
//        currentInstanceState.putSerializable(Constants.ROUTE_STATUS, route);
//
//    }

    private Route loadRouteStatus(Bundle savedInstanceState) {

        if (savedInstanceState != null) {

            return (Route) savedInstanceState.getSerializable(Constants.ROUTE_STATUS);
        } else {
            return null;
        }

    }


    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }


}


