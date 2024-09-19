package com.example.erobot_controller;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    String DEVICE_ADDRESS; //MAC Address of Bluetooth Module
    private final UUID PORT_UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outputStream;

    Button forward_btn, forward_left_btn, forward_right_btn, reverse_btn, bluetooth_connect_btn;
    Button servo4_minus, servo4_plus, servo3_minus, servo3_plus, servo2_minus, servo2_plus, servo1_minus, servo1_plus;
    EditText macAddressEditText;

    String command; //string variable that will store value to be transmitted to the bluetooth module

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //declaration of button variables
        forward_btn = (Button) findViewById(R.id.forward_btn);
        forward_left_btn = (Button) findViewById(R.id.forward_left_btn);
        forward_right_btn = (Button) findViewById(R.id.forward_right_btn);
        reverse_btn = (Button) findViewById(R.id.reverse_btn);
        bluetooth_connect_btn = (Button) findViewById(R.id.bluetooth_connect_btn);
        macAddressEditText = (EditText) findViewById(R.id.macAddressEditText);
        servo4_minus = (Button) findViewById(R.id.servo4_minus);
        servo4_plus = (Button) findViewById(R.id.servo4_plus);
        servo3_minus = (Button) findViewById(R.id.servo3_minus);
        servo3_plus = (Button) findViewById(R.id.servo3_plus);
        servo2_plus = (Button) findViewById(R.id.servo2_plus);
        servo2_minus = (Button) findViewById(R.id.servo2_minus);
        servo1_plus = (Button) findViewById(R.id.servo1_plus);
        servo1_minus = (Button) findViewById(R.id.servo1_minus);

        //OnTouchListener code for the forward button (button long press)
        forward_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) //MotionEvent.ACTION_DOWN is when you hold a button down
                {
                    command = "A";

                    try {
                        outputStream.write(command.getBytes()); //transmits the value of command to the bluetooth module
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) //MotionEvent.ACTION_UP is when you release a button
                {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                return false;
            }

        });

        //OnTouchListener code for the reverse button (button long press)
        reverse_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "B";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {

                    }

                }
                return false;
            }
        });

        //OnTouchListener code for the forward left button (button long press)
        forward_left_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "C";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {

                    }

                }
                return false;
            }
        });

        //OnTouchListener code for the forward right button (button long press)
        forward_right_btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "D";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo4_minus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "1";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo4_plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "2";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo3_minus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "3";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo3_plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "4";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo2_minus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "5";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo2_plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "6";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo1_minus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "7";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        servo1_plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    command = "8";

                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    command = "10";
                    try {
                        outputStream.write(command.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });

        //Button that connects the device to the bluetooth module when pressed
        bluetooth_connect_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DEVICE_ADDRESS = macAddressEditText.getText().toString();
                if (BTinit()) {
                    BTconnect();
                }

            }
        });
    }

    //Initializes bluetooth module
    public boolean BTinit() {
        boolean found = false;

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (bluetoothAdapter == null) //Checks if the device supports bluetooth
        {
            Toast.makeText(getApplicationContext(), "Device doesn't support bluetooth", Toast.LENGTH_SHORT).show();
        }

        if (!bluetoothAdapter.isEnabled()) //Checks if bluetooth is enabled. If not, the program will ask permission from the user to enable it
        {
            Intent enableAdapter = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableAdapter, 0);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
        }
        Set<BluetoothDevice> bondedDevices = bluetoothAdapter.getBondedDevices();

        if (bondedDevices.isEmpty()) //Checks for paired bluetooth devices
        {
            Toast.makeText(getApplicationContext(), "Please pair the device first", Toast.LENGTH_SHORT).show();
        } else {
            for (BluetoothDevice iterator : bondedDevices) {
                if (iterator.getAddress().equals(DEVICE_ADDRESS)) {
                    device = iterator;
                    found = true;
                    break;
                }
            }
        }

        return found;
    }

    public boolean BTconnect() {
        boolean connected = true;

        try {
            if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
            }
            socket = device.createRfcommSocketToServiceRecord(PORT_UUID); //Creates a socket to handle the outgoing connection
            socket.connect();

            Toast.makeText(getApplicationContext(),
                    "Connection to bluetooth device successful", Toast.LENGTH_LONG).show();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            connected = false;
        }

        if(connected)
        {
            try
            {
                outputStream = socket.getOutputStream(); //gets the output stream of the socket
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return connected;
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }
}