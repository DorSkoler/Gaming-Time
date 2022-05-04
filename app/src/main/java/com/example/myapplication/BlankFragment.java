package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_blank, container,  false);
        Button login = view.findViewById(R.id.loginbtn);
        Button register = view.findViewById(R.id.registerbtn);
        TextView email = view.findViewById(R.id.email_login);
        TextView password = view.findViewById(R.id.password_login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = ( MainActivity) getActivity();
                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(mainActivity, "Insert email", Toast.LENGTH_LONG).show();
                }
                else if (!mainActivity.isEmailValid(email.getText().toString())) {
                    Toast.makeText(mainActivity, "Insert valid email", Toast.LENGTH_LONG).show();
                }
                else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(mainActivity, "Insert password", Toast.LENGTH_LONG).show();
                }
                else if (password.getText().toString().length() < 8) {
                    Toast.makeText(mainActivity, "Password too short", Toast.LENGTH_LONG).show();
                }
                else {
                    mainActivity.loginFunc(view);
                }
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_blankFragment_to_blankFragment2);
            }
        });

        // Inflate the layout for this fragment
        return view;
    }


}