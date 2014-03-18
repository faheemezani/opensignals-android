package pt.lighthouse.opensignals.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import pt.lighthouse.opensignals.R;
import pt.lighthouse.opensignals.model.Port;
import pt.lighthouse.opensignals.model.PortEnum;
import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


/**
 * The Main activity, where the user must input a MAC address and select which sensors are plugged in each port.
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends RoboActivity {

  private List<Port> portList;

  @InjectView(R.id.spinner_port_one)
  private Spinner spinnerPortOne;

  @InjectView(R.id.spinner_port_two)
  private Spinner spinnerPortTwo;

  @InjectView(R.id.spinner_port_three)
  private Spinner spinnerPortThree;

  @InjectView(R.id.spinner_port_four)
  private Spinner spinnerPortFour;

  @InjectView(R.id.spinner_port_five)
  private Spinner spinnerPortFive;

  @InjectView(R.id.spinner_port_six)
  private Spinner spinnerPartSix;

  @InjectView(R.id.button_connect)
  private Button buttonConnect;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // Initiate the port list and populate it
    portList = new ArrayList<>();
    portList.add(new Port(getString(R.string.port_none), PortEnum.NONE));
    portList.add(new Port(getString(R.string.port_ecg), PortEnum.ECG));
    portList.add(new Port(getString(R.string.port_emg), PortEnum.EMG));
    portList.add(new Port(getString(R.string.port_eda), PortEnum.EDA));
    portList.add(new Port(getString(R.string.port_luminosity), PortEnum.LUMINOSITY));
    portList.add(new Port(getString(R.string.port_accelerometer), PortEnum.ACCELEROMETER));

    // Create a simple Array Adapter and pass it on to the spinners
    // TODO: Check if using the same adapter instance will cause problems when checking for the selected elements
    ArrayAdapter<Port> adapter = new ArrayAdapter<>(this, R.layout.port_spinner_item, portList);
    spinnerPortOne.setAdapter(adapter);
    spinnerPortTwo.setAdapter(adapter);
    spinnerPortThree.setAdapter(adapter);
    spinnerPortFour.setAdapter(adapter);
    spinnerPortFive.setAdapter(adapter);
    spinnerPartSix.setAdapter(adapter);

    buttonConnect.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        connectDevice();
        loadNextActivity();
      }
    });
  }

  private void connectDevice() {
    // TODO: @ppires, do your magic here
  }

  private void loadNextActivity() {
    Intent readingsIntent = new Intent(this, ValuesActivity.class);
    // TODO: Pass port info as extras
    startActivity(readingsIntent);
  }
}
