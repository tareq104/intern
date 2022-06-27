package com.example.tareq;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tareq.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
     private FragmentHomeBinding binding;
     private StudentAdapter adapter;
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater);

adapter= new StudentAdapter(Student.studentList);
final LinearLayoutManager llm = new LinearLayoutManager(getActivity());
llm.setOrientation(RecyclerView.VERTICAL);
binding.courseRV.setLayoutManager(llm);
binding.courseRV.setAdapter(adapter);

        binding.newCourseFab.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.new_student_action);
        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.submitNewList(Student.studentList);
    }
}