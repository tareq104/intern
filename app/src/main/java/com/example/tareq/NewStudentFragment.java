package com.example.tareq;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.tareq.databinding.FragmentNewStudentBinding;

import java.util.List;


public class NewStudentFragment extends Fragment {
        private FragmentNewStudentBinding binding;
        private String  courseType = Student.SEIP;
        private  String courseName;
        private List<String > courseList =Student.seipCourseList;
    public NewStudentFragment() {

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNewStudentBinding.inflate(inflater,container,false);
      initAdapter();


      binding.courseSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
          @Override
          public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            courseName = adapterView.getItemAtPosition(i).toString();
          }

          @Override
          public void onNothingSelected(AdapterView<?> adapterView) {

          }
      });

      binding.courseTypeRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup radioGroup, int i) {
              final RadioButton rb = radioGroup.findViewById(i);
              courseType= rb.getText().toString();
              switch (i){
                  case  R.id.seipRB:
                      courseList = Student.seipCourseList;
                      break;
                  case R.id.paidRB:
                      courseList= Student.paidCourseList;
                      break;
              }
              Toast.makeText(getActivity(), courseList.size()+"", Toast.LENGTH_SHORT).show();
            initAdapter();
          }
      });

      binding.saveBTN.setOnClickListener(view -> {
          final String name = binding.nameInputET.getText().toString();
          final Student s1 =new Student(name,courseType,courseName);
          Student.studentList.add(s1);
          Navigation.findNavController(view).popBackStack();

      });
        return binding.getRoot();
    }

    private void initAdapter() {


        final ArrayAdapter<String >adapter =
                new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_dropdown_item_1line,courseList);
        binding.courseSP.setAdapter(adapter);
    }
}