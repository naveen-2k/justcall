package com.example.myemergentapplication;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DataAdapterdb {
    private DatabaseReference databaseReference;
    public DataAdapterdb()
    {
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference(Users.class.getSimpleName());
    }

    public Task insert(Users u)
    {
        return databaseReference.push().setValue(u);
    }
}
