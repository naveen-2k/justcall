package com.example.myemergentapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
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

    EditText t2;
    EditText t5;

    FirebaseAuth auth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_login, container, false);

        t2=v.findViewById(R.id.LoginUsername);
        t5=v.findViewById(R.id.passText);
        auth=FirebaseAuth.getInstance();

        Button b=v.findViewById(R.id.loginSubmit);
        b.setOnClickListener(view -> {
            loginuser();
           //startActivity(new Intent(getContext(),HomePage.class));
        });

        return v;
    }
   private void loginuser()
   {
      String mail=t2.getText().toString();
       String pass=t5.getText().toString();

       if(TextUtils.isEmpty(mail))
       {
           t2.setError("required");
           t2.requestFocus();
       }
       else if(TextUtils.isEmpty(pass))
       {
           t5.setError("required"); t5.requestFocus();
       }else
       {
           auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener( new OnCompleteListener<AuthResult>()
           {
               @Override
               public void onComplete(@NonNull Task<AuthResult> task)
               {
                   if(task.isSuccessful()){
                       Toast.makeText(getActivity(),"registered",Toast.LENGTH_SHORT).show();
                      startActivity(new Intent(getContext(),HomePage.class));
                   }
                   else{Toast.makeText(getActivity(),"new user signin",Toast.LENGTH_SHORT).show();}

               }
           });
       }
   }
}