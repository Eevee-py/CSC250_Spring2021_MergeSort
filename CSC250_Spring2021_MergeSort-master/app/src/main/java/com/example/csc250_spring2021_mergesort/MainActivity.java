package com.example.csc250_spring2021_mergesort;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ListView listOfNumbersLV;
    private ArrayList<String> theListOfNumbersAsStrings;
    private ArrayAdapter<String> theListOfNumbersAdapter;

    private ListView theCallsToMergeSortLV;
    private ArrayList<String> theListOfMergeSortCalls;
    private ArrayAdapter<String> theCallsToMergeSortAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.listOfNumbersLV = this.findViewById(R.id.listOfNumbersLV);

        //this guy will show the parts of the arraylist we are working on in mergesort
        this.theListOfMergeSortCalls = new ArrayList<String>();
        this.theCallsToMergeSortAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                this.theListOfMergeSortCalls);
        this.theCallsToMergeSortLV = this.findViewById(R.id.theCallsToMergeSortLV);
        this.theCallsToMergeSortLV.setAdapter(this.theCallsToMergeSortAdapter);


        this.theListOfNumbersAsStrings = new ArrayList<String>();
        this.theListOfNumbersAsStrings.add("5");
        this.theListOfNumbersAsStrings.add("2");
        this.theListOfNumbersAsStrings.add("8");
        this.theListOfNumbersAsStrings.add("3");
        this.theListOfNumbersAsStrings.add("13");
        this.theListOfNumbersAsStrings.add("5");
        this.theListOfNumbersAsStrings.add("5");
        this.theListOfNumbersAsStrings.add("8");
        this.theListOfNumbersAsStrings.add("1");

        this.theListOfNumbersAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                this.theListOfNumbersAsStrings);

        this.listOfNumbersLV.setAdapter(theListOfNumbersAdapter);
    }

    private String buildStringFromPartOfList(ArrayList<String> theList, int begin, int end)
    {
        String s = "";
        for(int i = begin; i <= end; i++)
        {
            s = s + theList.get(i) + " ";
        }
        return s;
    }

    private void mergeSort(ArrayList<String> theList, int begin, int end)
    {
        //ask if this list is trivially sorted
        //I only want to do anything inside mergeSort if it is NOT trivially sorted
        String currentPartOfArray = this.buildStringFromPartOfList(theList, begin, end);
        this.theListOfMergeSortCalls.add(currentPartOfArray);
        this.theCallsToMergeSortAdapter.notifyDataSetChanged();

        //need to loop?
        if(begin != end)
        {
            int n =this.theListOfNumbersAsStrings.length();
            int mid = n/2;
            int[] arr1 = new int[mid];
            int[] arr2 = new int[n-mid];

            for(i = 0; i < mid; i++)
            {arr1[i] = theList[i];}

            for(i = mid; i < n; i++)
            {arr[i-mid]=theList[i]}

            //need to display somehow




        }
    }

    public void onMergeSortButtonClicked(View v)
    {
        this.mergeSort(this.theListOfNumbersAsStrings,
                0, this.theListOfNumbersAsStrings.size()-1);
    }
}