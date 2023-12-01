package com.example.myemergentapplication;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SigninFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SigninFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SigninFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SigninFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SigninFragment newInstance(String param1, String param2) {
        SigninFragment fragment = new SigninFragment();
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
    EditText text1,t2,t3;
    Button signbutton;
    DataAdapterdb db=new DataAdapterdb();
    FirebaseAuth auth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v=inflater.inflate(R.layout.fragment_signin, container, false);
        text1=(EditText)v.findViewById(R.id.user1);
        t2=(EditText)v.findViewById(R.id.email1);
        t3=(EditText)v.findViewById(R.id.pass1);

        auth=FirebaseAuth.getInstance();


        signbutton=v.findViewById(R.id.siginSubmit);
       signbutton.setOnClickListener(view -> {
           createuser();
          getFragmentManager().beginTransaction().replace(R.id.frameLayout,new LoginFragment()).commit();
       });

        return v;
    }

    private void createuser()
    {

        String mail=t2.getText().toString();
        String pass=t3.getText().toString();

        if(TextUtils.isEmpty(mail))
        {
            t2.setError("required");
            t2.requestFocus();
        }
        else if(TextUtils.isEmpty(pass))
        {
            t3.setError("required"); t3.requestFocus();
        }else
        {
            auth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful()){Toast.makeText(getActivity(),"registered",Toast.LENGTH_SHORT).show();
                       }
                else{Toast.makeText(getActivity(),"error",Toast.LENGTH_SHORT).show();}

                }
            });
        }
    }


}